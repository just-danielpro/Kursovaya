<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@include file="../../static/INC/header.jsp"%>
<body>
	<center class='content'>
	<c:if test='${form}'>
	<form action='' method = 'post'>
			<table>
				<tr>
					<td>Title</td>
					<td><input type='text' name='title' value = '${title}'/></td>
				</tr>
				<tr>
					<td>Descriotion</td>
					<td><textarea cols='20' rows='10' name='desc' value='${desc}'></textarea></td>
				</tr>
				<tr>
					<td>
						<td><input type='submit' value='Create'/></td>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<c:if test='${error}'>clean
						${errorText}
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<if test='${form == true}'>
		Your vacation was successfully added
	</if>
	</center>
</body>
<%@include file="../../static/INC/footer.jsp"%>
