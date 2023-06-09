package com.gres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gres.model.CurrentUserSession;


@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession,Integer> {

	public CurrentUserSession findByUuid(String key);

	public Optional<CurrentUserSession> findByUsername(String email);

}
