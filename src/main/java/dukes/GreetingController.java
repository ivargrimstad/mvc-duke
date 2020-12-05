package dukes;


import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("greet")
@Controller
public class GreetingController {

    @Inject
    private Greeting greeting;

    @GET
    @View("hello.jsp")
    public void hello() {
    }
}
