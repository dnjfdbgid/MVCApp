<%@page import="mvc.exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%
	Vector bookList = (Vector)session.getAttribute("cart");
	
%>

<%
	try{
		if( bookList != null || bookList.size() > 0){
%>
<b>���� �ֹ��� ����</b>
<hr/>
<table border="1">
	<tr>
		<th>���� ����</th>
		<th>�۰�</th>
		<th>����</th>
		<th>����</th>
		<th>���</th>
	</tr>
	<%for(int i=0; i<bookList.size();i++){
		BookDto dto = (BookDto)bookList.get(i);%>
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQuantity()%></td>
		<td>
			<form method="post" action="/MVCApp/book.do">
				<input type="hidden" name="command" value="del" />
				<input type="hidden" name="idx" value="<%=i%>"/>
				<input type="submit" value="����"/>
			</form>
		</td>
	</tr>
	<%}%>
</table>
<br/>
<form method="post" action="/MVCApp/book.do">
	<input type="hidden" name="command" value="chk" />
	<input type="submit" value="üũ �ƿ�" />
</form>
<%
		}
	}catch(Exception err){
		
	}
%>