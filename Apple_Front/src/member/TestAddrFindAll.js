import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import Button from "../common/Button";
import "./Member.css";

function TestAddrFindAll() {
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

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">주소 관리</h1>
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">구분 번호</th>
                                <th className="member_th">우편 번호</th>
                                <th className="member_th">상세 주소</th>
                            </thead>
                            <tbody>
                                {addrList.map(function (address, idx) {
                                    return (
                                        <TableRow
                                            obj={address}
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
                                onClick={deleteAddress}
                            />
                        </div>

                        <div>
                            <Link to="/TestAddrCreate">
                                <li>회원가입</li>
                            </Link>
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

/* 글 목록 테이블 행 컴포넌트 */
function TableRow(props) {
    const address = props.obj;

    return (
        <tr>
            {
                <>
                    <td>
                        <Link
                            to={{
                                pathname: `/TestAddrGetOne/${address.addrSeq}`,
                            }}
                        >
                            <span className="underline bbs-title">
                                {address.addrSeq}
                            </span>
                        </Link>
                    </td>
                    <td>{address.addrZip}</td>
                    <td>{address.addrDetail}</td>
                </>
            }
        </tr>
    );
}

export default TestAddrFindAll;
