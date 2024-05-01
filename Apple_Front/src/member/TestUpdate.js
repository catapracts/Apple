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

	const [mem_id, setMem_id] = useState(member.mem_id);
	const [mem_pw, setMem_pw] = useState(member.mem_pw);
	const [check_mem_pw, setCheck_mem_pw] = useState(member.check_mem_pw);


	const changePwd = (event) => {
		setMem_pw(event.target.value);
	}

	const changeCheckPwd = (event) => {
		setCheck_mem_pw(event.target.value);
	}

	const updateMember = async () => {


		const req = {
			mem_id : mem_id,
			mem_pw : mem_pw, 
			check_mem_pw : check_mem_pw
		}

		console.log(`Header 값 : ${headers.Authorization}`); 
		console.log(member);
		await axios.patch(`http://localhost:3000/user/${member.mem_id}`, req, {headers: headers})
		.then((resp) => {
			console.log("[TestUpdate.js] updateMember() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("회원 정보를 성공적으로 수정했습니다 :D");
				navigate(`/TestgetOne/${member.mem_id}`); // 글 상세로 이동
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
										{member.mem_seq}
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 ID</th>
									<td className="mypage_td">
										{member.mem_id}
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