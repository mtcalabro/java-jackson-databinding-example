package example.jackson.databinding;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by matthewcalabro on 10/30/15.
 *
 *
 *
 *
 */
public class Presentations {


    private static Presentations instance = null;

    private static HashMap<String, ArrayList<Presentation>> presentations;
    protected static final String KEY = "presentations";

    public static Presentations getInstance() {
        if (instance == null) {
            instance = new Presentations();
            presentations = new HashMap();
            presentations.put(KEY, new ArrayList<Presentation>());
        }
        return instance;
    }

    public HashMap<String, ArrayList<Presentation>> getPresentations() {
        return presentations;
    }

    public void addPresentation(Presentation presentation) {
        presentations.get(KEY).add(presentation);
    }

}
