import React from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { useLocation } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import "./Payment.css";
import Button from "../common/Button";
import iphone15 from "../img/iphone_iphone15.png";

function Payment_test() {
    const { auth, setAuth } = useContext(AuthContext);
    const { headers, setHeaders } = useContext(HttpHeadersContext);

    const navigate = useNavigate();

    // DB Address
    const [addrZip, setAddrZip] = useState("");
    const [addrDetail, setAddrDetail] = useState("");

    const changeAddrZip = (event) => {
        setAddrZip(event.target.value);
    };
    const changeAddrDetail = (event) => {
        setAddrDetail(event.target.value);
    };

    // DB Card
    const [cardComp, setCardComp] = useState("");
    const [cardNum, setCardNum] = useState("");
    const [cardDate, setCardDate] = useState("");
    const [cardCvc, setCardCvc] = useState("");

    const changeCardComp = (event) => {
        setCardComp(event.target.value);
    };
    const changeCardNum = (event) => {
        setCardNum(event.target.value);
    };
    const changeCardDate = (event) => {
        setCardDate(event.target.value);
    };
    const changeCardCvc = (event) => {
        setCardCvc(event.target.value);
    };

    // DB CartProduct
    const [cartProduct, setCartProduct] = useState("");
    const [cartSeq, setCartSeq] = useState("");
    const [prodSeq, setProdSeq] = useState("");
    const [cartpCnt, setCartpCnt] = useState("");

    const { cartpSeq } = useParams();

    const changeProdSeq = (event) => {
        setProdSeq(event.target.value);
    };

    // DB Product
    const [product, setProduct] = useState("");
    const [prodSeq1, setProdSeq1] = useState(cartProduct.prodSeq);
    const [prodName, setProdName] = useState("");
    const [prodPrice, setProdPrice] = useState("");
    const [hddSeq, setHddSeq] = useState("");

    const changeProdName = (event) => {
        setProdName(event.target.value);
    };

    // DB Color
    const [color, setColor] = useState("");
    const [colorSeq, setColorSeq] = useState("");
    const [color1, setColor1] = useState("");

    // DB PaymentProduct
    const [paymentProduct, setPaymentProduct] = useState("");

    // DB CreatePayment
    const [memSeq, setMemSeq] = useState("");
    const [payDate, setPayDate] = useState("");
    const [payStatus, setPayStatus] = useState("");

    // DB CreatePaymentProduct
    const [paySeq, setPaySeq] = useState("");
    const [payiPrice, setPayiPrice] = useState("");
    const [payiCount, setPayiCount] = useState("");

    const createAddress = async () => {
        const req = {
            addrZip: addrZip,
            addrDetail: addrDetail,
        };

        console.log(`Header 값 : ${headers.Authorization}`);

        await axios
            .post("http://localhost:3000/address/create", req, {
                headers: headers,
            })
            .then((resp) => {
                console.log("[payment_test.js] createAddress() success");
                console.log(resp.data);

                alert("새로운 주소를 성공적으로 등록했습니다");
                navigate("/payment_test"); // 그대로 등록만
            })
            .catch((err) => {
                console.log("[Payment_test.js] createAddress() error");
                console.log(err);
            });
    };

    const createCard = async () => {
        const req = {
            cardComp: cardComp,
            cardNum: cardNum,
            cardDate: cardDate,
            cardCvc: cardCvc,
        };

        await axios
            .post("http://localhost:3000/card/create", req, {
                headers: headers,
            })
            .then((resp) => {
                console.log("[payment_test.js] createCard() success");
                console.log(resp.data);

                alert("새로운 카드를 성공적으로 등록했습니다");
                navigate("/payment_test"); // 그대로 등록만
            })
            .catch((err) => {
                console.log("[Payment_test.js] createCard() error");
                console.log(err);
            });
    };

    /* 카트프로덕트 1개 조회 */
    const findByIdCartProduct = async () => {
        await axios
            .get(`http://localhost:3000/cart/getOneCartProduct/${1}`)
            .then((resp) => {
                console.log(
                    "[Payment_test.js] findByIdCartProduct() success :D"
                );
                console.log(resp.data);
                setCartProduct(resp.data);
            })
            .catch((err) => {
                console.log("[Payment_test.js] findByIdCartProduct() error :<");
                console.log(err);
            });
    };

    /* 프로덕트 1개 조회 */
    const findByIdProduct = async () => {
        await axios
            .get(`http://localhost:3000/admin/product/getOne/${"i15b256"}`)
            .then((resp) => {
                console.log("[Payment_test.js] findByIdProduct() success :D");
                console.log(resp.data);
                setProduct(resp.data);
            })
            .catch((err) => {
                console.log("[Payment_test.js] findByIdProduct() error :<");
                console.log(err);
            });
    };

    /* 컬러1개 조회 */
    const findByIdColor = async () => {
        await axios
            .get(`http://localhost:3000/admin/color/getOne/${1}`)
            .then((resp) => {
                console.log("[Payment_test.js] findByIdColor() success :D");
                console.log(resp.data);
                setColor(resp.data);
            })
            .catch((err) => {
                console.log("[Payment_test.js] findByIdColor() error :<");
                console.log(err);
            });
    };

    /* CreatePayment */ 
    const createPayment = async () => {
        const req = {
            // req라는 이름의 변수를 객체 형식으로 사용
            memSeq: memSeq,
            payDate: payDate,
            payStatus: payStatus,
        };

        await axios
            .post("http://localhost:3000/payment/create", req) // req라는 객체를 서버에 전달해서 회원가입 진행
            .then((resp) => {
                // 회원가입 성공 시 출력
                console.log("[Payment_test.js] payCreate() success :D");
                console.log(resp.data);
                navigate("/Payment_success");
            })
            .catch((err) => {
                // 회원가입 실패 시 출력
                console.log("[Payment_test.js] payCreate() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status == 400) {
                    alert(resp.data);
                }
            });
    };

    /* CreatePaymentProduct */ 
    const createPaymentProduct = async () => {
        const req = {
            // req라는 이름의 변수를 객체 형식으로 사용
            prodSeq: memSeq,
            paySeq: payDate,
            payiPrice: payStatus,
            payiCount: payiCount,
        };

        await axios
            .post("http://localhost:3000/payment/createPaymentProduct", req) // req라는 객체를 서버에 전달해서 회원가입 진행
            .then((resp) => {
                
                console.log("[Payment_test.js] payCreateProduct() success :D");
                console.log(resp.data);
                navigate("/Payment_success");
            })
            .catch((err) => {
                
                console.log("[Payment_test.js] payCreateProduct() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status == 400) {
                    alert(resp.data);
                }
            });
    };

    // 해당 부분 관리자만 가능하게 해야함
    useEffect(() => {
        if (!auth) {
            alert("로그인 한 사용자만 게시글을 작성할 수 있습니다!");
            navigate(-1);
        }
    }, []);

    useEffect(() => {
        findByIdCartProduct();
        findByIdProduct();
        findByIdColor();
    }, []);

    // const total = (event) => {
    //     product.prodCnt * product.prodPrice;
    // };

    return (
        <div>

            
            <div className="container">
                <div className="payment_part">
                    <div className="payment_part_title">
                        <h1 className="payment_title">결제하기</h1>
                    </div>

                    <div>
                        <div className="payment_part_img">
                            <img src={iphone15} alt="" />
                        </div>
                        <div className="payment_part1">
                            <div className="d-flex justify-content-between">
                                
                                <div>
                                    <h1 className="payment_part1_title">
                                        {product.prodName}
                                    </h1> &nbsp;
                                    <h1 className="payment_part1_title">
                                        {color.color}
                                    </h1> &nbsp;
                                    <h1 className="payment_part1_title unvisible"
                                        onchange={changeProdSeq}>
                                        {product.prodSeq}
                                    </h1>
                                </div>
                                    <h1 className="payment_part1_subtitle">
                                        {product.prodCnt}개
                                    </h1>    
                            </div>
                            <hr />
                            <div className="d-flex justify-content-between">
                                <div>
                                    <div>
                                        <p className="payment_part1_1">
                                            위 제품의 예상 수령 일자를
                                            확인해보세요.
                                        </p>
                                        <p className="payment_part1_2">
                                            오늘 날짜 +2일
                                        </p>
                                    </div>
                                </div>
                                <div>
                                    <p className="payment_part1_title">
                                        {product.prodPrice} &nbsp;원
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="d-flex justify-content-between">
                        <div className="payment_part2 col-4">
                            <div>
                                <h1 className="payment_part2_title">
                                    주문자 정보
                                </h1>
                            </div>
                            <div>
                                <table className="payment_part2_table">
                                    <tr>
                                        <th className="payment_part2_th">
                                            회원 ID
                                        </th>
                                        <td className="payment_part2_td">
                                            회원 ID
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            이름
                                        </th>
                                        <td className="payment_part2_td">
                                            이름
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            연락처
                                        </th>
                                        <td className="payment_part2_td">
                                            연락처
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="payment_part2 col-4">
                            <div>
                                <h1 className="payment_part2_title">
                                    결제 정보
                                </h1>
                            </div>
                            <div>
                                <table className="payment_part2_table">
                                    <tr>
                                        <th className="payment_part2_th">
                                            카드사
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeCardComp}
                                            />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            카드 번호
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeCardNum}
                                            />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            카드 유효 기간
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeCardDate}
                                            />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            CVC 번호
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeCardCvc}
                                            />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button
                                    size={"default"}
                                    color={"blue"}
                                    text={"등록하기"}
                                    onClick={createCard}
                                ></Button>
                            </div>
                        </div>

                        <div className="payment_part2 col-4">
                            <div>
                                <h1 className="payment_part2_title">
                                    배송지 정보
                                </h1>
                            </div>
                            <div>
                                <table className="payment_part2_table">
                                    <tr>
                                        <th className="payment_part2_th">
                                            우편번호
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeAddrZip}
                                            />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_part2_th">
                                            주소
                                        </th>
                                        <td className="payment_part2_td">
                                            <input
                                                type="text"
                                                className="payment_form"
                                                onChange={changeAddrDetail}
                                            />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div className="d-flex justify-content-center">
                                <Button
                                    size={"default"}
                                    color={"blue"}
                                    text={"등록하기"}
                                    onClick={createAddress}
                                ></Button>
                            </div>
                        </div>
                    </div>

                    <div className="payment_part3">
                        <hr />
                        <div className="payment_part3_1">
                            <span className="payment_total_title">
                                총 주문 금액
                            </span>
                            <span className="payment_total_price">
                                ￦&nbsp; {product.prodPrice}
                            </span>
                        </div>
                        <div className="payment_part3_2">
                            <Button
                                size={"default"}
                                color={"none"}
                                text={"뒤로가기"}
                                onClick={() => {
                                    navigate(-1);
                                }}
                            ></Button>
                            <Button
                                size={"default"}
                                color={"blue"}
                                text={"결제하기"}
                                onClick={() => {
                                    navigate("/payment_success");
                                }}
                            ></Button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    );
}

export default Payment_test;
