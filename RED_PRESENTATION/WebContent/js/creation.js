


function creation()
{




  var dataformulaire = {
           	name : $("#inputLastName").val(),
            lastname : $("#inputFirstName").val(),
            birthday : $("#inputBirthday").val(),
            email : $("#inputEmail").val(),
           
            date : $("#inputInscriptionDate").val(),
			
            

        }

//alert(dataformulaire.name +" "+dataformulaire.lastname );
//alert(JSON.stringify(dataformulaire));

$.ajax({
            url: 'http://localhost:8080/RED_WEBSERVICE/rest/enduser',
            type: 'POST',
            dataType: 'json',
             contentType: "application/json",
              data: JSON.stringify(dataformulaire),
            success: function (data) {
              alert('Création réussie');
            }
          
        });


}

function effacer()
{
	alert('delete');
}

