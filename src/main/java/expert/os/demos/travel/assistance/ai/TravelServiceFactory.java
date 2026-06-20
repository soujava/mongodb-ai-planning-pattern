package expert.os.demos.travel.assistance.ai;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class TravelServiceFactory {

    @Inject
    private ChatModel chatModel;
    @Inject
    private AttractionTools attractionTools;
    @Inject
    private CityTools cityTools;

    @Produces
    public TravelService createAgent() {
        return AiServices.builder(TravelService.class)
                .chatModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .tools(attractionTools, cityTools)
                .build();
    }
}
