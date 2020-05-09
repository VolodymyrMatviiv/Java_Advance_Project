package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;

@Service
public class EntrantService {
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	
	public Entrant save(Entrant entrant) {
		return entrantRepository.save(entrant);		
	}
	
	
	public List<Entrant> getAllEntrants(){
		return entrantRepository.findAll();		
	}
	
	public List<Entrant> sortedEntrants(){
		return entrantRepository.findAll(Sort.by(Sort.Direction.DESC, "totalMark"));		
	}
	
}
