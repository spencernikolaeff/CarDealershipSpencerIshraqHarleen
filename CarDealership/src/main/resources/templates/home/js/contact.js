$(document).ready(function () {
	alert("submitted!");
	addContact();
});

function addContact() {
    $('#addButton').click(function (event) {
        $.ajax({
           type: 'POST',
           url: 'http://localhost:8080/home/contact.html',
           data: JSON.stringify({
                contactName: $('#name').val(),
                email: $('#email').val(),
                phoneNumber: $('#phone').val(),
                message: $('#message').val()
           }),
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
           'dataType': 'json',
           success: function() {
				$('#errorMessages').empty();
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