import {useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';


function TestCardUpdate() {
	
	const navigate = useNavigate();

	const location = useLocation();
	const { card } = location.state;


	const [cardSeq, setCardSeq] = useState(card.cardSeq);
    const [cardComp, setCardComp] = useState(card.cardComp);
    const [cardNum, setCardNum] = useState(card.cardNum);
    const [cardDate, setCardDate] = useState(card.cardDate);
    const [cardCvc, setCardCvc] = useState(card.cardCvc);


	const changeCardComp = (event) => {
		setCardComp(event.target.value);
	}

	const changeCardNum = (event) => {
		setCardNum(event.target.value);
	}

    const changeCardDate = (event) => {
		setCardDate(event.target.value);
	}

    const changeCardCvc = (event) => {
		setCardCvc(event.target.value);
	}

	const updateCard = async () => {

		const req = {
			cardSeq : cardSeq,
			cardComp : cardComp, 
			cardNum : cardNum,
            cardDate : cardDate,
            cardCvc : cardCvc
		}

		console.log(card);

		await axios.patch(`http://localhost:3000/card/${card.cardSeq}`, req)
		.then((resp) => {
			console.log("[TestCardUpdate.js] updateCard() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("Card 정보를 성공적으로 수정했습니다 :D");
				navigate(`/TestCardGetOne/${card.cardSeq}`); // 글 상세로 이동
			}

		})
		.catch((err) => {
			console.log("[TestCardUpdate.js] updateCard() error :<");
			console.log(err);
		});

	}


    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">카드 수정 페이지</h1>
					</div>
					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">카드 정보 수정하기</h2>
						</div>
						<div className="">
							<table className="mypage_table">

								<tr>
									<th className="mypage_th">카드 구분 번호</th>
									<td className="mypage_td">
										{card.cardSeq}
									</td>
								</tr>

								<tr>
									<th className="mypage_th">카드 회사</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeCardComp}/>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 숫자</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeCardNum}/>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 유효기간</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeCardDate}/>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">카드 CVC 번호</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeCardCvc}/>
									</td>
								</tr>

							</table>
						</div>
					</div>

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"}text={"수정하기"} onClick={updateCard}></Button>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default TestCardUpdate;