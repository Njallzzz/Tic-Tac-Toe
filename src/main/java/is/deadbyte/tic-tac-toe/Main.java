import ratpack.server.RatpackServer;
import ratpack.jackson.Jackson;
import org.json.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class Main {
	private static class Person {
		private final String name;
		public Person(@JsonProperty("name") String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	private static int num;

	public static void main(String... args) throws Exception {
	   num = 1337;
		RatpackServer.start (server -> server
			.handlers(chain -> chain
				.get(ctx  -> {
					Map<String, String> temp = new HashMap<String, String>();
					temp.put("hello", "there");
					temp.put("this", Integer.toString(num));
					num++;		
					 ctx.render(Jackson.json(temp));
					})
				.post( "person", ctx -> {
					ctx.parse(Person.class).then(person -> ctx.render(person.getName()));
					})
			)
		);
	}

}

