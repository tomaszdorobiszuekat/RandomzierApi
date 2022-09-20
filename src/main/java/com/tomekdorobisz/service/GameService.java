package com.tomekdorobisz.service;

import com.tomekdorobisz.dao.GameDao;
import com.tomekdorobisz.dao.SessionDao;
import com.tomekdorobisz.model.domain.Game;
import com.tomekdorobisz.model.domain.Session;
import com.tomekdorobisz.model.dto.GuessNumberRQ;
import com.tomekdorobisz.model.dto.GuessNumberRS;
import com.tomekdorobisz.model.dto.HighestPlayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private GameDao gameDao;

    /**
     * @param guessNumberRQ
     * @return GuessNumberRS
     */
    public GuessNumberRS guessNumber(GuessNumberRQ guessNumberRQ) throws Exception {
        GuessNumberRS guessNumberRS = new GuessNumberRS();

        //Generate random number (Integer) with upper bound 100
        Random rand = new Random();
        Integer upperBound = 100;
        Integer randomInt = rand.nextInt(upperBound);
        Boolean isNumberCorrect = false;
        String result;

        if (guessNumberRQ.getInputNumber().equals(randomInt)) {
            isNumberCorrect = true;
            result = "Winner";
        } else if (randomInt < guessNumberRQ.getInputNumber()) {
            result = "Too High";
        } else {
            result = "Too Small";
        }

        guessNumberRS.setResultCorrect(isNumberCorrect);
        guessNumberRS.setInputNumber(guessNumberRQ.getInputNumber());
        guessNumberRS.setRandomNumber(randomInt);
        guessNumberRS.setResult(result);

        Game game = new Game();

        Session session = this.sessionDao.getById(guessNumberRQ.getSessionID());

        if (session == null) {
            //Session is not valid
            throw new Exception();
        }

        game.setSession(session);
        game.setInputNumber(guessNumberRQ.getInputNumber());
        game.setRandomNumber(randomInt);
        game.setCreatedDate(new Date());

        game = this.gameDao.saveAndFlush(game);

        return guessNumberRS;
    }

    /**
     * @return List<HighestPlayDTO>
     */
    public List<HighestPlayDTO> getHighestPlays() {
        List<Game> gameList = this.gameDao.findAll();
        List<HighestPlayDTO> highestPlayDTOS = new ArrayList<>();

        Map<Integer, List<Game>> sessionWiseMoveCount = new HashMap<>();

        for (Game game : gameList) {
            Integer sessionID = game.getSession().getSessionID();
            sessionWiseMoveCount.putIfAbsent(sessionID, new ArrayList<>());
            sessionWiseMoveCount.get(sessionID).add(game);
        }

        int count = 0;

        //Sort game list descending order by result
        gameList.sort(Comparator.comparing(Game::getRandomNumber).reversed());

        for (Game game : gameList) {
            Integer sessionID = game.getSession().getSessionID();

            HighestPlayDTO highestPlayDTO = new HighestPlayDTO();
            highestPlayDTO.setSessionID(sessionID);
            highestPlayDTO.setNoOfMoves(sessionWiseMoveCount.get(sessionID).size());

            highestPlayDTOS.add(highestPlayDTO);

            if (count == 10) {
                break;
            }

            count++;
        }

        return highestPlayDTOS;
    }
}
