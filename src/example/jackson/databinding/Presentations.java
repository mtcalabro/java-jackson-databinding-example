package example.jackson.databinding;

import com.fasterxml.jackson.xml.annotate.JacksonXmlElementWrapper;
import com.fasterxml.jackson.xml.annotate.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * Created by matthewcalabro on 10/30/15.
 *
 *
 *
 *
 */
public class Presentations {


    private static Presentations instance = null;

    private static ArrayList<Presentation> presentations;

    public static Presentations getInstance() {
        if (instance == null) {
            instance = new Presentations();
            presentations = new ArrayList<>();
        }
        return instance;
    }

    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    public void addPresentation(Presentation presentation) {
        presentations.add(presentation);
    }

}
