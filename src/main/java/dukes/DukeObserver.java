package dukes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.mvc.event.BeforeControllerEvent;
import jakarta.mvc.event.ControllerRedirectEvent;

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
