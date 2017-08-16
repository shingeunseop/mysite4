<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${rbv.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								
								${rbv.content}
								
							</div>
						</td>
					</tr>
				</table>		<div class="bottom">
					<a href="${pageContext.request.contextPath}/replyboard/list">글목록</a>
					
					<c:if test="${authUser.no == rbv.userNo }">
						<a href="${pageContext.request.contextPath}/replyboard/modifyform?no=${rbv.no }">글수정</a>
					</c:if>
					
				<c:if test="${authUser != null }">
							<a href="${pageContext.request.contextPath}/replyboard/datform?groupNo=${rbv.groupNo}&orderNo=${rbv.orderNo}
							&no=${rbv.no}"
							 id="new-book">댓글</a>
				</c:if>			
					
				</div>
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div><!-- /container -->
</body>
</html>		
		
