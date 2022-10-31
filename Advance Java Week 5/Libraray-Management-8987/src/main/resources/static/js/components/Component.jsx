let Component = (props) => {
	const [count, setCount] = React.useState(0)

	let incrementCount = () => {
		setCount((previousCount) => previousCount + 1)
	}

	return (
		<div>
			<h1>You clicked the button {count} times</h1>
			<button onClick={incrementCount}>Click here</button>
		</div>
	)
}