<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="../../static/INC/header.jsp"%>

<content>
	<center>
		<c:forEach items='${listVacation}' var = 'str'>
			<table>
				<tr>
					<td>${str.name}</td><td><input type="submit" name="Submit" value="desc" onclick="showAlert('${str.description}')"></td>
				</tr>
			</table>
		</c:forEach>
	</center>
</content>
<script type="text/javascript">
function showAlert(str){
alert(str);
}
</script>
<%@include file="../../static/INC/footer.jsp"%>