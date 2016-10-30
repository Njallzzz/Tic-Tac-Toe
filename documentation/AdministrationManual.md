#Administration manual

##To set up the program and get it to run you'll need:
	* Any linux based operating system.
	* To download the git repo on the system (https://github.com/Njallzzz/Tic-Tac-Toe).

To run the program you'll have to type "RATPACK_PORT=80 ./gradlew run" in the command console. This is not necessary if deploying to heroku.

##To deploy, run and maintain the program follow these steps:
	1) create a heroku account.
	2) download and install heroku toolkit.
	3) log in to your heroku account on heroku toolkit.
	4) move to the directory of the repo on the system.
	5) create a heroku app (heroku create).
	6) type "git push heroku master" in the command console.
	7) type "heroku open" to view the deployed app.
