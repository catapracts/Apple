import { useNavigate } from "react-router-dom";
import Button from '../common/Button';
import './Admin.css';

function Admin_payment() {

    const navigate = useNavigate();

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">결제 내역</h1>                    
                    </div>
                    <div>
                        <div>
                            <table className="payment_detail_table">
                                <tr>
                                    <th className="payment_detail_th">결제번호</th>
                                    <td className="payment_detail_td">결제번호</td>
                                </tr>
                                
                            </table>
                        </div>
                        <div>
                            <table className="payment_detail_table">
                                <tr>
                                    <th className="payment_detail_th">결제번호</th>
                                    <td className="payment_detail_td">결제번호</td>
                                </tr>
                                
                            </table>
                        </div>
                        <div>
                            <table className="payment_detail_table">
                                <tr>
                                    <th className="payment_detail_th">결제번호</th>
                                    <td className="payment_detail_td">결제번호</td>
                                </tr>
                                
                            </table>
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

export default Admin_payment;