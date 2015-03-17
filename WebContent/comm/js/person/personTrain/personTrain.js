function getContent() {
	var input2=document.getElementById("input2").value;
	
	var input2Len = input2.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");//获得所有的span
	
	if (input2Len > 5) {
		spans[1].innerHTML="内容字的个数过多啊亲，请重新输入";
	} else if (input2Len <= 5 && input2Len > 0) {
		spans[1].innerHTML="";
	}
	if (input2Len == 0) {
		spans[1].innerHTML="没有内容啊亲，请重新输入";
	}
}
function getTime() {
	var input3=document.getElementById("input3").value;
	
	var input3Len = input3.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");//获得所有的span
	
	if (input3Len == 0) {
		spans[2].innerHTML="没有时间啊亲，请重新添加";
	}else if(input3Len>0){
		spans[2].innerHTML="";
	}
	
}



// 手动提交
function submitForm() {
	getContent();
	getTime();
	// 判断span内是否有值
	var spans = document.getElementsByTagName("span");
	var spanresult = 0;
	for ( var i = 0; i < spans.length; i++) {
		if (spans[i].innerHTML != "") {
			spanresult++;
		}
	}

	// 如果span内无值，进行提交
	if (spanresult == 0) {
		document.getElementById('formid').submit();
	} else {
		alert("请按规则正确填写再提交啊亲~.~");
	}
}

function submitForm2(){
	var departmentName= document.getElementsByName("departmentName")[0].value;
	var jobName= document.getElementsByName("jobName")[0].value;

	if(departmentName!=""&&jobName==""){
		window.location.href="personTrain.per?method=findAll&state=1&currentPage=1&departmentName="+departmentName;
	}else if(departmentName==""&&jobName!=""){
		window.location.href="personTrain.per?method=findAll&state=2&currentPage=1&jobName="+jobName;
	}else{
		alert("请重新填写查询条件！");
	}
	
}


//浮层
function locking() {
	document.all.ly.style.display = "block";
	document.all.ly.style.width = document.body.clientWidth;
	document.all.ly.style.height = document.body.clientHeight;
	document.all.Layer2.style.display = 'block';
}
function Lock_CheckForm(theForm) {
	document.all.ly.style.display = 'none';
	document.all.Layer2.style.display = 'none';
	return false;
}


//跳转页
function getPage() {
	var page=document.getElementById("textfield").value;
	var pageLen = page.replace(/[^x00-xff]/g, "xx").length;
	var allPage=document.getElementById("allPage").value;
	var spans=document.getElementsByTagName("span");//获得所有的span
	var i=0;
	
	for ( var k = 0; k < page.length; k++) {
		var b1 = page.charAt(k);
		var b = b1.charCodeAt();
		if (b < 48 || b > 57) {
			i=i+1;
		}
	}
	if(i>0&&pageLen>0){
		spans[0].innerHTML="请输入正整数!";
	}else if (i==0&&parseInt(page)>parseInt(allPage)) {//不转换的话就是字符串比较大小
		spans[0].innerHTML="最多只有"+allPage+"页!";
	}else if(i==0&&parseInt(page)<=parseInt(allPage)){
		window.location.href="personTrain.per?method=findAll&state=0&currentPage="+page;
	}
}


