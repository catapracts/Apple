import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function TestUpdate() {
	
	const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);
	const navigate = useNavigate();

	const location = useLocation();
	const { member } = location.state;
	//const { member } = useState(location.state?.data);

	const [memId, setMemId] = useState(member.memId);
	const [memPw, setMemPw] = useState(member.memPw);
	const [checkMemPw, setCheckMemPw] = useState(member.checkMemPw);


	const changePwd = (event) => {
		setMemPw(event.target.value);
	}

	const changeCheckPwd = (event) => {
		setCheckMemPw(event.target.value);
	}

	const updateMember = async () => {


		const req = {
			memId : memId,
			memPw : memPw, 
			checkMemPw : checkMemPw
		}

		console.log(`Header 값 : ${headers.Authorization}`); 
		console.log(member);
		await axios.patch(`http://localhost:3000/user/${member.memId}`, req, {headers: headers})
		.then((resp) => {
			console.log("[TestUpdate.js] updateMember() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("회원 정보를 성공적으로 수정했습니다 :D");
				navigate(`/TestgetOne/${member.memId}`); // 글 상세로 이동
			}

		})
		.catch((err) => {
			console.log("[TestUpdate.js] updateMember() error :<");
			console.log(err);
		});

	}


    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">마이페이지</h1>
					</div>
					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">기본 정보 수정하기</h2>
						</div>
						<div className="">
							<table className="mypage_table">

								<tr>
									<th className="mypage_th">회원 구분 번호</th>
									<td className="mypage_td">
										{member.memSeq}
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 ID</th>
									<td className="mypage_td">
										{member.memId}
									</td>
								</tr>

								<tr>
									<th className="mypage_th">비밀번호</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changePwd}/>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">비밀번호 재확인</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeCheckPwd}/>
									</td>
								</tr>

							</table>
						</div>
					</div>

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"}text={"수정하기"} onClick={updateMember}></Button>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default TestUpdate;