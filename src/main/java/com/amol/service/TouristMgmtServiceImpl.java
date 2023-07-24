package com.amol.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.dao.ITouristRepo;
import com.amol.exception.TouristNotFoundException;
import com.amol.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = repo.save(tourist).getId();
		
		return "Tourist is registered having ticket ID :: " + tid;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = repo.findAll();
		list.sort((t1,t2)->t1.getId().compareTo(t2.getId()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer Id) {
//		java.util.Optional<Tourist> optional = repo.findById(Id);
//		
//		if (optional.isPresent()) {
//			return optional.get();
//		}else {
//			throw new TouristNotFoundException(Id + " " + "record not found" );
//		}
		return repo.findById(Id).orElseThrow(()-> new TouristNotFoundException(Id + " " + "record not found" ));
		
	}

	@Override
	public String updateTouristById(Tourist tourist) {
		
		java.util.Optional<Tourist> optional= repo.findById(tourist.getId());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "toursit with the id :: "+ tourist.getId() + "updated";
		}else {
			throw new TouristNotFoundException("tourist with the id::" + tourist.getId()+ "not available for updation");
		}
		
	}

	@Override
	public String updateTouristByDetails(Integer Id, Float hikePercent) {
		java.util.Optional<Tourist> optional =repo.findById(Id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+tourist.getBudget()*(hikePercent/100));
			repo.save(tourist);
			return "Tourist budget is updated for the id ::" + tourist.getId();
		}else {
			throw new TouristNotFoundException("Tourist not Founf for the id");
		}
		
	}

	@Override
	public String deleteTouristById(Integer id) {
		java.util.Optional<Tourist> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "tourist with the id deleted" + id + "deleted........";
		}else
			throw new TouristNotFoundException("Tourist not found for the id :: "+ id);
	}
	
	
	
	

	

	

}
