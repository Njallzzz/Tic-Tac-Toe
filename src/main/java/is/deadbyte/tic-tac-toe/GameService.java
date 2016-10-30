import ratpack.server.RatpackServer;
import ratpack.jackson.Jackson;
import ratpack.http.MutableHeaders;
import org.json.*;


import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;

public class GameService {
	private static HashMap<Integer, Game> g;
	private static JSONDB db;

	public static void main(String... args) throws Exception {
	   g = new HashMap<Integer, Game>();
		try {
			db = new JSONDB();
		} catch (IOException e) {
			return;
		}
		RatpackServer.start (server -> server
			.handlers(chain -> chain
				.get("board/:game", ctx  -> {
					MutableHeaders headers = ctx.getResponse().getHeaders();
					headers.add("Access-Control-Allow-Origin", "*");
					headers.add("Access-Control-Allow-Methods", "GET");
					headers.add("Access-Control-Max-Age", "1000");
					headers.add("Access-Control-Allow-Headers", "Content-Type");
					int gameid = Integer.parseInt(ctx.getPathTokens().get("game"));
					if(g.get(gameid) == null) {
						ctx.render("game does not exist");
					} else {
				   	LinkedList<LinkedList<String>> b = new LinkedList<LinkedList<String>>();
						TicTacToe game = (TicTacToe)g.get(gameid);
					 	char[][] refb = game.getBoard();
					 	for(int i = 0; i < 3; i++) {
							LinkedList<String> line = new LinkedList<String>();
							for(int j = 0; j < 3; j++) {
								line.add(Character.toString(refb[i][j]));
							}
							b.add(line);
					 	}
					 	ctx.render(Jackson.json(b));
					}
				})
				.get("action/:game/:action", ctx -> {
					MutableHeaders headers = ctx.getResponse().getHeaders();
					headers.add("Access-Control-Allow-Origin", "*");
					headers.add("Access-Control-Allow-Methods", "GET");
					headers.add("Access-Control-Max-Age", "1000");
					headers.add("Access-Control-Allow-Headers", "Content-Type");

					int gameid = Integer.parseInt(ctx.getPathTokens().get("game"));
					int action = Integer.parseInt(ctx.getPathTokens().get("action"));
					if(g.get(gameid) == null) {
						ctx.render("game does not exist");
					} else {
						TicTacToe game = (TicTacToe)g.get(gameid);
						if(game.checkBoardFull() || !game.checkWinner().equals("No Winner")) {
							if(!game.checkWinner().equals("No Winner")) {
								String winner, loser;
								if(game.checkWinner().equals("X")) {
									winner = game.getPlayerX().getName();
									loser = game.getPlayerO().getName();
								} else {
									winner = game.getPlayerO().getName();
									loser = game.getPlayerX().getName();
								}
								db.addPlayer(winner);
								db.addPlayer(loser);
								db.addWin(winner);
								db.addLoss(loser);
							}
							if(action == 1){	
								game.initializeGame();
							} else {
								g.remove(gameid);
							}
							ctx.render("done");
							return;
						}
										
						String result = game.nextTurn(action);
						if(!game.checkWinner().equals("No Winner")) {
							if(game.checkWinner().equals("X")) {
								ctx.render(game.getPlayerX().getName() + " has won!");
							} else {
								ctx.render(game.getPlayerO().getName() + " has won!");
							}
						} else if(game.checkBoardFull()) {
							ctx.render("Draw!");
						}  else {
							ctx.render(result);
						}
					}
				})
				.get("newgame/:player1/:player2", ctx -> {
					MutableHeaders headers = ctx.getResponse().getHeaders();
					headers.add("Access-Control-Allow-Origin", "*");
					headers.add("Access-Control-Allow-Methods", "GET");
					headers.add("Access-Control-Max-Age", "1000");
					headers.add("Access-Control-Allow-Headers", "Content-Type");

					String player1 = ctx.getPathTokens().get("player1");
					String player2 = ctx.getPathTokens().get("player2");
					Game newgame = new TicTacToe(player1, player2);
					int testid;
					while(true) {
						testid = (int)(Math.random() * Integer.MAX_VALUE);
						if(g.get(testid) == null)
						break;
					}
					g.put(testid, newgame);
					HashMap<String, String> result = new HashMap<String, String>();
					result.put("game", Integer.toString(testid));
					ctx.render(Jackson.json(result));
				})
			)
		);
	}

}

