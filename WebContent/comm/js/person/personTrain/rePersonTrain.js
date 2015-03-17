function getConten() {
	var personnelTrainConten=document.getElementById("personnelTrainConten").value;
	
	var personnelTrainContenLen = personnelTrainConten.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");//获得所有的span
	
	if (personnelTrainContenLen > 5) {
		spans[0].innerHTML="内容字的个数过多啊亲，请重新输入";
	} else if (personnelTrainContenLen <= 5 && personnelTrainContenLen > 0) {
		spans[0].innerHTML="";
	}
	if (personnelTrainContenLen == 0) {
		spans[0].innerHTML="没有内容啊亲，请重新输入";
	}
	
}
function getDate() {
	var personnelTrainDate=document.getElementById("personnelTrainDate").value;
	
	var personnelTrainDateLen = personnelTrainDate.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");//获得所有的span
	
	if (personnelTrainDateLen == 0) {
		spans[1].innerHTML="没有时间啊亲，请重新添加";
	}else if(personnelTrainDateLen>0){
		spans[1].innerHTML="";
	}
	
}



// 手动提交
function submitForm() {
	getConten();
	getDate();
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


//rePersonTrain.jsp提交
function submitForm2(){
	document.getElementById('formid').submit();
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
