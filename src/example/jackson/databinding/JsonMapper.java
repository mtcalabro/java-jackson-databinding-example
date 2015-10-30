package example.jackson.databinding;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonMapper {

    public static ObjectMapper jsonMapper = new ObjectMapper();

    /**
     * Encode any instance to the JSON string
     *
     * @param data Object to be converted to JSON string
     * @return String json string of Object
     */
    public static <T> String toJson(T data) {
        try {
            return jsonMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    /**
     * Decode any instance to the mapped Java Class
     *
     * @param data JSON string to be converted to Java Object
     * @param <T>  Class file of object to be converted to Object
     *
     * @return Class Instance
     */
    public static <T> T toClassInstance(String data, Class<T> type) {
        try {
            return jsonMapper.readValue(data, type);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
