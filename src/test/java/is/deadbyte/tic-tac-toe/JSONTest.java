import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONTest{

    @Test
    public void testStatsWins(){
      assertEquale(getStatsWins("Baldur"), 12);
    }



}
