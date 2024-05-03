import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";
import Button from '../common/Button';
import './Member.css';

function Admin_member() {
    const [memberList, setMemberList] = useState([]);
	const [memId, setMemId] = useState("");

	const navigate = useNavigate();	


	const changeId = (event) => {	
		setMemId(event.target.value);
	}



    /* 회원 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/user/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[TestFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setMemberList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[TestFindAll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);


    /* 회원 삭제 */
    const deleteMember = async () => {

		const req = { memId: memId}	

		await axios.delete(`http://localhost:3000/user/${memId}`, req)	
			.then((resp) => {									
				console.log("[TestFindAll.js] delete() success :D");
				console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("회원을 성공적으로 삭제했습니다 :D");
                    navigate("/");
                }

			}).catch((err) => {	
                console.log("req=> " , req)	;
				console.log("[TestFindAll.js] delete() error :<");
				console.log(err);

				const resp = err.response;
				if (resp.status === 400) {
					alert(resp.data);
				}
			});
	}   



    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">회원 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">회원번호</th>
                                <th className="member_th">회원 ID</th>
                                <th className="member_th">회원이름</th>
                            </thead>
                            <tbody>
                                { 
                                    memberList.map( function(member, idx) {
                                        return(
                                            <TableRow obj={member} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                 }
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeId}></input>
                            <Button size={"default"} color={"none"} text={"삭제"} onClick={deleteMember}/>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                    </div>

                    <Link className="btn btn-outline-secondary"  to="/TestAddrFindAll"> 주소 정보 설정</Link>

                    <Link className="btn btn-outline-secondary"  to="/TestInfoFindAll"> 회원 정보 설정</Link>

                    <Link className="btn btn-outline-secondary"  to="/TestCardFindAll"> 카드 정보 설정</Link>

                </div>
            </div>
        </div>
    );
}

/* 글 목록 테이블 행 컴포넌트 */
function TableRow(props) {
	const member = props.obj;

	return (
			<tr>
					{
						<>
							<td >
								{member.memSeq}
							</td>

                            <td>
                                <Link to={{ pathname: `/TestgetOne/${member.memId}` }}>
                                <span className="underline bbs-title" >{member.memId}</span>
                                </Link>
                            </td>
                            <td>{member.memPw}</td>
						</>
					}			
			</tr>
	);
}

export default Admin_member;