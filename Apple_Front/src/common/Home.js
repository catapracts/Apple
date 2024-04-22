import './Home.css';
import homeimg1 from '../img/home_iphone15promax.png';
import homeimg2 from '../img/home_iphone15pro.png';
import homeimg3 from '../img/home_iphone15.png';

const Home = () => {
	return (
		<div className="main container-fluid">
			<div className="home1">
				<img src={homeimg1} alt=""/>
				<div className="hometext1">
					<h3>iPhone 15 Pro Max</h3>
					<p>티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn1">
					<button className="btn1">더 알아보기</button>
					<button className="btn2">구입하기</button>
				</div>
			</div>
			<div className="home2">
				<img src={homeimg2} alt="" />
				<div className="hometext2">
					<h3>iPhone 15 Pro</h3>
					<p>티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn2">
					<button className="btn1">더 알아보기</button>
					<button className="btn2">구입하기</button>
				</div>
			</div>
			<div className="home3">
				<img src={homeimg3} alt="" />
				<div className="hometext3">
					<h3>iPhone 15</h3>
					<p>티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn3">
					<button className="btn1">더 알아보기</button>
					<button className="btn2">구입하기</button>
				</div>
			</div>
		</div>
	
	);
}

export default Home;