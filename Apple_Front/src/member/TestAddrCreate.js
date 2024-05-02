import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from '../common/Button';
import './Member.css';

function TestAddrCreate() {
	const [addrZip, setAddrZip] = useState("");
	const [addrDetail, setAddrDetail] = useState("");

	const navigate = useNavigate();			// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

	const changeZip = (event) => {			// Client에서 id입력하면, 입력한 값 저장
		setAddrZip(event.target.value);
	}

	const changeDetail = (event) => {			// Client에서 pwd입력하면, 입력한 값 저장
		setAddrDetail(event.target.value);
	}

	/* 주소 정보 생성 */
	const createAddress = async () => {

		const req = {													// req라는 이름의 변수를 객체 형식으로 사용
			addrZip: addrZip,
			addrDetail: addrDetail
		}

		await axios.post("http://localhost:3000/address/create", req)		// req라는 객체를 서버에 전달해서 회원가입 진행
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[TestAddrCreate.js] addrCreate() success :D");
				console.log(resp.data);
				navigate("/TestAddrFindAll");

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[TestAddrCreate.js] addrCreate() error :<");
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
					<h1 className="member_title">주소 등록</h1>
					</div>
					<div className="d-flex justify-content-center">
						<table className="join_table">

							<tr>
								<th className="join_th">우편 번호</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeZip} />
								</td>
							</tr>
							<tr>
								<th className="join_th">상세 주소</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeDetail} />	
								</td>
							</tr>

						</table><br />
					</div>
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"} text={"가입하기"} onClick={createAddress}></Button>
					</div>
				</div>

			</div>

		</div>
	);
}

export default TestAddrCreate;	// Join component를 외부의 다른 component가 사용할 수 있도록 설정