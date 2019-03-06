#include <Wire.h>

int address = 77; //binary equivalent is 1001 101

void setup(){

  Serial.begin(9600); //this creates the Serial Monitor
  Wire.begin(); //this creates a Wire object
}

void loop(){


  int celsius= read_temp(77);


  //this reads the value from the sensor. The value is in degrees celsius
  Serial.print(celsius);
  Serial.print(" ºC\n");


  delay(1000);
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
