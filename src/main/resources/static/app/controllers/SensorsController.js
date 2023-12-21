let sensorsController= angular.module('sensorsController', ['sensorsService']);

sensorsController.controller ("SensorsController",function($scope, SensorsService, $interval){

	const SENSORS_REFRESH_TIME_MS = 2000 ;

	let self = this;

	self.sensors = [];

	self.setSensors = function(){
		SensorsService.getSensors()
		.then(function(sensors) { 
			self.sensors = sensors;	
		},function() {
			self.sensors = [];
		})
	}
	
	self.setSensors();   
	
	let intervalIstance = $interval(self.setSensors, SENSORS_REFRESH_TIME_MS);

	$scope.$on('$destroy',function(){
		if(intervalIstance) {
			$interval.cancel(intervalIstance);
		}
	})

});

