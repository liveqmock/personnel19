function checkIsNumber(n)//检查是否输入合理的数字
{
	var reg= new RegExp("^[0-9]*$"); 	
	var num=document.getElementsById("cPTemp").value;
	if(!(reg.test(num)))//不是数字
		{
		document.getElementById("numError").innerHTML="输入不为数字，请重新输入";
	  
		}
		else
	{
		if(num>n)
		{
			document.getElementById("numError").innerHTML="输入的页数超过总页数";
		
		}
		else	
		{
			document.getElementById("numError").innerHTML=" ";
			document.getElementById("formid").submit();
	
		}			
	}	
}
