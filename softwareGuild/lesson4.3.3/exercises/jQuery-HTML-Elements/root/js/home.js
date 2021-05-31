$(document).ready(function () {
    // center all H1 elements
    $('H1').css('text-align', 'center');
    // center all H2 elements
	$('H2').css('text-align', 'center');
	// remove class 'myBannerHeading' and add class 'page-header' to 'H1' element with "Team Up"
	$('H1:first').removeClass('myBannerHeading').addClass('page-header');
	// change the text of "The Squad" to "Yellow Team"
	$('#yellowHeading').text("Yellow Team");
	// change the background color for each team list to match the name of the team
	$('#orangeHeading').css('background-color', 'orange');
	$('#blueHeading').css('background-color', 'blue');
	$('#redHeading').css('background-color', 'red');
	$('#yellowHeading').css('background-color', 'yellow');
	// add Joseph Banks and Simon Jones to the Yellow Team list
	$('#yellowTeamList').html('<li>Joseph Banks</li> <li>Simon Jones</li>');
	// Hide the element containing the text "Hide Me!!!"
	$('#oops').hide();
	// Remove the element containing the text "Bogus Contact Info" from the footer
	$('#footerPlaceholder').remove();
	// add a paragraph element containing your name and email to the footer 
	// the text must be in Courier font and be 24 pixels in height
	$('.footer').html('<p>Dmitry Volodkevich, dmitryvolodk@gmail.com</p>');
	$('.footer').css({'font-family': 'Courier', 'fontSize': '24px'});
});
