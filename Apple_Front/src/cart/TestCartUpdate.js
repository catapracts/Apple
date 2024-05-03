import {useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "../member/Member.css";



function TestCartUpdate() {
    const navigate = useNavigate();

    const location = useLocation();
    const { cart } = location.state;

    const [cartSeq, setCartSeq] = useState(cart.cartSeq);
    const [memSeq, setMemSeq] = useState(cart.memSeq);

    const changeMemSeq = (event) => {
        setMemSeq(event.target.value);
    };

    const updateCart = async () => {
        const req = {
            cartSeq: cartSeq,
            memSeq: memSeq
        };

        console.log(cart);

        await axios
            .patch(`http://localhost:3000/cart/${cart.cartSeq}`, req)
            .then((resp) => {
                console.log("[TestCartUpdate.js] updateCart() success :D");
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("장바구니 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/TestCartGetOne/${cart.cartSeq}`);
                }
            })
            .catch((err) => {
                console.log("[TestCartUpdate.js] updateCart() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">카트 수정 페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">
                                카트 정보 수정하기
                            </h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        카트 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        {cart.cartSeq}
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">회원 번호</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeMemSeq}
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
                            onClick={updateCart}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestCartUpdate;
