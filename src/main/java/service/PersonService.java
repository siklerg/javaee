package service;

import dao.BaseDao;
import model.Person;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
public class PersonService {
	@Inject
	private BaseDao baseDao;

	public void addPerson(String name, Date birthday) {
		Person person = new Person();
		person.setName(name);
		person.setBirthday(birthday);
		baseDao.save(person);
	}

	public List<Person> getPersons() {
		return baseDao.query(Person.class, Person.NQ_FIND_ALL_PERSONS);
	}
}
