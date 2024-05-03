import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "./Member.css";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function TestAddrUpdate() {
    const navigate = useNavigate();

    const location = useLocation();
    const { address } = location.state;

    const [addrSeq, setAddrSeq] = useState(address.addrSeq);
    const [addrZip, setAddrZip] = useState(address.addrZip);
    const [addrDetail, setAddrDetail] = useState(address.addrDetail);

    const changeZip = (event) => {
        setAddrZip(event.target.value);
    };

    const changeDetail = (event) => {
        setAddrDetail(event.target.value);
    };

    const updateAddress = async () => {
        const req = {
            addrSeq: addrSeq,
            addrZip: addrZip,
            addrDetail: addrDetail,
        };

        console.log(address);
        await axios
            .patch(`http://localhost:3000/address/${address.addrSeq}`, req)
            .then((resp) => {
                console.log("[TestAddrUpdate.js] updateAddress() success :D");
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("주소 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/TestAddrGetOne/${address.addrSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[TestAddrUpdate.js] updateAddress() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">마이페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">
                                기본 정보 수정하기
                            </h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        주소 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        {address.addrSeq}
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">우편 번호</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeZip}
                                        />
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">상세 주소</th>
                                    <td className="mypage_td">
                                        <input
                                            type="text"
                                            className="join_form"
                                            onChange={changeDetail}
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
                            onClick={updateAddress}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TestAddrUpdate;
