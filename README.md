SerialTester
============
I created a very basic test project to try out Flow. I have a USB to serial cable connected and have it plugged into a board
The project is very much like your example Terminal application

The [Main File](https://github.com/cloverKartik/SerialTester/blob/master/src/main/scala/com/bcd/SerialTester/TesterMain.scala)

THe exception occurs when running 
    IO(Serial) ! Open

This is the exception: 
    java.lang.UnsupportedClassVersionError: com/github/jodersky/flow/internal/NativeSerial : Unsupported major.minor version 51.0

