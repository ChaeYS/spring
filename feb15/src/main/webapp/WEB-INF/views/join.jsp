<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>회원가입</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="apple-touch-icon" sizes="57x57" href="assets/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="assets/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="assets/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="assets/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="assets/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="assets/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="assets/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="assets/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="assets/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="assets/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="/assetsfavicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="/assetsfavicon-16x16.png">
		<link rel="manifest" href="/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
        <script type="text/javascript">
        const Toast = Swal.mixin({
      	  toast: true,
      	  position: 'center-center',
      	  showConfirmButton: false,
      	  timer: 3000,
      	  timerProgressBar: true,
      	  didOpen: (toast) => {
      	    toast.onmouseenter = Swal.stopTimer;
      	    toast.onmouseleave = Swal.resumeTimer;
      	  }
      	});
        
      $(function(){
		 //Swal.fire('title', 'content', 'success');
		 //join을 클릭하면 이벤트 발생
		 $('#join').click(function(){
			 //Swal.fire('회원가입', '회원가입 버튼을 클릭하셨습니다', 'success');
			 //id값 가져오기
			 let id = $('#id').val();
			 let pw1 = $('#password1').val();
			 let pw2 = $('#password2').val();
			 let name = $('#name').val();
			 let email = $('#email').val();
			 Swal.fire('회원가입', '아이디 : ' + id + "비밀번호 : " + pw1 + "/" + pw2, 'success');
			 //alert("줄바꿈 \n 줄바꿈");
		 });
      });
      </script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <%@ include file="menu.jsp" %>
        
        <div class="mb-10">회원가입</div>
               
        <!-- join -->
         <section class="page-section" id="mail">
            <div class="d-flex justify-content-center">
            <div class="text-center p-5 w-50 bg-primary">
            <div class="mb-3 row">
    			<label for="id" class="col-sm-2 col-form-label">아이디</label>
  				<div class="col-sm-7">
    				<input type="text" id="id" class="form-control" placeholder="아이디를 입력하세요">
  				</div>
  				<div class="col-sm-3">
  					<button type="button" id="idCheck" class="btn btn-info w-100">ID 검사</button>
  				</div>
  			</div>
  			<div class="mb-3 row">
    			<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
  				<div class="col-sm-5">
    				<input type="password" class="form-control" id="password1" placeholder="비밀번호를 입력하세요">
  				</div>
  				<div class="col-sm-5">
    				<input type="password" class="form-control" id="password2" placeholder="비밀번호를 입력하세요">
  				</div>
  			</div>
  			<div class="mb-3 row">
    			<label for="name" class="col-sm-2 col-form-label">이 름</label>
  				<div class="col-sm-10">
    				<input type="name" class="form-control" id="name" placeholder="이름을 입력하세요">
  				</div>
			</div>
  			<div class="mb-3 row">
    			<label for="email" class="col-sm-2 col-form-label">이메일</label>
  				<div class="col-sm-10">
    				<input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요">
  				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-12">
    				<button type="submit" id="join" class="btn btn-info">회원가입</button>
  				</div> 		
            </div>
           	</div>
        </div>
        </section>
       
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
