function checkboxValidation() {
	const checkboxes = document.getElementsByName("idEvent");
	const err = document.getElementById("errorText");

	let checked = false;

	for (let i = 0, l = checkboxes.length; i < l; i++) {
		if (checkboxes[i].checked) {
			checked = true;
			break;
		}
	}
	if (!checked) {
		err.innerHTML = "Check at least one of the task";
		return false;
	} else {
		document.getElementById('main-table').submit();
	}
}

function validateAddTask() {
	const taskDate = document.querySelector('input[type=date]').value;
	const taskDescription = document.querySelector('input[type=text]').value;
	const now = new Date();
	const today = new Date(now.getFullYear(), now.getMonth(), now.getDate());
	const expDate = new Date(taskDate);
	const err = document.getElementById("errorText");

	if (taskDate === '') {
		err.innerHTML = "Fill in the task date field";
		return false;
	}
	if (expDate < today) {
		err.innerHTML = "Choose a current or future date";
		return false;
	}

	if (taskDescription === '') {
		err.innerHTML = "Fill in the task description field";
		return false;
	}

	newTask.submit();
}

function setCookieValidUser(event, username) {
	if (!event.defaultPrevented) {
		if (!cookieIsSet(username)) {
			setCookie("username", username);
		}
	}
}

function requireValue(input, message) {
	return input.value.trim() === '' ?
		error(input, message) :
		success(input);
}

function error(input, message) {
	input.classList.add('placeholderred');
	input.setAttribute('placeholder', input.name.toLowerCase() + message);
	input.style.border = '1px solid red';
	return false;
}

function success(input) {
	input.classList.remove('placeholderred');
	input.style.border = '1px solid #551a8b45';
	return true;
}

function validateConfirmPass(inputPass, inputConfPass) {
	if(inputPass.value.trim() !== inputConfPass.value.trim()){
		inputConfPass.setAttribute('type','text');
		inputPass.setAttribute('type','text');
		inputConfPass.value = '';
		error(regConfirmPassword, ' doesnt match');
		success(inputPass);
		return false;
	} else {
		success(inputPass);
		success(inputConfPass);
		return true;
	}
}

