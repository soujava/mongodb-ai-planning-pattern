package expert.os.demos.travel;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;
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

    @PostConstruct
    void load() {
        if (travelRepository.isEmpty()) {
            LOGGER.info("[TRAVEL SERVICE] Loading initial travel data...");
            travelRepository.save(new Travel(UUID.randomUUID(), "New York", TravelType.BUSINESS, new java.math.BigDecimal("1500.00")));
            travelRepository.save(new Travel(UUID.randomUUID(), "Paris", TravelType.LEISURE, new java.math.BigDecimal("2000.00")));
            travelRepository.save(new Travel(UUID.randomUUID(), "Tokyo", TravelType.BUSINESS, new java.math.BigDecimal("3000.00")));
            travelRepository.save(new Travel(UUID.randomUUID(), "Sydney", TravelType.LEISURE, new java.math.BigDecimal("1800.00")));
            travelRepository.save(new Travel(UUID.randomUUID(), "Rome", TravelType.LEISURE, new java.math.BigDecimal("2500.00")));
        } else {
            LOGGER.info("[TRAVEL SERVICE] Travel data already loaded.");
        }
    }
}
