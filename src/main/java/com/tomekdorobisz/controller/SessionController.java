package com.tomekdorobisz.controller;

import com.tomekdorobisz.model.dto.SessionDTO;
import com.tomekdorobisz.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SessionController insert all API end point related to session
 */
@RestController
@RequestMapping(value = "session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    /**
     * This is get current session REST End point
     *
     * @return SessionDTO
     */
    @GetMapping(value = "/getCurrentSession", headers = "Accept=application/json")
    public ResponseEntity<SessionDTO> getCurrentSession() {

        SessionDTO response = this.sessionService.getCurrentSession();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
