let gestorSensores = angular.module("gestorSensores",['ngRoute',  'sensorsController', 'installSensorController'] );


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
	.when('/installSensor', {
		templateUrl : 'InstallTransductor.html',
		controller : 'InstallSensorController',
		controllerAs: "InstallTransductorController",
		redirectParam: '/sensors'
	})
	.when('/installActuator', {
		templateUrl : 'InstallTransductor.html',
		controller : 'InstallActuatorController',
		controllerAs: "InstallTransductorController",
		redirectParam: '/actuators'
	})
});