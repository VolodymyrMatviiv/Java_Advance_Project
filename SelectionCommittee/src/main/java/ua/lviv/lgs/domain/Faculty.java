package ua.lviv.lgs.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "faculty_name")
	private FacultyName name;
	
	@Column(name = "qty_of_students")
	private int qtyOfStudents;
	
	@ElementCollection
	private List<Subjects> subjects;

	public Faculty() {
	}

	public Faculty(int qtyOfStudents, FacultyName name, List<Subjects> subjects) {

		this.qtyOfStudents = qtyOfStudents;
		this.name = name;
		this.subjects = subjects;
	}

	public Faculty(Integer id, int qtyOfStudents, FacultyName name, List<Subjects> subjects) {
		super();
		this.id = id;
		this.qtyOfStudents = qtyOfStudents;
		this.name = name;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQtyOfStudents() {
		return qtyOfStudents;
	}

	public void setQtyOfStudents(int qtyOfStudents) {
		this.qtyOfStudents = qtyOfStudents;
	}

	public FacultyName getName() {
		return name;
	}

	public void setName(FacultyName name) {
		this.name = name;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + qtyOfStudents;
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name != other.name)
			return false;
		if (qtyOfStudents != other.qtyOfStudents)
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", qtyOfStudents=" + qtyOfStudents + ", name=" + name + ", subjects=" + subjects
				+ "]";
	}

}
