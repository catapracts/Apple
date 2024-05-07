# Apple
'휴대폰 판매' Web Application Project입니다.
<br/><br/>


# 📑목차
* [개발 환경](#개발-환경)
* [사용 언어](#사용-언어)
* [구현 기능](#구현-기능)
* [개발 인원](#개발-인원)
* [Front End](#Front-End)
* [Back End](#Back-End)
<br/><br/>


# 🛠개발 환경
|tool, service, SW이름|버전|
|----|----|
|SpringBoot|3.2.4|
|MySQL Workbench|8.0.3|
|React|18.2.0|
|GitHub, GitLab||
|Jenkins||
|Docker||
|Kubernetes||
|Elasticsearch|Test : v7, Service : v8|
|lombok|1.18.30|
|Swagger(docs)|2.0.2|
|Spring Security|6.2.3|
|MyBatis|3.0.3|
|Node.js|16.16.0|
|JSON Web Token|0.11.5|
|ApacheTomcat|10.1.19|
|slf4j|2.0.12|
|jUnit|5.10.2|



# 🖋사용 언어
* HTML5, CSS, Javascript
* SQL 
* React 
* Axios
* Spring
<br/><br/>


# ⚙구현 기능
## 회원
* 회원가입, 회원 정보 수정(주소, 카드정보, 회원 개인 정보), 회원 정보 삭제, 회원 정보 조회(1개, 전체)
<br/><br/>


## 상품
* 상품 정보 생성, 수정, 삭제, 조회(1개, 전체)
<br/><br/>


## 장바구니
* 장바구니 생성
* 장바구니에 상품 선택(생성), 담기, 삭제, 수정, 조회(1개, 전체)
<br/><br/>


## 결제
* 결제 정보 생성(결제)
* 결제 정보 삭제(환불, 기록 삭제)
* 결제 정보 수정(배송지 등)
* 결제 정보 조회(1개, 전체)
<br/><br/>


# 👨‍💻개발 인원
## 정상엽(팀장)
* 프로젝트, 형상 관리, API 문서 작성 총괄
* FE, BE 개발 환경 세팅
* ERD 작성 / DB 정규화 / ERD, 프로젝트 기획 가이드 제작
* BE : Member관련 Domain(Member, Address, Info, Card), Cart관련 Domain(Cart, Cart Product) 구현 / Spring 개발환경(Config, SpringSecurity, JWT) 구현
* FE : Member 파트, Context, Router 파트 제작 / Member, Cart관련 Domain간 FE/BE연동
* API 문서 작성 (Member, Cart Domain)
<br/><br/>


## 제지운
* BE : Product관련 Domain(Product, Hdd, Color, Plus) 구현
* FE : common, product, admin 파트 제작 / Front 디자인 전체, Product관련 Domain간 FE/BE연동
* 문서화 작업 제작(발표 PPT), 시연 영상 제작
* API 문서 작성(Product Domain)
<br/><br/>


## 김기백
* BE : Payment관련 Domain(Payment, Payment Product) 구현
* FE : Payment 파트, store 파트 제작 / Payment관련 Domain간 FE/BE연동
* API 문서 작성 (Payment Domain)
<br/><br/>


# 😎Front End
1. member
 * Login.js(로그인)
 * Logout.js(로그아웃)
 * Join.js(회원가입)
 * MyPage.js(마이페이지 - 회원관련 전체 정보 조회)
 * MyPage_Update.js(마이페이지 - 회원관련 정보 수정)
 * MyPage_payment.js(마이페이지 - 결제관련 정보 전체 조회)
 * MyPage_payment_detail.js(마이페이지 - 결제관련 정보 상세 조회)
<br/><br/>
 
 2. context
  * AuthProvider.js(회원 로그인 인증 처리)
  * HttpHeaderProvider.js(JWT Header 처리)
  * ScrollToTop.js(화면 스크롤 조작 시 설정)
<br/><br/>
 
3. store
  * Store.js(스토어 메인 페이지)
  * Store_Detail_1.js(스토어 상세 페이지 - 상품1 설명 페이지)
  * Store_Detail_2.js(스토어 상세 페이지 - 상품2 설명 페이지)
  * Store_Detail_3.js(스토어 상세 페이지 - 상품3 설명 페이지)
<br/><br/>

 4. product
  * Product.js(상품 메인 페이지)
  * Product_Detail_1.js(상품1 결제 전 옵션 선택 페이지)
  * Product_Detail_2.js(상품2 결제 전 옵션 선택 페이지)
  * Product_Detail_3.js(상품3 결제 전 옵션 선택 페이지)
<br/><br/>
 
5. common
  * Button.js(페이지에 사용할 버튼 설정)
  * Footer.js(페이지 맨 아래 sitemap등 설정)
  * Header.js(페이지 맨 위 nav bar등 설정)
  * Home.js(페이지 접속시 나타나는 처음 화면)
  * Main.js(모든 component들 표시하는 페이지)
<br/><br/>

6. admin
 * Admin_color_detail.js(관리자 페이지 - 상품 색상 상세 조회)
 * Admin_color_update.js(관리자 페이지 - 상품 색상 수정)
 * Admin_hdd_detail.js(관리자 페이지 - 상품 용량 상세 조회)
 * Admin_hdd_update.js(관리자 페이지 - 상품 용량 수정)
 * Admin_member_detail.js(관리자 페이지 - 회원 상세 조회)
 * Admin_member.js(관리자 페이지 - 회원 전체 조회)
 * Admin_payment_detail.js(관리자 페이지 - 결제 상세 조회)
 * Admin_payment.js(관리자 페이지 - 결제 전체 조회)
 * Admin_plus_detail.js(관리자 페이지 - 상품 용량별 추가 금액 상세 조회)
 * Admin_plus_update.js(관리자 페이지 - 상품 용량별 추가 금액 수정)
 * Admin_product_create.js(관리자 페이지 - 상품 정보 생성)
 * Admin_product_update.js(관리자 페이지 - 상품 정보 수정)
 * Admin_product_detail.js(관리자 페이지 - 상품 정보 상세 조회)
 * Admin_product.js(관리자 페이지 - 상품 정보 전체 조회)
<br/><br/>

7. router
 * router.js(component들을 mapping한 파일)
<br/><br/>


# 🤓Back End
1. Product
* Controller - Product_Controller.java <br/><br/>
* Service - Product_Service.java <br/><br/>
* Domain – Product.java <br/><br/>
* DTO <br/><br/>
  1. param		
   + ProductCreateParam.java
   + ProductUpdateParam.java
   + ProductDeleteParam.java
   + ProductListParam.java
   + ProductParam.java
<br/><br/>
  2. request	
   + ProductListRequest.java
   + ProductCreateRequest.java
   + ProductUpdateRequest.java
<br/><br/>
  3. response	
   + ProductResponse.java
   + ProductListResponse.java
   + ProductCreateResponse.java
   + ProductUpdateResponse.java
   + ProductDeleteResponse.java
<br/><br/>
* DAO - Product_Dao.java
<br/><br/>


2. Member
* Controller – Member_Controller.java <br/><br/>
* Service - Member_Service.java <br/><br/>
* Domain – Member.java <br/><br/>

* DTO <br/><br/>
  1. param
   + MemberCreateParam.java
   + MemberUpdateParam.java
   + MemberDeleteParam.java
   + MemberListParam.java
   + MemberParam.java
<br/><br/>
  2. request	
   + MemberListRequest.java
   + MemberCreateRequest.java
   + MemberRequest.java
<br/><br/>
  3. response
   + MemberResponse.java
   + MemberListResponse.java
   + MemberCreateResponse.java
   + MemberUpdateResponse.java
   + MemberDeleteResponse.java
<br/><br/>
* DAO - Member_Dao.java
<br/><br/>


3. Cart & Cart Product
* Controller – CartController.java <br/><br/>
 
* Service - CartService.java <br/><br/>
 
* Domain – Cart.java, CartProduct.java <br/><br/>
 
* DTO <br/><br/>
  1. param
   + CartCreateParam.java / CartProductCreateParam.java
   + CartUpdateParam.java / CartProductUpdateParam.java
   + CartDeleteParam.java / CartProductDeleteParam.java
   + CartListParam.java / CartProductListParam.java
   + CartParam.java / CartProductParam.java
<br/><br/>
  2. request
   + CartListRequest.java / CartProductListRequest.java
   + CartCreateRequest.java / CartProductCreateRequest.java
   + CartUpdateRequest.java / CartProductUpdateRequest.java
<br/><br/>
  3. response
   + CartResponse.java / CarProductResponse.java
   + CartListResponse.java / CartProductListResponse.java
   + CartCreateResponse.java / CartProductCreateResponse.java
   + CartUpdateResponse.java / CartProductUpdateResponse.java
   + CartDeleteResponse.java / CartProductDeleteResponse.java
<br/><br/> 
* DAO - CartDao.java, CartProductDao.java
<br/><br/>


4. Payment & Payment Product
* Controller – PaymentController.java <br/><br/>

* Service - Payment Service.java <br/><br/>

* Domain – Payment.java, PaymentProduct.java <br/><br/>
 
* DTO <br/><br/>
  1. param
   + PaymentCreateParam.java / PaymentProductCreateParam.java
   + PaymentUpdateParam.java / PaymentProductUpdateParam.java
   + PaymentDeleteParam.java / PaymentProductDeleteParam.java
   + PaymentListParam.java / PaymentProductListParam.java
   + PaymentParam.java / PaymentProductParam.java
<br/><br/>
  2. request
   + PaymentListRequest.java / PaymentProductListRequest.java
   + PaymentCreateRequest.java / PaymentProductCreateRequest.java
   + PaymentUpdateRequest.java / PaymentProductUpdateRequest.java
<br/><br/>
  3. response
   + PaymentResponse.java / PaymentProductResponse.java
   + PaymentListResponse.java / PaymentProductListResponse.java
   + PaymentCreateResponse.java / PaymentProductCreateResponse.java
   + PaymentUpdateResponse.java / PaymentProductUpdateResponse.java
   + PaymentDeleteResponse.java / PaymentProductDeleteResponse.java
<br/><br/>
* DAO - PaymentDao.java, PaymentProductDao.java
<br/><br/>


5. Common
* Config Domain
  - DatabaseConfig.java
  - SwaggerConfig.java
  - WebConfig.java
<br/><br/>

 
* JWT Domain
  - JwtAuthenticationEntryPoint.java
  - JwtAuthenticationFilter.java
  - JwtTokenUtil.java
<br/><br/>


* Security Domain
  - UserDetailsImpl.java
  - UserDetailsServiceImpl.java
  - WebSecurityConfig.java

