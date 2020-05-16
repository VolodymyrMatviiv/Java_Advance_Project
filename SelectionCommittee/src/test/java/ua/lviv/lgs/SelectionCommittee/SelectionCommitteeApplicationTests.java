package ua.lviv.lgs.SelectionCommittee;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subjects;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.UserService;


@RunWith(SpringRunner.class)
@DataJpaTest
class SelectionCommitteeApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EntrantService entrantService;
	
	@Autowired
	private FacultyRepository facultyRepo;
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	
	public void testSaveUser() {
		List<User> users = userRepo.findAll();
		assertThat(users, hasSize(0));

		User user = new User("a", "a", "a@a", "a", "a");
		userService.seve(user);

		users = userRepo.findAll();
		assertThat(users, hasSize(1));

		User userFromDB = users.get(0);

		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getPassword().equals(user.getPassword()));
		assertTrue(userFromDB.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testFindByEmail() {
		User user = new User("a", "a", "a@a", "a", "a");
		User user2 = new User("b", "b", "b@b", "b", "b");
		userRepo.saveAll(Arrays.asList(user, user2));

		List<User> users = userRepo.findAll();
		assertThat(users, hasSize(2));

		User userFromDB = userService.findUserByEmail("b@b");

		assertTrue(userFromDB.equals(user2));
		assertTrue(userFromDB.getFirstName().equals(user2.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user2.getLastName()));
		assertTrue(userFromDB.getEmail().equals(user2.getEmail()));
		assertTrue(userFromDB.getPassword().equals(user2.getPassword()));
		assertTrue(userFromDB.getRole().equals(user2.getRole()));
	}
	
	@Test
	public void testSaveEntrant() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));

		Entrant entrant = new Entrant();
		entrant.setId(1);
		entrant.setFirstName("a");
		entrant.setLastName("a");
		entrant.setFaculty((Faculty) facultyRepo);
		entrant.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.GEOGRAPHY));
		entrantService.save(entrant);

		entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(1));

		Entrant entrantFromDB = entrants.get(0);

		assertTrue(entrantFromDB.equals(entrant));
		assertTrue(entrantFromDB.getId().equals(entrant.getId()));
		assertTrue(entrantFromDB.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDB.getLastName().equals(entrant.getLastName()));
		assertTrue(entrantFromDB.getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrantFromDB.getSubjects().equals(entrant.getSubjects()));
	}

	@Test
	public void testGetAllEntants() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));

		Entrant entrant = new Entrant("a1", "a1", (Faculty) facultyRepo,
				Arrays.asList(Subjects.ENGLISH, Subjects.GEOGRAPHY));
		Entrant entrant2 = new Entrant("a2", "a2", (Faculty) facultyRepo,
				Arrays.asList(Subjects.ENGLISH, Subjects.GEOGRAPHY));
		entrantRepository.saveAll(Arrays.asList(entrant, entrant2));

		entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(2));

		Entrant entrantFromDB = entrants.get(0);
		Entrant entrantFromDB2 = entrants.get(1);

		assertTrue(entrantFromDB.equals(entrant));
		assertTrue(entrantFromDB.getId().equals(entrant.getId()));
		assertTrue(entrantFromDB.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDB.getLastName().equals(entrant.getLastName()));
		assertTrue(entrantFromDB.getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrantFromDB.getSubjects().equals(entrant.getSubjects()));

		assertTrue(entrantFromDB2.equals(entrant2));
		assertTrue(entrantFromDB2.getId().equals(entrant2.getId()));
		assertTrue(entrantFromDB2.getFirstName().equals(entrant2.getFirstName()));
		assertTrue(entrantFromDB2.getLastName().equals(entrant2.getLastName()));
		assertTrue(entrantFromDB2.getFaculty().equals(entrant2.getFaculty()));
		assertTrue(entrantFromDB2.getSubjects().equals(entrant2.getSubjects()));
	}

	@Test
	public void testSortedEntants() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));

		Entrant entrant = new Entrant("a1", "a1", (Faculty) facultyRepo,
				Arrays.asList(Subjects.ENGLISH, Subjects.GEOGRAPHY));
		Entrant entrant2 = new Entrant("a2", "a2", (Faculty) facultyRepo,
				Arrays.asList(Subjects.ENGLISH, Subjects.GEOGRAPHY));
		entrantRepository.saveAll(Arrays.asList(entrant, entrant2));

		entrants = entrantRepository.findAll(Sort.by(Sort.Direction.DESC, "totalMark"));
		assertThat(entrants, hasSize(2));

		Entrant entrantFromDB = entrants.get(0);
		Entrant entrantFromDB2 = entrants.get(1);

		assertTrue(entrantFromDB.equals(entrant));
		assertTrue(entrantFromDB.getId().equals(entrant.getId()));
		assertTrue(entrantFromDB.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDB.getLastName().equals(entrant.getLastName()));
		assertTrue(entrantFromDB.getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrantFromDB.getSubjects().equals(entrant.getSubjects()));

		assertTrue(entrantFromDB2.equals(entrant2));
		assertTrue(entrantFromDB2.getId().equals(entrant2.getId()));
		assertTrue(entrantFromDB2.getFirstName().equals(entrant2.getFirstName()));
		assertTrue(entrantFromDB2.getLastName().equals(entrant2.getLastName()));
		assertTrue(entrantFromDB2.getFaculty().equals(entrant2.getFaculty()));
		assertTrue(entrantFromDB2.getSubjects().equals(entrant2.getSubjects()));
	}

	
	
}
