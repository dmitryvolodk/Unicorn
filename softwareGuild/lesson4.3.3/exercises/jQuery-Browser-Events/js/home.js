$(document).ready(function () {
	// only the content in the Main section should display when the page is loaded
    $('#akronInfoDiv').hide();
	$('#minneapolisInfoDiv').hide();
	$('#louisvilleInfoDiv').hide();
	// when the Akron button is clicked, only the content in the Akron section should display 
	// the weather information for Akron should be hidden initially
	$('#akronButton').on('click', function () {
		$('#akronInfoDiv').show();
		$('#akronWeather').hide();
	});
	// when the Minneapolis button is clicked, only the content in the Minneapolis section should display 
	// the weather information for Minneapolis should be hidden initially
	$('#minneapolisButton').on('click', function () {
		$('#minneapolisInfoDiv').show();
		$('#minneapolisWeather').hide();
	});
	// when the Louisville button is clicked, only the content in the Louisville section should display 
	// the weather information for Louisville should be hidden initially
	$('#louisvilleButton').on('click', function () {
		$('#louisvilleInfoDiv').show();
		$('#louisvilleWeather').hide();
	});
	// when the Show/Hide Weather button is clicked, the page should display the associated weather information 
	// display - if it was hidden or hide the associated weather information - if it was showing. It should default to hidden
	// for Acron
	$('#akronWeatherButton').on('click', function () {
		$('#akronWeather').toggle();
	});
	// for Minneapolis
	$('#minneapolisWeatherButton').on('click', function () {
		$('#minneapolisWeather').toggle();
	});
	// for Louisville
	$('#louisvilleWeatherButton').on('click', function () {
		$('#louisvilleWeather').toggle();
	});
	// add "Hover" for background color of data cells to change to "WhiteSmoke" and back
	$('td').hover(
    // in callback
	function () {
		$(this).css('background-color', 'WhiteSmoke');
	}, 
	// out callback
	function () {
		$(this).css('background-color', '');
	});
});