package dukes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mvc.security.Csrf;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.krazo.Properties;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("ui")
@ApplicationScoped
public class MvcDukeApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        final Map<String,Object> map = new HashMap<>();

        map.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);

        map.put(Properties.REDIRECT_SCOPE_COOKIES, true);
        return map;
    }
}
