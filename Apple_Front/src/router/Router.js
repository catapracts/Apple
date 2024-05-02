import { Routes, Route } from "react-router-dom";

import Home from "../common/Home"
import Cart from "../cart/Cart"
import Admin_product from "../admin/Admin_product"
import Admin_product_create from "../admin/Admin_product_create"
import Admin_product_update from "../admin/Admin_product_update"
import Admin_payment from "../admin/Admin_payment"
import Admin_payment_detail from "../admin/Admin_payment_detail"
import Admin_member from "../admin/Admin_member"
import Admin_member_detail from "../admin/Admin_member_detail"
import Store from "../store/Store"
import Store_Detail_1 from "../store/Store_Detail_1"
import Store_Detail_2 from "../store/Store_Detail_2"
import Store_Detail_3 from "../store/Store_Detail_3"
import Payment from "../payment/Payment"
import Payment_success from "../payment/Payment_success"
import Mypage from "../member/Mypage"
import Mypage_payment from "../member/Mypage_payment"
import Mypage_payment_detail_1 from "../member/Mypage_payment_detail_1"
import Join from "../member/Join"
import Login from "../member/Login"
import Logout from "../member/Logout"
import TestFindAll from "../member/TestFindAll"
import TestgetOne from "../member/TestgetOne"
import TestUpdate from "../member/TestUpdate"
import Product from "../product/Product"
import Product_Detail_1 from "../product/Product_Detail_1"
import Product_Detail_2 from "../product/Product_Detail_2"
import Product_Detail_3 from "../product/Product_Detail_3"
import TestFindAllPayment from "../payment/TestFindAllPayment"


function Router() {

	return (
			<Routes>
				<Route path="/" element={<Home />}></Route>

				<Route path="/cart" element={<Cart />}></Route>
				<Route path="/admin/product" element={<Admin_product />}></Route>
				<Route path="/admin/product/create" element={<Admin_product_create />}></Route>
				<Route path="/admin/product/update" element={<Admin_product_update />}></Route>
				<Route path="/admin/payment" element={<Admin_payment />}></Route>
				<Route path="/admin/payment/1" element={<Admin_payment_detail />}></Route>
				<Route path="/admin/member" element={<Admin_member />}></Route>
				<Route path="/admin/member/1" element={<Admin_member_detail />}></Route>
				<Route path="/store/" element={<Store />}></Route>
				<Route path="/store_detail/1" element={<Store_Detail_1 />}></Route>
				<Route path="/store_detail/2" element={<Store_Detail_2 />}></Route>
				<Route path="/store_detail/3" element={<Store_Detail_3 />}></Route>
				<Route path="/payment" element={<Payment />}></Route>
				<Route path="/payment/success" element={<Payment_success />}></Route>
				<Route path="/login" element={<Login />}></Route>
				<Route path="/join" element={<Join />}></Route>
				<Route path="/logout" element={<Logout />}></Route>
				<Route path="/TestFindAll" element={<TestFindAll />}></Route>
				<Route path="/TestgetOne/:memId" element={<TestgetOne />}></Route>
				<Route path="/TestUpdate/:memId" element={<TestUpdate />}></Route>
				<Route path="/mypage" element={<Mypage />}></Route>
				<Route path="/mypage/payment" element={<Mypage_payment />}></Route>
				<Route path="/mypage/payment_detail/1" element={<Mypage_payment_detail_1 />}></Route>
				<Route path="/product" element={<Product />}></Route>
				<Route path="/product_detail/1" element={<Product_Detail_1 />}></Route>
				<Route path="/product_detail/2" element={<Product_Detail_2 />}></Route>
				<Route path="/product_detail/3" element={<Product_Detail_3 />}></Route>
				<Route path="/TestFindAllPayment" element={<TestFindAllPayment />}></Route>

			</Routes>
	);
}

export default Router;