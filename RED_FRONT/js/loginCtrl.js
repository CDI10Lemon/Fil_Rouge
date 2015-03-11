angular.module('cyberbase',[])
	.controller('loginCtrl',['$scope',
		function($scope){
			$scope.master={};

			$scope.reset=function(){
				$scope.employee=angular.copy($scope.master);
				$scope.employee.site="Site de référence";
			};
			$scope.reset();
		}]);
