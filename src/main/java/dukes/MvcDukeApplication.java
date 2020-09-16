package dukes;

import org.eclipse.krazo.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
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
