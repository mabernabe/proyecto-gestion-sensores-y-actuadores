class SensorValue {
	
	constructor(propertyMeasured, value) {
		this.propertyMeasured = propertyMeasured;
		this.value = value;
	}
	
	
	getPropertyMeasured() {
		return this.propertyMeasured;
	}
	
	
	getValue() {
		return this.value;
	}
	
	getValueWithUnit() {
		return this.value + " " + this.propertyMeasured.getUnit();
	}
	
}