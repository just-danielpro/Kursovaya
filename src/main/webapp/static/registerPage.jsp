<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="../../static/INC/header.jsp"%>


<content>
	<center>
			<form action="" method='post'>
				<table>
					<tr>
						<td>Your email</td>
						<td><input type='email' name='login' value='${login}' /></td>
					</tr>
					<tr>
						<td>Your name</td>
						<td><input type='text' name='name' value='${login}' /></td>
					</tr>
					<tr>
						<td>Your surname</td>
						<td><input type='text' name='surName' value='${login}' /></td>
					</tr>
					<tr>
						<td>Your age</td>
						<td><input type='number' name='age' value='${login}' /></td>
					</tr>
					<tr>
						<td>Your password</td>
						<td><input type='password' name='password' value='${login}' /></td>
					</tr>
					<tr>
						<td>Confirm password</td>
						<td><input type='password' name='confirmPassword' value='${login}' /></td>
					</tr>
					<tr>
							<td>Gender</td>
							<td>Male<input type='radio' name='gender' value='M' ${genderM}/>
								Female<input type='radio' name='gender' value='F' ${genderF}/>
							</td>
						</tr>
						<tr>
							<td>City</td>
							<td><select name="address">
									<option value='1' ${address1}>Kyiv</option>
									<option value='2'${address2}>Poltava</option>
									<option value='3'${address3}>Odesa</option>
									<option value='4' ${address4}>Zhytomyr</option>
									<option value='5'${address5}>Dnipro</option>
									<option value='6'${address6}>Lviv</option>\
									<option value='7' ${address7}>Kharkov</option>
									<option value='8'${address8}>Rovno</option>
									<option value='9'${address9}>Mariupol</option>
							</select></td>
						</tr>
						<tr>
							<td>Your position</td>
							<td>Employee<input type='radio' name='worker' value='Employe' ${genderM}/>
								Employer<input type='radio' name='worker' value='Employer' ${genderF}/>
							</td>
						</tr>
						<tr>
							<td><input type='submit' name='worker' value='Register' ${genderM}/></td>
						</tr>
				</table>
			</form>
	</center>
	
</content>



<%@include file="../../static/INC/footer.jsp"%>