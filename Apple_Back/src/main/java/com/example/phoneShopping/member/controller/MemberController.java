package com.example.phoneShopping.member.controller;

import java.util.Date;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.request.LoginRequest;
import com.example.phoneShopping.member.dto.request.UpdateMemberRequest;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.dto.response.LoginResponse;
import com.example.phoneShopping.member.dto.response.UpdateMemberResponse;
import com.example.phoneShopping.member.exception.MemberException;
import com.example.phoneShopping.member.service.MemberService;

@Tag(name = "MemberController", description = "회원 API")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController 
{
	private final MemberService service;

	@Operation(summary = "checkIdDuplicate() - 아이디 중복체크 API ", description = "아이디 중복체크 API")
	@GetMapping
	public ResponseEntity<?> checkIdDuplicate(@RequestParam("id") String id) 
	{
		System.out.println("아이디 중복 요청 성공 : " + id );
		System.out.println("UserController checkIdDuplicate " + new Date());

		HttpStatus status = service.checkIdDuplicate(id);
		return new ResponseEntity<>(status);
	}
	
	
	@Operation(summary = "join() - 회원가입 API ", description = "회원가입 API")
	@PostMapping("/join")
	public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest req) 
	{
		System.out.println("UserController join " + new Date());

		return ResponseEntity.ok(service.join(req));
	}
	
	
	@Operation(summary = "login() - 회원 로그인 API ", description = "회원 로그인 API")
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) 
	{
		System.out.println("UserController login " + new Date());

		return ResponseEntity.ok(service.login(req));
	}


	/* 요청 DTO 검증 예외처리 핸들러 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) 
	{
		System.out.println("UserController handleMethodArgumentNotValidException " + new Date());

		BindingResult bs = e.getBindingResult();
		StringBuilder sb = new StringBuilder();
		bs.getFieldErrors().forEach(err -> 
		{
			sb.append(String.format("[%s]: %s.\n입력된 값: %s",
						err.getField(), err.getDefaultMessage(), err.getRejectedValue()));
		});

		// Map 으로 보낸다면 프론트에서 사용하기 더 편리할 듯 !
		return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
	}

	
	/* 사용자 관련 요청 예외처리 핸들러 */
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<?> handleUserException(MemberException e) 
	{
		System.out.println("UserController handlerUserException " + new Date());
		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllMember()
	{
		System.out.println("회원 정보 전체 출력");
		service.findAllMember();
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOneMember")
	public void findByIdMember(String mem_id)
	{
		System.out.println("회원 정보 1개 출력");
		System.out.println(mem_id);
		service.findByIdMember(mem_id);
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{mem_seq}")
	public ResponseEntity<UpdateMemberResponse> updateMember(@Valid @RequestBody UpdateMemberRequest req)
	{
		System.out.println("회원 정보 수정");
		return ResponseEntity.ok(service.updateMember(req));
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{mem_seq}")
	public void delete(String mem_id)
	{
		System.out.println("회원 정보 제거");
		System.out.println("mem_id");
		service.deleteMember(mem_id);
	}	
}
