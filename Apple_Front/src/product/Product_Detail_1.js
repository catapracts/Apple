import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";


function Product_Detail_1() {

	const navigate = useNavigate();

    return (
		<div>
			<div className="wide_container">
				<div className="product_detail_part1">
					<div className="d-flex justify-content-center">
						<h1> 영상 들어갈거고요 </h1>
					</div>
					<div className="d-flex justify-content-center">
						<h2> 구입하기 버튼 들어가고요 </h2>
					</div>
				</div>
				<div className="product_detail_part2">
					<div>
						사진 3개정도 쭈르륵 들어가고요
					</div>
				</div>
				<div>
					<div>
						제품라인업부분 들어가요
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Product_Detail_1;