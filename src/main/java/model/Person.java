package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NamedQueries(
		@NamedQuery(name = Person.NQ_FIND_ALL_PERSONS, query = "select p from Person p")
)
@Entity
public class Person extends BaseEntity {
	public static final String NQ_FIND_ALL_PERSONS = "person.findAll";

	@Basic
	private String name;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date birthday;

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
