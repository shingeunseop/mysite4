<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
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
				<div id="guestbook">

					<form id="write_form" method="post"
						action="${pageContext.request.contextPath}/guestbook/insert">

						<table>
							<tr>
								<td>이름</td>
								<td><input id="name" type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input id="password" type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>

					</form>
					<ul id="guestbook_list">
						<!-- 이 위치에 값이 들어가라고 id를 설정헤줌 -->


					</ul>

				</div>
				<!-- /guestbook -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- /container -->
</body>

<script type="text/javascript">
	$(document).ready(function() {
		fetchlist();//list를 그려라 라는 명령

		//저장버튼 클릭
		$("#write_form").on("submit", function() {//위에 있는 write_form 즉, 전에 사용하던 write_Form의 기능을 막아준다.
			event.preventDefault();//원래 기능을 막아준다.
			console.log("전송완료");
			var name = $("[name=name]").val();
			var password = $("[name=password]").val();
			var content = $("[name=content]").val();
			/* 밑의 메소드는 이 것을 간편화 한것
			 
			 var guestbookVo={
				 name=$("[name=name]").val(),
				 password=$("[name=password]").val(),
				 content=$("[name=content]").val()
				 
			 };*/

			//ajax의 형식
			$.ajax({
				url : "${pageContext.request.contextPath }/api/guestbook/add",
				type : "post",//데이터 형식
				/*contentType : "application/json",*/
				data : {
					name : name,
					password : password,
					content : content
				},//앞의 name은 앞쪽에서의 name 뒤에서는 넘기고 싶은 값

				dataType : "json",//json으로 받는다.
				success : function(guestbookVo) {
					console.log(guestbookVo);
					reader(guestbookVo, "up");
					/*성공시 처리해야될 코드 작성*/},

				error : function(XHR, status, error) {
					console.error(status + " : " + error);

				}

			});

		});

	});

	function fetchlist() {

		//ajax의 형식
		$.ajax({
			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "post",//데이터 형식
			/*contentType : "application/json",
			data : {name: "홍길동"},*/

			//dataType : "json",
			success : function(guestbooklist) {
				for (var i = 0; i < guestbooklist.length; i++) {
					reader(guestbooklist[i], "down");//한번씩 List값을 가져오라는 얘기
				}

				console.log(guestbooklist);
				/*성공시 처리해야될 코드 작성*/},

			error : function(XHR, status, error) {
				console.error(status + " : " + error);

			}

		});

	}

	function reader(guestbookVo, updown) {

		var str = "";//여기에 문자열을 담는다.

		str += "<li>";

		str += "      <table>";
		str += "           <tr>";
		str += "               <td>[" + guestbookVo.no + "]</td>";
		str += "               <td>" + guestbookVo.name + "</td>";
		str += "               <td>" + guestbookVo.reg_date + "</td>";
		str += "               <td><a href='${pageContext.request.contextPath}/guestbook/deleteform?no=${vo.no}'>삭제</a></td>";
		str += "          </tr>";
		str += "          <tr>";
		str += "            <td colspan=4>" + guestbookVo.content + "</td>";
		str += "         </tr>";
		str += "     </table>";
		str += "     <br/>";
		str += "</li>";

		if (updown == "down") {
			$("#guestbook_list").append(str);//javascript는 ()를 이용

		} else if (updown == "up") {
			$("#guestbook_list").prepend(str);
		} else {
			$("#guestbook_list").append(str);
		}

	}
</script>
</html>

