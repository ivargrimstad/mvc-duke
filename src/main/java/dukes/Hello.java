package dukes;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.MvcContext;
import jakarta.mvc.View;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
