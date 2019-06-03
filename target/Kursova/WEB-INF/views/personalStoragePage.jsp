
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="../../static/INC/header.jsp"%>
<content>
	<table>
		<tr>
			<td>
		<table>
			<c:if test="${sessionScope.user !=null}">
			<tr><td>My profile</td></tr>
			<tr><td>${sessionScope.user.name}</td></tr>
			<tr><td>${sessionScope.user.surName}</td></tr>
			<tr><td>${sessionScope.user.age}</td></tr>
			<tr><td>${sessionScope.user.gender == 'M' ? 'Male':'Female'}</td></tr>
			<tr><td>${sessionScope.user.position}</td></tr>
			<tr><td>${sessionScope.user.city}</td></tr>
			</c:if>
			<c:if test="${sessionScope.userEmployer !=null}">
			<tr><td>My profile</td></tr>
			<tr><td>${sessionScope.userEmployer.name}</td></tr>
			<tr><td>${sessionScope.userEmployer.surName}</td></tr>
			<tr><td>${sessionScope.userEmployer.age}</td></tr>
			<tr><td>${sessionScope.userEmployer.gender == 'M' ? 'Male':'Female'}</td></tr>
			<tr><td>${sessionScope.userEmployer.position}</td></tr>
			<tr><td>${sessionScope.userEmployer.city}</td></tr>
			<tr><td>${sessionScope.userEmployer.companyName}</td></tr>
			<tr><td>${sessionScope.userEmployer.companyMobile}</td></tr>
			</c:if>
		</table>
			</td>
			<td>
				<table>
					<c:forEach items="${list}" var="str">
					<tr>
						<td>${str.name} <input type="submit" name="Submit" value="desc" onclick="showAlert('${str.description}')"></td>
					</tr>
				</c:forEach>
				</table>
			</td>
		</tr>
</content>

<script type="text/javascript">
function showAlert(str){
alert(str);
}
</script>
<%@include file="../../static/INC/footer.jsp"%>