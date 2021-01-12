const loginForm = document.getElementById('login');
loginForm.addEventListener('submit', (event) => {
	let valid = true;
	requiredLoginFields.forEach((input) => {
		valid = requireValue(input.input, input.message);
	});
	(!valid) ? event.preventDefault() : setCookieValidUser(event, loginUsername.value);
});

const loginUsername = loginForm.elements[0];
const loginPassword = loginForm.elements[1];
const requiredLoginFields = [
	{input: loginUsername, message: ' is required'},
	{input: loginPassword, message: ' is required'},
];

