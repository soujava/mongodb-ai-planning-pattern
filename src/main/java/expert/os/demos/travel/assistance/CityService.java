package expert.os.demos.travel.assistance;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CityService {


    private final CityRepository cityRepository;

    @Inject
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
