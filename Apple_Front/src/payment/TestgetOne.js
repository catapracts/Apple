import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Payment.css';
import { AuthContext } from "../context/AuthProvider";

function TestgetOne() {

    const {auth, setAuth} = useContext(AuthContext)
    const [payment, setPayment] = useState({});
    const {memSeq} = useParams();

    const navigate = useNavigate();

    /* 결제 1개 조회 */
    const getOne = async () => {

        await axios.get(`http://localhost:3000/payment/${memSeq}`, {params : {memSeq : auth ? auth : ""}})
            .then((resp) => {
                console.log("[TestgetOne.js] getOne() success :D");
                console.log(resp.data);
                setPayment(resp.data)
            }).catch((err) => {
                console.log("[TestgetOne.js] getOne() error :<");
                console.log(err);
            });
    }

    useEffect(() => {
        getOne();
    }, []);

    const updatePayment = {
        paySeq : payment.paySeq,
        payStatus : payment.payStatus,
        memSeq : payment.memSeq
    }

    const moveUpdate = (event) => {
        navigate(`/TestUpdate/${memSeq}`, {
            state : {data : payment}
        });
    }

}