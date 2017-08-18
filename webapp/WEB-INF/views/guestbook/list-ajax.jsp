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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<title>Mysite</title>
</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">

					<form method="post"
						action="${pageContext.request.contextPath}/guestbook/insert">

						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>

					</form>
					<ul>

						<c:forEach items="${list}" var="vo">
							<li>
								<table>
									<tr>
										<td>[${vo.no }]</td>
										<td>${vo.name }</td>
										<td>${vo.reg_date }</td>
										<td><a
											href="${pageContext.request.contextPath}/guestbook/deleteform?no=${vo.no}">삭제</a></td>
									</tr>
									<tr>
										<td colspan=4>${fn:replace(vo.content, newLine, "<br>")}
										</td>
									</tr>
								</table> <br>
							</li>
						</c:forEach>
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
$(document).ready(function(){

    $.ajax({
     url : "${pageContext.request.contextPath }/api/guestbook/list",
     type : "post",
     /*contentType : "application/json",
     data : {name: "홍길동"},*/


      //dataType : "json",
      success : function(result){
         console.log(result);
      /*성공시 처리해야될 코드 작성*/},

      error : function(XHR, status, error) {
      console.error(status + " : " + error);

}


});

});




</script>
</html>

