import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDBTest{

    public JSONDB db;

    @Test
    public void testStatsWins() throws IOException{
      db = new JSONDB();
      assertEquals(db.getStatsWins("Baldur"), 12);
    }

    @Test
    public void testStatsLosses() throws IOException{
      db = new JSONDB();
      assertEquals(db.getStatsLosses("Njáll"), 12);
    }

    @Test
    public void addPlayer(){
      db = new JSONDB();

      db.addPlayer("Lúðvík");
      assertEquals(db.getStatsWins("Lúðvík"), 0);

    }


}
