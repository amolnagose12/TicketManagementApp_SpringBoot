package com.amol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
