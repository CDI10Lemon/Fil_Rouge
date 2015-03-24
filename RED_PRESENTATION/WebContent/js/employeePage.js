/**
 * employeePage.js
 * 
 * Implementation des fonctionnalités de la page Utilisateurs
 * 
 * @author Sebastien PASSIER
 * @version 1.0.3
 * 
 * @Todo
 * - Contrôles des champs via regexp
 * - Messages d'erreurs pour les  controles de champs 
 * - Messages d'erreurs pour les accès au service REST
 * - Créer/update un utilisateur
 * - Popup
 */

(function() {
	"use strict";

	var employeeList = [];
	var employeeSelected = null;

	/**
	 * initilization
	 * 
	 * Cette méthode regroupe l'ensemble des opérations réalisées sitôt le chargement de la page terminé
	 */
	function initialization() {
		clearAllFields(true);
		disableButtons(false, true);
		queryAllEmployees();
		queryAllSites();
		queryAllStructures();

		// Disable KEY_ENTER on input #selectedEmployee to prevent deletion
		$("#selectEmployee").on('keypress keydown keyup', function(e) {
			if (e.keyCode == 13) {
				e.preventDefault();
			}
		});
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
			$row.html("<td data-row=" + index + ">"	+ employeeList[index].fullname() + "</td>");
			$table.append($row);
		}

		$("#autoCompletion").append($table);
	}

	/**
	 * clearAllFields
	 * 
	 * Efface tous les champs, desélectionne les comboBox et décoche la checkbox
	 * 
	 * @param withSearchInput Boolean indiquant si le champs de recherche doit aussi être effacer
	 */
	function clearAllFields(withSearchInput) {
		if ( !withSearchInput ) {
			$("#inputLastName").val("");
			$("#inputFirstName").val("");
			$("#inputPassword").val("");
			$("#inputConfirmPassword").val("");
		} else {
			$("input").val("");
		}
		$("select").val("");
		$(":checkbox").prop("checked", false);
	}

	/**
	 * populateFieldsFromEmployee
	 * 
	 * Alimente les différents champs de la page avec les données du DTO employee
	 * 
	 * @param employee Objet de type Employee
	 */
	function populateFieldsFromEmployee(employee) {
		var id = 0;
		var checked = false;
		
		$("#inputLastName").val(employee.lastname);
		$("#inputFirstName").val(employee.name);
		
		id = 0;
		if ( employee.site ) {
			id = employee.site.id;
		}
		$("#sites").val(id);
		
		id = 0;
		if ( employee.structure ) {
			id = employee.structure.id;
		}
		$("#structures").val(id);
		
		$("#inputPassword").val(employee.password);
		$("#inputConfirmPassword").val(employeeList.password);
		
		if ( employee.category && employee.category.sedentary ) {
			checked = true;
		}
		$("#multisites").prop("checked", checked);
	}

	/**
	 * 
	 */
	function checkAllFields() {
		var result = "noerror";

		if ( $("#inputLastName").val() ) {
			// TODO: regexp
		} else {
			result = "Le nom de l'utilisateur est manquant.<br/>Veuillez saisir le nom de l'utilisateur";
			return result;
		}

		if ( $("#inputFirstName").val() ) {
			// TODO: regexp
		} else {
			result = "Le prénom de l'utilisateur est manquant.<br/>Veuillez saisir le prénom de l'utilisateur";
			return result;
		}

		if ( $("#sites").val() !== 0 ) {
			// TODO: regexp
		} else {
			result = "Aucun site est selectionné.<br/>Veuillez sélectionner un site";
			return result;
		}

		if ( $("#structures").val() !== 0 ) {
			// TODO: regexp
		} else {
			result = "Aucune structure d'appartenance est selectionnée.<br/>Veuillez sélectionner une structure d'appartenance";
			return result;
		}

		if ( $("#inputPassword").val() && $("#inputConfirmPassword").val() && ($("#inputPassword").val() === $("#inputConfirmPassword").val() ) ) {
			// TODO: regexp
		} else if ( !$("#inputPassword").val() ) {
			result = "Le mot de passe est manquant.<br/>Veuillez saisir le mot de passe";
			return result;
		} else if ( !$("#inputConfirmPassword").val() ) {
			result = "La confirmation du mot de passe est manquant.<br/>Veuillez saisir le confirmation du mot de passe";
			return result;
		} else if ( $("#inputPassword").val() !== $("#inputConfirmPassword").val() ) {
			result = "La confirmation du mot de passe est différente du mot de passe<br/>Veuillez saisir à nouveau la confirmation du mot de passe";
			return result;
		}

		return result;
	}

	/**
	 * 
	 */
	function showPopupWithError(error) {
		$("#popupErrorMessage").html(error);
		$("#popupError").modal("show");
	}

	/**
	 * disableButtons
	 * 
	 * Permet de changer l'état des 2 boutons
	 * 
	 * @param btnSave Indique si le bouton "Enregistrer" doit être désactivé
	 * @param btnDelete Indique si le bouton "Supprimer" doit être désactivé
	 */
	function disableButtons(btnSave, btnDelete) {
		$("#btnSave").prop("disabled", btnSave);
		$("#btnDelete").prop("disabled", btnDelete);
	}

	/**
	 * queryAllEmployees
	 * 
	 * Charge la liste de tous les utilisateurs
	 */
	function queryAllEmployees() {
		employeeList = [];

		$.ajax({
			url : "http://localhost:8080/RED_WEBSERVICE/rest/employee",
			type : "GET",
			dataType : "json",
			contentType : "application/json",
		}).done( function(data) {
			var site = null;
			var category = null;
			var structure = null;
			
			for ( var index = 0; index < data.length; index++ ) {
				if ( data[index].site !== null ) {
					site = new Site(data[index].site.idSite, data[index].site.name, data[index].site.maxUnit);
				}

				if ( data[index].site !== null ) {
					category = new Category(data[index].category.idCategory, data[index].category.name, data[index].category.sedentary);
				}
				
				if ( data[index].structure !== null ) {
					structure = new Structure(data[index].structure.idStructure, data[index].structure.name);
				}
				
				var employee = new Employee(data[index].idEmployee,	data[index].name, data[index].lastname, data[index].password, category, structure, site);
				employeeList.push(employee);
				console.log(employee);
			}

			employeeList.sort(function(itemA, itemB) {
				var a = itemA.lastname.toLowerCase();
				var b = itemB.lastname.toLowerCase();

				if ( a < b )
					return -1;
				else if ( a > b )
					return 1;

				return 0;
			});

			refreshQuickSelectionView(0);
		}).fail(function() {
			// H event.preventDefault();andling errors here ...
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
			url : "http://localhost:8080/RED_WEBSERVICE/rest/structure",
			type : "GET",
			dataType : "json",
			contentType : "application/json",
		}).done( function(data) {
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
			url : "http://localhost:8080/RED_WEBSERVICE/rest/site",
			type : "GET",
			dataType : "json",
			contentType : "application/json",
		}).done( function(data) {
			var $option;

			for (var index = 0; index < data.length; index++) {
				$option = $("<option value=" + data[index].idSite + ">"	+ data[index].name + "</option>");
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

	/**
	 * queryDeleteEmployee
	 * 
	 * Supprimer un utilisateur
	 * 
	 * @param employee Objet de type Employee à supprimer
	 */
	function queryDeleteEmployee(employee) {
		if (employee && employee.id !== 0) {
			$.ajax({
				url : "http://localhost:8080/RED_WEBSERVICE/rest/employee/"	+ employee.id,
				type : "DELETE",
				dataType : "json",
				contentType : "application/json",
			}).done( function(data) {
				console.log("[DEBUG] employee "	+ employee.lastname + " deleted successfully");
				employeeList.splice(employeeList.indexOf(employee), 1);
				employeeSelected = null;
				refreshQuickSelectionView(0); // We are async...
			}).fail(function() {
				// Handling errors here ...
			}).always(function() {
				// Action to do after the call of done or fail
			});
		}
	}

	/**
	 * queryUpdateEmployee
	 * 
	 * Update d'un utilisateur
	 * 
	 * @param employee Objet de type Employee à mettre à jour
	 */
	function queryUpdateEmployee(employee) {
		if (employee && employee.id !== 0) {
			// FIXME: les attributs null ne doivent pas être dans l'objet employee sous peine de plantage
			$.ajax({
				url : "http://localhost:8080/RED_WEBSERVICE/rest/employee/"	+ employee.id,
				type : "PUT",
				data : JSON.stringify(employee),
				dataType : "json",
				contentType : "application/json",
			}).done( function(data) {
				console.log("[DEBUG] employee "	+ employee.lastname	+ " updated successfully");
			}).fail(function() {
				// Handling errors here ...
			}).always(function() {
				// Action to do after the call of done or fail
			});
		}
	}

	/**
	 * queryCreateEmployee
	 * 
	 * Créer un nouvel utilisateur
	 * 
	 * @param employee Objet de type Employee à mettre à jour
	 */
	function queryCreateEmployee(employee) {
		if (employee && employee.id !== 0) {
			// FIXME: les attributs null ne doivent pas être dans l'objet employee sous peine de plantage
			$.ajax({
				url : "http://localhost:8080/RED_WEBSERVICE/rest/employee",
				type : "POST",
				data : JSON.stringify(employee),
				dataType : "json",
				contentType : "application/json",
			}).done( function(data) {
				console.log("[DEBUG] employee " + employee.lastname	+ " created successfully");
			}).fail(function() {
				// Handling errors here ...
			}).always(function() {
				// Action to do after the call of done or fail
			});
		}
	}

	/*
	 * Events functions
	 */
	$("#selectEmployee").keyup(	function(e) {
		var searchStr = $(this).val().toLowerCase();
		var found = false;

		if ( $(this).val() ) {
			// Populate the fields if the search string match with any employee fullname
			for ( var index = 0; index < employeeList.length; index++ ) {
				if (searchStr === employeeList[index].fullname().toLowerCase()) {
					found = true;
					employeeSelected = employeeList[index];// = true;
					populateFieldsFromEmployee(employeeList[index]);
					disableButtons(false, false);
					break;
				}
			}

			// Clear all fields if the search string differ from any
			// employee fullname but previously selected
			if (!found && employeeSelected) {
				employeeSelected = null;// = false;
				clearAllFields(false);
				disableButtons(false, true);
			}

			// Autocompletion
			for ( var index = 0; index < employeeList.length; index++ ) {
				var subStr = employeeList[index].fullname().toLowerCase().substring(0, searchStr.length);

				if (subStr === searchStr) {
					refreshQuickSelectionView(index);
					return;
				}
			}
		} else {
			refreshQuickSelectionView(0);
			clearAllFields(true);
			disableButtons(false, true);
		}
	});

	// Delegated events have the advantage that they can process events from children elements that are added to the document at a later time
	// In that case #employeeTable is created dynamically so the classic syntax/ $().keyup will not respond to the event callback
	$("#autoCompletion").on("click", "#employeeTable td", function() {
		var selectedRowIndex = $(this).attr("data-row");

		employeeSelected = employeeList[selectedRowIndex];// = true;
		$("#selectEmployee").val(employeeList[selectedRowIndex].fullname()); // When selected, the fullname much appears in the search input
		populateFieldsFromEmployee(employeeList[selectedRowIndex]);
		disableButtons(false, false);
	});

	$("#btnSave").on("click", function(e) {
		var error = checkAllFields();

		console.log(error);

		if (error === "noerror") {
			// TODO: le code ci dessous est call pat la methode ajax de creation lorsque l'opération est reussie
			$("#popupCreateTitle").html("Créer un utilisateur");
			$("#popupCreateMessage").html(" a été crée avec succès !");
			$("#popupCreate").modal("show");
			e.preventDefault();
		} else {
			showPopupWithError(error);
			e.preventDefault();
		}
		// TODO: ici soit queryCreateEmployee() soit queryUpdateEmployee(employeeSelected) un update est a faire lorsque employeeSelected !== null
		// sinon c'est un creation

	});

	$("#btnDelete").on("click",	function(e) {
		$("#popupTitle").html("Supprimer un utilisateur");
		$("#popupMessage").html("Etes-vous sur(e) de vouloir supprimer :" + employeeSelected.fullname());
		$("#popup").modal("show");
		e.preventDefault();
	});

	$("#btnPopupCancel").on("click", function(e) {
		$("#popup").modal("hide");
		// Nothing more, just close the popup
	});

	$("#btnPopupConfirm").on("click", function(e) {
		$("#popup").modal("hide");
		queryDeleteEmployee(employeeSelected);
		clearAllFields(true);
		disableButtons(false, true);
	});

	$("#btnPopupCreateAcknowledge").on("click", function(e) {
		$("#popupCreate").modal("hide");

		clearAllFields(true);
		disableButtons(false, true);
	});

	$("#btnPopupErrorAcknowledge").on("click", function(e) {
		$("#popupError").modal("hide");
		// Nothing more, just close the popup
	});

	/*
	 * $("#popup").on("shown-bs-modal", function(e) { // TODO: ici modifier le
	 * DOM de la popup console.log("popup shown"); return e.preventDefault();
	 * });
	 * 
	 * $("#popup").on("hidden-bs-modal", function(e) { console.log("popup
	 * hidden"); return e.preventDefault();
	 * 
	 * //clearAllFields(true); //disableButtons(false, true); });
	 */

	/*
	 * Flow of execution of the page
	 */
	initialization();
	// I'am happy with application driven by event handling ^^

}).call(this);