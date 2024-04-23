import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Product.css';
import Video from '../img/product_video.mp4';
import Slide1 from '../img/iphone_slide1.jpg';
import Slide2 from '../img/iphone_slide2.jpg';
import Slide3 from '../img/iphone_slide3.jpg';
import Slide4 from '../img/iphone_slide4.jpg';
import lineup1 from '../img/iphone_iphone15promax.png';
import lineup2 from '../img/iphone_iphone15pro.png';
import lineup3 from '../img/iphone_iphone15.png';
import duallens from '../img/iphone_2lens_icon.png';
import triplelens from '../img/iphone_3lens_icon.png';
import A17 from '../img/iphone_A17_icon.png';
import A16 from '../img/iphone_A16_icon.png';
import battery from '../img/iphone_battery_icon.png';

function Product() {


    return (
		<div>
			<div className="wide_container">
				<div className="part1">
					<div className="parttitle d-flex justify-content-between">
						<h1 className="producttitle">iPhone</h1>
						<p className="productsubtitle">사랑받기 위해 디자인되다.</p>
					</div>
					<div className="videopart">
						<video
							muted autoPlay loop className="videoitem">
							<source src={Video} type="video/mp4" />
						</video>
					</div>
				</div>

				<div className="part2">
					<div className="parttitle d-flex justify-content-between">
						<h1 className="producttitle">알면 알수록, iPhone</h1>
					</div>
					<div className="text-center d-flex justify-content-between">
						<div className="slidepart">
							<div>
								<img src={Slide1} alt="" />
							</div>
							<div className="slidetext">
								<p className="slidetitle">첨단 카메라</p>
								<p className="slidesubtitle">셀피 장인부터</p>
								<p className="slidesubtitle">영상 제작자,</p>
								<p className="slidesubtitle">경계 파괴자까지.</p>
							</div>
						</div>
						<div className="slidepart">
							<div>
								<img src={Slide2} alt="" />
							</div>
							<div className="slidetext">
								<p className="slidetitle">Apple 제작 칩</p>
								<p className="slidesubtitle">매번 실감하는 속도.</p>
							</div>
						</div>
						<div className="slidepart">
							<div>
								<img src={Slide3} alt="" />
							</div>
							<div className="slidetext">
								<p className="slidetitle">배터리</p>
								<p className="slidesubtitle">탁월한 배터리 사용 시간이란</p>
								<p className="slidesubtitle">이런 것.</p>
							</div>
						</div>
					</div>
				</div>
				<div className="part3">
					<div className="parttitle d-flex justify-content-between">
						<h1 className="producttitle">라인업 살펴보기</h1>
					</div>
					<div className="text-center d-flex justify-content-around">
						<div className="lineuppart">
							<div className="lineupimg">
								<img src={lineup1} alt="" />
							</div>
							<div className="lineuptext">
								<p className="lineuptitle">iPhone 15 Pro Max</p>
								<p className="lineupsubtitle">궁극의 iPhone.</p>
								<p className="lineupprice">￦ 1,550,000 부터</p>
							</div>
							<div>
								<button className="productbtn1">더 알아보기</button>
								<button className="productbtn2">구입하기</button>
							</div>
						</div>
						<div className="lineuppart">
							<div className="lineupimg">
								<img src={lineup2} alt="" />
							</div>
							<div className="lineuptext">
								<p className="lineuptitle">iPhone 15 Pro</p>
								<p className="lineupsubtitle">막강한 성능</p>
								<p className="lineupprice">￦ 1,250,000 부터</p>
							</div>
							<div>
								<button className="productbtn1">더 알아보기</button>
								<button className="productbtn2">구입하기</button>
							</div>
						</div>
						<div className="lineuppart">
							<div className="lineupimg">
								<img src={lineup3} alt="" />
							</div>
							<div className="lineuptext">
								<p className="lineuptitle">iPhone 15</p>
								<p className="lineupsubtitle">여전한 놀라움.</p>
								<p className="lineupprice">￦ 1,090,000 부터</p>
							</div>
							<div>
								<button className="productbtn1">더 알아보기</button>
								<button className="productbtn2">구입하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Product;