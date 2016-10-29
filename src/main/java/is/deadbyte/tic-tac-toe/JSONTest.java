import org.json.simple.JSONObject;

public class JSONTest{

  public static void main(String[] args){
    JSONObject playerTest = new JSONObject();
    playerTest.put("Name", "Njáll");

    Player testPlayer = newPlayer(playerTest.get("Name"));

    System.out.println(testPlayer.getName());

  }

}
