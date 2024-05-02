import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from '../common/Button';
import './Admin.css';

function Admin_member_detail() {

    const { auth, setAuth } = useContext(AuthContext)
    const [member, setMember] = useState({});
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

	const updateMember = {
		mem_seq : member.memSeq,
		mem_id : member.memId,
		mem_pw : member.memPw
	}	

    const moveUpdate = (event) => {
        navigate(`/admin/member/${memId}`, {
			state : {data : member}
		});
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">회원 관리</h1>                    
                    </div>
                    
                    <div className="admin_member_part">
                        <div className="admin_member_part1">
                            <div>
                                <h1 className="admin_member_title">계정</h1>                    
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">회원 번호</th>
                                        <td className="admin_member_td">
                                            <span>{member.memSeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">회원 ID</th>
                                        <td className="admin_member_td">
                                            <span>{member.memId}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">비밀번호</th>
                                        <td className="admin_member_td">
                                            <span>{member.memPw}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
              
                        <div className="admin_member_part2">
                            <div>
                                <h1 className="admin_member_title">회원 정보</h1>                    
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">이름</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">연락처</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">성별</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">생년월일</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="admin_member_part3">
                            <div>
                                <h1 className="admin_member_title">배송지 관리</h1>                    
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">이름</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">연락처</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">우편번호</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">주소</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="admin_member_part4">
                            <div>
                                <h1 className="admin_member_title">결제 관리</h1>                    
                            </div>
                            <div>
                                <table className="member_table">
                                    <tr>
                                        <th className="admin_member_th">이름</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">카드사</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">카드 번호</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">카드 유효 기간</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">CVC 번호</th>
                                        <td className="admin_member_td">
                                            <input type="text" className="admin_member_form" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Button size={"default"} color={"blue"}text={"수정하기"}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_member_detail;