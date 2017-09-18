
<html>

<head>
   <title>Spring Web Application - For Learning</title>    
</head>
<style type="text/css">
	body {
		background-image: url('https://crunchify.com/bg.png');
	}
	button#yui-gen1-button {
		font-weight: bold;
	}
</style>
<body id="jenkins" >
    <div id="page-head">
        <div id="header"  >        		          		   
				<a href="index.jsp" >
					<img style:"text-align:left" src="../WEB-INF/images/home.jpg"/>  
				</a>
		</div>
    </div>
	<div style="margin: 2em;"  id="main-panel" >
		<form method="post" name="login" action="" style="text-align:center">
			<table align="center">
				<tbody >
					<tr>
						<td>User:</td>
						<td>
							<input type="text" name="j_username" id="j_username" autocorrect="off" autocapitalize="off">
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td>
							<input type="password" name="j_password">
						</td>
					</tr>
					<tr>
						<td align="right">
							<input id="remember_me" type="checkbox" name="remember_me">
						</td>
						<td>
							<label for="remember_me">Remember me on this computer</label>
						</td>
					</tr>
				</tbody>
			</table>
			<input name="from" type="hidden" value="/">
			<span id="yui-gen1" name="Submit">						
					<button type="button" tabindex="0" id="yui-gen1-button">Log in</button>						
			</span>                  
		</form>
	</div>
	<div id="sub-panel" style="text-align:center">
			<div id="firstname_field" class="_1ixn">
					<div class="placeholder" >First name</div>
					<input name="firstname" type="text">
			</div>
			
			<div id="lastname_field" class="">
					<div class="placeholder" >Surname</div>
					<input name="lastname" type="text">
			</div>          
			<div id="fullname_field" class="_1ixn">
					<div class="placeholder">Email id</div>
					<input name="firstname" type="text">
			</div>
			
			<div id="reg_password">
				<div class="placeholder" aria-hidden="true">New password</div>
				<input name="reg_passwd__" type="password">
			</div>            
			<div id="u_0_l">
				<p class="_58mv">By clicking Create an account, you agree to our <a href="/legal/terms" id="terms-link" target="_blank" rel="nofollow">Terms</a> and confirm that you have read our <a href="/about/privacy" id="privacy-link" target="_blank" rel="nofollow">Data Policy</a>, including our <a href="/policies/cookies/" id="cookie-use-link" target="_blank" rel="nofollow">Cookie Use Policy</a></p>
			</div>
			<div class="clearfix">
				<button type="submit" name="websubmit" id="u_0_m">Create an account</button>		
			</div>
	</div>
    <footer>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6" id="footer"></div>
                <div class="col-md-18">
						<span class="page_generated"></span><span class="rest_api">
                </div>
            </div>
        </div>
    </footer>
</body>

</html>