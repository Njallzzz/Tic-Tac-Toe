import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;

public class JSONDB{
    File fileName;
    FileReader reader;
    FileWriter writer;

    public JSONDB() throws IOException {
      this.fileName = new File("test.json");
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

    public int getStatsWins(String name) throws IOException{
      // Read the file and cast to char then String
        reader = new FileReader(this.fileName);
        char[] jsonchar = new char[2048];
        reader.read(jsonchar);
        String jsonFile = new String(jsonchar);

      return 0;
    }

    public int getStatsLosses(String name){
      return 0;
    }

    private boolean isInDataBase(String name){
      return false;
    }
}
