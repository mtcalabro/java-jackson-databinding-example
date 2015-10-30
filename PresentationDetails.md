##Jackson JSON Processor Example
Jackson is a multi-purpose Java library for processing JSON data format. The library offers three way to process JSON
Streaming API, Tree Model and Data Binding. This project is a working example of the libraries Data Binding capabilities.

### About this repo
The containing code within this repo goes beyond a basic working example of the Jackson JSON libaray. I've included a basic example below. 
What is included is a working example of a RESTful service for adding and retreiving Presentation objects in Java using JAX-RS and Jackson JSON parser.

###Implementing a somewhat basic working example

###Step 1. Get some JSON data to map
This example uses a simple presention object
```
{"date": "11/01/2015", "time" : "06:00PM", "presenterName" : "Matt", "presentationTopic" : "Jackson-databinding"} 
```

###Step 2. Create a class file in your Java project which models the JSON object
You can create the model object yourself by hand or use a tool to generate the object. The YouTube video I've provided
in below in my resources provides a method for generating the class file.
```
public class Presentation {

    private String date;
    private String time;
    private String presenterName;

    private String presentationTopic;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPresenterName() {
        return presenterName;
    }

    public void setPresenterName(String presenterName) {
        this.presenterName = presenterName;
    }

    public String getPresentationTopic() {
        return presentationTopic;
    }

    public void setPresentationTopic(String presentationTopic) {
        this.presentationTopic = presentationTopic;
    }

    @Override
    public String toString() {

        return "date=" + this.date
                + "time=" + this.time
                + "presenterName=" + this.presenterName
                + "presentorTopic=" + this.presentationTopic;

    }
}

```

###Step 3: Use the ObjectMapper class to read or write to or from the class.
In this case I created a class to handle the writing a class to JSON and instiantiation a class from JSON.

```
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

```
###Step 4: Process some JSON!
####To JSON
```
Presentation presention = new Presentation();
// set some values to the presentation here instance...

String json = JsonMapper.toJson(presention);
```

####fromJSON
```
Presentation presentation = JsonMapper.toClassInstance(postBodyData, Presentation.class);
```

###Resources:
####FastXML jackson: [databind:](https://github.com/FasterXML/jackson-databind)

####FastXML jackson: [main page](https://github.com/FasterXML/jackson)

###Other Resources:

####Youtube: [Basic Demo which includes a decoding example and Class generation](https://www.youtube.com/watch?v=PARyHhklbgc)

####FastXML jackson: [XML](https://github.com/FasterXML/jackson-dataformat-xml/wiki)