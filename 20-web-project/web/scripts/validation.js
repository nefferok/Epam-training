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
        err.innerHTML = "Check at least one task";
        return false;
    } else {
        tasks.submit();
    }
}

function validateLogin() {
    const userName = document.login.userName.value.trim();
    const pass = document.login.password.value.trim();
    const err = document.getElementById("errorText");
    if (userName === '' && pass === '') {
        err.innerHTML = "enter the user name and password";
        return false;
    }
    if (userName === '') {
        err.innerHTML = "enter the user name";
        return false;
    }
    if (pass === '') {
        err.innerHTML = "enter the password";
        return false;
    }
    login.submit();
}

function validateRegistration() {
    const userName = document.registrate.userName.value.trim();
    const pass = document.registrate.password.value.trim();
    const confPass = document.registrate.confPassword.value.trim();
    const err = document.getElementById("errorText");
    if (userName === '' || pass === '' || confPass === '') {
        err.innerHTML = "fill in all fields for registration";
        return false;
    }
    if (pass !== confPass) {
        err.innerHTML = "password confirmation error";
        return false;
    }
    registrate.submit();
}

function validateAddTask() {
    const taskDate = document.newTask.date.value;
    const taskDescription = document.newTask.description.value.trim();
    const now = new Date();
    const today = new Date(now.getFullYear(), now.getMonth(), now.getDate());
    const expDate = new Date(taskDate);
    const err = document.getElementById("errorText");

    if (taskDate === '') {
        err.innerHTML = "fill in the task date field";
        return false;
    }
    if (expDate < today) {
        err.innerHTML = "choose a current or future date";
        return false;
    }

    if (taskDescription === '') {
        err.innerHTML = "fill in the task description field";
        return false;
    }

    newTask.submit();
}