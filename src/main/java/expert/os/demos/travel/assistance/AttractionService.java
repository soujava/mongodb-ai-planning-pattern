package expert.os.demos.travel.assistance;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AttractionService {


    private final AttractionRepository attractionRepository;

    @Inject
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> findByCity(String name) {
        return attractionRepository.findByCityName(name);
    }

    public Attraction save(Attraction attraction) {
        return attractionRepository.save(attraction);
    }
}
