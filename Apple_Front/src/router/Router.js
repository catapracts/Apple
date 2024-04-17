import { Routes, Route } from "react-router-dom";

import Home from "../common/Home"
import Cart from "../cart/Cart"
import Cart_Detail from "../cart/Cart_Detail"
import Admin from "../admin/Admin"
import Admin_aside from "../admin/Admin_aside"
import Store from "../store/Store"
import Store_Detail from "../store/Store_Detail"
import Payment from "../payment/Payment"
import Payment_Detail from "../payment/Payment_Detail"
import Mypage from "../member/Mypage"
import Join from "../member/Join"
import Login from "../member/Login"
import Logout from "../member/Logout"


function Router() {

	return (
			<Routes>
				<Route path="/" element={<Home />}></Route>

				<Route path="/cart" element={<Cart />}></Route>
				<Route path="/cart_detail/:cartp_seq" element={<Cart_Detail />}></Route>
				<Route path="/admin/" element={<Admin />}></Route>
				<Route path="/admin_aside" element={<Admin_aside />}></Route>
				<Route path="/store/" element={<Store />}></Route>
				<Route path="/store_detail/:prod_seq" element={<Store_Detail />}></Route>
				<Route path="/payment/" element={<Payment />}></Route>
				<Route path="/payment_detail/" element={<Payment_Detail />}></Route>
				<Route path="/login" element={<Login />}></Route>
				<Route path="/join" element={<Join />}></Route>
				<Route path="/logout" element={<Logout />}></Route>
				<Route path="/mypage" element={<Mypage />}></Route>

			</Routes>
	);
}

export default Router;