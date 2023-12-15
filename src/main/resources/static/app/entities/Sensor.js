

class Sensor extends Transductor{
	
	constructor(name, active, propertiesMeasured, sensorValues) {
		super(name, active);
		this.propertiesMeasured = propertiesMeasured;
		this.sensorValues = sensorValues;
	}
	
	
	getPropertiesMeasured() {
		return this.propertiesMeasured;
	}
	
	
	getValue(propertyMeasuredName) {
		let value = this.sensorValues.getValue(propertyMeasuredName);
		return this.sensorValues.getValue(propertyMeasuredName);
	}
	
	getSensorValues() {
		return this.sensorValues;
	}
	
}

