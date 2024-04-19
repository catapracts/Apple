import './Header.css';
import { Link } from 'react-router-dom';
import Logo from '../img/apple_logo_white.svg';

function Header() {
	return (
		<header className="py-4">
			{/* The navigation menu */}
			<div className="container navbar">
  				<Link to="/">Home</Link>
  				<Link to="/">스토어</Link>
  				<Link to="/">iphone</Link>
  				<Link to="/">장바구니</Link>
  				<div class="dropdown">
    				<div className="dropdown-toggle nav_hover" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">OOO 로그인 중
    				</div>
    				<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
      					<Link className="dropdown-item" to="/">회원 정보 수정</Link>
      					<Link className="dropdown-item" to="/">결제 내역</Link>
      					<Link className="dropdown-item" to="/">배송 조회</Link>
    				</div>
  				</div>
			
			</div>
		</header>
	);
}

export default Header;