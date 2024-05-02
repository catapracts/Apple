import Button from '../common/Button';

function Admin_product_update() {
    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 수정</h1>                    
                    </div>
                    <div className="admin_product part1">
                        <div>
                            <h2 className="admin_product_subtitle">Product</h2>
                        </div>
                        <div>
                            <table className="create_table">
                                <tbody>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 모델명</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 이름</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 가격</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">수량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"></input>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}></Button>
                        <Button size={"default"} color={"blue"} text={"등록하기"}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product_update;