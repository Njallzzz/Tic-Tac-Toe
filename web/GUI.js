/*Default variables initiated on load of the page*/
player1="";
player2="";
game = 0;
server = "http://hugb.deadbyte.is:443";

/*Funcionts triggered by buttonclicks, not availeble before document has fully loaded*/
$(document).ready(function () {
	/*Function gettin player names by button submit*/
	$("#names").click(function(){
  	player1=$("#name1").val();
  	player2=$("#name2").val();
  	if (player1 != "" && player2 !=""){
  		new_game(player1,player2);
  		$("#message").html("<p>"+player1+" and "+player2+" are now competing</p>");
  		clearerror();
  	}
  	else{
  		console.log("error")
  		$("#error").html("<p>Players must submit their names before competing</p>");
  		clearmessage();
  	}
  	});
  	/*Function of making a game move by mouseclick, triggering ajax calls*/
	$(".field").click(function(){
	  	field_nr =Number($(this).attr('id'));
	  	field_stat = $(this).text();
	  	gameaction(Number(game),field_nr);
	  	board(Number(game));
	});
	/*Function for quitting when players choose not to play another game*/
	$("#no").click(function(){
	gameaction(Number(game),0);
	$("#message").html("<p>You have left the game. Submit names for new game</p>");
	clearerror();
	$("#again").toggle();
	});
	/*Function for re initiating the board to play another game*/
	$("#yes").click(function(){
		gameaction(Number(game),1);
		board(Number(game));
		$("#message").html("<p>The board has been reset. "+player1+", your turn to make a move.");
		clearerror();
		$("#again").toggle();
	});
	/*Function getting the server URL if player has his own URL to game server*/
	$("#serversubmit").click(function(){
		server = $("#newserver").val();
	});
});

/*Clears the error message board*/
function clearerror(){
	$("#error").html("<p></p>");
}
/*Clears the message board*/
function clearmessage(){
	$("#message").html("<p></p>");
}

/*Function printing message if player has won*/
function haswon(player){
	$("#message").html("<p>Congratulations "+player+"! You have won</br> ");
	clearerror();
	$("#again").toggle();
}

/*Function reading from server if game action is legal or not, and responding with a relevant message to the screen*/
function Readplay(response){
	if(response.indexOf("Illegal") != -1){
		$("#error").html("<p>You have made an illegal move. Try again");
		clearmessage();
	}
	if(response.indexOf("exist") != -1){
		$("#error").html("<p>You have to insert your names before you can play");
		clearmessage();
	}
	if (response.indexOf("won") != -1){
			if (response.indexOf("1") != -1){
				haswon(player1);
			}
			else{
				haswon(player2);
			}
		}
	if(response.indexOf("Draw") != -1){
		clearerror();
		$("#message").html("<p>You made a draw. ");
		$("#again").toggle();
	}
	else if(response.indexOf("X") != -1){
		clearerror();
		$("#message").html("<p> "+player1+" has successfully made a move. Your turn "+player2+" </p>");
	}
	else if(response.indexOf("O") != -1){
		clearerror();
		$("#message").html("<p> "+player2+" has successfully made a move. Your turn "+player1+" </p>");
	}
}

/*Function sending a game action to the server and retreiving the result, takes in "gameid" and "field" desired to play*/
function gameaction(game_id,field){
	$.ajax({
	  type: "GET",
	  url:server+"/action/"+game_id+"/"+field,
	  async:false,
	  crossDomain:true,
	  success:  function(response){
	  	Readplay(response);
      }
	});
}
/*function updating the on screen board based on the latest fetch from the server*/
function refresh_board(loadedboard){
	counter = 1;
	for (i=0; i<3; i++){
		for (j=0; j<3; j++){
			if (loadedboard[i][j] == "X" || loadedboard[i][j] == "O"){
				$("#"+counter+" p").replaceWith("<p>"+loadedboard[i][j]+"</p>");
			}
			else{
				$("#"+counter+" p").replaceWith("<p>+</p>");
			}
			counter++;
		}
	}
}

/*Function fetching the current game board for a certain game*/
function board(game_id){
	  	$.ajax({
	  type: "GET",
	  url: server+"/board/"+game_id,
	  async:false,
	  crossDomain:true,
	  success:  function(response){
        refresh_board(response);
      }
	});
}
/*Function initiating a new game taking in player names from the screen*/
function new_game(player_1,player_2){
	$.ajax({
	  type: "GET",
	  url: server+"/newgame/"+player_1+"/"+player_2,
	  async:false,
	  crossDomain:true,
	  success:  function(response){
	  	game = response.game;
	  	board(Number(game));
      },
      error: function(){
      	$("#error").html("<p>Something went wrong. Try again</p>");
      	clearmessage();
      }
	});
}