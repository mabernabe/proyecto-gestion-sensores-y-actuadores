let sensorsService = angular.module('sensorsService', ['restService']);

sensorsService.service ("SensorsService",function(RestService, $q){
	let self = this;	
	
	let sensorsBaseUri = "sensors/";

	self.getSensors = function () {
		let deferred = $q.defer();
		RestService.get(sensorsBaseUri).then(function(objectResponse) {
			deferred.resolve(getSensorsFromResponse(objectResponse));
		}, function errorCallback(errorResponse) {
			deferred.reject(errorResponse);
		});
		return deferred.promise ;
	}
	

	function getSensorsFromResponse(objectResponse) {
		let sensors = [];
		objectResponse.sensors.forEach(sensorObject => {
			let sensor = getSensorFromResponse(sensorObject);
			sensors.push(sensor);
		})
		return sensors;
	}
	
	function getSensorFromResponse(sensorObject) {
		let properties = [];
		sensorObject.properties.forEach(propertyId => {
			let propertyMeasured = PropertyMeasured.getInstance(propertyId);
			properties.push(propertyMeasured);
		})
		let sensorValues = null;
		if (sensorObject.active) {
			sensorValues = getSensorValuesFromResponse(sensorObject.sensorValues);
		}
		return new Sensor(sensorObject.name, sensorObject.active, properties, sensorValues);

	}
	
	function getSensorValuesFromResponse(sensorValuesObject) {
		let values = [];
		sensorValuesObject.values.forEach(sensorValueObject => {
			let propertyMeasured = PropertyMeasured.getInstance(sensorValueObject.propertyMeasured);
			values.push(new SensorValue(propertyMeasured, sensorValueObject.value));
		})	
		return new SensorValues(sensorValuesObject.date, values);
	}
	
	self.installMQttSensor = function (newSensor) {
		var deferred = $q.defer();
		var newSensorObjRequest = createNewMqttSensorObjRequest(newSensor);
		RestService.post(sensorsBaseUri.concat("mqttsensors//"), newSensorObjRequest).then(function(objectResponse) {
			deferred.resolve(objectResponse);
		}, function errorCallback(errorResponse) {
			deferred.reject(errorResponse);
		});
		return deferred.promise ;
	}
	
	function createNewMqttSensorObjRequest(newSensor) {
		var newMqttSensor = {};
		newMqttSensor.name = newSensor.getName();
		newMqttSensor.propertiesMeasured = newSensor.getPropertiesMeasured();
		return newMqttSensor;
	}
	

});

