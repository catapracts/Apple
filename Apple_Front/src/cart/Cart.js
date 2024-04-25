import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Cart.css';
import Button from '../common/Button';

import iphone15 from '../img/iphone_iphone15.png';


function Cart() {

	const navigate = useNavigate();

    return (
		<div>
			<div className="container">
				<div className="part1">
					<div>
						<h1 className="part1_title">장바구니 총액: ￦1,250,000</h1>
						<p className="part1_subtitle">모든 주문에 무료 배송 서비스가 제공됩니다.</p>
						<Button size={"large"} color={"blue"} text={"결제"}
							onClick={() => {navigate('/payment')}}></Button>
						<p />
					</div>
				</div>
				<hr />

				<div className="part2">
					<div className="part2_left">
						<img src={iphone15} alt="" />
					</div>
					<div className="part2_right">
						<div className="d-flex justify-content-between">
							<h1 className="part2_title">iPhone 15 256GB 옐로</h1>
							<h1 className="part2_subtitle">1개</h1>
						</div>
						<hr />
						<div>
							<p className="part2_1">위 제품의 예상 수령 일자를 확인해보세요.</p>
							<p className="part2_2">오늘 날짜 +2일</p>
						</div>
						<div className="part2_right_3">
							<Button size={"default"} color={"red"} text={"삭제"}></Button>
						</div>
					</div>
				</div>

			</div>
		</div>
	);
    
    }
    
    export default Cart;