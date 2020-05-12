package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subjects;

public class EntrantDTOHelper {
	
	private static Logger logger = LoggerFactory.getLogger(EntrantDTOHelper.class);
	
	public static Entrant createEntity(MultipartFile file, String firstName, String lastName, 
			Faculty faculty, List<Subjects> subjects,Integer firstSubject,Integer secondSubject,Integer thirdSubject,Integer fourthSubject) throws IOException {
		
		logger.debug("Adding a new registration for entrant " + firstName + " " + lastName);
		
		Entrant entrant = new Entrant();
		entrant.setFirstName(firstName);
		entrant.setLastName(lastName);
		entrant.setFaculty(faculty);
		entrant.setSubjects(subjects);
		entrant.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		entrant.setAward_fourth_subject(fourthSubject);
		entrant.setAward_first_subject(firstSubject);
		entrant.setAward_second_subject(secondSubject);
		entrant.setAward_third_subject(thirdSubject);
		entrant.setTotalMark(firstSubject + secondSubject + thirdSubject + fourthSubject);
		
		return entrant;
	}

}
