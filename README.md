# Keyboard-Controlling-Servo-Motor
Using PC keyboard, servo motor is controlled which is connected to Arduino Uno via serial cable.

Aim :- Using keyboard keys (A & D) control servo motor arm at desired angle.

Use :- For controlling Robots using PC keyboard and this way, many IOT projects can be made in java and controlled using serial cable.

Development :- Java, Java Swing, Arduino programming and java serial programming.

Software Requirements :- Java Development Kit
                         ArduinoIDE
                         jSerialComm.jar (http://fazecast.github.io/jSerialComm/) link to download jar

Hardware Requirements :- Arduino Uno (any other board can be used)
                         Servo Motor (180 degree rotation)
                         Three jumper wires (male to male)
                         R3 USB cable
                         
Procedure :- 

(1) Open Servo_Control.ino using Arduino IDE.
(2) Connect Arduino Uno using R3 USB Cable and select respective port on IDE.
(3) Upload the code.
(4) Connect red wire of servo motor to 5v supply from arduino uno and black to ground (GND).
(5) Connect orange (info wire) to pin number 9. This pin number can be changed by changing pin number in Servo_Control.ino file.
(6) Navigate to jdk folder and go to directory jdk\jre\lib\ext\, copy jSerialComm.jar to import serial library.
(7) open cmd and test this command "javap com.fazecast.jSerialComm.SerialPort", if output "class does not found" does not come that means the jSerialComm.jar has been imported.
(8) Now compile SerialRW.java and ServoCmd.java
(9) Compile OperateServo.java and run this file

Observation :- Window frame will pop out and rx led on arduino board will start blinking. Press or Hold 'A' or 'D' to move servo arm to and fro at desired angle.

Working :- 
