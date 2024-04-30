import { Link, useNavigate } from "react-router-dom";
import Button from '../common/Button';
import './Admin.css';

function Admin_member() {
    
    const navigate = useNavigate();

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">회원 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">회원번호</th>
                                <th className="member_th">회원 ID</th>
                                <th className="member_th">회원이름</th>
                            </thead>
                            <tbody>
                                <td className="member_td">
                                    <Link to="/admin/member/1">내용</Link>
                                </td>
                                <td className="member_td">내용</td>
                                <td className="member_td">내용</td>
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

export default Admin_member;