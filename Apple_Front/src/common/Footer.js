import './Footer.css';
import { Link } from 'react-router-dom';

function Footer() {
	return (
		<footer className="footer_bg">
      <div className="container">
        <div className="div_flex">
          <div>
            <h3 className="footertitle">쇼핑 및 알아보기</h3>
            <ul>
              <Link to="/store"><li>스토어</li></Link>
              <Link to="/product"><li>iPhone</li></Link>
              <Link to="/cart"><li>장바구니</li></Link>
            </ul>
          </div>

          <div>
            <h3 className="footertitle">계정</h3>
            <ul>
              <Link to="/mypage"><li>회원 정보 수정</li></Link>
              <Link to="/login"><li>로그인</li></Link>
              <li>결제 내역</li>
            </ul>
          </div>

          <div>
            <h3 className="footertitle">회원</h3>
            <ul>
              <Link to="/join"><li>회원가입</li></Link>
              <Link to="/login"><li>로그인</li></Link>
              <li>로그아웃</li>
            </ul>
          </div>
        </div>
        <hr></hr>
        <div className=""> Copyrightⓒ 2024 Apple Inc. 모든 권리 보유.</div>
        <p />
        <div className="div_flex">
          <div>개인정보 처리 방침</div>
          <div>웹 사이트 이용 약관</div>
          <div>판매 및 환불</div>
          <div>법적 고지</div>
          <div>사이트 맵</div>
        </div>
        <p />
      </div>
    </footer>
	);
}

export default Footer;