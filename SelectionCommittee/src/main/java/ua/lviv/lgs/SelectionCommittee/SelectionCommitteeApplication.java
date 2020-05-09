package ua.lviv.lgs.SelectionCommittee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"selectionCommitee"})
public class SelectionCommitteeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelectionCommitteeApplication.class, args);
	}

}
