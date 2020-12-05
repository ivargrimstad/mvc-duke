package dukes;

import jakarta.inject.Named;
import jakarta.mvc.RedirectScoped;

import java.io.Serializable;

@Named("greeting")
@RedirectScoped
public class Greeting implements Serializable {

    private static final long serialVersionUID = 21325253464L;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
