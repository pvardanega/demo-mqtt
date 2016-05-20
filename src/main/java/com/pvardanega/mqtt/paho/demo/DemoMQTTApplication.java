package com.pvardanega.mqtt.paho.demo;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMQTTApplication implements CommandLineRunner, MqttCallback {

	public static void main(String[] args) {
		SpringApplication.run(DemoMQTTApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		MqttClient client = new MqttClient("tcp://192.168.99.100:1883", "demo-consumer");
        client.connect();
        client.setCallback(this);
        client.subscribe("demo");
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.err.println("Connection lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("New message in topic '" + s + "': " + mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Delivery complete: " + iMqttDeliveryToken);
    }
}
