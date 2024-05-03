import {useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "../member/Member.css";



function TestCartProductUpdate() {
    const navigate = useNavigate();

    const location = useLocation();
    const { cartProduct } = location.state;

    const [cartpSeq, setCartpSeq] = useState(cartProduct.cartpSeq);
    const [cartSeq, setCartSeq] = useState(cartProduct.cartSeq);
    const [prodSeq, setProdSeq] = useState(cartProduct.prodSeq);
    const [cartpCnt, setCartpCnt] = useState(cartProduct.cartpCnt);

    const changeCartSeq = (event) => {
        setCartSeq(event.target.value);
    };

    const changeProdSeq = (event) => {
        setProdSeq(event.target.value);
    };

    const changeCartpCnt = (event) => {
        setCartpCnt(event.target.value);
    };

    const updateCartProduct = async () => {
        const req = {
            cartpSeq : cartpSeq,
            cartSeq : cartSeq,
            prodSeq : prodSeq,
            cartpCnt : cartpCnt
        };

        console.log(cartProduct);

        await axios
            .patch(`http://localhost:3000/cart/UpdateCartProduct/${cartProduct.cartpSeq}`, req)
            .then((resp) => {
                console.log("[TestCartProductUpdate.js] updateCartProduct() success :D");
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("장바구니 상품 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/TestCartProductGetOne/${cartProduct.cartpSeq}`);
                }
            })
            .catch((err) => {
                console.log("[TestCartProductUpdate.js] updateCartProduct() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">카트 상품 수정 페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">
                                카트 상품 정보 수정하기
                            </h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        카트 상품 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        {cartProduct.cartpSeq}
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">카트 번호</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeCartSeq}
                                        />
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">상품 번호</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeProdSeq}
                                        />
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">카트 상품 갯수</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeCartpCnt}
                                        />
                                    </td>
                                </tr>

                            </table>
                        </div>
                    </div>

                    <div className="d-flex justify-content-center">
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
                            text={"수정하기"}
                            onClick={updateCartProduct}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestCartProductUpdate;
