package dukes;

import javax.mvc.binding.MvcBinding;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;

public class HelloForm {

    @MvcBinding
    @NotNull
    @Pattern(regexp = "[a-zA-Z]*", message= "only letters")
    @FormParam("name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
