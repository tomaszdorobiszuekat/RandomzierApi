package com.tomekdorobisz.service;

import com.tomekdorobisz.dao.SessionDao;
import com.tomekdorobisz.model.domain.Session;
import com.tomekdorobisz.model.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Add business logic's related to service
 */
@Service
public class SessionService {

    @Autowired
    private SessionDao sessionDao;

    /**
     * @return SessionDTO
     */
    public SessionDTO getCurrentSession() {

        //Create new session
        Session session = new Session();
        session.setCreatedDate(new Date());

        //Insert session data to database
        session = this.sessionDao.saveAndFlush(session);

        return new SessionDTO(session);
    }
}
