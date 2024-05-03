import axios from "axios";
import { Link, useParams, useNavigate } from "react-router-dom";
import { useState, useEffect, useContext} from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Member.css';

function Mypage() {
	const { auth, setAuth } = useContext(AuthContext)
    const [member, setMember] = useState([]);
    const {memId} = useParams();

	const navigate = useNavigate();	

	/* 회원 1개 조회 */
	const getOne = async () => {

		await axios.get(`http://localhost:3000/user/${memId}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[TestgetOne.js] getOne() success :D");
                console.log(resp.data);
                setMember(resp.data)

			}).catch((err) => {	
				console.log("[TestgetOne.js] getOne() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getOne();
	}, []);

    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">마이페이지</h1>
					</div>

					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">계정</h2>
						</div>
						<div className="">
							<table className="mypage_table">
								<tr>
									<th className="mypage_th">회원 번호</th>
									<td className="mypage_td">
										<span>{member.memSeq}</span>
									</td>
								</tr>
								<tr>
									<th className="mypage_th">회원 ID</th>
									<td className="mypage_td">
										<span>{member.memId}</span>
									</td>
								</tr>
								<tr>
									<th className="mypage_th">비밀번호</th>
									<td className="mypage_td">
										<span>{member.memPw}</span>
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div className="mypage_part2">
						<div>
							<h2 className="mypage_subtitle">회원 정보</h2>
						</div>
						<div className="">
							<table className="mypage_table">
								<tr>
									<th className="mypage_th">이름</th>
									<td className="mypage_td">
										<input type="text" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">연락처</th>
									<td className="mypage_td">
										<input type="text" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">성별</th>
									<td className="mypage_td">
										<input type="text" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">생년월일</th>
									<td className="mypage_td">
										<input type="text" className="mypage_form" />
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div className="mypage_part3">				
						<div>
							<h2 className="mypage_subtitle">배송지 관리</h2>
						</div>
						<div>
							<table className="mypage_table">
								<tr>
									<th className="mypage_th">이름</th>
									<td className="mypage_td">
										<input type="text" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">연락처</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">우편번호</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">주소</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div className="mypage_part4">
						<div>
							<h2 className="mypage_subtitle">결제 관리</h2>
						</div>
						<div>
							<table className="mypage_table">
								<tr>
									<th className="mypage_th">이름</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">카드사</th>									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">카드 번호</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">카드 유효 기간</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
								<tr>
									<th className="mypage_th">CVC 번호</th>
									<td className="mypage_td">
										<input type="tex" className="mypage_form" />
									</td>
								</tr>
							</table>
						</div>

					</div>
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"}text={"수정하기"}></Button>		{/* 값을 전부 입력하고 버튼을 누르면, join이라는 함수를 실행한다. */}
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Mypage;