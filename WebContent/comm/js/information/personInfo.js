function selectAll() {
	var a = document.getElementsByName("checkbox");
	if (a[0].checked) {
		for (var i = 0; i < a.length; i++) {
			if (a[i].type == "checkbox") a[i].checked = false;
		}
	} else {
		for (var i = 0; i < a.length; i++) {
			if (a[i].type == "checkbox") a[i].checked = true;
		}
	}
}

function popwin() {
	ymPrompt.win({
		message: '/personnel/comm/resource/information/printInfo.jsp',
		width: 700,
		height: 400,
		title: '打印',
		maxBtn: true,
		minBtn: true,
		iframe: true
	})
}
