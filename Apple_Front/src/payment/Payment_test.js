import React from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useLocation } from "react-router-dom";
import { useContext, useState } from "react";
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
    const [addr_zip, setAddr_Zip] = useState("");
    const [addr_detail, setAddr_Detail] = useState("");

    const changeAddr_Zip = (event) => {
        setAddr_Zip(event.target.value);
    };
    const changeAddr_Detail = (event) => {
        setAddr_Detail(event.target.value);
    };

    // DB Card
    const [card_comp, setCard_comp] = useState("");
    const [card_num, setCard_num] = useState("");
    const [card_date, setCard_date] = useState("");
    const [card_cvc, setCard_cvc] = useState("");

    const changeCard_comp = (event) => {
        setCard_comp(event.target.value);
    };
    const changeCard_num = (event) => {
        setCard_num(event.target.value);
    };
    const changeCard_date = (event) => {
        setCard_date(event.target.value);
    };
    const changeCard_cvc = (event) => {
        setCard_cvc(event.target.value);
    };

    const createAddress = async () => {
        const req = {
            addr_zip: addr_zip,
            addr_detail: addr_detail,
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
            card_comp: card_comp,
            card_num: card_num,
            card_date: card_date,
            card_cvc: card_cvc,
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
                                <h1 className="payment_part1_title">
                                    iPhone 15 256GB 옐로
                                </h1>
                                <h1 className="payment_part1_subtitle">1개</h1>
                            </div>
                            <hr />
                            <div>
                                <p className="payment_part1_1">
                                    위 제품의 예상 수령 일자를 확인해보세요.
                                </p>
                                <p className="payment_part1_2">
                                    오늘 날짜 +2일
                                </p>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div className="payment_part_img">
                            <img src={iphone15} alt="" />
                        </div>
                        <div className="payment_part1">
                            <div className="d-flex justify-content-between">
                                <h1 className="payment_part1_title">
                                    iPhone 15 256GB 옐로
                                </h1>
                                <h1 className="payment_part1_subtitle">1개</h1>
                            </div>
                            <hr />
                            <div>
                                <p className="payment_part1_1">
                                    위 제품의 예상 수령 일자를 확인해보세요.
                                </p>
                                <p className="payment_part1_2">
                                    오늘 날짜 +2일
                                </p>
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
                                                onChange={changeCard_comp}
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
                                                onChange={changeCard_num}
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
                                                onChange={changeCard_date}
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
                                                onChange={changeCard_cvc}
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
                                                onClick={changeAddr_Zip}
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
                                                onClick={changeAddr_Detail}
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
                                    onClick={() => {
                                        navigate("/product_detail/1");
                                    }}
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
                                ￦ 1,250,000
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
