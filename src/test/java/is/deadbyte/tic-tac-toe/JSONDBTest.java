import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDBTest{

    @Test
    public void testStatsWins(){
      JSONDB db = new JSONDB();

      assertEquals(db.getStatsWins("Baldur"), 12);
    }



}
