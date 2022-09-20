package com.tomekdorobisz.dao;

import com.tomekdorobisz.model.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDao extends JpaRepository<Session, Integer> {
}
