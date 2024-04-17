import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function Mypage() {


    return (
		<div>
			<h2> Mypage 입니다. </h2>
		</div>
	);
    
    }
    
    export default Mypage;