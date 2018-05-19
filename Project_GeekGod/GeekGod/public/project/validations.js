function Validations()
{
	
}

Validations.prototype.isEmpty = function(str){	
	if(str == null || str =="")
	{
		return true;
	}
	else
	{
	return false;
	}
}

Validations.prototype.isEmail = function(str){
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(pattern.test(str))
	{
		return true;
	}
	else
	{
	return false;
	}
}

Validations.prototype.isChar = function(str){
	var charPattern= /^[a-zA-Z]+$/;
	if(charPattern.test(str))
	{
		return true;
	}
	else
	{
	return false;
	}
}

Validations.prototype.isNumber = function(str){
	var numPattern= /^[0-9]+$/;
	if(numPattern.test(str))
	{
		return true;
	}
	else
	{
	return false;
	}
}

Validations.prototype.validLength = function(str){
	var input = str;
	if(input.length == 10)
	{
		return true;
	}
	else
	{
	return false;
	}
}







