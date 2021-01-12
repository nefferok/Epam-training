const regForm = document.getElementById('registrate');
regForm.addEventListener('submit', (event) => {
	let valid = true;
	requiredRegFields.forEach((input) => {
		valid = requireValue(input.input, input.message);
	});

	if (valid) {
		valid = validateConfirmPass(regPassword, regConfirmPassword);
	}
	(!valid) ? event.preventDefault() : setCookieValidUser(event, regUsername.value);
});

const regUsername = regForm.elements[0];
const regPassword = regForm.elements[1];
const regConfirmPassword = regForm.elements[2];
const requiredRegFields = [
	{input: regUsername, message: ' is required'},
	{input: regPassword, message: ' is required'},
	{input: regConfirmPassword, message: ' is required'},
];