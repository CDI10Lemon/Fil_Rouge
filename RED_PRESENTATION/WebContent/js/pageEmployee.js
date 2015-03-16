/**
 * 
 */

(function(){
	"use strict";
	
	var employeeList = [];
	var indexOfFirstEmployeeToShow = 0;
	
	function buildEmployeeListToShow(startIndex) {
		var $table;
		var $row;
		
		$("#testAutoCompUtilisateur").empty();
		$table = $("<table id='employeeTable'/>");
		
		for (var index = startIndex; index < employeeList.length; index++ ) {
			$row = $("<tr/>");
			$row.html("<td>" + employeeList[index] + "</td>");
			$table.append($row);
		}
		
		$("#testAutoCompUtilisateur").append($table);
	}
	
	$.ajax({
		url: "http://localhost:8080/RED_WEBSERVICE/rest/employee",
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        //data: JSON.stringify(dataForm),
        success: function (data) {
        	
        	
        	// Construction de la liste des utilisateurs sous la forme "nom prenom"
        	for (var index = 0; index < data.length; index++)
        	{
        		employeeList.push(data[index].lastname + " " + data[index].name);
        	}
        	employeeList.sort();
        	console.log(employeeList);
        	
        	// Construction et injection du code html
        	for (var index = 0; index < employeeList.length; index++) //data
        	{
        		console.log(employeeList[index]); //data

        		var $newTag;
        		var $div;
        		var $table;
        		var $row;
        		
        		// Remplissage de la datalist
        		$newTag = $("<option>")
        		$newTag.val(employeeList[index]);
        		$("#employees").append($newTag);
        		
        		// Remplissage de la liste de selection rapide
        		buildEmployeeListToShow(0);
        		/*
        		$table = $("<table id='employeeTable'/>");
        		$row = $("<tr/>");
        		$row.html("<td>" + employeeList[index] + "</td>");
        		$table.append($row);
        		*/
        		
        		/*
        		//$div = $("<p/>")
        		$newTag = $("<a/>");
        		$newTag.html(employeeList[index]);//data[index].lastname + " " + data[index].name + " ");
        		//$div.append($newTag);
        		*/
        		
        		$("#testAutoCompUtilisateur").append($table);
        	}

        	//console.log(data);
        }
    });
	
	$("#selectEmployee").keyup(function() {
		var searchItem = $(this).val();
		
		//for ( var indexItem = 0; indexItem < searchItem.length; indexItem++) {
		//var indexItem = searchItem.length - 1;
		//console.log("recherche " + searchItem[indexItem]);

		    for (var index = 0; index < employeeList.length; index++ ) {
		    	var subStr = employeeList[index].substring(0, searchItem.length);
		    	console.log(subStr);
		    	console.log(searchItem);
		    	
		    	if ( subStr === searchItem )
		    	{
		    		console.log("found " + employeeList[index])
		    		buildEmployeeListToShow(index);
		    		return;
		    	}
		    	/*
		    	var res = employeeList[index].toLowerCase().indexOf(searchItem[indexItem]);
		    	//console.log("pour " + employeeList[index] + "index = " + res);
		    	if ( res === indexItem ) {
		    		buildEmployeeListToShow(index);

		    		//console.log("found " + employeeList[index]);
		    	}
		    		*/
		    	/*
		    	if ( searchItem[indexItem] === employeeList[index] )
				{
					indexOfFirstEmployeeToShow = index;
					console.log(indexOfFirstEmployeeToShow);
					break;
				}
				*/
			}
		    
		    
		//}
	});

	/*
	if ( document.getElementById("selectEmployee") )
		document.getElementById("selectEmployee").addEventListener("search", function(e){
			var userInput = $("selectEmployee").val();
			console.log(userInput);
		}, false);
	*/
}).call(this);