import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import Button from "../common/Button";
import "./Payment.css";

function TestFindAllPaymentProduct() {
    const [addrList, setAddrList] = useState([]);
    const [addrSeq, setAddrSeq] = useState("");

    const navigate = useNavigate();

    const changeSeq = (event) => {
        setAddrSeq(event.target.value);
    };

    /* 주소 전체 조회 */
    const getAll = async () => {
        await axios
            .get("http://localhost:3000/address/getAll")
            .then((resp) => {
                // 회원가입 성공 시 출력
                console.log("[TestAddrFindAll.js] getAll() success :D");

                console.log(resp.data);
                setAddrList(resp.data);
            })
            .catch((err) => {
                // 회원가입 실패 시 출력
                console.log("[TestAddrFindAll.js] getAll() error :<");
                console.log(err);
            });
    };

    useEffect(() => {
        getAll();
    }, []);

    /* 회원 삭제 */
    const deleteAddress = async () => {
        const req = { addrSeq: addrSeq };

        await axios
            .delete(`http://localhost:3000/address/${addrSeq}`, req)
            .then((resp) => {
                console.log("[TestAddrFindAll.js] delete() success :D");
                console.log(resp.data);

                if (resp.data.deleteRecordCount === 1) {
                    alert("주소를 성공적으로 삭제했습니다 :D");
                    navigate("/");
                }
            })
            .catch((err) => {
                console.log("req=> ", req);
                console.log("[TestAddrFindAll.js] delete() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status === 400) {
                    alert(resp.data);
                }
            });
    };
}
