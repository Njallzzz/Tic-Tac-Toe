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

	private static TicTacToe g;

	public static void main(String... args) throws Exception {
	   g = new TicTacToe();

		RatpackServer.start (server -> server
			.handlers(chain -> chain
				.get("board", ctx  -> {
				    LinkedList<LinkedList<String>> b = new LinkedList<LinkedList<String>>();
					 char[][] refb = g.getBoard();
					 for(int i = 0; i < 3; i++) {
						LinkedList<String> line = new LinkedList<String>();
						for(int j = 0; j < 3; j++) {
							line.add(Character.toString(refb[i][j]));
						}
						b.add(line);
					 }
					 ctx.render(Jackson.json(b));
					})
				.post( "action", ctx -> {
					ctx.parse(GameAction.class).then(gameac -> {
									String result = g.nextTurn(gameac.getAction());		  		
							  		ctx.render(result);
								});
				})
				//.post("newgame", ctx -> {
						  
				//	}
				//	)
			)
		);
	}

}

