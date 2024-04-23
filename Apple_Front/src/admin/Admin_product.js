import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Pagination from "react-js-pagination";

import './Admin.css';

function Admin_product() {

    const [getAll] = useState([]);

    //paging
    const [page, setPage] = useState(1);
	const [totalCnt, setTotalCnt] = useState(0);

    // Link 용 (함수) 
    let navigate = useNavigate();

    /* [GET /bbs]: 게시글 목록 */
	const getBbsList = async (choiceVal, searchVal, page) => {

        //	await axios.get("http://localhost:3000/bbs", { params: { "choice": choice, "search": search, "page": page } })
        await axios.get("http://localhost:3306/bbs", { params: { "choice": choiceVal, "search": searchVal, "page": page } })
                
            .then((resp) => {
                console.log("[Admin_product.js] useEffect() success :D");
                console.log(resp.data);
    
                setGetAll(resp.data.getAll);
                setTotalCnt(resp.data.pageCnt);
            })
            .catch((err) => {
                console.log("[Admin_product.js] useEffect() error :<");
                console.log(err);

            });
    }
    
        useEffect(() => {
            getAll("", "", 1);
        }, []);
    
    
        const changeChoice = (event) => { setChoiceVal(event.target.value); }
        const changeSearch = (event) => { setSearchVal(event.target.value); }
        const search = () => {
            console.log("[BbsList.js searchBtn()] choiceVal=" + choiceVal + ", searchVal=" + searchVal);
    
            navigate("/bbslist");
            getBbsList(choiceVal, searchVal, 1);
        }
    
        const changePage = (page) => {
            setPage(page);
            getBbsList(choiceVal, searchVal, page);
        }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 관리</h1>                    
                    </div>
                    <div>
                        <table className="tale table-hover">
                            <thead>
					            <tr>
                                    <th className="col-1">번호</th>
                                    <th className="col-8">제목</th>
                                    <th className="col-3">작성자</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    getAll.map(function (product, prod_seq) {
                                        return (
                                            <TableRow obj={product} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                }
                            </tbody>
                        </table>

                        <Pagination className="pagination"
                            activePage={page}
                            itemsCountPerPage={10}
                            totalItemsCount={totalCnt}
                            pageRangeDisplayed={5}
                            prevPageText={"‹"}
                            nextPageText={"›"}
                            onChange={changePage} />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product;