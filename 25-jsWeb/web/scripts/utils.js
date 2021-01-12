if (typeof Array.prototype.indexOf !== 'function') {
	Array.prototype.indexOf = function (item) {
		for (let i = 0; i < this.length; i++) {
			if (this[i] === item) {
				return i;
			}
		}
		return -1;
	};
}

window.dome = (function () {
	function Dome(els) {
		for (let i = 0; i < els.length; i++) {
			this[i] = els[i];
		}
		this.length = els.length;
	}

	// ========= UTILS =========
	Dome.prototype.forEach = function (callback) {
		this.map(callback);
		return this;
	};
	Dome.prototype.map = function (callback) {
		const results = [];
		for (let i = 0; i < this.length; i++) {
			results.push(callback.call(this, this[i], i));
		}
		return results; //.length > 1 ? results : results[0];
	};
	Dome.prototype.mapOne = function (callback) {
		const m = this.map(callback);
		return m.length > 1 ? m : m[0];
	};

	// ========== DOM MANIPULATION ==========
	Dome.prototype.text = function (text) {
		if (typeof text !== "undefined") {
			return this.forEach(function (el) {
				el.innerText = text;
			});
		} else {
			return this.mapOne(function (el) {
				return el.innerText;
			});
		}
	};

	Dome.prototype.html = function (html) {
		if (typeof html !== "undefined") {
			return this.forEach(function (el) {
				el.innerHTML = html;
			});
		} else {
			return this.mapOne(function (el) {
				return el.innerHTML;
			});
		}
	};

	Dome.prototype.addClass = function (classes) {
		let className = "";
		if (typeof classes !== 'string') {
			for (let i = 0; i < classes.length; i++) {
				className += " " + classes[i];
			}
		} else {
			className = " " + classes;
		}
		return this.forEach(function (el) {
			el.className += className;
		});
	};

	Dome.prototype.removeClass = function (clazz) {
		return this.forEach(function (el) {
			let cs = el.className.split(' '), i;

			while ((i = cs.indexOf(clazz)) > -1) {
				cs = cs.slice(0, i).concat(cs.slice(++i));
			}
			el.className = cs.join(' ');
		});
	};

	Dome.prototype.attr = function (attr, val) {
		if (typeof val !== 'undefined') {
			return this.forEach(function (el) {
				el.setAttribute(attr, val);
			});
		} else {
			return this.mapOne(function (el) {
				return el.getAttribute(attr);
			});
		}
	};

	Dome.prototype.append = function (els) {
		return this.forEach(function (parEl, i) {
			els.forEach(function (childEl) {
				parEl.appendChild((i > 0) ? childEl.cloneNode(true) : childEl);
			});
		});
	};

	Dome.prototype.prepend = function (els) {
		return this.forEach(function (parEl, i) {
			for (let j = els.length - 1; j > -1; j--) {
				parEl.insertBefore((i > 0) ? els[j].cloneNode(true) : els[j], parEl.firstChild);
			}
		});
	};

	Dome.prototype.remove = function () {
		return this.forEach(function (el) {
			return el.parentNode.removeChild(el);
		});
	};

	Dome.prototype.on = (function () {
		if (document.addEventListener) {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el.addEventListener(evt, fn, false);
				});
			};
		} else if (document.attachEvent) {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el.attachEvent("on" + evt, fn);
				});
			};
		} else {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el["on" + evt] = fn;
				});
			};
		}
	}());

	Dome.prototype.off = (function () {
		if (document.removeEventListener) {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el.removeEventListener(evt, fn, false);
				});
			};
		} else if (document.detachEvent) {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el.detachEvent("on" + evt, fn);
				});
			};
		} else {
			return function (evt, fn) {
				return this.forEach(function (el) {
					el["on" + evt] = null;
				});
			};
		}
	}());

	let dome = {
		get: function (selector) {
			let els;
			if (typeof selector === 'string') {
				els = document.querySelectorAll(selector);
			} else if (selector.length) {
				els = selector;
			} else {
				els = [selector];
			}
			return new Dome(els);
		},
		create: function (tagName, attrs) {
			const el = new Dome([document.createElement(tagName)]);
			if (attrs) {
				if (attrs.className) {
					el.addClass(attrs.className);
					delete attrs.className;
				}
				if (attrs.text) {
					el.text(attrs.text);
					delete attrs.text;
				}
				for (let key in attrs) {
					if (attrs.hasOwnProperty(key)) {
						el.attr(key, attrs[key]);
					}
				}
			}
			return el;
		},
	};
	return dome
}());

