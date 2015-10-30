package example.jackson.databinding;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/presentation")
public class PresentationEndPoints {

    // The Java method will process HTTP GET requests
    @GET
    @Path("/presentations")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getPresentations() {
        // Return some cliched textual content

        String presentationArrayJson = JsonMapper.toJson(Presentations.getInstance().getPresentations());

        return presentationArrayJson;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPresentation(String postBodyData) {

        Presentation presentation = JsonMapper.toClassInstance(postBodyData, Presentation.class);

        Presentations presentations = Presentations.getInstance();
        presentations.addPresentation(presentation);

        // printing the presentations added so far
        for (Presentation p : presentations.getPresentations().get(Presentations.KEY)) {
            System.out.println(p.toString());
        }

        System.out.println("\n");

    }

}
