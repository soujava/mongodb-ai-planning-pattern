package expert.os.demos.travel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelResource {

    @Inject
    private TravelService travelService;

    public List<Travel> search(TravelFilterRequest filter) {
        return travelService.search(filter);
    }

}
