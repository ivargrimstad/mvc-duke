package dukes;


import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.FormParam;

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
