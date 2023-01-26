<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

function edit(id){
	
	
	location.href="/getUserById?id="+id
	
	/*  $.ajax({
         url: '/getUserById?id='+id,
         method: 'GET',
         dataType: 'json',
         success: function (data) {
            
        	 
        	 
              
            // getAllBooks();
         },
         error: function (error) {
             alert(error);
         }
     })	 */
	
}
function edit1(id){

	
	location.href="/deleteUser?id="+id
		
}

</script>
<body>

<h1>User List</h1>

	<table border="3">
		<tr>

			<th>Name</th>
			<th>Date Of Birth</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>



		<c:forEach items="${list}" var="lang">
			<tr>


				<td><c:out value="${lang.name}" /></td>
				<td><c:out value="${lang.dateofBirth}" /></td>
				<td><c:out value="${lang.username}" /></td>
				<td><c:out value="${lang.email}" /></td>

				<td>
				<input type="button" value="edit"
					onclick="edit('${lang.id}')"> 
					
					
					
						<input type="button" value="delete"
					onclick="edit1('${lang.id}')"> 
					
					</td>
					
					

			</tr>
		</c:forEach>

	</table>

</body>
</html>


