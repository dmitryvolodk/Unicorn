$(document).ready(function () {
    loadDVDs();
    addDVD();
    updateDVD();
});

function loadDVDs() {
    clearDVDTable();
    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvds',
        success: function (DVDArray) {
            $.each(DVDArray, function (index, DVD) {
                var title = DVD.title;
                var releaseYear = DVD.releaseYear;
                var director = DVD.director;
                var rating = DVD.rating;
                var dvdId = DVD.id;

                var row = '<tr>';
                row += '<td>' + title + '</td>';
                row += '<td>' + releaseYear + '</td>';
                row += '<td>' + director + '</td>';
                row += '<td>' + rating + '</td>';
                row += '<td><a id="editLink" onclick="showEditForm(' + dvdId + ')">Edit</a>|<a id="deleteLink" onclick="deleteDVD(' + dvdId + ')">Delete</a></td>';
                row += '</tr>';

                contentRows.append(row);
            });
        },
        error: function () {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again later.'));
        }
    })
}

function showAddForm() {
    $('#errorMessages').empty();
    
    $('#MenuFormDiv').hide();
    $('#DVDTableDiv').hide();
    $('#addFormDiv').show();
}

function hideAddForm() {
    $('#errorMessages').empty();
    
    $('#addDVDTitle').val('');
    $('#addReleaseYear').val('');
    $('#addDirector').val('');
    $('#addRating').val('');
    $('#addNotes').val('');

    $('#MenuFormDiv').show();
    $('#DVDTableDiv').show();
    $('#addFormDiv').hide();
}

function addDVD() {
    $('#createDVD2').click(function (event) {
        var haveValidationErrors = checkAndDisplayValidationErrors($('#addForm').find('input'));
        
        if(haveValidationErrors) {
            return false;
        }
        
        $.ajax({
           type: 'POST',
           url: 'https://tsg-dvds.herokuapp.com/dvd',
           data: JSON.stringify({
                title: $('#addDVDTitle').val(),
                releaseYear: $('#addReleaseYear').val(),
                director: $('#addDirector').val(),
                rating: $('#addRating').val(),
                notes: $('#addNotes').val()
           }),
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
           'dataType': 'json',
           success: function() {
               $('#errorMessages').empty();
               $('#addDVDTitle').val('');
               $('#addReleaseYear').val('');
               $('#addDirector').val('');
               $('#addRating').val('');
               $('#addNotes').val('');
               hideAddForm();
               loadDVDs();
           },
           error: function () {
               $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again later.')); 
           }
        })
    });
}

function clearDVDTable() {
    $('#contentRows').empty();
}

function showEditForm(DVDId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvd/' + DVDId,
        success: function(data, status) {
            $('#editDVDId').val(data.id);
            $('#editDVDTitle').val(data.title);
            $('#editReleaseYear').val(data.releaseYear);
            $('#editDirector').val(data.director);
            $('#editRating').val(data.rating);
            $('#editNotes').val(data.notes);
            
        },
        error: function() {
            $('#errorMessages')
            .append($('<li>')
            .attr({class: 'list-group-item list-group-item-danger'})
            .text('Error calling web service. Please try again later.')); 
        }
    })
    
    $('#MenuFormDiv').hide();
    $('#DVDTableDiv').hide();
    $('#editFormDiv').show();
}

function hideEditForm() {
    $('#errorMessages').empty();
    
    $('#editDVDTitle').val('');
    $('#editReleaseYear').val('');
    $('#editDirector').val('');
    $('#editRating').val('');
    $('#editNotes').val('');

    $('#MenuFormDiv').show();
    $('#DVDTableDiv').show();
    $('#editFormDiv').hide();
}

function updateDVD(id) {
    $('#editSaveChanges').click(function(event) {
        var haveValidationErrors = checkAndDisplayValidationErrors($('#editForm').find('input'));
        
        if(haveValidationErrors) {
            return false;
        }
        
        $.ajax({
            type: 'PUT',
            url: 'https://tsg-dvds.herokuapp.com/dvd/' + $('#editDVDId').val(),
            data: JSON.stringify({
                id: $('#editDVDId').val(),
                title: $('#editDVDTitle').val(),
                releaseYear: $('#editReleaseYear').val(),
                director: $('#editDirector').val(),
                rating: $('#editRating').val(),
                notes: $('#editNotes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            'success': function() {
                $('#errorMessage').empty();
                hideEditForm();
                loadDVDs();
            },
            'error': function() {
                $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again later.')); 
            }
        });
    })
}

function deleteDVD(DVDId) {
    $.ajax({
        type: 'DELETE',
        url: 'https://tsg-dvds.herokuapp.com/dvd/' + DVDId,
        success: function() {
            loadDVDs();
        }
    });
}

function checkAndDisplayValidationErrors(input) {
    $('#errorMessages').empty();
    
    var errorMessages = [];
    
    input.each(function() {
        if (!this.validity.valid) {
            var errorField = $('label[for=' + this.id + ']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }  
    });
    
    if (errorMessages.length > 0){
        $.each(errorMessages,function(index,message) {
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        // return true, indicating that there were errors
        return true;
    } else {
        // return false, indicating that there were no errors
        return false;
    }
}