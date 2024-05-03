import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from "../common/Button";
import "./Payment.css";

function TestCreatePayment() {
    const [memSeq, setMemSeq] = useState("");
    const [payDate, setPayDate] = useState("");
    const [payStatus, setPayStatus] = useState("");

    const navigate = useNavigate(); // useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

    const changeSeq = (event) => {
        // Client에서 id입력하면, 입력한 값 저장
        setMemSeq(event.target.value);
    };

    const changeDate = (event) => {
        // Client에서 pwd입력하면, 입력한 값 저장
        setPayDate(event.target.value);
    };

    const changeStatus = (event) => {
        // Client에서 pwd입력하면, 입력한 값 저장
        setPayStatus(event.target.value);
    };

    /* 주소 정보 생성 */
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
                console.log("[TestCreatePayment.js] payCreate() success :D");
                console.log(resp.data);
                navigate("/TestFindAllPayment");
            })
            .catch((err) => {
                // 회원가입 실패 시 출력
                console.log("[TestCreatePayment.js] payCreate() error :<");
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
                        <h1 className="member_title">결제 등록</h1>
                    </div>
                    <div className="d-flex justify-content-center">
                        <table className="join_table">
                            <tr>
                                <th className="join_th">결제자</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeSeq}
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th className="join_th">결제일</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeDate}
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th className="join_th">결제 상태</th>
                                <td className="join_td">
                                    <input
                                        type="text"
                                        className="join_form"
                                        onChange={changeStatus}
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
                            text={"등록하기"}
                            onClick={createPayment}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestCreatePayment;
