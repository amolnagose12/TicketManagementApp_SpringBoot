package com.amol.service;

import java.util.List;

import com.amol.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer Id);
	public String updateTouristById(Tourist tourist);
	public String updateTouristByDetails(Integer Id, Float hikePercent);
	public String deleteTouristById(Integer id);
}
