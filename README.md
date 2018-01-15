# Dragonboard Server

Main goal of this project was to create sample http server for drabonboard controller.

The main and only feature was to provide rest methods for turning on/off led.

# Implmenetation details:
The application core is Spring Boot Java server, which allows http communication.
Since there is no working java library for GPIO managing I used JNI (Java native interface)
to get acces to gpio from native code (C/C++). I used SWIG library to create proxy code that wraps and ports 96BoardsGPIO, libsoc
libraries to java level.

