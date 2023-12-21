class TransductorInterface {

  static MQTT = new TransductorInterface('MQTT')
  static GPIO = new TransductorInterface('GPIO')

  constructor(name) {
    this.name = name;
  }
  
  getName () {
	return this.name;
  }
  
  static getAllInstances () {
	let allInstances = [];
	allInstances.push(TransductorInterface.MQTT);
	allInstances.push(TransductorInterface.GPIO);
	return allInstances;
  }
  
 
  
}