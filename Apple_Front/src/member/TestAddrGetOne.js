import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "./Member.css";
import { AuthContext } from "../context/AuthProvider";
import TestUpdate from "./TestUpdate";

function TestAddrGetOne() {
    const { auth, setAuth } = useContext(AuthContext);
    const [address, setAddress] = useState({});
    const { addrSeq } = useParams();

    const navigate = useNavigate(); // useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

    /* 회원 1개 조회 */
    const getOne = async () => {
        await axios
            .get(`http://localhost:3000/address/${addrSeq}`, {
                params: { addrSeq: auth ? auth : "" },
            })
            .then((resp) => {
                console.log("[TestAddrGetOne.js] getOne() success :D");
                console.log(resp.data);
                setAddress(resp.data);
            })
            .catch((err) => {
                console.log("[TestAddrGetOne.js] getOne() error :<");
                console.log(err);
            });
    };

    useEffect(() => {
        getOne();
    }, []);

    const updateAddress = {
        addrSeq: address.addrSeq,
        addrZip: address.addrZip,
        addrDetail: address.addrDetail,
    };

    const moveUpdate = (event) => {
        navigate(`/TestAddrUpdate/${addrSeq}`, {
            state: { data: address },
        });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">주소 상세페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">기본 정보</h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        주소 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        <span>{address.addrSeq}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">우편 번호</th>
                                    <td className="mypage_td">
                                        <span>{address.addrZip}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">상세 주소</th>
                                    <td className="mypage_td">
                                        <span>{address.addrDetail}</span>
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

                        <Link
                            className="btn btn-outline-secondary"
                            to="/TestAddrUpdate/${addrSeq}"
                            state={{ address: updateAddress }}
                        >
                            {" "}
                            수정
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestAddrGetOne;
