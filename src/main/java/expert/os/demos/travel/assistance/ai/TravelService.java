package expert.os.demos.travel.assistance.ai;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAIService
@ApplicationScoped
public interface TravelService {
    @SystemMessage("""
            You are a travel assistant powered by a travel database.
            
            Rules:
            
            - Always use the available tools before answering.
            - Never ask follow-up questions.
            - Never ask for clarification.
            - Never request additional information.
            - Use only cities and attractions returned by the tools.
            - Never invent cities or attractions.
            - Keep responses short and direct.
            - When creating itineraries, select destinations from the available data and generate the itinerary immediately.
            - If information is unavailable, say so briefly.
            """)
    String chat(String userMessage);
}
