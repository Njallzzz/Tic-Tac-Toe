				import ratpack.server.RatpackServer;
				import ratpack.jackson.Jackson;
				import ratpack.http.MutableHeaders;
				import org.json.*;

				import com.fasterxml.jackson.annotation.JsonProperty;

				import java.util.ArrayList;
				import java.util.LinkedList;
				import java.util.List;
				import java.util.HashMap;
				import java.util.Map;

				public class GameService {

					private static class GameAction {
						private int game;
						private int action;
						public GameAction(@JsonProperty("game") int game, @JsonProperty("action") int action) {
							this.game = game;
							this.action = action;
						}
						public int getGame() {
							return this.game;
						}
						public int getAction() {
							return this.action;
						}
					}

					private static class NewGame {
						private String player1;
						private String player2;
						public NewGame(@JsonProperty("player1") String p1, @JsonProperty("player2") String p2) {
			this.player1 = p1;
			this.player2 = p2;
		}
		public String getPlayer1() {
			return this.player1;
		}
		public String getPlayer2() {
			return this.player2;
		}
	}

	private static class GetBoard {
		private int id;
		public GetBoard(@JsonProperty("game") int game) {
			this.id = game;
		}
		public int getId() {
			return this.id;
		}
	}

	private static HashMap<Integer, Game> g;

	public static void main(String... args) throws Exception {
	   g = new HashMap<Integer, Game>();

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
							if(action == 1){
								game.initializeGame();
							} else {
								g.remove(gameid);
							}
							ctx.render("done");
							return;
						}
										
						String result = game.nextTurn(action);
						if(game.checkBoardFull()) {
							ctx.render("Draw!");
						} else if(!game.checkWinner().equals("No Winner")) {
							if(game.checkWinner().equals("X")) {
								ctx.render(game.getPlayerX().getName() + " has won!");
							} else {
								ctx.render(game.getPlayerO().getName() + " has won!");
							}
						} else {
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

