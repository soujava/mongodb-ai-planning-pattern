package expert.os.demos.travel;

import jakarta.annotation.PostConstruct;
import jakarta.data.restrict.Restrict;
import jakarta.data.restrict.Restriction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class TravelService {

    private static final Logger LOGGER = Logger.getLogger(TravelService.class.getName());

    private final TravelRepository travelRepository;

    @Inject
    public TravelService(@Database(DatabaseType.DOCUMENT) TravelRepository travelRepository) {
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

    public List<Travel> search(TravelFilterRequest filter) {
        LOGGER.info("[TRAVEL SERVICE] Searching for travels with filter: " + filter);
        if(filter == null) {
            return travelRepository.findAll().toList();
        }
        List<Restriction<Travel>> restrictions = new ArrayList<>();
        filter.city().ifPresent(city -> restrictions.add(_Travel.city.equalTo(city)));
        filter.type().ifPresent(type -> restrictions.add(_Travel.type.equalTo(type)));
        filter.minPrice().ifPresent(minPrice -> restrictions.add(_Travel.price.greaterThanEqual(minPrice)));
        filter.maxPrice().ifPresent(maxPrice -> restrictions.add(_Travel.price.lessThanEqual(maxPrice)));
        return travelRepository.query(Restrict.all(restrictions.toArray(new Restriction[0])));
    }
}
