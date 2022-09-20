package com.tomekdorobisz.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "GAME_ID")
    private Integer gameID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SESSION_ID")
    private Session session;

    @Column(name = "INPUT_NUMBER")
    private Integer inputNumber;

    @Column(name = "RANDOM_NUMBER")
    private Integer randomNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
