$(document).ready(function () {
    loadWeather();
	loadForecast();
});


function loadWeather() {
    var contentBlocks1 = $('#contentBlocks1');
	
	$.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/data/2.5/weather?zip=94040&units=imperial&appid=2edab6a0f184684dcb1781c444a78c22',
        success: function(weatherContent) {
                var name = weatherContent.name;
                var speed = weatherContent.wind.speed;
                var temperature = weatherContent.main.temp;
                var humidity = weatherContent.main.humidity;
				var condition = "";
				var description = "";
				var icon = "";
				
				$.each(weatherContent.weather, function(index, weatherElement){
				condition = weatherElement.main;
                description = weatherElement.description;
                icon = weatherElement.icon;
				})
				var block = '<hr>';
                    block += '<h2>Current Conditions in ' + name + '</h2>';
                    block += '<!-- container for Current Conditions content block -->';
					block += '<div class="row">'; 
					block += '	<!-- container for the icon and description of the current conditions -->';
					block += '	<div class="col-md-3">'; 
					block += '		<p><img src="http://openweathermap.org/img/w/' + icon + '.png" />' + condition + ': ' + description + '</p>';
					block += '	</div>';

					block += '	<!-- container for the temperature, humidity, and wind data -->';
					block += '	<div class="col-md-3">'; 
					block += '		<p>Temperature: ' + temperature + ' F</p>';
					block += '		<p>Humidity: ' + humidity + ' %</p>';
					block += '		<p>Wind: ' + speed + ' miles/hour</p>';
					block += '	</div>';
					block += '</div>'; 
					block += '<hr>';
                
                contentBlocks1.append(block);
        },
        error: function() {
        
        }
    });
}	
	




function loadForecast() {
    var contentBlocks2 = $('#contentBlocks2');
	
	$.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/data/2.5/forecast?zip=94040&units=imperial&appid=2edab6a0f184684dcb1781c444a78c22',
        success: function(forecastContent) {
			
				var block = '<h2>Five Day Forecast</h2>';
					block += '<!-- container for Five Day Forecast content block -->';
					block += '<div class="row">'; 
					
				

				var temIcon = "";
				var temCondition = "";
				var temTempMax = "";
				var temTempMin = "";
				var temDay = "";
				var temDate = "";
				var date = "";
				var tempDay = "";
				var dateFuture = "";
				
				$.each(forecastContent.list, function(index, dayElement){
				var day = dayElement.dt_txt;
				var condition = "";
				var icon = "";
				var temp_min = dayElement.main.temp_min;
				var temp_max = dayElement.main.temp_max;
				
					$.each(dayElement.weather, function(index, weatherElement){
						condition = weatherElement.main;
						icon = weatherElement.icon;
					})
					
					
					var parts = day.split(" ");
					var	dateYearMonth = parts[0].split("-");
						date = dateYearMonth[2];
										
					if(index < (forecastContent.list.length - 1)){
					var partsFuture = forecastContent.list[index + 1].dt_txt.split(" ");
					var	dateYearMonthFuture = partsFuture[0].split("-");
						dateFuture = dateYearMonthFuture[2];
					}

						if(index == 0){
							temTempMax = temp_max;
							temTempMin = temp_min;
							temDay = day;
							temIcon = icon;
							temCondition = condition;
						}
						
									
					if(index != 0){
						if(temp_max > temTempMax){
							temTempMax = temp_max;
							temDay = day;
							temIcon = icon;
							temCondition = condition;
							
						}
						if(temp_min < temTempMin){
							temTempMin = temp_min;
						}
					}
					
					
					if(index == (forecastContent.list.length - 1) || (dateFuture - date) != 0){
					block += '	<!-- container for the each Day of the Forecast -->';
					block += '	<div class="col-md-2">'; 
					block += '		<p>' + temDay + '</p>';
					block += '		<p><img src="http://openweathermap.org/img/w/' + temIcon + '.png" />' + temCondition + '</p>';
					block += '		<p>' + dateFuture + 'H ' + temTempMax + ' F L ' + temTempMin + ' F</p>';
					block += '	</div>';
					
							if(index != (forecastContent.list.length - 1)){
							temTempMax = forecastContent.list[index +1].main.temp_max;
							temTempMin = forecastContent.list[index +1].main.temp_min;
							}
					}
					
					
				
				})
		
		
					block += '</div>';
                
                contentBlocks2.append(block);
        },
        error: function() {
        
        }
    });

	
	
}