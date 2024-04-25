import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Admin.css';

function Admin_product_create() {

    // const { auth, setAuth } = useContext(AuthContext)
	// const { headers, setHeaders } = useContext(HttpHeadersContext);

	const navigate = useNavigate();

	// const [title, setTitle] = useState("");
	// const [content, setContent] = useState("");

    // const changeProd_seq = (event) => {
    //     setProd_seq(event.target.value);
    // }

    // const changeProd_name = (event) => {
    //     setProd_name(event.target.value);
    // }

    // const changeProd_price = (event) => {
    //     setProd_price(event.target.value);
    // }

    // const changeProd_hdd = (event) => {
    //     setProd_hdd(event.target.value);
    // }

    // const changeProd_color = (event) => {
    //     setProd_color(event.target.value);
    // }

    // const changeProd_cnt = (event) => {
    //     setProd_cnt(event.target.value);
    // }

    // const createProduct = async() => {

    //     const req = {
    //         prod_seq: prod_seq,
    //         prod_name: prod_name,
    //         prod_price: prod_price,
    //         prod_hdd: prod_hdd,
    //         prod_color: prod_color,
    //         prod_cnt: prod_cnt
    //     }

    //     console.log (`Header 값 : ${headers.Authorization}`);

    //     await axios.post("http://localhost:3306/bbs", req, {headers: headers})
    //     .then ((resp) => {
    //         console.log("[Admin_product_create.js] createProduct() success");
    //         console.log(resp.data);

    //         alert ("새로운 상품을 성공적으로 등록했습니다");
    //         navigate (`/product_detail/${resp.data.prod_seq}`);     // 새로 등록한 상품으로 이동
    //     })
    //     .catch ((err) => {
    //         console.log("[Admin_product_create.js] createProduct() error");
    //         console.log(err);
    //     })
    // }

    // // 해당 부분 관리자만 가능하게 해야함
    // useEffect(() => {
    //     if (!auth) {
    //         alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
    //         navigate(-1);
    //     }
    // }, []);

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 등록</h1>                    
                    </div>
                    <div>
                        <table className="create_table">
                            <tr className="create_tr">
                                <th className="create_th">상품 모델명</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>
                                </td>
                            </tr>
                            <tr className="create_tr">
                                <th className="create_th">상품 이름</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>
                                </td>
                            </tr>
                            <tr className="create_tr">
                                <th className="create_th">상품 가격</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>
                                </td>
                            </tr>
                            <tr className="create_tr">
                                <th className="create_th">용량</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>
                                </td>
                            </tr>
                            <tr className="create_tr">
                                <th className="create_th">색상</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>                                    </td>
                                </tr>
                            <tr className="create_tr">
                                <th className="create_th">수량</th>
                                <td className="create_td">
                                    <input type="text" className="create_form"></input>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Button size={"default"} color={"blue"} text={"등록하기"}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product_create;