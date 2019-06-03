<link href="main.css" rel="stylesheet" type="text/css" media="screen" />
<head>
<table>

	<tr>
		<td class="header-title">Robotyaga.ua</td>
		<td >
			<form action="" method="post">
					<table>
						<tr>
							<td class="header-search">
								<input type="text" name="t1">

							</td>
						</tr>
					</table>

	
			</form>
		</td>
		<td>
		<c:if test="${sessionScope.user==null}">
		<a href="./AuthorizationServlet" class="header-summery">Make the summary</a>
		</c:if>
		</td>
		<td>
		<a href="./MainServlet">Main</a>
			<c:if test='${sessionScope.user == null }'>
				<a href="./RegisterServlet">Registrate</a>
				<a href="./AuthorizationServlet">Login</a>
			</c:if>
			<c:if test='${sessionScope.user != null }'>
				<c:if test="${sessionScope.user.position=='Employee'}">
					<a href="./SummeryServlet">Make the summery</a>
					User:${sessionScope.user.name}
					<a href = '?logout=1' class='logOut'>
						&#9032
				</c:if>
				<c:if test="${sessionScope.user.position=='Employer'}">
					<a href="./VacationServlet">Make the vacation</a>
					User:${sessionScope.user.name}
					<a href = '?logout=1' class='logOut'>
						&#9032
				</c:if>
			</c:if>
		</ul>
		</td>


	</tr>


</table>
</head>

