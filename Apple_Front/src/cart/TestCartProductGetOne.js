import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import Button from "../common/Button";
import "../member/Member.css";
import { AuthContext } from "../context/AuthProvider";


function TestCartProductGetOne() {
    const { auth, setAuth } = useContext(AuthContext);
    const [cartProduct, setCartProduct] = useState({});
    const { cartpSeq } = useParams();

    const navigate = useNavigate(); // useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

    /* 장바구니 1개 조회 */
    const getOne = async () => {
        await axios
            .get(`http://localhost:3000/cart/getOneCartProduct/${cartpSeq}`, {
                params: { cartSeq: auth ? auth : "" },
            })
            .then((resp) => {
                console.log("[TestCartProductGetOne.js] getOne() success :D");
                console.log(resp.data);
                setCartProduct(resp.data);
            })
            .catch((err) => {
                console.log("[TestCartProductGetOne.js] getOne() error :<");
                console.log(err);
            });
    };

    useEffect(() => {
        getOne();
    }, []);

    const updateCartProduct = {
        cartpSeq : cartProduct.cartpSeq,
        cartSeq : cartProduct.cartSeq,
        prodSeq : cartProduct.prodSeq,
        cartCnt : cartProduct.cartCnt
    };

    const moveUpdate = (event) => {
        navigate(`/TestCartProductUpdate/${cartpSeq}`, {
            state: { data: cartProduct },
        });
    };

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">카트 상품 상세 페이지</h1>
                    </div>
                    <div className="mypage_part1">
                        <div>
                            <h2 className="mypage_subtitle">기본 정보</h2>
                        </div>
                        <div className="">
                            <table className="mypage_table">
                                <tr>
                                    <th className="mypage_th">
                                        카트 상품 구분 번호
                                    </th>
                                    <td className="mypage_td">
                                        <span>{cartProduct.cartpSeq}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">카트 번호</th>
                                    <td className="mypage_td">
                                        <span>{cartProduct.cartSeq}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">상품 번호</th>
                                    <td className="mypage_td">
                                        <span>{cartProduct.prodSeq}</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th className="mypage_th">카트 상품 갯수</th>
                                    <td className="mypage_td">
                                        <span>{cartProduct.cartCnt}</span>
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
                            to="/TestCartProductUpdate/${cartpSeq}"
                            state={{cartProduct : updateCartProduct }}
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

export default TestCartProductGetOne;
