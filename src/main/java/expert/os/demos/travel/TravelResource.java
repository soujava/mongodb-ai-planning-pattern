package expert.os.demos.travel;

import expert.os.demos.travel.infrastructure.QUERY;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/travels")
public class TravelResource {

    private static final Logger LOGGER = Logger.getLogger(TravelResource.class.getName());

    @Inject
    private TravelService travelService;

    @QUERY
    public List<Travel> search(TravelFilterRequest filter) {
        LOGGER.info("Searching travels with filter: " + filter);
        return travelService.search(filter);
    }

}
