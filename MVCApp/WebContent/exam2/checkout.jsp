<%@page import="java.util.Vector"%>
<%@page import="mvc.exam2.BookDto"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%
	Vector bookList = (Vector)session.getAttribute("cart");
	int sum=0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
</head>
<body>
<h1>도서 구매 주문 페이지</h1>
<hr/>
<b>주문한 도서</b><br/>
<table border="1">
	<tr>
		<th>도서 제목</th>
		<th>작가</th>
		<th>가격</th>
		<th>수량</th>
	</tr>
	<%for(int i=0; i<bookList.size();i++){
			BookDto dto = (BookDto)bookList.get(i);%>
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQuantity()%></td>
	</tr>
	<%
			sum += dto.getPrice() * dto.getQuantity();
		}
	%>
</table>
<hr/>
<b>전체 구입 액수 : <%=sum%></b>
</body>
</html>