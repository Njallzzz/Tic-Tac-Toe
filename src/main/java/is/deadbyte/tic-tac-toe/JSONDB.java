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


    /**
    * Constructor for JSONDB
    *
    * @throws IOException
    */
    public JSONDB() throws IOException {
      this.fileName = new File(folder + "dataBase.json");
      fileName.isFile();
      if(!fileName.isFile()){
        fileName.createNewFile();
        initFile();
      }
    }

    /**
    * Builds the JSON file from db file
    *
    * @return JSONObject
    * @throws IOException
    */
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

    /**
    * Increments the win for the player witn @paramn name
    *
    * @param name   name of player
    * @throws IOException
    */
    public void addWin(String name) throws IOException{
      if(isInDataBase(name)){
        // Build the JSON file
        JSONObject fileJson = getJSON();

        // Get statistics and wins
        JSONArray statistics = (JSONArray) fileJson.get(name);
        JSONObject wins = (JSONObject)statistics.get(0);
        int numberOfWins = Integer.parseInt((String)wins.get("Wins"));

        // Increments the wins for player
        wins.put("Wins", String.valueOf(numberOfWins+1));

        // Recomplie the JSON file
        statistics.put(0, wins);
        fileJson.put(name, statistics);

        // Cast json to String
        String writeString = new String(String.valueOf(fileJson));

        // Write to file
        FileWriter writer = new FileWriter(fileName);
        writer.write(writeString);
        writer.flush();
        writer.close();
      }
    }

    /**
    * Decrements the win for the player witn @paramn name
    *
    * @param name   name of player
    * @throws IOException
    */
    public void addLoss(String name) throws IOException{
      if(isInDataBase(name)){
        // Build the JSON file
        JSONObject fileJson = getJSON();

        // Get statistics and wins
        JSONArray statistics = (JSONArray) fileJson.get(name);
        JSONObject losses = (JSONObject)statistics.get(1);
        int numberOfLosses = Integer.parseInt((String)losses.get("Losses"));

        // Increments the wins for player
        losses.put("Losses", String.valueOf(numberOfLosses-1));

        // Recomplie the JSON file
        statistics.put(1, losses);
        fileJson.put(name, statistics);

        // Cast json to String
        String writeString = new String(String.valueOf(fileJson));

        // Write to file
        FileWriter writer = new FileWriter(fileName);
        writer.write(writeString);
        writer.flush();
        writer.close();
      }
    }

    /**
    * Adds a new player to the database
    *
    * @param name   name of the player to add
    * @throws IOException
    */
    public void addPlayer(String name) throws IOException{
      if(!isInDataBase(name)){
        JSONObject fileJson = getJSON();
        JSONArray newUserArr = new JSONArray();
        JSONObject emptyWins = new JSONObject();
        emptyWins.put("Wins", "0");
        JSONObject emptyLosses = new JSONObject();
        emptyLosses.put("Losses", "0");
        newUserArr.put(emptyWins);
        newUserArr.put(emptyLosses);

        fileJson.put(name, newUserArr);
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
    * @throws IOException
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
    * @throws IOException
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
    * @throws IOException
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
