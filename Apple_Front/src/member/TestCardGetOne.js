import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';
import { AuthContext } from "../context/AuthProvider";
import TestUpdate from "./TestUpdate";

function TestAddrGetOne() {

    const { auth, setAuth } = useContext(AuthContext)
    const [card, setCard] = useState({});
    const {cardSeq} = useParams();

	const navigate = useNavigate();			// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

    /* 회원 1개 조회 */
	const getOne = async () => {

		await axios.get(`http://localhost:3000/card/${cardSeq}`, {params : {cardSeq : auth ? auth : ""}})
			.then((resp) => {
				console.log("[TestCardGetOne.js] getOne() success :D");
                console.log(resp.data);
                setCard(resp.data)

			}).catch((err) => {	
				console.log("[TestCardGetOne.js] getOne() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getOne();
	}, []);

	const updateCard = {
		cardSeq : card.cardSeq,
		cardComp : card.cardComp,
		cardNum : card.cardNum,
        cardDate : card.cardDate,
        cardCvc : card.cardCvc
	}	

    const moveUpdate = (event) => {
        navigate(`/TestCardUpdate/${cardSeq}`, {
			state : {data : card}
		});
    }


    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">카드 상세페이지</h1>
					</div>
					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">기본 정보</h2>
						</div>
						<div className="">
							<table className="mypage_table">

                                <tr>
									<th className="mypage_th">카드 구분 번호</th>
									<td className="mypage_td">
                                        <span>{card.cardSeq}</span>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">카드사</th>
									<td className="mypage_td">
                                        <span>{card.cardComp}</span>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 번호</th>
									<td className="mypage_td">
                                        <span>{card.cardNum}</span>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 날짜</th>
									<td className="mypage_td">
                                        <span>{card.cardDate}</span>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 CVC 번호</th>
									<td className="mypage_td">
                                        <span>{card.cardCvc}</span>
									</td>
								</tr>

							</table>
						</div>
					</div>

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>

						<Link className="btn btn-outline-secondary"  to="/TestCardUpdate/${cardSeq}" state={{ card : updateCard }}> 수정</Link>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default TestAddrGetOne;