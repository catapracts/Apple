import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "../member/Member.css";
import { AuthContext } from "../context/AuthProvider";


function TestCartGetOne() {
    const { auth, setAuth } = useContext(AuthContext);
    const [cart, setCart] = useState({});
    const { cartSeq } = useParams();

    const navigate = useNavigate(); // useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

    /* 장바구니 1개 조회 */
    const getOne = async () => {
        await axios
            .get(`http://localhost:3000/cart/${cartSeq}`, {
                params: { cartSeq: auth ? auth : "" },
            })
            .then((resp) => {
                console.log("[TestCartGetOne.js] getOne() success :D");
                console.log(resp.data);
                setCart(resp.data);
            })
            .catch((err) => {
                console.log("[TestCartGetOne.js] getOne() error :<");
                console.log(err);
            });
    };

    useEffect(() => {
        getOne();
    }, []);

    const updateCart = {
        cartSeq: cart.cartSeq,
        memSeq: cart.memSeq
    };

    const moveUpdate = (event) => {
        navigate(`/TestCartUpdate/${cartSeq}`, {
            state: { data: cart },
        });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">카트 상세페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">기본 정보</h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        카트 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        <span>{cart.cartSeq}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">회원 번호</th>
                                    <td className="mypage_td">
                                        <span>{cart.memSeq}</span>
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
                            to="/TestCartUpdate/${cartSeq}"
                            state={{cart: updateCart }}
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

export default TestCartGetOne;
