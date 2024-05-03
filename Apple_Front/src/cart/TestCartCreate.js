import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from "../common/Button";
import "../member/Member.css";

function TestCartCreate() {
    const [memSeq, setMemSeq] = useState("");

    const navigate = useNavigate();

    const changeSeq = (event) => {
        setMemSeq(event.target.value);
    };


    /* 장바구니 정보 생성 */
    const createCart = async () => {
        const req = {
            memSeq : memSeq
        };

        await axios
            .post("http://localhost:3000/cart/create", req)
            .then((resp) => {
                console.log("[TestcartCreate.js] cartCreate() success :D");
                console.log(resp.data);
                navigate("/TestCartFindAll");
            })
            .catch((err) => {
                console.log("[TestCartCreate.js] cartCreate() error :<");
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
                        <h1 className="member_title">장바구니 등록</h1>
                    </div>
                    <div className="d-flex justify-content-center">
                        <table className="join_table">
                            <tr>
                                <th className="join_th">회원 번호</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeSeq}
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
                            onClick={createCart}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestCartCreate;
