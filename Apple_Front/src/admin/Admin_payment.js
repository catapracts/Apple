function Admin_payment() {
    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">결제 내역</h1>                    
                    </div>
                    <div>
                        <table className="payment_table">
                            <thead>
                                <th className="payment_th col-2">결제번호</th>
                                <th className="payment_th col-2">결제자</th>
                                <th className="payment_th">상품명</th>
                                <th className="payment_th col-2">결제금액</th>
                                <th className="payment_th col-2">결제일</th>
                            </thead>
                            <tbody>
                                <td className="payment_td">내용</td>
                                <td className="payment_td">내용</td>
                                <td className="payment_td">내용</td>
                                <td className="payment_td">내용</td>
                                <td className="payment_td">내용</td>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_payment;