package dukes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.ControllerRedirectEvent;
import java.util.logging.Logger;

@ApplicationScoped
public class DukeObserver {

    private static final Logger LOG = Logger.getLogger(DukeObserver.class.getName());

    private void beforeController(@Observes BeforeControllerEvent bfe) {
        LOG.warning(() -> "Before " + bfe.getUriInfo().getPath());
    }

    private void beforeController(@Observes ControllerRedirectEvent cre) {
        LOG.warning(() -> "Redirect " + cre.getUriInfo().getPath());
    }
}
