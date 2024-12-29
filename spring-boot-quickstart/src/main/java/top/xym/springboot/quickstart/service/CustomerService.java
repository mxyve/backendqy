package top.xym.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.enums.RequestType;

@Service
public class CustomerService {

    public String handleRequest(RequestType requestType) {
        return switch (requestType) {
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };
    }

    private String handleQuery() {
        return "handling user query...";
    }

    private String handleComplaint() {
        return "handling user complaint...";
    }

    private String handleSuggestion() {
        return "handling user suggestion...";
    }
}
