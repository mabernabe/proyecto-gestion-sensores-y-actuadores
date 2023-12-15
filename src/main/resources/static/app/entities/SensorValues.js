class SensorValues {
	
	constructor(date, values) {
		this.date = date;
		this.values = values;
	}
	
	
	getDate() {
		return this.date;
	}
	
	
	getValue(propertyMeasured) {
		let value = null;
		this.values.forEach(valueInstance => {
			if (valueInstance.getPropertyMeasured().getId() === propertyMeasured.getId()) {
				value =  valueInstance;
			}
		})	
		return value;
	}
	
}