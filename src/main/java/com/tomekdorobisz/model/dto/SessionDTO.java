package com.tomekdorobisz.model.dto;

import com.tomekdorobisz.model.domain.Session;

/**
 * Session related data transfer object
 */
public class SessionDTO {

    /**
     * session ID is the unique key of a session
     */
    private Integer sessionID;

    /**
     * default constructor
     */
    public SessionDTO() {
    }

    /**
     * @param session
     */
    public SessionDTO(Session session) {
        this.sessionID = session.getSessionID();
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }
}
