# Medical Appointment Application
  Patient medicine and Appointment Application
* To book appointment by patient
* To view Prescription by patient
* Doctor can add and update diagnosis and prescription for respective patients

# Read Me First



# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)

## Table of Contents

1. [Guides](#Guides)
2. [Prerequisites](#Prerequisites)
3. [Installation](#Installation)
4. [Set Up Environment Variables](#Set-Up-Environment-Variables)
5. [Setup Tomcat Server](#Setup-Tomcat-Server)
6. [Project Demo](#Project-Demo)

### Guides
The following guides illustrate how to use some features concretely:
Overview
This project is a Spring service designed to book appointment with doctor and view prescription by patients. It includes separate access 
to add/update diagnosis and prescription, have patients as per respective doctor.

### Prerequisites
Before you begin, ensure you have met the following requirements:

Java Development Kit (JDK) 17 or later
Apache Maven 3.6.0 or later
An IDE such as IntelliJ IDEA or Eclipse (optional but recommended)
## Git
### Installation
Follow these steps to get the project up and running on your local machine.

* git clone https://github.com/VengateshPrasad5/Medical-Appt-FS.git
* clone the repository in your local
* go to maven and run the dependency
* cd root directory

###  Set Up Environment Variables
Create a db connections 
by providing own environment variables. For example:

    conn = DriverManager.getConnection("jdbc:mysql://<yourURL>/<databaseName>","<username>","<password>");

###  Setup Tomcat Server
* Download tomcat server as plugins
* Configure to tomcat server with root file by
  * On top click right click play button in intellij and edit configuration.
  * Select the Use classpath of module to root folder to run
  * Update path context
  * Update server port and admin port, (i.e)note don't provide same admin port and server port if running
  multiple servlet in local machine, try different port number for both
  
### Run the Application from My Application
* Follow the above instruction and click "apply" then "ok"
* The Tomcat server is ready now
* Click "run" button, if any error check the configuration

### Project Demo
Watch the [project demo video](https://drive.google.com/file/d/10_o13mxvsy7qXAL2SL4_HvWwkzkHd8YU/view?usp=sharing) for a quick overview.

!!!Happy Coding!!!




 



