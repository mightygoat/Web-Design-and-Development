function submitForm()
{
	var feedbackForm = document.feedbackForm;
	
	if(validateForm())
	{
		alert("Thanks! Feedback submitted successfully");
		feedbackForm.reset();
	}
}



function validateForm() 
{	
	var validations = new Validations();
	
    document.forms["feedbackForm"]["name"].style.borderColor = "#FFFFFF";
	var name = document.forms["feedbackForm"]["name"].value;
    if (validations.isEmpty(name)){
        document.forms["feedbackForm"]["name"].style.borderColor = "#3E2723";
		alert("Name must be filled");
        return false;
    }
	
	document.forms["feedbackForm"]["email"].style.borderColor = "#FFFFFF";
	var email = document.forms["feedbackForm"]["email"].value; 
	if ( validations.isEmpty(email)) {
        document.forms["feedbackForm"]["email"].style.borderColor = "#3E2723";
		alert("Email ID must be filled");
        return false;
    }
	
	if( !(validateRadio(document.forms["feedbackForm"]["Rating"])))
	{
		
		alert( "Please tell us your experience");
		return false;
	}
	
	if(!(validations.isChar(name)))
	{
		document.forms["feedbackForm"]["name"].style.borderColor = "#3E2723";
		alert("Name can have only characters");
        return false;
	}
	
	document.forms["feedbackForm"]["email"].style.borderColor = "#FFFFF";
	if(!(validations.isEmail(email)))
	{
		document.forms["feedbackForm"]["email"].style.borderColor = "#3E2723";
		alert("Email address is invalid");
		return false;
	}
	
	return true;
	
	
}

function validateRadio (radios)
{
    for (i = 0; i < radios.length; ++ i)
    {
        if (radios [i].checked) return true;
    }
    return false;
}

