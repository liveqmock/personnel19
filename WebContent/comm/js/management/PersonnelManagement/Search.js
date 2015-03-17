var isdb;
function display(Param)
{	
	
     isdb=false;
    
     window.setTimeout(cc,250);
     function cc(){
    	 if(isdb!=false)return;
    
    	 document.getElementById(Param).style.display = "block"; 
    	}
   
}
function notDisplay(Param)
{	
	isdb=true;

	 document.getElementById(Param).style.display = "none"; 
}
function checkIsNumber(salary)
{
	var reg= new RegExp("^[0-9]*$"); 
	if(!(reg.test(salary)))//不是数字
		document.getElementById("salaryError").innerHTML="输入不为数字，请重新输入";
	else
		document.getElementById("salaryError").innerHTML=" ";
}
function checkSalary()
{
	var num1=document.getElementById("low").value;
	var num2=document.getElementById("up").value;
	
	if(num1!=""&&num2!=""){
	if(num1>num2)
	{
		document.getElementById("salaryError").innerHTML="输入的最低工资大于最高工资，请重输";
		return "notJump";
	}
	else
	{
		document.getElementById("salaryError").innerHTML=" ";
		return "jump";
	}
	}
	else
	{
		document.getElementById("salaryError").innerHTML=" ";
		return "jump";
	}
}

function submitForm()
{
    var temp=checkSalary();
    if(temp=="jump")
    {
    	document.getElementById('formId').submit();
    }
   
}
function submitForm2()
{
	var startDate=document.getElementById("date1").value;
	var endDate=document.getElementById("date2").value;
	
	if(startDate!=""&&endDate!="")
	{
		if(startDate>endDate)
		{
			document.getElementById("dateError").innerHTML="亲,您输入的初始时间和最终时间有误";
		}
		else
		{
			document.getElementById("form2").submit();
		}
	}
	else
	{
		document.getElementById("form2").submit();
	}
}