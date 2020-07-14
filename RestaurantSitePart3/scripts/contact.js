function clearErrors() {    
    for (var loopCounter = 0; loopCounter < document.forms["contactFun"].elements.length; 
        loopCounter++) {
        if (document.forms["contactFun"].elements[loopCounter].parentElement.className.indexOf("has-") != -1) {
            
            document.forms["contactFun"].elements[loopCounter]
               .parentElement.className = "form-group";
        }
    }    
} 

function validateItems() {
   clearErrors();
    var inputName = document.forms["contactFun"]["inputName"].value;
    var inputEmail = document.forms["contactFun"]["inputEmail"].value;
    var inputPhone = document.forms["contactFun"]["inputPhone"].value;
    if (inputName == "") {
        alert("inputName must be filled in.");
        document.forms["contactFun"]["inputName"].parentElement.className = "form-group has-error";
        document.forms["contactFun"]["inputName"].focus();
        return false;
    }
   if (inputEmail == "") {
       alert("inputEmail must be filled in.");
       document.forms["contactFun"]["inputEmail"].parentElement.className = "form-group has-error"
       document.forms["contactFun"]["inputEmail"].focus();
       return false;
   }
   if (inputPhone == "") {
       alert("inputPhone must be filled in.");
       document.forms["contactFun"]["inputPhone"].parentElement.className = "form-group has-error"
       document.forms["contactFun"]["inputPhone"].focus();
       return false;
   }
   if (inputName != "" || inputPhone != "" || inputEmail != "") {
       alert("The invormation is valid.");
   }
   

   // We are returning false so that the form doesn't submit 
   // and so that we can see the results
   return false;
}