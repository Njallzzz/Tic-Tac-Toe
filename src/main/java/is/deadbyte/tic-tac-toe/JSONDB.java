import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONDB{
    String folder = "db/";
    File fileName;
    FileReader reader;
    FileWriter writer;

    public JSONDB() throws IOException {
      this.fileName = new File(folder + "dataBase.json");
      fileName.isFile();
      if(!fileName.isFile()){
        fileName.createNewFile();
        initFile();
      }
    }

    private JSONObject getJSON() throws IOException{
      // Read the file and cast to char then String
      reader = new FileReader(this.fileName);
      char[] jsonchar = new char[2048];
      reader.read(jsonchar);
      String jsonFile = new String(jsonchar);

      // Build the JSON file
      JSONObject fileJson = new JSONObject(jsonFile);
      return fileJson;
    }

    /**
    * Creates an "empty" JSON file
    *
    * @throws IOException
    */
    private void initFile() throws IOException{
        writer = new FileWriter(fileName);
        writer.write("{}");
        writer.flush();
        writer.close();
    }

    public void addWin(String name) throws IOException{
      if(!isInDataBase(name)){

      }
    }

    public void addLoss(String name){

    }

    public void addPlayer(String name) throws IOException{
      if(!isInDataBase(name)){
        JSONObject fileJson = getJSON();
        fileJson.put(name, "[{\"Wins\":\"0\"},{\"Losses\": \"0\"}]");
        writer = new FileWriter(this.fileName);
        writer.write(String.valueOf(fileJson));
        writer.flush();
        writer.close();
      }
    }

    /**
    * Gets the win statistics of a player
    *
    * @param namd   Name of player
    * @return int number of wins - -1 if not in database
    */
    public int getStatsWins(String name) throws IOException{
      if(!isInDataBase(name)){
        return -1;
      }
      JSONObject fileJson = getJSON();

      // Get statistics and wins
      JSONArray player = (JSONArray) fileJson.get(name);
      JSONObject wins = (JSONObject)player.get(0);

      return Integer.parseInt((String)wins.get("Wins"));
    }

    /**
    * Gets the loss statistics of a player
    *
    * @param namd   Name of player
    * @return int number of wins - -1 if not in database
    */
    public int getStatsLosses(String name) throws IOException{
      if(!isInDataBase(name)){
        return -1;
      }
      // Build the JSON file
      JSONObject fileJson = getJSON();

      // Get statistics and wins
      JSONArray player = (JSONArray) fileJson.get(name);
      JSONObject wins = (JSONObject)player.get(1);

      return Integer.parseInt((String)wins.get("Losses"));
    }

    /**
    * Since the org.json library doesn't have( or need ) any member check
    * the exception throws are used for checks.
    * @param name  name of player to check
    * @return boolean true if player is in database
    */
    private boolean isInDataBase(String name) throws IOException{
      JSONObject fileJson = getJSON();
      try{
        fileJson.get(name);
        return true;
      }
      catch(JSONException e){
        return false;
      }
    }
}
