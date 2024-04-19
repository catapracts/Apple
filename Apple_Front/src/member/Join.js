/* 회원가입 컴포넌트 */

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";

function Join() {

	const [id, setId] = useState("");
	const [name, setName] = useState("");
	const [pwd, setPwd] = useState("");
	const [checkPwd, setCheckPwd] = useState("");
	const [email, setEmail] = useState("");	// 각 변수들을 선언만 하고 초기값은 없는 상태

	const navigate = useNavigate();			// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

	const changeId = (event) => {			// Client에서 id입력하면, 입력한 값 저장
		setId(event.target.value);
	}

	const changeName = (event) => {			// Client에서 name입력하면, 입력한 값 저장
		setName(event.target.value);
	}

	const changePwd = (event) => {			// Client에서 pwd입력하면, 입력한 값 저장
		setPwd(event.target.value);
	}

	const changeCheckPwd = (event) => {		// Client에서 checkpwd입력하면, 입력한 값 저장
		setCheckPwd(event.target.value);
	}

	const changeEmail = (event) => {		// Client에서 email입력하면, 입력한 값 저장
		setEmail(event.target.value);
	}

	/* 아이디 중복 체크 */
	const checkIdDuplicate = async () => {

		await axios.get("http://localhost:3000/user", { params: { id: id } })	// axios를 이용해 server로부터 id값 가지고 와서 중복된 id인지 확인
			.then((resp) => {
				console.log("[Join.js] checkIdDuplicate() success :D");
				console.log(resp.data);

				if (resp.status == 200) {								// 중복 ID아니면 출력
					alert("사용 가능한 아이디입니다.");
				}
				
			})
			.catch((err) => {											// 중복 ID일 경우 출력
				console.log("[Join.js] checkIdDuplicate() error :<");
				console.log(err);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});

	}

	/* 회원가입 */
	const join = async () => {

		const req = {													// req라는 이름의 변수를 객체 형식으로 사용
			id: id,
			name, name,
			pwd: pwd,
			checkPwd: checkPwd,
			email: email
		}

		await axios.post("http://localhost:3000/user/join", req)		// req라는 객체를 서버에 전달해서 회원가입 진행
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Join.js] join() success :D");
				console.log(resp.data);

				alert(resp.data.id + "님 회원가입을 축하드립니다 🎊");
				navigate("/login");

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Join.js] join() error :<");
				console.log(err);

				// alert(err.response.data);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});
	}


	return (
		<div>
			<table className="table">
				<tbody>
					<tr>
						<th className="col-2">아이디</th>
						<td>
							<input type="text" value={id} onChange={changeId} size="50px" /> &nbsp; &nbsp;														{/* id 값을 넣고, changeId라는 Event를 발생시킨다. -> 아이디 값이 입력한 것에 따라 바뀐다. */}
							<button className="btn btn-outline-danger" onClick={checkIdDuplicate}><i className="fas fa-check"></i> 아이디 중복 확인</button>	 {/* 버튼 누르면, checkIdDuplicate 함수를 실행한다. */}
						</td>
					</tr>

					<tr>
						<th>이름</th>
						<td>
							<input type="text" value={name} onChange={changeName} size="50px" />									{/* name값을 넣고, changeName이라는 Event를 발생시킨다. */}
						</td>
					</tr>

					<tr>
						<th>비밀번호</th>
						<td>
							<input type="password" value={pwd} onChange={changePwd} size="50px" />									{/* pwd값을 넣고, changePwd라는 Event를 발생시킨다. */}
						</td>
					</tr>

					<tr>
						<th>비밀번호 확인</th>
						<td>
							<input type="password" value={checkPwd} onChange={changeCheckPwd} size="50px" />						{/* checkPwd값을 넣고, changeCheckPwd라는 Event를 발생시킨다. */}
						</td>
					</tr>

					<tr>
						<th>이메일</th>
						<td>
							<input type="text" value={email} onChange={changeEmail} size="100px" />									{/* email값을 넣고, changeEmail이라는 Event를 발생시킨다. */}
						</td>
					</tr>
				</tbody>
			</table><br />

			<div className="my-3 d-flex justify-content-center">
				<button className="btn btn-outline-secondary" onClick={join}><i className="fas fa-user-plus"></i> 회원가입</button>	{/* 값을 전부 입력하고 버튼을 누르면, join이라는 함수를 실행한다. */}
			</div>

		</div>
	);
}

export default Join;	// Join component를 외부의 다른 component가 사용할 수 있도록 설정