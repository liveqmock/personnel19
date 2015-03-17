function submitButton () {
	var spans = document.getElementsByTagName("span");
	var result = 0;
	for ( var i = 0; i < spans.length; i++) {
		if (spans[i].innerHTML != "") {
			result++;
		}
	}
	if (result == 0) {
		document.getElementById("form1").submit();
	} else {
		alert("请确认所有信息全部填写后再进行查询 ");
	}
	
}

function peocReasonCheck() {
	var valueInside = document.getElementsByName("peocReason")[0].value;
	if ( valueInside.length != 0 ){
		if ( valueInside.length > 200) {
			document.getElementById("alertInfo2").innerHTML = " 奖惩原因过长，不能超过200个字符 "; 
		} else {
			document.getElementById("alertInfo2").innerHTML = ""; 
		}
	} else {
		document.getElementById("alertInfo2").innerHTML = " 奖惩原因不能为空，请说明具体奖惩原因 "; 
	}
	
}

function peocRemarkCheck() {
	var valueInside = document.getElementsByName("peocRemark")[0].value;
	if ( valueInside.length > 200) {
		document.getElementById("alertInfo3").innerHTML = " 奖惩备注过长，不能超过200个字符 "; 
	} else {
		document.getElementById("alertInfo3").innerHTML = ""; 
	}
	
}

function peocDateCheck(){
	var valueInside = document.getElementsByName("peocDate")[0].value;
	if ( valueInside.length != 0 ){	
		document.getElementById("alertInfo1").innerHTML = ""; 	
	} else {
		document.getElementById("alertInfo1").innerHTML = " 奖惩日期不能为空，请填写具体奖惩日期 "; 
	}
}


