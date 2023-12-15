let gestorSensores = angular.module("gestorSensores",['ngRoute',  'sensorsController'] );


gestorSensores.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'sensors.html',
		controller : 'SensorsController',
		controllerAs: "SensorsController"
	})
	.when('/sensors', {
		templateUrl : 'sensors.html',
		controller : 'SensorsController',
		controllerAs: "SensorsController"
	})
});