import { Link, useNavigate } from "react-router-dom";
import Button from '../common/Button';
import './Member.css';

function Mypage_payment() {

    const navigate = useNavigate();

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">결제 내역</h1>                    
                    </div>
                    <div>
                        <table className="mypage_payment_table">
                            <thead>
                                <th className="mypage_payment_th col-2">결제번호</th>
                                <th className="mypage_payment_th col-2">결제자</th>
                                <th className="mypage_payment_th">상품명</th>
                                <th className="mypage_payment_th col-2">결제금액</th>
                                <th className="mypage_payment_th col-2">결제일</th>
                            </thead>
                            <tbody>
                                <td className="mypage_payment_td"><Link to="/mypage/payment_detail/1">내용</Link></td>
                                <td className="mypage_payment_td">내용</td>
                                <td className="mypage_payment_td">내용</td>
                                <td className="mypage_payment_td">내용</td>
                                <td className="mypage_payment_td">내용</td>
                            </tbody>
                        </table>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Mypage_payment;