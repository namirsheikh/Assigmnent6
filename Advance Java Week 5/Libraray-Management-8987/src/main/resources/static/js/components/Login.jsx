let Login = (props) => {

	return (
		<React.Fragment>
		<div id="parent">
			<form action="user/login" method="post" id="form-login">
				<div className="card-header">
					<h3 align="center">Login Form</h3>
				</div>
				<div className="form-group mt-3">
					<label htmlFor="exampleInputEmail1">Email</label> <input name="email"
						type="email" className="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Enter email" />
				</div>
				<div className="form-group mt-3">
					<label htmlFor="exampleInputPassword1">Password</label> <input
						type="password" name="password" className="form-control"
						id="exampleInputPassword1" placeholder="Password" />
				</div>
				<div>
					<button type="submit" className="btn btn-outline-secondary mt-3">Submit</button>
				</div>
			</form>
		</div>
		</React.Fragment>
	)
}