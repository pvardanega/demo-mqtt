This demo starts a Java application that connects to a MQTT broker and prints consumed messages in the console. It also provides a HTML page that 
connects the MQTT broker in javascript via a websocket and prints consumed messages.
 
# Make it run

## Clone and package the sources

```
git clone git@github.com:pvardanega/demo-mqtt.git
cd demo-mqtt
mvn clean package
```

## Start a MQTT broker

```
docker run -ti -p 1883:1883 -p 9001:9001 toke/mosquitto
```

In the demo, I assumed that the host of the broker is 192.168.99.100. If not, you'll have to change the value.

## Download a MQTT client

Try [MQTT.fx](http://mqttfx.jfx4ee.org/).

## Start the java client 

```
jar -jar target/demo-mqtt.jar
```

## Send messages

You have to configure mqtt.fx to connect to your mosquitto broker. 
Send a message in the topic named **demo**. You should see the consumed messages in the console, where you started the java appliction.

You can also consume the message using the HTML/Javascript application by opening the file *index.html* in your browser.
