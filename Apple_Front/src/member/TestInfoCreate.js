import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from '../common/Button';
import './Member.css';

function TestInfoCreate() {
	const [infoName, setInfoName] = useState("");
	const [infoBirth, setInfoBirth] = useState("");
	const [infoGender, setInfoGender] = useState("");
	const [infoPhone, setInfoPhone] = useState("");


	const navigate = useNavigate();

	const changeName = (event) => {
		setInfoName(event.target.value);
	}

	const changeBirth = (event) => {
		setInfoBirth(event.target.value);
	}

	const changeGender = (event) => {
		setInfoGender(event.target.value);
	}

	const changePhone = (event) => {
		setInfoPhone(event.target.value);
	}


	/* 주소 정보 생성 */
	const createInfo = async () => {

		const req = {
			infoName : infoName,
			infoBirth : infoBirth,
            infoGender : infoGender,
            infoPhone : infoPhone
		}

		await axios.post("http://localhost:3000/info/create", req)
			.then((resp) => {
				console.log("[TestInfoCreate.js] infoCreate() success :D");
				console.log(resp.data);
				navigate("/TestInfoFindAll");

			}).catch((err) => {
				console.log("[TestInfoCreate.js] infoCreate() error :<");
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
					<h1 className="member_title">개인 정보 등록</h1>
					</div>
					<div className="d-flex justify-content-center">
						<table className="join_table">

							<tr>
								<th className="join_th">회원 이름</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeName} />
								</td>
							</tr>

							<tr>
								<th className="join_th">회원 생일</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeBirth} />	
								</td>
							</tr>

                            <tr>
								<th className="join_th">회원 성별</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeGender} />	
								</td>
							</tr>

                            <tr>
								<th className="join_th">회원 전화번호</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changePhone} />	
								</td>
							</tr>

						</table><br />
					</div>
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"} text={"가입하기"} onClick={createInfo}></Button>
					</div>
				</div>

			</div>

		</div>
	);
}

export default TestInfoCreate;	// Join component를 외부의 다른 component가 사용할 수 있도록 설정