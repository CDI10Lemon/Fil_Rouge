/**
 * dto.js
 * 
 * Implementation de chacun des DTOs utilisés par l'application
 * 
 * @author Sebastien PASSIER
 * @version 1.0.0
 */


/**
 * Employee
 * 
 * Prototype employee, DTO des utilisateurs
 * 
 * @param id id technique de l'utilisateur
 * @param name Nom de l'utilisateur
 * @param lastname Prénom de l'utilisateur
 * @param password Mot de passe de l'utilisateur
 * @param category DTO de type Category
 * @param structure DTO de type Structure
 * @param site DTO de type Site
 */
var Employee = function(id, name, lastname, password, category, structure, site) {
	this.id = id || 0;
	this.name = name || "";
	this.lastname = lastname || "";
	this.password = password || "";
	// FIXME: Stockage des DTO category, structure et site
	this.category = category || "";
	this.structure = structure || "";
	this.site = site || "";

	/**
	 * fullname
	 * 
	 * @return Renvoie la construction du NOM + Prenom
	 */
	this.fullname = function () {
		return this.lastname + " " + this.name;
	};
};