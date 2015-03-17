function getContent() {
	var personnelAppraiseContent=document.getElementById("personnelAppraiseContent").value;
	var personnelAppraiseContentLen = personnelAppraiseContent.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");// 获得所有的span
	
	if (personnelAppraiseContentLen > 5) {
		spans[0].innerHTML="内容字的个数过多啊亲，请重新输入";
	} else if (personnelAppraiseContentLen <= 5 && personnelAppraiseContentLen > 0) {
		spans[0].innerHTML="";
	}
	if (personnelAppraiseContentLen == 0) {
		spans[0].innerHTML="没有内容啊亲，请重新输入";
	}
	
}
function getDate() {
	var personnelAppraiseDate=document.getElementById("personnelAppraiseDate").value;
	var personnelAppraiseDateLen = personnelAppraiseDate.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");// 获得所有的span
	
	if (personnelAppraiseDateLen == 0) {
		spans[1].innerHTML="没有时间啊亲，请重新添加";
	}else if(personnelAppraiseDateLen>0){
		spans[1].innerHTML="";
	}
	
}
function getResult() {
	var personnelAppraiseResult=document.getElementById("personnelAppraiseResult").value;
	var personnelAppraiseResultLen = personnelAppraiseResult.replace(/[^x00-xff]/g, "xx").length;
	var spans=document.getElementsByTagName("span");// 获得所有的span
	
	if(personnelAppraiseResult!="优秀"&&personnelAppraiseResult!="良好"&&personnelAppraiseResult!="中等"&&personnelAppraiseResult!="合格"&&personnelAppraiseResult!="不合格"){
		spans[2].innerHTML="结果只有优秀，良好，中等，合格，不合格五种";
	} else {
		spans[2].innerHTML="";
	}
	
	
}



// 手动提交
function submitForm() {
	getContent();
	getDate();
	getResult();
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


// rePersonTrain.jsp提交
function submitForm2(){
	document.getElementById('formid').submit();
}


// 浮层
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
