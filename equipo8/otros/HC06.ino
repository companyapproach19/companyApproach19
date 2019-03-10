/*
  Project: Bluetooth HC-06 ZS-40 TEST using software serial library
  Function: Connect the HC-06 ZS-40 module and communicate using the serial monitor
            The HC-06 enters AT mode by default when powered on.The default baud rate is 9600.
            The HC-06 requires all AT commands to be in uppercase. NL+CR should not be added to the command string
            It must be No line editing selected in serial monitor and 9600 bps.
  Pins
  Arduino  - Bluetooth HC-06 ZS-40
  5V pin     VCC pin
  GND pin    GND pin
  Digital 3  RX pin through a voltage divider
  Digital 2  TX pin (no need voltage divider)
*/
//*********************************************************************
#include <SoftwareSerial.h>
#include <Wire.h>
//**********************************************************************
SoftwareSerial BTserial(2, 3); // RX | TX
// Connect the HC-06 TX to the Arduino RX on pin 2. 
// Connect the HC-06 RX to the Arduino TX on pin 3 through a voltage divider.
String cadena;
int i = 0;
int celsius;
bool on=false;
 
void setup() 
{
    Serial.begin(9600);
    BTserial.begin(9600);
    pinMode(11,OUTPUT);
    Wire.begin(); //this creates a Wire object 
}
 
void loop()
{
     
     // Keep reading from HC-06 and send to Arduino Serial Monitor
    if (BTserial.available())
    {  
        cadena = BTserial.readString();
          Serial.print(cadena);

        if(cadena == "on"){
          delay(2000);
          digitalWrite(11,HIGH);
          Serial.println("Encendido\n");
          BTserial.println("Encendido\n");
          on = true;
        }

        if(cadena == "off"){
          delay(2000);
          digitalWrite(11,LOW);
          Serial.println("Apagado\n");
          BTserial.println("Apagado\n");
          on = false;
        }

        if(cadena == "tmp" && on){
          delay(2000);
          celsius = read_temp(77);
          BTserial.print(celsius);
          BTserial.print("ºC\n");
          Serial.print(celsius);
          Serial.print("ºC\n");
        }
    }
    // Keep reading from Arduino Serial Monitor and send to HC-06
    if (Serial.available())
    {
        BTserial.write(Serial.read());
    }
 }



 int read_temp(int address) {
  //start the communication with IC with the address xx
  Wire.beginTransmission(address); 
  //send a bit and ask for register zero
  Wire.write(0);
  //end transmission
  Wire.endTransmission();
  //request 1 byte from address xx
  Wire.requestFrom(address, 1);
  //wait for response
  while(Wire.available() == 0);
  //put the temperature in variable c
  int c = Wire.read();   
  return c;
}
