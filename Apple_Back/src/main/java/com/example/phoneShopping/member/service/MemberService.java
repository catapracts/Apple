package com.example.phoneShopping.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.phoneShopping.jwt.JwtTokenUtil;
import com.example.phoneShopping.member.dao.MemberDao;
import com.example.phoneShopping.member.dto.param.CreateMemberParam;
import com.example.phoneShopping.member.dto.param.UpdateMemberParam;
import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.request.LoginRequest;
import com.example.phoneShopping.member.dto.request.UpdateMemberRequest;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.dto.response.LoginResponse;
import com.example.phoneShopping.member.dto.response.UpdateMemberResponse;
import com.example.phoneShopping.member.exception.MemberException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService 
{
	private final MemberDao dao;
	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final UserDetailsService userDetailsService;

	public HttpStatus checkIdDuplicate(String id) 
	{				// ID 중복 체크 확인
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	public JoinResponse join(JoinRequest req)	// 회원가입 처리 
	{
		saveMember(req);
		authenticate(req.getMem_id(), req.getMem_pw());
		return new JoinResponse(req.getMem_id());
	}

	private void saveMember(JoinRequest req)	// 회원가입 method
	{
		// 아이디 중복 확인
		isExistUserId(req.getMem_id());

		// 패스워드 일치 확인
		checkPwd(req.getMem_pw(), req.getCheck_mem_pw());

		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getMem_pw());
		CreateMemberParam param = new CreateMemberParam(req, encodedPwd);

		Integer result = dao.createMember(param);
		if (result == 0) 
		{
			throw new MemberException("회원 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public LoginResponse login(LoginRequest req)	// 로그인 성공 시 응답 
	{
		authenticate(req.getMem_id(), req.getMem_pw());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getMem_id());
		final String token = jwtTokenUtil.generateToken(userDetails);

		System.out.println("인증 성공 토큰 출력 : " + token);
		System.out.println("아이디 출력 : " + req.getMem_id());
			
		return new LoginResponse(token, req.getMem_id());
	}

	
	private void authenticate(String id, String pwd)	// 오류 정의 - 아이디, 비밀번호 잘못 입력 
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));
		} 
			
		catch (DisabledException e) 
		{
			throw new MemberException("인증되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST);
		} 
			
		catch (BadCredentialsException e) 
		{
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void isExistUserId(String id)	// 오류 정의 - 이미 존재하는 아이디 
	{
		Integer result = dao.isExistUserId(id);
		if (result == 1) 
		{
			throw new MemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void checkPwd(String pwd, String checkPwd)	// 오류 정의 - 비밀번호 잘 못 입력 
	{
		if (!pwd.equals(checkPwd)) 
		{
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllMember()
	{
		System.out.println("findAllMember동작");
		dao.findAll();
	}
	
	@Transactional(readOnly=true)
	public void findByIdMember(String mem_id)
	{
		System.out.println("findByIdMember동작");
		dao.findById(mem_id);
	}
	
	@Transactional
	public UpdateMemberResponse updateMember(UpdateMemberRequest req)
	{
		findByIdMember(req.getMem_id());
		updateMemberMethod(req);
		return new UpdateMemberResponse(req.getMem_seq());
	}	
	
	private void updateMemberMethod(UpdateMemberRequest req)
	{
		System.out.println("updateMemberMethod동작");
		UpdateMemberParam param = new UpdateMemberParam(req.getMem_id(), req.getMem_pw(), req.getCheck_mem_pw());
		
		Integer result = dao.updateMember(param);
		if(result==0)
		{
			throw new MemberException("회원 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@Transactional
	public void deleteMember(String mem_id)
	{
		System.out.println("deleteMember동작");
		dao.deleteMember(mem_id);
	}
	
}
