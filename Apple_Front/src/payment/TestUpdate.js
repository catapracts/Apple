import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Payment.css';
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function TestUpdate() {

    const {headers, setHeaders} = useContext(HttpHeadersContext);
    const {auth, setAuth} = useContext(AuthContext);

    const navigate = useNavigate();

    const location = useLocation();

    const {payment} = location.state;

    const [memSeq, setMemSeq] = useState(member.memSeq);
    const [paySeq, setPaySeq] = useState(member.memSeq);
    const [payStatus, setPayStatus] = useState(member.memSeq);


    const changeStatus = (event) => {
        setPayStatus(event.target.value);
    }

    const updatePayment = async () => {


        const req = {
            memSeq : memSeq,
            paySeq : paySeq,
            payStatus : payStatus
        }

        console.log(`Header 값 : ${headers.Authorization}`);
        console.log(payment);

        await axios.patch(`http://localhost:3000/payment/${payment.memSeq}`, req, {headers: headers})
            .then((rest) => {
                console.log("[TestUpdate.js] updatePayment() success :D");
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("결제 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/TestgetOne/${payment.memSeq}`);
                }
            }).catch((err) => {
                console.log("[TestUpdate.js] updatePayment() error :<");
                console.log(err);
            });
    }
}