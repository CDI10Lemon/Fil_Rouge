/**
 * employeePage
 * 
 * Implementation des fonctionnalités de la page Utilisateurs
 * 
 * @author Sebastien PASSIER
 * @version 1.0
 */

(function(){
	"use strict";
	
	var employeeList = [];

	/**
	 * initilization
	 * 
	 * Cette méthode regroupe l'ensemble des opérations réalisées sitôt le chargement de la page terminé
	 */
	function initialization() {
		queryAllEmployees();
		queryAllSites();
		queryAllStructures();
	}
	
	/**
	 * refreshQuickSelectionView
	 * 
	 * Reconstruit le DOM de la fenêtre de sélection rapide
	 * 
	 * @param startIndex Index indiquant l'élement de la liste qui débute l'affichage  
	 */
	function refreshQuickSelectionView(startIndex) {
		var $table;
		var $row;
		
		$("#autoCompletion").empty();
		
		$table = $("<table id='employeeTable'/>");
		
		for ( var index = startIndex; index < employeeList.length; index++ ) {
			$row = $("<tr/>");
			$row.html("<td>" + employeeList[index] + "</td>");
			$table.append($row);
		}
		
		$("#autoCompletion").append($table);
	}
	
	/**
	 * queryAllEmployees
	 * 
	 * Charge la liste de tous les utilisateurs
	 */
	function queryAllEmployees() {
		$.ajax({
			url: "http://localhost:8080/RED_WEBSERVICE/rest/employee",
			type: "GET",
			dataType: "json",
			contentType: "application/json",
			success: function(data) {
				for ( var index = 0; index < data.length; index++ ) {
					employeeList.push(data[index].lastname + " " + data[index].name);
				}
				employeeList.sort();
        	
				refreshQuickSelectionView(0);
			}
		});
	}
	
	/**
	 * queryAllStructures
	 * 
	 * Charge la liste de toutes les structures d'appartenance
	 */
	function queryAllStructures() {
		$.ajax({
			url: "http://localhost:8080/RED_WEBSERVICE/rest/structure",
			type: "GET",
			dataType: "json",
			contentType: "application/json",
			success: function(data) {
				var $option;

				for ( var index = 0; index < data.length; index++ ) {
					$option = $("<option value=" + data[index].idStructure + ">" + data[index].name + "</option>");
					$("#structures").append($option);
				}
				
				// Option vide en tete de sélection
				$option = $("<option value=" + 0 + "></option>");
				$("#structures").prepend($option);
			}
		});
	}
	
	/**
	 * queryAllSites
	 * 
	 * Charge la liste de tous les sites
	 */
	function queryAllSites() {
		$.ajax({
			url: "http://localhost:8080/RED_WEBSERVICE/rest/site",
			type: "GET",
			dataType: "json",
			contentType: "application/json",
			success: function(data) {
				var $option;

				for ( var index = 0; index < data.length; index++ ) {
					$option = $("<option value=" + data[index].idSite + ">" + data[index].name + "</option>");
					$("#sites").append($option);
				}
				
				// Option vide en tete de sélection
				$option = $("<option value=" + 0 + "></option>");
				$("#sites").prepend($option);
			}
		});
	}
	
	/*
	 * Events functions
	 */
	$("#selectEmployee").keyup(function() {
		var searchStr = $(this).val().toLowerCase();
		for ( var index = 0; index < employeeList.length; index++ ) {
		    var subStr = employeeList[index].toLowerCase().substring(0, searchStr.length);
		    	
		    if ( subStr === searchStr )
		    {
		    	refreshQuickSelectionView(index);
		    	return;
		    }
		}
	});

	/*
	 * Flow of execution of the page
	 */
	initialization();

}).call(this);