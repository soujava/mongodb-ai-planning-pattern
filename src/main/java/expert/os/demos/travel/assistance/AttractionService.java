package expert.os.demos.travel.assistance;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AttractionService {


    private final AttractionRepository attractionRepository;

    @Inject
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> findByCity(String city) {
        return attractionRepository.findByCity(city);
    }

    public Attraction save(Attraction attraction) {
        return attractionRepository.save(attraction);
    }
}
