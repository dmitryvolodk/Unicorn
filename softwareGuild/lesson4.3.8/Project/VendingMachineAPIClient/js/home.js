$(document).ready(function () {
    loadItems();
    makePurchase();
    addMoney();
    returnChange();
});

function loadItems(){
    // to reset money input by a use once the purchase is made
    $('#addMoney').val(0);
    clearItemTable();
    var displayItemsForm = $('#displayItemsForm');
    $.ajax({
        type: 'GET',
        url: 'http://tsg-vending.herokuapp.com/items',
        success: function(itemArray) {
                var row = "";
            $.each(itemArray, function(index, item){
                var id = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;
                
                
               if(index == 0 || (index % 3) == 0){
                    row += '<div class="form-group row">';
                }
                
                row += '<div class="col-md-4">';
                row += '    <button type="button"';
                row += '        id="addItemButton' + id + '"';
                row += '        class="btn btn-light btn-block"';
                row += '        onclick="addItem(' + id + ')">';
                row += '            <div class="text-left">';
                row += '                <span id="' + id + '">' + id + '</span><br>';
                row += '            </div>';
                row += '            <div class="text-center">';
                row += '                <span id="name' + id + '">' + name + '</span><br>';
                row += '                <br>';
                row += '                <span id="price' + id + '">$' + price + '</span><br>';
                row += '                <br>';
                row += '                <br>';
                row += '                <span id="quantity' + id + '">Quantity Left: ' + quantity + '</span>';
                row += '            </div>';
                row += '    </button>';
                row += '</div>';
                
                if((itemArray.length -  1) == index || ((index + 1) % 3) == 0){
                    row += '</div>';
                }
                
            });
            displayItemsForm.append(row);
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again later.'));
        }
    });
}

function clearItemTable() {
    $('#displayItemsForm').empty();
}

function addMoney(){
    var money = 0.0;
    
    $('#addDollarButton').click(function (event) {
        money = 1.0 + parseFloat($('#addMoney').val());
        money = Math.round(money * 100) / 100;
        $('#addMoney').val(money);
    });
    
    $('#addQuarterButton').click(function (event) {
        money = 0.25 + parseFloat($('#addMoney').val());
        money = Math.round(money * 100) / 100;
        $('#addMoney').val(money);
    });
    
    $('#addDimeButton').click(function (event) {
        money = 0.10 + parseFloat($('#addMoney').val());
        money = Math.round(money * 100) / 100;
        $('#addMoney').val(money);
    });
    
    $('#addNickelButton').click(function (event) {
        money = 0.05 + parseFloat($('#addMoney').val());
        money = Math.round(money * 100) / 100;
        $('#addMoney').val(money);
    });
    
    $('#errorMessages').empty();
}

function addItem(id){
    $('#errorMessages').empty();
    $('#addItemId').val(id);
}

function makePurchase() {
    $('#makePurchaseButton').click(function (event) {
    var change = $('#change');
    var money = $('#addMoney').val();
    var item = $('#addItemId').val();
        $.ajax({
           type: 'POST',
           url: 'http://tsg-vending.herokuapp.com/money/' + money + '/item/' + item + '',
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
           'dataType': 'json',
           success: function(data, status) {
               var quarters = data.quarters;
               var dimes = data.dimes;
               var nickels = data.nickels;
               var pennies = data.pennies;
                
               var row = filterZeroCoins(quarters,dimes,nickels,pennies);
        
               change.append(row);
               
               $('#addItemId').val(0);
               $('#addMoney').val(0);
               $('#errorMessages').empty();
               $('#message').empty();
               $('#message').val('Thank you!!!');
               $('#change').val(row);
               loadItems();
           },
        error: function(xhr, status, error) {
               $('#message').empty();
               $('#message').val(JSON.parse(xhr.responseText).message);
               loadItems();
        }
        });
    });
}

function filterZeroCoins(quarters,dimes,nickels,pennies){
    var row = "";
        
    if(quarters > 0){
        row += quarters + ' Quarter(s) ';
    }
    if(dimes > 0){
        row += dimes + ' Dime(s) ';
    }
    if(nickels > 0){
        row += nickels + ' Nickel(s) ';
    }
    if(pennies > 0){
        row += pennies + ' Penny(s) ';
    }
                
    return row;         
}

function returnChange() {
    $('#returnChangeButton').click(function (event) {
        var changeDue = $('#addMoney').val();
        changeDue = changeDue * 100;
        
        var quarters = Math.trunc(changeDue / 25);
        changeDue = changeDue - quarters * 25;
        
        var dimes = Math.trunc(changeDue / 10);
        changeDue = changeDue - dimes * 10;
        
        var nickels = Math.trunc(changeDue / 5);
        changeDue = changeDue - nickels * 5;
        
        var pennies = changeDue;
        
        var row = filterZeroCoins(quarters,dimes,nickels,pennies);
        
        $('#change').empty();
        $('#change').val(row);
        
        $('#addMoney').val(0);
        
    });
}