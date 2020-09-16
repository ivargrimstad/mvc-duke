package dukes;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.mvc.security.CsrfProtected;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Locale;
import java.util.ResourceBundle;

@Path("hello")
@Controller
public class Hello {

    @Inject
    private Models model;

    @Inject
    private MvcContext ctx;

    @Inject
    private BindingResult br;

    @Inject
    private Greeting greeting;

    @GET
    @View("form.jsp")
    public void hello() {

//        model.put("name", "Duke");
    }

    @POST
    @CsrfProtected
    public Response name(@Valid @BeanParam HelloForm helloForm) {

        if(br.isFailed()) {
            model.put("errors", br.getAllMessages());
            return Response.status(Response.Status.BAD_REQUEST).entity("form.jsp").build();
        }

        model.put("name", helloForm.getName());
        ResourceBundle greetings = ResourceBundle.getBundle("greetings", ctx.getLocale());
        model.put("greet", greetings.getString("greeting"));

        greeting.setMessage(greetings.getString("greeting") + "  " + helloForm.getName());

        return Response.ok("redirect:greet").build();
    }

    // return form.jsp from @GET
    // @POST method with form param name
    // add models
    // add csrf
    // locale
    // events
}
