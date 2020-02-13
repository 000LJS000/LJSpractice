

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="http://code.jquery.com/jquery-1.7.js"></script>

<!--폰트설정  -->
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato|Nanum+Gothic|Noto+Sans|Noto+Sans+KR|Open+Sans&display=swap" rel="stylesheet">
<title>welcome space</title>

<style type="text/css">
   /*font설정  */

   /* 공통적용사항 */
   *{margin:0;font-family: 'Jeju Gothic', sans-serif;font-family: 'Nanum Gothic', sans-serif;
font-family: 'Open Sans', sans-serif;
font-family: 'Lato', sans-serif;
font-family: 'Noto Sans', sans-serif;
font-family: 'Noto Sans KR', sans-serif;}
   html,body{height: 100%;}
   h1{padding-top: 30px;text-align: center}
   li{list-style: none;cursor: pointer;text-align: center;}
   a{text-decoration: none;color:black;cursor: pointer;}
   #wrap{border: 1px soild}
   
   
/*contents  */
#contents{width: 100%;height:100%;margin-bottom:100px}
/*footer  */
#footer { border-top: 1px solid;text-align: center;bottom:0;position:fixed;width: 100%;font: 20px;background: white;}

</style>
<script type="text/javascript">
/* 메뉴 토글 */


</script>
<title>Space</title>
</head>
<body>
	<div id="wrap">
			<div id="header">
				

<script src="http://code.jquery.com/jquery-1.7.js"></script>


   <style type="text/css">

    /* header */
    
#top{border-bottom:1px solid;width: 100%;height: 100%;height: 80px;margin-top:15px}
#menu{width: 70%;margin-left: 15%;}
.logo{width: 10%;float:left;font-size: 20px;margin-top:20px}
.nav{talign-items: center;ext-align:center; margin:0px;float: right; position: relative;}
.nav>li{width:150px;height:50px;float:left;display:flex ;align-items:center;} 
.nav>li>a{width: 100%;text-align: center;} 
.nav>li>a:hover{transition:all 0.3s ease-in;border-left:8px solid #ffaa28; }

/*메뉴 토글 */
.bar{text-align: center;}
.hide{position: fixed;top:calc(10%);left: calc(100% - 380px);display: none;padding: 0; background-color: white;border-radius: 10px}
.hide>li{ cursor:pointer; height:50px;display:flex; align-items: center;position: relative;}

.hide>li:hover{transition:all 0.4s ease-in;border-bottom:10px solid #9400d3;background-color:50%}
.hide>li:hover:last-child{border-radius: 10px;}
.hide>li>a{display:block;width: 100%; text-align: center;line-height: 50px;}
.hide>li>a:hover{transition:all 0.4s ease-in;}
 /*메뉴 삼색바 디자인  */
 #x{display: inline-block;width: 100%}
.bar1, .bar2, .bar3 {
  width:calc(50%/3);
  height: 5px;
  background-color: #333;
  margin: 6px 0;

} 
   </style>
<script type="text/javascript">
function logout() {
	if(confirm("로그아웃하시겠습니까?")==true){
		alert("로그아웃되었습니다.");
	}else{
		return false;
	}
}
$(document).on('click','.bar',function(){
	
	$('.hide').slideDown();
	console.log("click");

}); 


</script>
 <div id="top" >
        <div id="menu">
            <div class="logo"><a href="/two/main">공간</a></div>
            <ul class="nav">
                <li><a href="#">예약확인</a></li>
                
                <!-- 로그인했을때 마이페이지버튼 나타나게하기 -->
               
                <li class="log" >
                
                <!--로그인안했을경우  로그인버튼 -->
                
                	<a href="/two/login/loginForm">로그인</a></li>
                	
                	
                <!-- 로그인했을경우 로그아웃버튼으로 변경-->
                
                	
                <li class="bar" onclick="">
                <div id="x">
                <div class="bar1"></div>
                <div class="bar2"></div>
                <div class="bar3"></div></div>
                	<ul class="hide">
                            <li>님<span></span> </li>
                             
                            <li><a href="#">전체 공간 리스트 보기</a></li>
                            <li><a href="#">예약공간보기</a></li>
                            <li><a href="#">찜한공간보기</a></li>
                            <li><a href="#">내가등록한 공간보기</a></li>
                            <li><a href="#">공지사항</a></li>
                           
                        </ul> 
                </li>
                
            </ul>
            
        </div>

    </div>

			</div>
		<div id="contents">
			
<style>

#loginform{width:648px; margin:0 auto;text-align:center;margin-bottom:100px}
.logintable{padding-top: 50px;padding-left: 0;}
.logintable>li{list-style: none;text-align: center;}
.logintable>li>a{float:right;}
.logintable>li>p{padding-right: 0;}
 .logintable>li>input{width: 100%;height: 50px; border:1px solid #e0e0e0;margin-bottom:20px} 
 
 p>a{color:blue}
 
 button{width:100%; height: 50px;background-color:#ffd014; display: block; border:none;margin-top: 10px;font-size: 20px;}

</style>
<script type="text/javascript">

	 function fn_login() {
		 if($("#USER_ID").val()==""){
			 
			 alert("아이디를 입력해주세요");
			 $("USER_ID").focus();
			 return false;
		 }
		 else if($("#USER_PASSWORD").val()==""){
			 
			 alert("비밀번호를 입력해주세요");
			 $("USER_PASSWORD").focus();
			 return false;
			 //버튼실행시
	 }
	 return true;
	 }
		
</script>
	<form  action="/two/login/login" method="post" id="frm" onsubmit="return fn_login();">
		<div id="loginform">
			<h1>로그인</h1>
			<ul class="logintable">
				<li><input type="text" name="USER_ID" id="USER_ID" placeholder="아이디">
				</li>
				<li><input type="password" name="USER_PASSWORD" id="USER_PASSWORD" placeholder="비밀번호">
				</li>
				<li><a href="/two/login/findIdPwd">아이디/비밀번호찾기</a><br></li>
				<li>
					<button type="submit" id="submit">로그인</button>

				</li>
			</ul>
			<p>
				아직 회원이 아니신가요? <a href="/two/join/joinForm">회원가입하기</a>

			</p>
		</div>
	</form>
	<label> null</label>
 
		</div>
		<div id="footer">
			

<style type="text/css" >

.footer_contents {text-align:center;margin-bottom:10px; font-size: 12px;}
.footer_menu {text-align: center;}
.footer_menu>ul{display: flex; width: 35%; margin: 0 auto; padding-left:0}
.footer_menu>ul>li {float: left;width:calc(100%/4);}
.footer_menu>ul>li:not(:first-child){border-left:1px solid #b6b3b3;}

.footer_logo{margin-bottom: 10px;margin-top:10px}
</style>
<div class="footer_contents">

	<div class="footer_logo">
		<a href="/testmain">로고</a>
	</div>
	<div class="company">
		<p>(우)06531 서울특별시 서초구 신반포로49길 12 하늘정원빌딩 3층 쉐어잇 주식회사</p>
	</div>
	<div class="footer_menu">
		<ul>
			<li><a href="#">이용약관 </a></li>
			<li><a href="#">개인정보처리방침</a></li>
			<li><a href="#">운영정책</a></li>
			<li><a href="#">고객문의</a></li>
		</ul>
	</div>
</div>


		
	</div>
	</div>
</body>
</html>