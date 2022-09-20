package com.tomekdorobisz;

import com.tomekdorobisz.controller.GameController;
import com.tomekdorobisz.controller.SessionController;
import com.tomekdorobisz.model.dto.GuessNumberRQ;
import com.tomekdorobisz.model.dto.GuessNumberRS;
import com.tomekdorobisz.model.dto.HighestPlayDTO;
import com.tomekdorobisz.model.dto.SessionDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TomekdorobiszApplicationTests {

    @Autowired
    private GameController gameController;

    @Autowired
    private SessionController sessionController;

    @Test
    void contextLoads() {
    }

    @Rollback(false)
    @Test
    public void getCurrentSession() throws Exception {
        ResponseEntity<SessionDTO> result = sessionController.getCurrentSession();
        Assert.assertNotNull(result.getBody());

        System.out.println("Output" + result.getBody());
    }

    @Rollback(false)
    @Test
    public void getHighestPlays() throws Exception {
        ResponseEntity<List<HighestPlayDTO>> result = gameController.getHighestPlays();
        Assert.assertNotNull(result.getBody());

        System.out.println("Output" + result.getBody());
    }

    @Rollback(false)
    @Test
    public void guessNumber() throws Exception {
        GuessNumberRQ guessNumberRQ = new GuessNumberRQ();

        guessNumberRQ.setSessionID(2);
        guessNumberRQ.setInputNumber(25);

        ResponseEntity<GuessNumberRS> result = gameController.guessNumber(guessNumberRQ);
        Assert.assertNotNull(result.getBody());

        System.out.println("Output" + result.getBody());
    }
}
