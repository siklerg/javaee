package hu.zerotohero.example.javaee.service;

import hu.zerotohero.example.javaee.dao.BaseDao;
import hu.zerotohero.example.javaee.dao.PhoneDao;
import hu.zerotohero.example.javaee.model.Person;
import hu.zerotohero.example.javaee.model.Phone;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
public class PersonService {
    @Inject
    private BaseDao baseDao;

    @Inject
    private PhoneDao phoneDao;

    public void addPerson(String name, Date birthday) {
        Person person = new Person();
        person.setName(name.trim());
        person.setBirthday(birthday);
        baseDao.save(person);
    }

    public String deletePerson(Person person) {
        System.out.println("---> " + person.getId() + " id-s person törlése by Service");
        List<Phone> phones = phoneDao.getPhonesByPerson(person);
        System.out.println("---> Telefonszámok száma: " + phones.size());
        if (!phones.isEmpty()) {
            for (Phone phone : phones
            ) {
                phoneDao.deletePhone(phone);
            }
        }
        baseDao.deletePerson(person);
        return null;
    }

    public List<Person> getPersons() {
        return baseDao.query(Person.class, Person.NQ_FIND_ALL_PERSONS);
    }

    public Person getPersonByName(String name) {
        return baseDao.queryWithNameParameter(Person.class, Person.NQ_FIND_PERSON_BY_NAME, name);
    }

    public Person getPersonById(Long id) {
        return baseDao.queryWithIdParameter(Person.class, Person.NQ_FIND_PERSON_BY_ID, id);
    }
}
