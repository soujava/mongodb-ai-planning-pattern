package expert.os.demos.travel.assistance;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CityTools {

    @Inject
    private CityService service;

    @Tool("""
            Find cities available in a country.
            Use this tool when you need to discover destinations before creating a travel itinerary.
            """)
    public List<City> citiesByCountry(String country) {
        return service.findByCountry(country);
    }

    @Tool("""
            List all available cities.
            Use this tool when you need to explore destinations without any country restriction.
            """)
    public List<City> cities() {
        return service.findAll();
    }
}