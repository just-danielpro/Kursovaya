<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="../../static/INC/header.jsp"%>


<content>
	<center>
	<c:if test='${form}'>
		<form action="" method='post'>
		<table>
				<table>
				<td>
					<tr>
						<td>Your email</td>
						<td><input type='email' name='login' value='${email}' /></td>
					</tr>
					<tr>
						<td>Your name</td>
						<td><input type='text' name='name' /></td>
					</tr>
					<tr>
						<td>Your surname</td>
						<td><input type='text' name='surName'/></td>
					</tr>
					<tr>
						<td>Your age</td>
						<td><input type='number' name='age' /></td>
					</tr>
					<tr>
						<td>Your password</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td>Confirm password</td>
						<td><input type='password' name='confirmPassword'/></td>
					</tr>
					<tr>
							<td>Gender</td>
							<td>Male<input type='radio' name='gender' value='M' ${genderM}/>
								Female<input type='radio' name='gender' value='F' ${genderF}/>
							</td>
						</tr>
						<tr>
							<td>City</td>
							<td><select name="city">
									<option value='Kyiv' ${address1}>Kyiv</option>
									<option value='Poltava'${address2}>Poltava</option>
									<option value='Odesa'${address3}>Odesa</option>
									<option value='Zhytomyr'${address4}>Zhytomyr</option>
									<option value='Dnipro'${address5}>Dnipro</option>
									<option value='Lviv'${address6}>Lviv</option>\
									<option value='Kharkov' ${address7}>Kharkov</option>
									<option value='Rovno'${address8}>Rovno</option>
									<option value='Mariupol'${address9}>Mariupol</option>
							</select></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td><input type='submit' name='button' value='Register'/></td>
						</tr>
					</td>
					<td><c:if test="${isError}">${errorText}</c:if></td>
				</table>
			</table>
			</form>
	</center>
	
</content>	
	</c:if>
	
	<td><c:if test="${thankful}">${thanks}</c:if></td>



<%@include file="../../static/INC/footer.jsp"%>