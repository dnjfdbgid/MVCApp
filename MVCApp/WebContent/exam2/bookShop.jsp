<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
</head>
<body>
<h1>도서 주문 페이지</h1>
<hr/>
<form method="post" action="/MVCApp/book.do">
<input type="hidden" name="command" value="add" />
	<b>도서 선택 : </b>
	<select name="book">
		<option>어린 왕자 / 생떽쥐페리 / 15000</option>
		<option>연금술사 / 파올로 코엘료 / 21000</option>
		<option>홍길동전 / 허균 / 25000</option>
		<option>50 Greatest Short Stories / Crane, Milton / 9800</option>
	</select>
	<br/>
	<b>수량 : </b>
	<input type="text" name="quantity" size="2" value="1" />
	<br/><br/>
	<input type="submit" value="장바구니에 담기" />
</form>
<hr/>
<jsp:include page="cart.jsp"/>
</body>
</html>