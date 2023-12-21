class PropertyMeasured {

  static TEMPERATURE_CENTIGRADES = new PropertyMeasured('TEMPERATURE_CENTIGRADES', 'Temperature', 'C')
  static TEMPERATURE_KELVIN = new PropertyMeasured('TEMPERATURE_CENTIGRADES', 'Temperature', 'K')
  static HUMIDITY_PERCENTAGE = new PropertyMeasured("HUMIDITY_PERCENTAGE", 'Humidity', "%")
  static MOTION = new PropertyMeasured("MOTION", 'Motion', null)

  constructor(id, name, unit) {
	this.id = id;
    this.name = name;
    this.unit = unit;
  }
  
  getName () {
	var name = this.name;
	if (this.unit !== null) {
		name = name + " " + this.unit;
	}
	return name;
  }
  
  getUnit () {
	return this.unit;
  }
  
  getId () {
	return this.id;
  }
  
  static getInstance(id) {
    switch (id) {
  		case PropertyMeasured.TEMPERATURE_CENTIGRADES.getId():
    	return PropertyMeasured.TEMPERATURE_CENTIGRADES;
    break;
 
	}
  }
  
  static getAllInstances () {
	let allInstances = [];
	allInstances.push(PropertyMeasured.TEMPERATURE_CENTIGRADES);
	allInstances.push(PropertyMeasured.TEMPERATURE_KELVIN);
	allInstances.push(PropertyMeasured.HUMIDITY_PERCENTAGE);
	allInstances.push(PropertyMeasured.MOTION);
	return allInstances;
  }
 
  
}