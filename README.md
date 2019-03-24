# Keyboard-Controlling-Servo-Motor
Using PC keyboard, servo motor is controlled which is connected to Arduino Uno via serial cable.

Aim :- Using keyboard keys (A & D) control servo motor arm at desired angle.

Use :- For controlling Robots using PC keyboard and this way, many IOT projects can be made in java and controlled using serial cable.

Development :- Java, Java Swing, Arduino programming and java serial programming.

Software Requirements :- Java Development Kit
                         ArduinoIDE
                         jSerialComm.jar (http://fazecast.github.io/jSerialComm/)

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


Working (Filewise explained):- 

(1) Servo_Control.ino :- An Arduino Program which takes input from arduino serial monitor like "mov 150" as a command and moves the servo arm respectively.

(2) SerialRW.java :- Command sender java program module which imports jSerialComm.jar and uses a timeout delay for writing to serial port plus reading from serial port. By default, it is set to 40 ms and can be modified as in case of this program it is changed to 30 ms. This module's objective is to bring sending receiving data on one function that is "String sendGet(String msg)".

(3) ServoCmd.java :- This program file has one shared resource cmd where the command is updated by the keyboard strokes 'A' and 'D'. It prepares the command which will be read and executed to Arduino Board.

(4) OperateServo.java :- It integrates above modules SerialRW and ServoCmd. It import java swing and set to action listerner that if 'D' is pressed angle should decrease and make an update on ServoCmd.cmd shared resource to prepare command and to execute and same way works for 'A' to increase angle of servo arm. There is one thread which sends commands continuously at the rate of of 30 ms. Command is keep on updating in ServoCmd.cmd and executed when 'A' or 'D' is pressed but the data is still sent to arduino when keys are not pressed, it sends invalid command when key is pressed it sends valid command. A trial was taken first for keylogger program using java Swing then it is integrated with these two modules SerialRW and ServoCmd.


Future Aspects :- Multiple servo motors arduino program will be designed and NodeMcu will be used as it is faster than Arduino Uno, this program can work with nodemcu but pin has to be changed. There comes a PL2303 PL2303HX USB To TTL(Serial) Converter Module – 5 Pin where ESP8266 can be connected and will be communicating with NodeMcu in order to eleminate USB wire and robot will be wireless.
