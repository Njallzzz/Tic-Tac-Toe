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

    public JSONDB(){
      fileName = new File("test.json");
    }

    public void addWin(String name){

    }

    public void addLoss(String name){

    }

    public void addPlayer(String name){

    }

    public int getStatsWins(String name){

    }

    public int getStatsLosses(String name){

    }

    private boolean isInDataBase(String name){
      return false;
    }
}
