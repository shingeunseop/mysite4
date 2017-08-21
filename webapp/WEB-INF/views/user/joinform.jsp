<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<title>Mysite</title>
</head>
<body>
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
						
						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="" />
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="" />
						<ul id="double_check">
						
						</ul>
						<input id="doublecheck" type="button" value="id 중복체크">
						
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="" />
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="submit" value="가입하기">
						
					</form>
					
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div><!-- /container -->
</body>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#doublecheck").click(function(){
		event.preventDefault();
		console.log("전송완료");
		var email=$("[name=email]").val();
		var no;
		
		$.ajax({
			url : "${pageContext.request.contextPath }/user/doublecheck",
		    type : "post",//데이터 형식
		     /*contentType : "application/json",*/
		    data :{email : email},//데이터 보내는 곳
		    dataType : "json",//json으로 받는다.
		    success : function(no) {//데이터 받는 곳
		    	console.log(no);
		    	if(no!=0){
		    		
		    		$("#double_check").html("이미 존재합니다.");
		    	}else{
		    		
		    		$("#double_check").html("사용 가능합니다.");
		    	}
		    },
		    error : function(XHR, status, error) {
		      	console.error(status + " : " + error);
			}
		    
		});
		
	
	});
	
});




</script>
</html>		
		
