import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import Button from '../common/Button';
import './Member.css';
import { AuthContext } from "../context/AuthProvider";
import TestUpdate from "./TestUpdate";

function TestInfoGetOne() {

    const { auth, setAuth } = useContext(AuthContext)
    const [Info, setInfo] = useState({});
    const {infoSeq} = useParams();

	const navigate = useNavigate();

    /* 회원 정보 1개 조회 */
	const getOne = async () => {

		await axios.get(`http://localhost:3000/info/${infoSeq}`, {params : {infoSeq : auth ? auth : ""}})
			.then((resp) => {
				console.log("[TestInfoGetOne.js] getOne() success :D");
                console.log(resp.data);
                setInfo(resp.data)

			}).catch((err) => {	
				console.log("[TestInfoGetOne.js] getOne() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getOne();
	}, []);

	const updateInfo = {
		infoSeq : Info.infoSeq,
		infoName : Info.infoName,
		infoBirth : Info.infoBirth,
        infoGender : Info.infoGender,
        infoPhone : Info.infoPhone
	}	

    const moveUpdate = (event) => {
        navigate(`/TestInfoUpdate/${infoSeq}`, {
			state : {data : Info}
		});
    }


    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">회원 정보 상세페이지</h1>
					</div>
					<div className="mypage_part1">
						<div>
							<h2 className="mypage_subtitle">기본 정보</h2>
						</div>
						<div className="">
							<table className="mypage_table">

                                <tr>
									<th className="mypage_th">회원 구분 번호</th>
									<td className="mypage_td">
                                        <span>{Info.infoSeq}</span>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 이름</th>
									<td className="mypage_td">
                                        <span>{Info.infoName}</span>
									</td>
								</tr>

								<tr>
									<th className="mypage_th">회원 생일</th>
									<td className="mypage_td">
                                        <span>{Info.infoBirth}</span>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">회원 성별</th>
									<td className="mypage_td">
                                        <span>{Info.infoGender}</span>
									</td>
								</tr>

                                <tr>
									<th className="mypage_th">회원 전화번호</th>
									<td className="mypage_td">
                                        <span>{Info.infoPhone}</span>
									</td>
								</tr>

							</table>
						</div>
					</div>

					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>

						<Link className="btn btn-outline-secondary"  to="/TestAddrUpdate/${addrSeq}" state={{ address: updateInfo }}> 수정</Link>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default TestInfoGetOne;