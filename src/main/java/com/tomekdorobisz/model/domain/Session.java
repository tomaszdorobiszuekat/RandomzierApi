package com.tomekdorobisz.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "SESSION_ID")
    private Integer sessionID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
