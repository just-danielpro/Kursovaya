
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="../../static/INC/header.jsp"%>
<content>
	<center>
		<c:if test='${form}'>
		<table>
		<tr>
		<td>
			<form action="" method="post">
				<tr>
					<td>Your email</td>
					<td><input type="email" name='login'/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name='pass'/></td>
				</tr>
				<tr>
					<td><input type="submit"  value ='Sing in'/></td>
				</tr>
			</form>
			</td>
			<td>
				${errorText}
			</td>
			</tr>
			</table>
			</c:if>
			<c:if test='${!form}'>
				Welcome Back  ${sessionScope.userEmployer.name}
			</c:if>
			
	</center>
</content>
<%@include file="../../static/INC/footer.jsp"%>