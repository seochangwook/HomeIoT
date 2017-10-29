package com.homeiot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeiot.application.model.TipModel;

@Repository
public interface TipDataDao extends JpaRepository<TipModel, String>{
	List<TipModel> findAll();
}
