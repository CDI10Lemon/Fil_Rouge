app.controller("loginCtrl",function($scope){
	$scope.master={};
	$scope.lastname="";
	$scope.name="";
	$scope.password="";


	$scope.getSites=function($scope,$html){
		$http.get("http://localhost:8080/RED_WEBSERVICE/rest/site")
			.success(function(response) {$scope.sites=response;});
	}

	$scope.reset=function(){
		$scope.employee=angular.copy($scope.master);
	}

	$scope.connect=function(){

	}


});




