import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

public class JSONTest{

    @Test
    public void testStatsWins(){
      assertEquale(getStatsWins("Baldur"), 12);
    }



}
