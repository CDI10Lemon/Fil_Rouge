/**
 * dto.js
 * 
 * Implementation de chacun des DTOs utilisés par l'application
 * 
 * @author Sebastien PASSIER
 */


/**
 * Site
 *
 * Prototype site, DTO des sites
 * 
 * @param id id technique du site
 * @param name Nom du site
 * @param maxunit Nombre de poste maximum
 */
var Site = function(id, name, maxUnit) {
	this.idSite = id || 0;
	this.name = name || "";
	this.maxUnit = maxUnit || 0;
};

/**
 * Structure
 * 
 * Prototype structure, DTO des structures
 * 
 * @param id id technique de la structure
 * @param name Nom de la structure d'appartenance
 */
var Structure = function(id, name) {
	this.idStructure = id || 0;
	this.name = name || "";
};

/**
 * Category
 * 
 * Prototype category, DTO des catagories
 * 
 * @param id id technique de la categorie
 * @param name Nom de la catégorie
 * @param sedentary Flag indiquant si l'employee est mobile ou pas
 */
var Category = function(id, name, sedentary) {
	this.idCategory = id || 0;
	this.name = name || "";
	this.sedentary = sedentary || true;
};

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
	this.idEmployee = id || 0;
	this.name = name || "";
	this.lastname = lastname || "";
	this.password = password || "";
	this.category = category || null;
	this.structure = structure || null;
	this.site = site || null;

	/**
	 * fullname
	 * 
	 * @return Renvoie la construction du NOM + Prenom
	 */
	this.fullname = function () {
		return this.lastname + " " + this.name;
	};
};