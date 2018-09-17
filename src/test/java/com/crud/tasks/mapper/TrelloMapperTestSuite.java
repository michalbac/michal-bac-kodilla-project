package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("testList", "1", false));
        trelloBoardDto.add(new TrelloBoardDto("test1", "1", trelloListDtos));

        //When
        List<TrelloBoard> mappedBoard = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(mappedBoard.get(0).getName(), trelloBoardDto.get(0).getName());
        assertEquals(mappedBoard.get(0).getId(), trelloBoardDto.get(0).getId());
        assertEquals(mappedBoard.get(0).getLists().get(0).getId(), trelloBoardDto.get(0).getLists().get(0).getId());
        assertEquals(mappedBoard.get(0).getLists().get(0).getName(), trelloBoardDto.get(0).getLists().get(0).getName());
        assertEquals(mappedBoard.get(0).getLists().get(0).isClosed(), trelloBoardDto.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToBoardDtoTest() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("2", "testList2", false));
        trelloBoard.add(new TrelloBoard( "2", "test2", trelloList));

        //When
        List<TrelloBoardDto> mappedBoard = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals(mappedBoard.get(0).getName(), trelloBoard.get(0).getName());
        assertEquals(mappedBoard.get(0).getId(), trelloBoard.get(0).getId());
        assertEquals(mappedBoard.get(0).getLists().get(0).getId(), trelloBoard.get(0).getLists().get(0).getId());
        assertEquals(mappedBoard.get(0).getLists().get(0).getName(), trelloBoard.get(0).getLists().get(0).getName());
        assertEquals(mappedBoard.get(0).getLists().get(0).isClosed(), trelloBoard.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testCard", "test card for mapper", "1", "11");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testCard2", "test card for mapper2", "2", "111");

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }
}
