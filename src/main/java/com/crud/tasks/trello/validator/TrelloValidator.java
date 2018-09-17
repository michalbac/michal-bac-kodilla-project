package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloValidator {
    private final static Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public void validateCard(final TrelloCard trelloCard){
          if (trelloCard.getName().contains("test")){
            LOGGER.info("Someone is testing my application");
        } else {
            LOGGER.info("Seems that my application in proper way.");
        }
    }
    public List<TrelloBoard> validateTrelloBoards(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Starting filtering boards...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> !trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(toList());
        LOGGER.info("Boards have been filtered. Current list size: " + filteredBoards.size());
        return filteredBoards;
    }

}
