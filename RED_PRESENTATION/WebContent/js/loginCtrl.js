app.controller("loginCtrl",function($scope){
	$scope.master={};
	$scope.lastname="";
	$scope.name="";
	$scope.password="";

	$scope.reset=function(){
		$scope.employee=angular.copy($scope.master);
	}
});




