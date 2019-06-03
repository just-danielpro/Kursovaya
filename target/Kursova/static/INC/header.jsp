<link href="main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="https://d3r3v3xnalu9ia.cloudfront.net/assets.rabota.ua/masterpages/fedor.css?v=1431.1.817-6665b3c-master" />
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
		</td>
		<td>
		<a href="./MainServlet">Main</a>
			<c:if test='${sessionScope.user == null and sessionScope.userEmployer == null}'>
			<a href="./AuthorizationServlet" class="header-summery">Make the summary</a>
				<a href="./CheckServlet">Registrate</a>
				<a href="./CheckServlet2">Login</a>
			</c:if>
			<c:if test='${sessionScope.user != null and sessionScope.userEmployer == null}'>
					<a href="./SummeryServlet">Make the summery</a>
					<a href="./PersonalStorageServlet">User:${sessionScope.user.name}</a>
					<a href = '?logout=1' class='logOut'>
						&#9032</a>
			</c:if>
			<c:if test="${sessionScope.userEmployer!=null and sessionScope.user == null}">
					<a href="./VacationServlet">Make the vacation</a>
					<a href="./PersonalStorageServlet">"User:${sessionScope.userEmployer.name}</a>
					<a href = '?logout=1' class='logOut'>
						&#9032</a>
				</c:if>
		</ul>
		</td>


	</tr>


</table>
</head>

