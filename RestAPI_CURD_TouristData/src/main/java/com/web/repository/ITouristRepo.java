package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
