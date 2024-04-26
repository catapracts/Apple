import { Link } from 'react-router-dom';
import React, { useState, useContext } from "react";
import { useNavigate } from 'react-router-dom';
import './Store.css';

function Store_Detail_1() {

    const navigate = useNavigate();

    return (
        <div>
            <div className="wide_container">
                <div className="detail_part1">
                    <div>
                        <h1 className="store_detail_title">iPhone 15 Pro Max 구매하기</h1>
                        <p className="store_detail_subtitle">1,500,000 부터</p>

                    </div>
                </div>
                <div className="store_detail_part2">
                    <div className="store_detail_left">
                        왼쪽 사진 영역
                    </div>
                    <div className="store_detail_right">
                        <div className="store_detail_name">
                            prod_name 선택 영역
                        </div>
                        <div className="store_detail_hdd">
                            용량 선택 영역
                        </div>
                        <div className="store_detail_color">
                            색상 선택 영역
                        </div>
                        <div className="store_detail_btn">
                            장바구니에 담기, 결제하기 영역
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Store_Detail_1;