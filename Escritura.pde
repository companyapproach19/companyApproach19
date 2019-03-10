import processing.serial.*;
Serial mySerial;
//import java.text.*;
//import java.util.*;
PrintWriter output;  

void setup() {
  printArray(Serial.list());
  size(720,700);
  background(255);
  mySerial = new Serial( this, Serial.list()[2], 9600 );
  mySerial.bufferUntil ( '\n' );
  output = createWriter("test5.txt");
}

void draw() {
if (mySerial.available() > 0 ) {
     String value = mySerial.readString();
     if ( value != null ) {
        fill(50);
        text(value,10,10,700,700);
        println(value);
        output.print(year() + "-");
        output.print(month() + "-");
        output.print(day() + " ");
        output.print(hour() + ":");
        output.print(minute() + ":");
        output.print(second() + " ");
        output.println(value);
        delay(2000);
     } 
  } 
  
  if (mousePressed && (mouseButton == LEFT)){
      output.flush(); // Writes the remaining data to the file
      output.close(); // Finishes the file
      exit(); // Stops the program
  }
}

void keyPressed() {
  output.flush(); // Writes the remaining data to the file
  output.close(); // Finishes the file
  exit(); // Stops the program
}
