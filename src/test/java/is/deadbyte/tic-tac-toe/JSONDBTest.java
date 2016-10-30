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
    public void testTest() throws IOException{
        resetTestBase();
    }

    @Test
    public void testStatsWins() throws IOException{
      db = new JSONDB();
      resetTestBase();
      db.addWin("Tester");
      assertEquals(db.getStatsWins("Tester"), 11);
    }

    @Test
    public void testStatsLosses() throws IOException{
      db = new JSONDB();
      resetTestBase();
      assertEquals(db.getStatsLosses("Tester"), 10);
    }

    @Test
    public void addPlayer() throws IOException{
      db = new JSONDB();
      resetTestBase();
      db.addPlayer("Lúðvík");
      assertEquals(db.getStatsWins("Lúðvík"), 0);

    }

    @Test
    public void testAddWin() throws IOException{
      db = new JSONDB();

      resetTestBase();

      db.addWin("Tester");

      assertEquals(db.getStatsWins("Tester"), 11);

    }

    public void resetTestBase() throws IOException{
      JSONObject fileJson = new JSONObject();
      JSONArray newUserArr = new JSONArray();
      JSONObject emptyWins = new JSONObject();
      emptyWins.put("Wins", "10");
      JSONObject emptyLosses = new JSONObject();
      emptyLosses.put("Losses", "10");
      newUserArr.put(emptyWins);
      newUserArr.put(emptyLosses);

      fileJson.put("Tester", newUserArr);
      String writeString = new String(String.valueOf(fileJson));

      // Write to file
      FileWriter writer = new FileWriter("db/dataBase.json");
      writer.write(writeString);
      writer.flush();
      writer.close();
    }
}
