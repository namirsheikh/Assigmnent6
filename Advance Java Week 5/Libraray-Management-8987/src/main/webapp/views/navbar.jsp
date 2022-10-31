
<%-- <nav class="navbar navbar-light bg-light justify-content-between">
	<div class=" ml-auto mr-auto">
		<h3>Library Management System</h3>
	</div>

	<form class="form-inline my-2 my-lg-0" action="/logout">
		<h5 class="mr-2">Welcome ${user.getOnlyName()}</h5>
		<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Logout</button>
	</form>
</nav> --%>

<nav class="navbar navbar-expand-sm navbar-black"
	style="background-color: #C7DEEF">
	<div class="container">
		<div class="navbar-brand">
			<h4>
				<spam class="fa fa-user-circle-o text-dark"></spam>
				<span style="color: #152c3c">Welcome ${user.getOnlyName()}</span>
			</h4>
		</div>
		<a href="#" class="navbar-brand text-dark font-weight-bold ml-4" type="submit"
			onclick="location.href='/addform'">Add a book </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse"></div>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<h4>
					<b class="text-muted">Library Management</b>
				</h4>
			</ul>
		</div>
		<div>
			<form class="form-inline my-2 my-lg-0" action="/logout">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</div>
</nav>
