package hu.zerotohero.example.javaee.service;

import hu.zerotohero.example.javaee.dao.BaseDao;
import hu.zerotohero.example.javaee.dao.PhoneDao;
import hu.zerotohero.example.javaee.model.Person;
import hu.zerotohero.example.javaee.model.Phone;
import hu.zerotohero.example.javaee.model.PhoneType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class PhoneService {

    @Inject
    BaseDao baseDao;

    @Inject
    PhoneDao phoneDao;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addPhone(String phoneType, String phoneNumber) {
        Phone phone = new Phone();
        phone.setPerson(person);
        phone.setType(PhoneType.valueOf(phoneType));
        phone.setNumber(phoneNumber);
        baseDao.save(phone);
    }

    public List<Phone> getPhones() {
        return phoneDao.getPhonesByPerson(person);
    }

    @Transactional
    public void deletePhone(Phone phone) {
        System.out.println("Delete clicked...");
        phoneDao.deletePhone(phone);
    }
}
