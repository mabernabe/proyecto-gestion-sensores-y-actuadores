class PropertyMeasured {

  static TEMPERATURE_CENTIGRADES = new PropertyMeasured('TEMPERATURE_CENTIGRADES', 'Temperature', 'C')

  constructor(id, name, unit) {
	this.id = id;
    this.name = name;
    this.unit = unit;
  }
  
  getName () {
	return this.name;
  }
  
  getNameWithUnit () {
	return this.name + " " + this.unit;
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
 
  
}