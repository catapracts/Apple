import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "./Payment.css";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function TestUpdatePayment() {
    const navigate = useNavigate();

    const location = useLocation();
    const { payment } = location.state;

    const [paySeq, setPaySeq] = useState(payment.paySeq);
    const [memSeq, setMemSeq] = useState(payment.memSeq);
    const [payDate, setPayDate] = useState(payment.payDate);
    const [payStatus, setPayStatus] = useState(payment.payStatus);

    const changeSeq = (event) => {
        setMemSeq(event.target.value);
    };

    const changeDate = (event) => {
        setPayDate(event.target.value);
    };

    const changeStatus = (event) => {
        setPayStatus(event.target.value);
    };

    const updatePayment = async () => {
        const req = {
            paySeq: paySeq,
            memSeq: memSeq,
            payDate: payDate,
            payStatus: payStatus,
        };

        console.log(payment);
        await axios
            .patch(`http://localhost:3000/payment/${payment.paySeq}`, req)
            .then((resp) => {
                console.log(
                    "[TestUpdatePayment.js] updateAddress() success :D"
                );
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("결제 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/TestgetOnePayment/${payment.paySeq}`); // 결제 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[TestUpdatePayment.js] updatePayment() error :<");
                console.log(err);
            });
    };
}
