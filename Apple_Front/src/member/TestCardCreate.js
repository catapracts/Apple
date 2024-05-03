import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from '../common/Button';
import './Member.css';

function TestCardCreate() {
	const [cardComp, setCardComp] = useState("");
	const [cardNum, setCardNum] = useState("");
    const [cardDate, setCardDate] = useState("");
    const [cardCvc, setCardCvc] = useState("");

	const navigate = useNavigate();

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


	/* 주소 정보 생성 */
	const createCard = async () => {

		const req = {
			cardComp : cardComp,
			cardNum : cardNum,
            cardDate : cardDate,
            cardCvc : cardCvc
		}

		await axios.post("http://localhost:3000/card/create", req)
			.then((resp) => {
				console.log("[TestCardCreate.js] CardCreate() success :D");
				console.log(resp.data);
				navigate("/TestCardFindAll");

			}).catch((err) => {
				console.log("[TestCardCreate.js] CardCreate() error :<");
				console.log(err);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});
	}


	return (
		<div>
			<div className="container">
				<div className="member_container">
					<div>
					<h1 className="member_title">카드 조회</h1>
					</div>
					<div className="d-flex justify-content-center">
						<table className="join_table">

							<tr>
								<th className="join_th">카드사</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeCardComp} />
								</td>
							</tr>

							<tr>
								<th className="join_th">카드 번호</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeCardNum} />	
								</td>
							</tr>

                            <tr>
								<th className="join_th">카드 날짜</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeCardDate} />	
								</td>
							</tr>

                            <tr>
								<th className="join_th">카드 CVC</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeCardCvc} />	
								</td>
							</tr>

						</table><br />
					</div>
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"} text={"등록하기"} onClick={createCard}></Button>
					</div>
				</div>

			</div>

		</div>
	);
}

export default TestCardCreate;