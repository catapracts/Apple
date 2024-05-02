import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';
import { AuthContext } from "../context/AuthProvider";
import TestUpdate from "./TestUpdate";

function TestgetOne() {

    const { auth, setAuth } = useContext(AuthContext)
    const [member, setMember] = useState({});
    const {memId} = useParams();

	const navigate = useNavigate();			// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

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

	const updateMember = {
		mem_seq : member.memSeq,
		mem_id : member.memId,
		mem_pw : member.memPw
	}	

    const moveUpdate = (event) => {
        navigate(`/TestUpdate/${memId}`, {
			state : {data : member}
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
							<h2 className="mypage_subtitle">기본 정보</h2>
						</div>
						<div className="">
							<table className="mypage_table">

                                <tr>
									<th className="mypage_th">회원 구분 번호</th>
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

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>

						<Link className="btn btn-outline-secondary"  to="/TestUpdate/${mem_id}" state={{ member: updateMember }}> 수정</Link>
					</div>
				</div>
			</div>
		</div>
	);
    
}
    
export default TestgetOne;