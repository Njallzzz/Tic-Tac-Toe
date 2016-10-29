import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;

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

    /**
    * Creates an "empty" JSON file
    *
    * @throws IOException
    */
    public void initFile() throws IOException{
        writer = new FileWriter(fileName);
        writer.write("{}");
        writer.flush();
        writer.close();
    }

    public void addWin(String name){

    }

    public void addLoss(String name){

    }

    public void addPlayer(String name){

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
      // Read the file and cast to char then String
      reader = new FileReader(this.fileName);
      char[] jsonchar = new char[2048];
      reader.read(jsonchar);
      String jsonFile = new String(jsonchar);

      // Build the JSON file
      JSONObject fileJson = new JSONObject(jsonFile);

      // Get statistics and wins
      JSONArray player = (JSONArray) fileJson.get(name);
      JSONObject wins = (JSONObject)player.get(0);
      
      return Integer.parseInt((String)wins.get("Wins"));
    }

    public int getStatsLosses(String name){
      return 0;
    }

    private boolean isInDataBase(String name){
      return true;
    }
}
