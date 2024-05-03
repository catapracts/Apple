import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import Button from "../common/Button";
import "./Payment.css";

function TestFindAllPayment() {
    const [paymentList, setPaymentList] = useState([]);
    const [paySeq, setPaySeq] = useState("");

    const navigate = useNavigate();

    const changeSeq = (event) => {
        setPaySeq(event.target.value);
    };

    /* 결제 정보 전체 조회 */
    const getAllPayment = async () => {
        await axios
            .get("http://localhost:3000/payment/getAll")
            .then((resp) => {
                // 결제 성공 시 출력
                console.log("[TestFindAllPayment.js] getAll() success :D");

                console.log(resp.data);
                setPaymentList(resp.data);
            })
            .catch((err) => {
                // 결제 실패 시 출력
                console.log("[TestFindAllPayment.js] getAll() error :<");
                console.log(err);
            });
    };

    useEffect(() => {
        getAll();
    }, []);

    /* 결제 정보 삭제 */
    const deletePayment = async () => {
        const req = { paySeq: paySeq };

        await axios
            .delete(`http://localhost:3000/payment/${paySeq}`, req)
            .then((resp) => {
                console.log("[TestFindAllPayment.js] delete() success :D");
                console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("결제 정보를 성공적으로 삭제했습니다 :D");
                    navigate("/");
                }
            })
            .catch((err) => {
                console.log("req=> ", req);
                console.log("[TestFindAllPayment.js] delete() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status === 400) {
                    alert(resp.data);
                }
            });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">결제 관리</h1>
                    </div>
                    <div>
                        <table className="payment_table">
                            <thead>
                                <th className="payment_th">결제번호</th>
                                <th className="payment_th">결제일</th>
                                <th className="payment_th">결제자</th>
                            </thead>
                            <tbody>
                                {paymentList.map(function (payment, idx) {
                                    return (
                                        <TableRow
                                            obj={payment}
                                            key={idx}
                                            cnt={idx + 1}
                                        />
                                    );
                                })}
                            </tbody>
                        </table>

                        <div>
                            <input type="text" onChange={changeSeq}></input>
                            <Button
                                size={"default"}
                                color={"none"}
                                text={"삭제"}
                                onClick={deletePayment}
                            />
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
                    </div>
                </div>
            </div>
        </div>
    );
}

function TableRow(props) {
    const payment = props.obj;

    return (
        <tr>
            {
                <>
                    <td>
                        <Link
                            to={{ pathname: `/TestgetOne/${payment.paySeq}` }}
                        >
                            <span className="underline bbs-title">
                                {payment.paySeq}
                            </span>
                        </Link>
                    </td>

                    <td>{payment.memSeq}</td>

                    <td>{payment.payDate}</td>

                    <td>{payment.payStatus}</td>
                </>
            }
        </tr>
    );
}

export default TestFindAllPayment;
