package dukes;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
