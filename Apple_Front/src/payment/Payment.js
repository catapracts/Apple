import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";


function Payment() {


    return (
		<div>
			<h2> Payment 입니다. </h2>
		</div>
	);
    
    }
    
    export default Payment;