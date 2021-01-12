async function start() {
	const urlParams = new URLSearchParams(location.search);
	const viewParam = urlParams.get("view");
	const userName = getCookie('username');
	const header = document.getElementById('userName');
	header.innerHTML = 'User : ' + userName;
	const url = `main?view=${viewParam}`;
	const response = await fetch(url);
	if (response.ok) {
		const tasksViewsButtons = await response.json();
		const viewsArray = tasksViewsButtons.views;
		createTopNavButton(viewsArray, viewParam);
		const tasksArray = tasksViewsButtons.tasks;
		dome.get("#table-tasks-header").text(viewParam + formAdditionalTitle(viewParam));
		if (tasksArray.length === 0) {
			dome.get('#tasks-empty').attr('style', 'display:block');
			dome.get('#main-table').attr('style', 'display:none');
		} else {
			dome.get('#tasks-empty').attr('style', 'display:none');
			buildTaskTable(tasksArray, viewParam);
			const buttonsArray = tasksViewsButtons.buttons;
			createFootButton(buttonsArray);
		}
		if (viewParam !== 'recycle' && viewParam !== 'fixed') {
			createInputAddTask('date', 'date', getDateByView(viewParam));
			createInputAddTaskDesc('text', 'description', 'Task description');
			createInputAddTask('hidden', 'view', viewParam);
			createInputAddTask('hidden', 'date', getDateByView(viewParam));
			createButtonAddTask('submit', 'Add Task','return validateAddTask()');
		}
	} else {
		alert("HTTP error: " + response.status);
		document.location.href = 'index.jsp?errMsg=Trouble with data source';
	}
}


