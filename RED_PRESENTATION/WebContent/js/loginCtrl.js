
app.controller("loginCtrl",function($scope,$http){
	$scope.master={};
//récup employee bdd
	
	$http.get("http://localhost:8080/RED_WEBSERVICE/rest/employee")
		.success(function(response) {$scope.employeeDb=response;});
	
	$scope.connexion=function(employeeDb){
		var connected=false;
		for(var i in employees){
			var employee=employees[i];
			alert(employee.toString());
			if(employee==$scope.ids){
				connected=true;
			}
		}
		if(connected){
			$scope.resultat="Connexion OK";
		}else{
			$scope.resultat="Connexion KO";
		}
	}
//récup site bdd
	var siteDb=[];
	$http.get("http://localhost:8080/RED_WEBSERVICE/rest/site")
		.success(function(response) {$scope.siteDb=response});
	
//récup structure bdd
	var structureDb=[];
	$http.get("http://localhost:8080/RED_WEBSERVICE/rest/structure")
		.success(function(response) {$scope.structureDb=response});
	
	$scope.reset=function(){
		$scope.ids=angular.copy($scope.master);
	}
});




