package expert.os.demos.travel.assistance.web;


import expert.os.demos.travel.assistance.DataLoader;
import expert.os.demos.travel.assistance.ai.TravelService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class TravelBean implements Serializable {

    @Inject
    private TravelService travelService;

    @Inject
    private DataLoader dataLoader;

    private String userMessage;

    private String answer;

    @PostConstruct
    public void init() {
        dataLoader.load();
    }

    public void send() {
        if (userMessage == null || userMessage.isBlank()) {
            return;
        }
        answer = travelService.chat(userMessage);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getAnswer() {
        return answer;
    }
}