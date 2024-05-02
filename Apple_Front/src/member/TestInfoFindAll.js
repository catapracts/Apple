import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";
import Button from '../common/Button';
import './Member.css';

function TestInfoFindAll() {
    const [infoList, setInfoList] = useState([]);
	const [infoSeq, setInfoSeq] = useState("");

	const navigate = useNavigate();	


	const changeSeq = (event) => {	
		setInfoSeq(event.target.value);
	}



    /* 회원 정보 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/info/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[TestInfoFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setInfoList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[TTestInfoFindAlll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);


    /* 회원 삭제 */
    const deleteInfo = async () => {

		const req = { infoSeq: infoSeq}	

		await axios.delete(`http://localhost:3000/info/${infoSeq}`, req)	
			.then((resp) => {									
				console.log("[TestInfoFindAll.js] delete() success :D");
				console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("개인정보를 성공적으로 삭제했습니다 :D");
                    navigate("/TestInfoFindAll");
                }

			}).catch((err) => {	
                console.log("req=> " , req)	;
				console.log("[TestInfoFindAll.js] delete() error :<");
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
                        <h1 className="admin_title">개인 정보 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">구분 번호</th>
                                <th className="member_th">회원 이름</th>
                                <th className="member_th">회원 생일</th>
                                <th className="member_th">회원 성별</th>
                                <th className="member_th">회원 전화번호</th>
                            </thead>
                            <tbody>
                                { 
                                    infoList.map( function(info, idx) {
                                        return(
                                            <TableRow obj={info} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                 }
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeSeq}></input>
                            <Button size={"default"} color={"none"} text={"삭제"} onClick={deleteInfo}/>
                        </div>

                        <div>
                            <Link to="/TestInfoCreate"><li>개인 정보 생성</li></Link>
                        </div>

                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                    </div>

                </div>
            </div>
        </div>
    );
}

/* 글 목록 테이블 행 컴포넌트 */
function TableRow(props) {
	const info = props.obj;

	return (
			<tr>
					{
						<>
                            <td>
                                <Link to={{ pathname: `/TestInfoGetOne/${info.infoSeq}` }}>
                                <span className="underline bbs-title" >{info.infoSeq}</span>
                                </Link>
                            </td>
                            <td>{info.infoName}</td>
                            <td>{info.infoBirth}</td>
                            <td>{info.infoGender}</td>
                            <td>{info.infoPhone}</td>
						</>
					}			
			</tr>
	);
}

export default TestInfoFindAll;