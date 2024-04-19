/* 로그인 컴포넌트 */

import axios from "axios";
import { useState, useContext } from "react";
import { useNavigate } from "react-router";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function Login() {

	const { auth, setAuth } = useContext(AuthContext);				// 초기값이 AuthContext(user의 정보가 있는 파일)인 useContext생성
	const { headers, setHeaders } = useContext(HttpHeadersContext);	// 초기값이 HttpHeadersContext(user의 JWT가 있는 파일)인 useContext생성

	const navigate = useNavigate();		// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

	const [id, setId] = useState("");
	const [pwd, setPwd] = useState("");	// Login에 사용할 변수들 선언

	const changeId = (event) => {		// Client에서 id입력하면, 입력한 값 저장
		setId(event.target.value);
	}

	const changePwd = (event) => {		// Client에서 pwd입력하면, 입력한 값 저장
		setPwd(event.target.value);
	}

	const login = async () => {

		const req = {					// login에 사용할 data들을 하나의 객체로 만든 것
			id: id,
			pwd: pwd
		}

		await axios.post("http://localhost:3000/user/login", req)	// Server에 만든 객체를 전달해서 login method 처리
		.then((resp) => {											// Login 성공 시 출력
			console.log("[Login.js] login() success :D");
			console.log(resp.data);

				alert(resp.data.id + "님, 성공적으로 로그인 되었습니다 🔐");

				// JWT 토큰 저장
				localStorage.setItem("bbs_access_token", resp.data.jwt);
				localStorage.setItem("id", resp.data.id);

				setAuth(resp.data.id); // 사용자 인증 정보(아이디 저장)
				setHeaders({"Authorization": `Bearer ${resp.data.jwt}`}); // 헤더 Authorization 필드 저장

				navigate("/bbslist");
			

		}).catch((err) => {											// Login 실패 시 출력
			console.log("[Login.js] login() error :<");
			console.log(err);

			alert("⚠️ " + err.response.data);
		});
	}

	return (
		<div>
			<table className="table">
				<tbody>
					<tr>
						<th className="col-3">아이디</th>
						<td>
							<input type="text" value={id} onChange={changeId} size="50px" />	{/* id 값을 넣고, changeId라는 Event를 발생시킨다. */}
						</td>
					</tr>

					<tr>
						<th>비밀번호</th>
						<td>
							<input type="password" value={pwd} onChange={changePwd} size="50px" />	{/* pwd 값을 넣고, changePwd라는 Event를 발생시킨다. */}
						</td>
					</tr>
				</tbody>
			</table><br />

			<div className="my-1 d-flex justify-content-center">
				<button className="btn btn-outline-secondary" onClick={login}><i className="fas fa-sign-in-alt"></i> 로그인</button>	{/*값을 전부 입력하고 버튼을 누르면, login이라는 함수를 실행한다.*/}
			</div>

		</div>
	);
}

export default Login;