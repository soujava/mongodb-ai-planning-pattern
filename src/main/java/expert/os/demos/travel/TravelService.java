package expert.os.demos.travel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@ApplicationScoped
public class TravelService {

    private static final Logger LOGGER = Logger.getLogger(TravelService.class.getName());

    private final TravelRepository travelRepository;

    @Inject
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    TravelService() {
        this.travelRepository = null;
    }
}
