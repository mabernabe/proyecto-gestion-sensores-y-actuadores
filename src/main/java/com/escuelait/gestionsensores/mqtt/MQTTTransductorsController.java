package com.escuelait.gestionsensores.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.escuelait.gestionsensores.models.MQTTTransductorInterface;
import com.escuelait.gestionsensores.services.SensorsService;
import com.escuelait.gestionsensores.utils.JSONParser;


@Controller
public class MQTTTransductorsController implements MqttCallbackExtended{
	
	private volatile IMqttClient mqttclient;

	@Autowired
	private SensorsService sensorsService;
	

	public MQTTTransductorsController(@Value("${mqtt.broker.url}") String brokerURL, @Value("${mqtt.folderpersistence}") String folderPersistence) {
		super();	
		try {
			mqttclient = new MqttClient(brokerURL, MqttClient.generateClientId(), new MqttDefaultFilePersistence(folderPersistence));
			mqttclient.setCallback(this);
			mqttclient.connect(this.getMqttConnectOptions());
		} catch (MqttException e) { 
			e.printStackTrace();
		} 	
	}
	
	private MqttConnectOptions getMqttConnectOptions() {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(false);
		options.setConnectionTimeout(0);
		return options;
	}

	
	public void subscribe(MQTTTransductorInterface mqttInterface) throws MqttSecurityException, MqttException {
		this.mqttclient.subscribe(mqttInterface.getTopic());
	}
	
	public void unsubscribe(MQTTTransductorInterface mqttInterface) throws MqttSecurityException, MqttException {
		this.mqttclient.unsubscribe(mqttInterface.getTopic());
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {		
		MQTTSensorValuesDTO sensorValuesDTO = new JSONParser().parseJsonBodyAs(MQTTSensorValuesDTO.class, message.toString());
		if (!sensorValuesDTO.hasErrors()) {
			sensorsService.update(topic, sensorValuesDTO.getValues());
		}
		
	
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
		
	}
	
	@Override
	public void connectionLost(Throwable cause) {
	}

}
