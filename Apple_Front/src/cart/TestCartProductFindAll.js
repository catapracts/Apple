import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";
import Button from '../common/Button';
import "../member/Member.css";

function TestCartProductFindAll() {
    const [cartProductList, setCartProductList] = useState([]);
	const [cartpSeq, setCartpSeq] = useState("");

	const navigate = useNavigate();	

	const changeSeq = (event) => {	
		setCartpSeq(event.target.value);
	}


    /* 카트 상품 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/cart/getAllCartProduct")
			.then((resp) => {
				console.log("[TestCartProductFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setCartProductList(resp.data);

			}).catch((err) => {
				console.log("[TestCartProductFindAll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);


    /* 카트 상품 삭제 */
    const deleteCartProduct = async () => {

		const req = {cartpSeq: cartpSeq}	

		await axios.delete(`http://localhost:3000/cart/deleteCartProduct/${cartpSeq}`, req)	
			.then((resp) => {									
				console.log("[TestCartProductFindAll.js] delete() success :D");
				console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("카트를 성공적으로 삭제했습니다 :D");
                    navigate("/Cart");
                }

			}).catch((err) => {	
                console.log("req=> " , req)	;
				console.log("[TestCartProductFindAll.js] delete() error :<");
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
                        <h1 className="admin_title">카트 상품 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">카트 상품 구분 번호</th>
                                <th className="member_th">카트 번호</th>
                                <th className="member_th">상품 번호</th>
                                <th className="member_th">카트 상품 갯수</th>
                            </thead>
                            <tbody>
                                { 
                                    cartProductList.map( function(cartProduct, idx) {
                                        return(
                                            <TableRow obj={cartProduct} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                 }
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeSeq}></input>
                            <Button size={"default"} color={"none"} text={"삭제"} onClick={deleteCartProduct}/>
                        </div>

                        <div>
                            <Link to="/TestCartProductCreate"><li>CartProduct 생성</li></Link>
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
	const cartProduct = props.obj;

	return (
			<tr>
					{
						<>
                            <td>
                                <Link to={{ pathname: `/TestCartProductGetOne/${cartProduct.cartpSeq}` }}>
                                <span className="underline bbs-title" >{cartProduct.cartpSeq}</span>
                                </Link>
                            </td>
                            <td>{cartProduct.cartSeq}</td>
                            <td>{cartProduct.prodSeq}</td>
                            <td>{cartProduct.cartpCnt}</td>
						</>
					}			
			</tr>
	);
}

export default TestCartProductFindAll;