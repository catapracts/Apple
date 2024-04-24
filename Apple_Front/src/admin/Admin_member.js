function Admin_member() {
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
                                <td className="member_td">내용</td>
                                <td className="member_td">내용</td>
                                <td className="member_td">내용</td>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_member;