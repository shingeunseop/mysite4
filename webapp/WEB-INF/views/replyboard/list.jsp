<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.request.contextPath}/replyboard/search"
					method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${list }" var="vo">
						<tr>
							<td>${vo.no }</td>
							<td style="text-align: left;">
							
								<c:if test="${vo.orderNo!=1}">
							   		<img id="reply" src="${pageContext.request.contextPath}/assets/images/reply.png">
								</c:if> 
								
								
								<a href="${pageContext.request.contextPath}/replyboard/read?no=${vo.no }&groupNo=${vo.groupNo}&orderNo=${vo.orderNo}&depthNo=${vo.depthNo}">								
									${vo.title }
								</a>
								
								
							</td>
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<td><c:if test="${authUser.no == vo.userNo }">
									<a
										href="${pageContext.request.contextPath}/replyboard/delete?groupNo=${vo.groupNo }&orderNo=${vo.orderNo}"
										class="/mysite4/webapp/assets/images/delete.png">삭제</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li class="selected">3</li>
						<li><a href="">4</a></li>
						<li><a href="">5</a></li>
						<li><a href="">6</a></li>
						<li><a href="">7</a></li>
						<li><a href="">8</a></li>
						<li><a href="">9</a></li>
						<li><a href="">10</a></li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<c:if test="${authUser != null }">
					<div class="bottom">
						<a href="${pageContext.request.contextPath}/replyboard/writeform"
							id="new-book">글쓰기</a>
					</div>
				</c:if>
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- /container -->
</body>
</html>

