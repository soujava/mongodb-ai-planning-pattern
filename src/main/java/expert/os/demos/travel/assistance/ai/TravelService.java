package expert.os.demos.travel.assistance.ai;

import dev.langchain4j.cdi.spi.RegisterAIService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAIService
@ApplicationScoped
public interface TravelService {

    String chat(String userMessage);
}
