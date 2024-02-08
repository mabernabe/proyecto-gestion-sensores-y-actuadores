package com.escuelait.gestionsensores.mqtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.escuelait.gestionsensores.models.PropertyMeasuredEnum;
import com.escuelait.gestionsensores.models.SensorValue;
import com.escuelait.gestionsensores.models.SensorValues;
import com.escuelait.gestionsensores.models.Value;
import com.escuelait.gestionsensores.models.ValueFormatException;
import com.escuelait.gestionsensores.utils.Date;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Sensor Values JSON Example : { "values" : {"TEMPERATURE_CENTIGRADES" : "25"}, "date" : "2022-03-23 15:41:03"}
public class MQTTSensorValuesDTO {
	
	private SensorValues sensorValues;
	
	private List<String> errors;
	
		
	@JsonCreator
	public MQTTSensorValuesDTO(@JsonProperty(value = "values" , required = true) HashMap<String, String> values, @JsonProperty(value = "date", required = true) String date){
		super();
		this.errors = new ArrayList<String>();
		deserialize(values, date);
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}


	private void deserialize(HashMap<String, String> values, String date)  {
		if (!Date.isValidDate(date)) {
			this.errors.add("Invalid date");
		}
		if (values.isEmpty()) {
			this.errors.add("values is empty");
		}
		this.sensorValues = new SensorValues(new ArrayList<SensorValue>(), date);
		for(String propertyString : values.keySet() ) {
			PropertyMeasuredEnum propertyMeasuredEnum = PropertyMeasuredEnum.getInstance(propertyString);
			if (propertyMeasuredEnum == null) {
				errors.add("Unknown property measured " + propertyString);
			} else {
				this.sensorValues.add(getSensorValue(propertyMeasuredEnum, values));
			}
		}		
	}


	private SensorValue getSensorValue(PropertyMeasuredEnum propertyMeasuredEnum, HashMap<String, String> values) {
		String valueString = values.get(propertyMeasuredEnum.toString());
		try {
			Value value = propertyMeasuredEnum.getPropertyMeasured().getValue(valueString);
			return new SensorValue(propertyMeasuredEnum, value);
		} catch (ValueFormatException e) {
			this.errors.add("Value is invalid :" + valueString);
			return null;
		}		
	}

	public SensorValues getValues() {
		assert(!this.hasErrors());
		return sensorValues;
	}


}
