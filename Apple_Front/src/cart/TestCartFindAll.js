import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";
import Button from '../common/Button';
import "../member/Member.css";

function TestCartFindAll() {
    const [cartList, setCartList] = useState([]);
	const [cartSeq, setCartSeq] = useState("");

	const navigate = useNavigate();	

	const changeSeq = (event) => {	
		setCartSeq(event.target.value);
	}



    /* 카트 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/cart/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[TestCartFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setCartList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[TestCartFindAll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);


    /* 회원 삭제 */
    const deleteCart = async () => {

		const req = {cartSeq: cartSeq}	

		await axios.delete(`http://localhost:3000/cart/${cartSeq}`, req)	
			.then((resp) => {									
				console.log("[TestCartFindAll.js] delete() success :D");
				console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("카트를 성공적으로 삭제했습니다 :D");
                    navigate("/Cart");
                }

			}).catch((err) => {	
                console.log("req=> " , req)	;
				console.log("[TestCartFindAll.js] delete() error :<");
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
                        <h1 className="admin_title">카트 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">카트 구분 번호</th>
                                <th className="member_th">회원 번호</th>
                            </thead>
                            <tbody>
                                { 
                                    cartList.map( function(cart, idx) {
                                        return(
                                            <TableRow obj={cart} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                 }
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeSeq}></input>
                            <Button size={"default"} color={"none"} text={"삭제"} onClick={deleteCart}/>
                        </div>

                        <div>
                            <Link to="/TestCartCreate"><li>Cart 생성</li></Link>
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
	const cart = props.obj;

	return (
			<tr>
					{
						<>
                            <td>
                                <Link to={{ pathname: `/TestCartGetOne/${cart.cartSeq}` }}>
                                <span className="underline bbs-title" >{cart.cartSeq}</span>
                                </Link>
                            </td>
                            <td>{cart.memSeq}</td>
						</>
					}			
			</tr>
	);
}

export default TestCartFindAll;