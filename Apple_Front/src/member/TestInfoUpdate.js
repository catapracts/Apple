import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function TestAddrUpdate() {
	
	const navigate = useNavigate();

	const location = useLocation();
	const { info } = location.state;


	const [infoSeq, setInfoSeq] = useState(info.infoSeq);
	const [infoName, setInfoName] = useState(info.infoName);
	const [infoBirth, setInfoBirth] = useState(info.infoBirth);
	const [infoGender, setInfoGender] = useState(info.infoGender);
	const [infoPhone, setInfoPhone] = useState(info.infoPhone);


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


	const updateInfo = async () => {

		const req = {
			infoSeq : infoSeq,
			infoName : infoName, 
			infoBirth : infoBirth,
			infoGender : infoGender,
			infoPhone : infoPhone
		}

		console.log(info);

		await axios.patch(`http://localhost:3000/info/${info.infoSeq}`, req)
		.then((resp) => {
			console.log("[TestInfoUpdate.js] updateInfo() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("회원 개인 정보를 성공적으로 수정했습니다 :D");
				navigate(`/TestInfoGetOne/${info.infoSeq}`);
			}

		})
		.catch((err) => {
			console.log("[TestInfoUpdate.js] updateInfo() error :<");
			console.log(err);
		});

	}


    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">개인 정보 페이지</h1>
					</div>
					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">정보 수정하기</h2>
						</div>
						<div className="">
							<table className="mypage_table">

								<tr>
									<th className="mypage_th">개인 정보 구분 번호</th>
									<td className="mypage_td">
										{info.infoSeq}
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 이름</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeName}/>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 생일</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeBirth}/>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 성별</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changeGender}/>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 전화번호</th>
									<td className="mypage_td">
										<input type="text" className="join_form" onChange={changePhone}/>
									</td>
								</tr>

							</table>
						</div>
					</div>

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"}text={"수정하기"} onClick={updateInfo}></Button>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default TestAddrUpdate;