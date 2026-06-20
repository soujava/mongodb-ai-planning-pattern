package expert.os.demos.travel.assistance.ai;

import dev.langchain4j.agent.tool.Tool;
import expert.os.demos.travel.assistance.Attraction;
import expert.os.demos.travel.assistance.AttractionService;
import expert.os.demos.travel.assistance.AttractionType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class AttractionTools {

    private static final Logger LOGGER = Logger.getLogger(AttractionTools.class.getName());
    @Inject
    private AttractionService service;

    @Tool("""
            Find attractions available in a city.
            Use this tool when you need to discover places to visit in a destination.
            """)
    public List<Attraction> attractionsByCity(String city) {
        return service.findByCity(city);
    }

    @Tool("""
            Find attractions by category in a city.
            Categories include HISTORICAL, NATURE, MUSEUM, ARCHITECTURE, FOOD, and RELIGIOUS.
            Use this tool when the traveler has specific interests or preferences.
            """)
    public List<Attraction> attractionsByType(
            String city,
            AttractionType type) {
        return service.findByType(city, type);
    }

    @Tool("""
            List all available attraction categories.
            Use this tool when you need to discover which attraction types can be used to build an itinerary.
            """)
    public AttractionType[] attractionTypes() {
        return AttractionType.values();
    }
}