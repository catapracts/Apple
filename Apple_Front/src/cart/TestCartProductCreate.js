import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from "../common/Button";
import "../member/Member.css";

function TestCartCreate() {
    const [cartSeq, setCartSeq] = useState("");
    const [prodSeq, setProdSeq] = useState("");
    const [cartpCnt, setCartpCnt] = useState("");

    const navigate = useNavigate();

    const changeCartSeq = (event) => {
        setCartSeq(event.target.value);
    };

    const changeProdSeq = (event) => {
        setProdSeq(event.target.value);
    };

    const changeCartpCnt = (event) => {
        setCartpCnt(event.target.value);
    };

    /* 장바구니 정보 생성 */
    const createCartProduct = async () => {
        const req = {
            cartSeq : cartSeq,
            prodSeq : prodSeq,
            cartpCnt : cartpCnt
        };

        await axios
            .post("http://localhost:3000/cart/createCartProduct", req)
            .then((resp) => {
                console.log("[TestCartProductCreate.js] cartProductCreate() success :D");
                console.log(resp.data);
                navigate("/TestCartProductFindAll");
            })
            .catch((err) => {
                console.log("[TestCartProductCreate.js] cartProductCreate() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status == 400) {
                    alert(resp.data);
                }
            });
    };

    return (
        <div>
            <div className="container">
                <div className="member_container">
                    <div>
                        <h1 className="member_title">장바구니 상품 등록</h1>
                    </div>
                    <div className="d-flex justify-content-center">
                        <table className="join_table">
                            <tr>
                                <th className="join_th">카트 번호</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeCartSeq}
                                    />
                                </td>
                            </tr>

                            <tr>
                                <th className="join_th">상품 번호</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeProdSeq}
                                    />
                                </td>
                            </tr>

                            <tr>
                                <th className="join_th">상품 갯수</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeCartpCnt}
                                    />
                                </td>
                            </tr>

                        </table>
                        <br />
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
                            text={"가입하기"}
                            onClick={createCartProduct}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestCartCreate;
