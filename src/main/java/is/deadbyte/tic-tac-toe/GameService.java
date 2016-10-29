import ratpack.server.RatpackServer;
import ratpack.jackson.Jackson;
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
				.post("board", ctx  -> {
					ctx.parse(GetBoard.class).then(gboard -> {
						if(g.get(gboard.getId()) == null) {
							ctx.render("game does not exist");
						} else {
				    		LinkedList<LinkedList<String>> b = new LinkedList<LinkedList<String>>();
					 		TicTacToe game = (TicTacToe)g.get(gboard.getId());
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
					});
				})
				.post("action", ctx -> {
					ctx.parse(GameAction.class).then(gameac -> {
							  		if(g.get(gameac.getGame()) == null) {
										ctx.render("game does not exist");
									} else {
										String result = g.get(gameac.getGame()).nextTurn(gameac.getAction());
							  			ctx.render(result);
									}
								});
				})
				.post("newgame", ctx -> {
					ctx.parse(NewGame.class).then(newg -> {
							  		Game newgame = new TicTacToe(newg.getPlayer1(), newg.getPlayer2());
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
								});
				})
			)
		);
	}

}

