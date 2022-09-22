<!-- 관리자페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
<!-- member.css파일 -->
<link rel="stylesheet" type="text/css" href="resources/css/member.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>

<script type="text/javascript">
	//버튼 눌렀을 때 productList.jsp호출
	$(document).ready(function() {
		$('#mainPage').click(function() {
			location.href = "productList.jsp";
		})
	});
	/* 페이징 처리 함수 =====================================================*/
	function fn_go_page(pageNo) {
		$("#pageIndex").val(pageNo);
		$("#listForm").submit();
		return false;
	}
	/* 검색함수 */
	function fn_search() {
		$("#pageIndex").val("1");
		$("#listForm").submit();
		return false;
	}
</script>
</head>
<body>
<!-- 페이징처리 총 게시물 수==================================================== -->
	<div></div>
	
	<div id="top">
		<jsp:include page="../../top.jsp"></jsp:include>
	</div>
	<h3>회원관리</h3>
	<h4>총회원수 ${totCnt} / 페이지 (${vo.pageIndex} / ${totalPageCnt})</h4>
	
	<button type="button" id="mainPage" class="btn btn-info" style="font-size:20px;">메인페이지로</button>
	<a href="memberAdmin">
		<button class="btn btn-info" style="font-size:20px;">회원전체검색</button>
	</a>
	<!-- 원래는 form 하나에 담았으나.. form 하나에 하나의 변수만 넣어줄 수 있는것으로 보인다. -->

	<form id="memberForm"
		action="${pageContext.request.contextPath}/memberAdmin">
		<!-- 컨트롤러의  memberAdmin으로 이동 후  -->
		<!-- views아래의(지금 이 파일) memberAdmin으로 action됨. -->
		<label>회원이름검색</label> <input name="keyword" type="text">
		<!--검색어 받아오는 코드  -->
		<button type="submit" class="btn btn-light">검색</button>
	</form>

	<table border=2>
		<tr>
			<td class="left">아이디</td>
			<td class="left">이름</td>
			<td class="left">패스워드</td>
			<td class="left">전화번호</td>
			<td class="left">나이</td>
			<td class="left">주소</td>
			<td class="left">레벨</td>
		</tr>
		<c:forEach items="${list}" var="one"><!-- 컨트롤러에 List MemberPageList 가져옴 -->
			<!-- var="one"는  items="${MemberPageList}"를 지칭해주는 말이다. ${MemberPageList}를 one이라고 쓰겠다는 의미.-->
			<tr>
				<td class="right">${one.user_id}</td>
				<td class="right"><a href="memberOne?user_id=${one.user_id}">${one.user_name}</a></td>
				<!-- 이름을 클릭하면 해당 아이디의 상세정보를 확인할 수 있도록 구현
				 href="views아래에 있는 상세정보jsp이름"?"유저아이디 객체 이름"-->
				<td class="right">${one.user_pw}</td>
				<td class="right">${one.user_tel}</td>
				<td class="right">${one.user_age}</td>
				<td class="right">${one.user_addr}</td>
				<td class="right">${one.level}</td>
			</tr>
		</c:forEach>
	</table>
		<!-- Paging[s] =========================================================-->
	
	<div class="col-sm-12 col-md-7" style="text-align:right">
	<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
	  <ul class="pagination">
	  
	  <!-- 이전 페이지 버튼생성 (현재 페이지에서 -1)-->
	  <c:if test="${vo.prev}">
	  <li class="paginate_button page-item previous" id="dataTable_previous">
	 		 <a href="javascript:void(0);" onclick="fn_go_page(${vo.startDate - 1});
	 		  return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0"
	 		   class="page-link">Previous</a>
	  </li>
	  </c:if>
	  
 	  <!-- 페이지 버튼생성 -->
	  <c:forEach var="num" begin="${vo.startDate}" end="${vo.endDate}">
	  <li class="paginate_button page-item">
	 		 <a href="javascript:void(0);" onclick="fn_go_page(${num});
	 		  return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0"
	 		   class="page-link">${num}</a>
	  </li>
	  </c:forEach>
	  
	  <!-- 다음 페이지 버튼생성 (현재 페이지 +1) -->
	  <c:if test="${vo.next}">
	  <li class="paginate_button page-item next" id="dataTable_next">
	 		 <a href="javascript:void(0);" onclick="fn_go_page(${vo.endDate + 1}); 
	 		 return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0"
	 		  class="page-link">Next</a>
	  </li>
	  </c:if>
	  </ul>
	</div>
	</div>
	<!-- Paging[e] =========================================================-->
	 <!-- form안에 input hidden으로 pageIndex 값을 넣어줘야 서버로 들고갈 수 있다.-->
	<form method="get"  id="listForm" action="memberAdmin">
	<input type="hidden" id="pageIndex" name="pageIndex" val="" />
	</form>
</body>
</html>