import './Header.css';
import { Link } from 'react-router-dom';
import Logo from '../img/apple_logo_white.svg';

function Header() {
	
	return (
		<header className="py-4">
			{/* The navigation menu */}
			<div className="container navbar">
  				<Link to="/">Home</Link>
  				<Link to="/store">스토어</Link>
  				<Link to="/product">iphone</Link>
				<div class="dropdown">
					<div className="dropdown-toggle nav_hover" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">iphone
    				</div>
    				<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
      					<Link className="dropdown-item" to="/">iphone 15 pro max</Link>
      					<Link className="dropdown-item" to="/">iphone 15 pro</Link>
      					<Link className="dropdown-item" to="/">iphone 15</Link>
    				</div>
				</div>
  				<Link to="/cart">장바구니</Link>
  				<div class="dropdown">
    				<div className="dropdown-toggle nav_hover" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">OOO 로그인 중
    				</div>
    				<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
      					<Link className="dropdown-item" to="/mypage">회원 정보 수정</Link>
      					<Link className="dropdown-item" to="/mypage/payment">결제 내역</Link>
    				</div>
  				</div>
  				<div class="dropdown">
    				<div className="dropdown-toggle nav_hover" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">관리자 페이지
    				</div>
    				<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
      					<Link className="dropdown-item" to="/admin/product">상품 관리</Link>
      					<Link className="dropdown-item" to="/admin/product_create">상품 등록</Link>
      					<Link className="dropdown-item" to="/admin/payment">결제 내역</Link>
      					<Link className="dropdown-item" to="/admin/member">회원 관리</Link>
    				</div>
  				</div>
			
			</div>
		</header>
	);
}

export default Header;