import { useNavigate } from "react-router-dom";
import Button from '../common/Button';
import './Member.css';

function Mypage_payment_detail() {

    const navigate = useNavigate();

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">결제 내역</h1>                    
                    </div>
                    <div className="mypage_payment_detail_part">
                        <div className="mypage_payment_detail_part1">
                            <div>
                                <h1 className="mypage_subtitle">회원 정보</h1>  
                            </div>
                            <div>
                                <table className="mypage_payment_detail_table">
                                    <tr>
                                        <th className="mypage_payment_detail_th">회원 ID</th>
                                        <td className="mypage_payment_detail_td">회원 ID</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">이름</th>
                                        <td className="mypage_payment_detail_td">이름</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">연락처</th>
                                        <td className="mypage_payment_detail_td">연락처</td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="mypage_payment_detail_part1">
                            <div>
                                <h1 className="mypage_subtitle">배송지 정보</h1>  
                            </div>
                            <div>
                                <table className="mypage_payment_detail_table">
                                    <tr>
                                        <th className="mypage_payment_detail_th">이름</th>
                                        <td className="mypage_payment_detail_td">이름</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">연락처</th>
                                        <td className="mypage_payment_detail_td">연락처</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">우편번호</th>
                                        <td className="mypage_payment_detail_td">우편번호</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">주소</th>
                                        <td className="mypage_payment_detail_td">주소</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        
                        <div className="mypage_payment_detail_part1">
                            <div>
                                <h1 className="mypage_subtitle">상품 정보</h1>  
                            </div>
                            <div>
                                <table className="mypage_payment_detail_table">
                                    <tr>
                                        <th className="mypage_payment_detail_th">결제번호</th>
                                        <td className="mypage_payment_detail_td">결제번호출력</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">기종</th>
                                        <td className="mypage_payment_detail_td">기종출력</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">HDD</th>
                                        <td className="mypage_payment_detail_td">HDD출력</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">색상</th>
                                        <td className="mypage_payment_detail_td">색상출력</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">가격</th>
                                        <td className="mypage_payment_detail_td">가격출력</td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>

                        <div className="mypage_payment_detail_part2">
                            <div>
                                <h1 className="admin_member_title">결제 정보</h1> 
                            </div>
                            <div>
                                <table className="mypage_payment_detail_table">
                                    <tr>
                                        <th className="mypage_payment_detail_th">결제번호</th>
                                        <td className="mypage_payment_detail_td">결제번호</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">이름</th>
                                        <td className="mypage_payment_detail_td">이름</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">카드사</th>
                                        <td className="mypage_payment_detail_td">카드사</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">카드번호</th>
                                        <td className="mypage_payment_detail_td">카드번호</td>
                                    </tr>
                                    <tr>
                                        <th className="mypage_payment_detail_th">결제일</th>
                                        <td className="mypage_payment_detail_td">결제일</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
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

export default Mypage_payment_detail;