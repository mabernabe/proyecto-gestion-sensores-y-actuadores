var installSensorController= angular.module('installSensorController', ['sensorsService', 'sweetAlertService']);


installSensorController.controller ("InstallSensorController",function(SensorsService, $route, SweetAlertService){

	var self = this;
	
	self.transductor = {type: "Sensor", interface : {type : null}, properties: [], name: null};
		
	self.transductorSupportedProperties = PropertyMeasured.getAllInstances();
	
	self.transductorSupportedInterfaces = TransductorInterface.getAllInstances();
	
	self.setTransductorInterface = function(interfaceType) {
		self.transductor.interface.type = interfaceType.getName();
	}

	self.allRequiredIsSet = function() {
		return (!(self.transductor.name == null) && !(self.transductor.interface.type == null) && (self.transductor.properties.length));
	}
	
	self.installAndRedirect = function() {
		let promise;
		let sensor = new Sensor(self.transductor.name, false, self.transductor.properties, null);
		if (self.transductor.interface.type === 'MQTT') {
			promise = SensorsService.installMQttSensor(sensor);
		}
		promise.then(function() {
			var redirectURL = $route.current.$$route.redirectParam;
			SweetAlertService.showSuccessAlertAndRedirect(self.transductor.type + ' installed with success', redirectURL);
		},function(error) {
			SweetAlertService.showErrorAlert(self.transductor.type + ' installation failed' + ' \n Error: ' + error.data.message);
		})
	}



});
