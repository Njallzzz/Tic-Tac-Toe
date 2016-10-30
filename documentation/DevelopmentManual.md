#Development manual

This project is a simple game of Tic tac toe, that uses gradlew and travis to handle tests and errors.

##If a new developer where to build the project for the first time he would need:

	* To have access to the repostory on github (https://github.com/Njallzzz/Tic-Tac-Toe).

	* Install of java we use version 1.8.


 
##HAVE IN MIND:

 	* Gradlew commands:
 		* build to build the project 
 		* test to run all test
 		* deploy creates javadocs, compiles jar files and host both on hugb.deadbyte.is it also regenerates the documentation there.

 	* Codecove is a website that checks code coverage that gives you the procents of how much of the code you are covering in your test(above 80% is recomended)
	* When pushed on branch travis runs error check 
 	* That when you push heroku deploys a running version of the server.

 You can get a version of the project on http://hugb.deadbyte.is/. There you can also read about the workflow and the coding style that we follow.