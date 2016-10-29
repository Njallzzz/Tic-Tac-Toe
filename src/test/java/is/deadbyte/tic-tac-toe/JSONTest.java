import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

public class JSONTest{

    @Test
    public void JSONTester(){
        JSONObject playerTest = new JSONObject();
              
        Player player1 = new Player();
        Player player2 = new Player();
        
        Player[] playerArr = new Player[2];
        playerArr[0] = player1;
        playerArr[1] = player2;
        JSONArray playersJson = new JSONArray(playerArr);
        
        playerTest.put("Players", playersJson);

        
        
        player1.setName(playerTest.get("name").toString());  
        
        assertEquals(player1.getName(), "Baldur");
    }


}
