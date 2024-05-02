import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Admin.css';

function Admin_product_create() {

    const { auth, setAuth } = useContext(AuthContext)
	const { headers, setHeaders } = useContext(HttpHeadersContext);

	const navigate = useNavigate();

    // DB product
	const [prodSeq, setProdSeq] = useState("");
	const [prodName, setProdName] = useState("");
	const [prodPrice, setProdPrice] = useState("");
	const [prodCnt, setProdCnt] = useState("");
	const [hddSeq, setHddSeq] = useState("");
	const [colorSeq, setColorSeq] = useState("");

    // DB hdd
	const [capacity, setCapacity] = useState("");
	const [plusSeq, setPlusSeq] = useState("");

    // DB color
	const [color, setColor] = useState("");
	
    // DB price
    const [price, setPrice] = useState("");

    // DB product
    const changeProdSeq = (event) => {setProdSeq(event.target.value);}
    const changeProdName = (event) => {setProdName(event.target.value);}
    const changeProdPrice = (event) => {setProdPrice(event.target.value);}
    const changeProdCnt = (event) => {setProdCnt(event.target.value);}
    const changeHddSeq = (event) => {setHddSeq(event.target.value);}
    const changeColorSeq = (event) => {setColorSeq(event.target.value);}

    // DB hdd
    const changeCapacity = (event) => {setCapacity(event.target.value);}
    const changePlusSeq = (event) => {setPlusSeq(event.target.value);}

    // DB color
    const changeColor = (event) => {setColor(event.target.value);}

    // DB price
    const changePrice = (event) => {setPrice(event.target.value);}

    const createProduct = async() => {

        const req = {
            prodSeq: prodSeq,
            prodName: prodName,
            prodPrice: prodPrice,
            prodCnt: prodCnt,
            hddSeq: hddSeq,
            colorSdq: colorSeq
        }

        console.log (`Header 값 : ${headers.Authorization}`);

        await axios.post("http://localhost:3000/product/create", req, {headers: headers})
        .then ((resp) => {
            console.log("[Admin_product_create.js] createProduct() success");
            console.log(resp.data);

            alert ("새로운 상품을 성공적으로 등록했습니다");
            navigate ('/admin/product/create');     // 상품 등록 페이지로 이동
        })
        .catch ((err) => {
            console.log("[Admin_product_create.js] createProduct() error");
            console.log(err);
        })
    }

    // 해당 부분 관리자만 가능하게 해야함
    useEffect(() => {
        if (!auth) {
            alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
            navigate(-1);
        }
    }, []);

    const createHdd = async() => {

        const req = {
            capacity: capacity,
            plusSeq: plusSeq
        }

        console.log (`Header 값 : ${headers.Authorization}`);

        await axios.post("http://localhost:3000/hdd/create", req, {headers: headers})
        .then ((resp) => {
            console.log("[Admin_product_create.js] createHdd() success");
            console.log(resp.data);

            alert ("새로운 용량 옵션을 성공적으로 등록했습니다");
            navigate ('/admin/product/create');     // 상품 등록 페이지로 이동
        })
        .catch ((err) => {
            console.log("[Admin_product_create.js] createHdd() error");
            console.log(err);
        })
    }

    // 해당 부분 관리자만 가능하게 해야함
    useEffect(() => {
        if (!auth) {
            alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
            navigate(-1);
        }
    }, []);

    const createColor = async() => {

        const req = {
            color: color
        }

        console.log (`Header 값 : ${headers.Authorization}`);

        await axios.post("http://localhost:3000/color/create", req, {headers: headers})
        .then ((resp) => {
            console.log("[Admin_product_create.js] createColor() success");
            console.log(resp.data);

            alert ("새로운 용량 옵션을 성공적으로 등록했습니다");
            navigate ('/admin/product/create');     // 상품 등록 페이지로 이동
        })
        .catch ((err) => {
            console.log("[Admin_product_create.js] createColor() error");
            console.log(err);
        })
    }

    // 해당 부분 관리자만 가능하게 해야함
    useEffect(() => {
        if (!auth) {
            alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
            navigate(-1);
        }
    }, []);

    const createPlus = async() => {

        const req = {
            plusSeq: plusSeq,
            price: price
        }

        console.log (`Header 값 : ${headers.Authorization}`);

        await axios.post("http://localhost:3000/plus/create", req, {headers: headers})
        .then ((resp) => {
            console.log("[Admin_product_create.js] createPlus() success");
            console.log(resp.data);

            alert ("새로운 용량 옵션을 성공적으로 등록했습니다");
            navigate ('/admin/product/create');     // 상품 등록 페이지로 이동
        })
        .catch ((err) => {
            console.log("[Admin_product_create.js] createPlus() error");
            console.log(err);
        })
    }

    // 해당 부분 관리자만 가능하게 해야함
    useEffect(() => {
        if (!auth) {
            alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
            navigate(-1);
        }
    }, []);

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 등록</h1>                    
                    </div>

                    <div className="d-flex justify-content-between">
                        <div className="admin_product_part1 col-6">
                            <div>
                                <h2 className="admin_product_subtitle">Product</h2>
                            </div>
                            <div>
                                <table className="create_table">
                                    <tr className="create_tr">
                                        <th className="create_th">상품 모델명</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeProdSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 이름</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeProdName}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 가격</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeProdPrice}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">수량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeProdCnt}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeHddSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form" onChange={changeColorSeq}></input>                                    </td>
                                        </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button size={"default"} color={"blue"} text={"등록하기"} onClick={createProduct}></Button>
                            </div>
                        </div>

                        <div className="admin_product_part2 col-6">
                            <div>
                                <h2 className="admin_product_subtitle">HDD</h2>
                            </div>
                            <div>
                                <table className="create_table">
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">추가금액번호</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button size={"default"} color={"blue"} text={"등록하기"} onClick={createHdd}></Button>
                            </div>
                        </div>
                    </div>

                    <div className="d-flex justify-content-between">
                        <div className="admin_product_part3 col-6">
                            <div>
                                <h2 className="admin_product_subtitle">Color</h2>
                            </div>
                            <div>
                                <table className="create_table">
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button size={"default"} color={"blue"} text={"등록하기"} onClick={createColor}></Button>
                            </div>
                        </div>

                        <div className="admin_product_part4 col-6">
                            <div>
                                <h2 className="admin_product_subtitle">추가금액</h2>
                            </div>
                            <div>
                                <table className="create_table">
                                    <tr className="create_tr">
                                        <th className="create_th">금액</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button size={"default"} color={"blue"} text={"등록하기"} onClick={createPlus}></Button>
                            </div>
                        </div>
                    </div>

                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        {/* <Button size={"default"} color={"blue"} text={"등록하기"}></Button> */}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product_create;