function createTopNavButton(viewsArray, currentView) {
	const viewsButton = dome.get("#main-topnav-form");
	for (let view of viewsArray) {
		if (view !== currentView) {
			viewsButton.append(dome.create('button', {
				type: "submit", class: "button",
				name: "view", value: view, text: view + formAdditionalTitle(view),
			}));
		}
	}
}

function createFootButton(buttonsArray) {
	const operationsButton = dome.get("#main-footnav");
	for (let button of buttonsArray) {
		operationsButton.append(dome.create('button', {
			type: 'submit', class: 'button', name: 'operation', value: button,
			onclick: 'return checkboxValidation()', text: button,
		}));
	}
}

function createInputAddTask(type, name, value) {
	const hiddenInput = dome.get("#main-footnav-form");
	hiddenInput.append(dome.create('input', {
		type: type, name: name, value: value,
	}));
}

function createInputAddTaskDesc(type, name, placeholder) {
	const hiddenInputText = dome.get("#main-footnav-form");
	hiddenInputText.append(dome.create('input', {
		type: type, name: name, placeholder: placeholder,
	}));
}

function createButtonAddTask(type, buttonName,onclick) {
	const viewsButton = dome.get("#main-footnav-form");
	viewsButton.append(dome.create('button', {
		type: type, class: 'button', text: buttonName,onclick:onclick
	}));
}

function buildTaskTable(tasksArray, currentView) {
	if (currentView === "today" || currentView === "tomorrow") {
		dome.get('#date-column-header').attr('style', 'display:none');
	}
	const hiddenInput = dome.get("#main-table");
	hiddenInput.append(dome.create('input', {
		type: 'hidden', name: 'view', value: currentView,
	}));

	const tasksTable = dome.get("#tasks-list");
	tasksTable.innerHTML = '';
	for (let task of tasksArray) {
		const td1 = dome.create('td');
		td1.append(dome.create('input', {
			type: 'checkbox', name: 'idEvent', value: task.id,
		}));
		const td2 = dome.create('td', {text: task.bodyTask});
		if (currentView === "today" || currentView === "tomorrow") {
			if (isDateOverdue(task.date)) {
				td2.attr('style', 'color: red');
			}
			tasksTable.append(dome.create('tr').append(td1).append(td2));
		} else {
			const td3 = dome.create('td', {text: task.date});
			tasksTable.append(dome.create('tr').append(td1).append(td2).append(td3));
		}
	}

}

function getFormattedDate(countAddDays, place) {
	let d = new Date();
	d.setDate(d.getDate() + countAddDays);
	switch (place) {
		case 'topButtons':
			return [d.getDate(), d.getMonth() + 1]
				.map(n => n < 10 ? `0${n}` : `${n}`).join('-');
		case 'calendar':
			return [d.getFullYear(), d.getMonth() + 1, d.getDate()]
				.map(n => n < 10 ? `0${n}` : `${n}`).join('-');
		default :
			return [d.getDate(), d.getMonth() + 1, d.getFullYear()]
				.map(n => n < 10 ? `0${n}` : `${n}`).join('-');
	}
}

function formAdditionalTitle(view) {
	switch (view) {
		case 'today':
			return ' ' + getFormattedDate(0, 'topButtons');
		case 'tomorrow':
			return ' ' + getFormattedDate(1, 'topButtons');
		case 'recycle':
			return ' byn';
		default :
			return "";
	}
}

function isDateOverdue(date) {
	let now = new Date();
	let today = new Date(now.getFullYear(), now.getMonth(), now.getDate());
	let checked = new Date(date);
	return checked < today;
}

function getDateByView(view) {
	switch (view) {
		case 'today':
			return getFormattedDate(0, 'calendar');
		case 'tomorrow':
			return getFormattedDate(1, 'calendar');
		default :
			return ' ';
	}
}

document.addEventListener("DOMContentLoaded", () => {
	const checkAll = document.querySelector('th#select-all-checkbox label input');
	checkAll.addEventListener("click", () => {
		const checkboxes = document.querySelectorAll('input[name=idEvent]');
		checkboxes.forEach(t => t.checked = checkAll.checked);
	});
});

function renewPage() {
	location.reload();
}







