package ReaderData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static JsonReader TestJson;

    public static String getJson(String filePath, String key) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("test/java/data/RegisterData.json"));
            return (String) jsonObject.get(key);
        } catch (IOException | ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null; // Return a default value or handle the error case
        }
    }
}