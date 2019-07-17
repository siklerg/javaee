package hu.zerotohero.example.javaee.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NamedQueries({ @NamedQuery(name = Person.NQ_FIND_ALL_PERSONS, query = "select p from Person p"),
		@NamedQuery(name = Person.NQ_DELETE_PERSONS, query = "delete from Person"),
		@NamedQuery(name = Person.NQ_FIND_PERSON_BY_NAME, query = "select p from Person p where p.name=:name ") }
)
@Entity
public class Person extends BaseEntity {
	public static final String NQ_FIND_ALL_PERSONS = "person.findAll";
	public static final String NQ_DELETE_PERSONS = "person.deleteAll";
	public static final String NQ_FIND_PERSON_BY_NAME = "person.findById";

	@Basic
	private String name;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date birthday;

	public Person() {
	}

	public Person(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		if (!super.equals(o)) { return false; }
		Person person = (Person) o;
		return Objects.equals(getName(), person.getName()) &&
				Objects.equals(getBirthday(), person.getBirthday());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getName(), getBirthday());
	}
}
