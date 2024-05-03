import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";
import Button from '../common/Button';
import './Member.css';

function TestCardFindAll() {
    const [cardList, setCardList] = useState([]);
	const [cardSeq, setCardSeq] = useState("");

	const navigate = useNavigate();	


	const changeSeq = (event) => {	
		setCardSeq(event.target.value);
	}



    /* card 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/card/getAll")
			.then((resp) => {											
				console.log("[TestCardFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setCardList(resp.data);

			}).catch((err) => {											
				console.log("[TestCardFindAll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);


    /* card 삭제 */
    const deleteCard = async () => {

		const req = { cardSeq: cardSeq}	

		await axios.delete(`http://localhost:3000/card/${cardSeq}`, req)	
			.then((resp) => {									
				console.log("[TestCardFindAll.js] delete() success :D");
				console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("card를 성공적으로 삭제했습니다 :D");
                    navigate("/");
                }

			}).catch((err) => {	
                console.log("req=> " , req)	;
				console.log("[TestCardFindAll.js] delete() error :<");
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
                        <h1 className="admin_title">카드 관리</h1>
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">카드 구분 번호</th>
                                <th className="member_th">카드사</th>
                                <th className="member_th">카드 번호</th>
                                <th className="member_th">카드 날짜</th>
                                <th className="member_th">카드 CVC 번호</th>
                            </thead>
                            <tbody>
                                { 
                                    cardList.map( function(card, idx) {
                                        return(
                                            <TableRow obj={card} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                 }
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeSeq}></input>
                            <Button size={"default"} color={"none"} text={"삭제"} onClick={deleteCard}/>
                        </div>

                        <div>
                            <Link to="/TestCardCreate"><li>카드 등록</li></Link>
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
	const card = props.obj;

	return (
			<tr>
					{
						<>
                            <td>
                                <Link to={{ pathname: `/TestCardGetOne/${card.cardSeq}` }}>
                                <span className="underline bbs-title" >{card.cardSeq}</span>
                                </Link>
                            </td>
                            <td>{card.cardComp}</td>
                            <td>{card.cardNum}</td>
                            <td>{card.cardDate}</td>
                            <td>{card.cardCvc}</td>
						</>
					}			
			</tr>
	);
}

export default TestCardFindAll;