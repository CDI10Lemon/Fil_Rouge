/**
 * employeePage.js
 * 
 * Implementation des fonctionnalités de la page Utilisateurs
 * 
 * @author Sebastien PASSIER
 * @version 1.0.1
 * 
 * @Todo 
 * - Contrôles des champs via regexp
 * - Messages d'erreurs pour les controles de champs
 * - Messages d'erreurs pour les accès au service REST
 * - Gestion de l'affichage des boutons
 * - Créer un utilisateur
 * - Modifier un utilisateur
 * - Annuler
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
		clearAllFields();
		disableButtons(false, true, true);
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
			$row.html("<td data-row=" + index + ">" + employeeList[index].fullname() + "</td>");
			$table.append($row);
		}
		
		$("#autoCompletion").append($table);
	}
	
	/**
	 * clearAllFields
	 * 
	 * Efface tous les champs, desélectionne les comboBox et decoche la checkbox
	 */
	function clearAllFields() {
		$("input").val("");
		$("select").val("");
		$(":checkbox").prop("checked", false);
	}
	
	/**
	 * disableButtons
	 * 
	 * Permet de changer l'état des 3 boutons
	 * 
	 * @param btnCreate Indique si le bouton "Créer" doit être désactivé
	 * @param btnModify Indique si le bouton "Modifier" doit être désactivé
	 * @param btnCancel Indique si le bouton "Annuler" doit être désactivé
	 */
	function disableButtons(btnCreate, btnModify, btnCancel) {
		$("#btnCreate").prop("disabled", btnCreate);
		$("#btnModify").prop("disabled", btnModify);
		$("#btnCancel").prop("disabled", btnCancel);
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
		}).done(function(data) {
			for ( var index = 0; index < data.length; index++ ) {
				var employee = new Employee(data[index].idEmployee, data[index].name, data[index].lastname, data[index].password, data[index].category, data[index].structure, data[index].site);
				
				employeeList.push(employee);
			}
			
			employeeList.sort(function(itemA, itemB) {
				  var a = itemA.lastname.toLowerCase();
				  var b = itemB.lastname.toLowerCase();

				  if( a < b )
				    return -1;
				  else if( a > b )
				    return 1;
				 return 0;
				});
    	
			refreshQuickSelectionView(0);
		}).fail(function() {
			// Handling errors here ...
		}).always(function() {
			// Action to do after the call of done or fail
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
		}).done(function(data) {
			var $option;

			for ( var index = 0; index < data.length; index++ ) {
				$option = $("<option value=" + data[index].idStructure + ">" + data[index].name + "</option>");
				$("#structures").append($option);
			}
			
			// Head of the selection is empty (at option tag of index zero)
			$option = $("<option value=" + 0 + "></option>");
			$("#structures").prepend($option);
		}).fail(function() {
			// Handling errors here ...
		}).always(function() {
			// Action to do after the call of done or fail
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
		}).done(function(data) {
			var $option;

			for ( var index = 0; index < data.length; index++ ) {
				$option = $("<option value=" + data[index].idSite + ">" + data[index].name + "</option>");
				$("#sites").append($option);
			}
			
			// Head of the selection is empty (at option tag of index zero)
			$option = $("<option value=" + 0 + "></option>");
			$("#sites").prepend($option);
		}).fail(function() {
			// Handling errors here ...
		}).always(function() {
			// Action to do after the call of done or fail
		});
	}
	
	/*
	 * Events functions
	 */
	$("#selectEmployee").keyup(function() {
		var searchStr = $(this).val().toLowerCase();
		
		if ( $(this).val() ) {
			for ( var index = 0; index < employeeList.length; index++ ) {
				var subStr = employeeList[index].fullname().toLowerCase().substring(0, searchStr.length);
		    	
				if ( subStr === searchStr )
				{
					refreshQuickSelectionView(index);
					return;
				}
			}
		}
		else {
			refreshQuickSelectionView(0);
			clearAllFields();
			disableButtons(false, true, true);
		}
	});

	// Delegated events have the advantage that they can process events from children elements that are added to the document at a later time
	$("#autoCompletion").on("click", "#employeeTable td", function(e) {
		var selectedRowIndex = $(this).attr("data-row");
		
		// When selected, the fullname much appears in the search input
		$("#selectEmployee").val(employeeList[selectedRowIndex].fullname());
		
		// Now populate all fields
		$("#inputLastName").val(employeeList[selectedRowIndex].lastname);
		$("#inputFirstName").val(employeeList[selectedRowIndex].name);		
		// FIXME: les données doivent être contenues dans un DTO site
		$("#sites").val(employeeList[selectedRowIndex].site);
		// FIXME: les données doivent être contenues dans un DTO structure
		$("#structures").val(employeeList[selectedRowIndex].structure);
		$("#inputPassword").val(employeeList[selectedRowIndex].password);
		$("#inputConfirmPassword").val(employeeList[selectedRowIndex].password);
		// FIXME: les données doivent être contenues dans un DTO category
		$("#utlimultisites").prop("checked", true);
		
		// Then change the buttons state
		disableButtons(true, false, false);
	});
	
	$("#btnCreate").click(function(e) {
		
	});
	
	$("#btnModify").click(function(e) {
		
	});
	
	$("#btnCancel").click(function(e) {
		refreshQuickSelectionView(0);
		clearAllFields();
		disableButtons(false, true, true);
	});
	
	/*
	 * Flow of execution of the page
	 */
	initialization();

}).call(this);