package hu.zerotohero.example.javaee.dao;

import hu.zerotohero.example.javaee.model.Person;
import hu.zerotohero.example.javaee.model.Phone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class PhoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Phone> getPhonesByPerson(Person person) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = criteriaBuilder.createQuery(Phone.class);
        Root<Phone> from = query.from(Phone.class);
        Path<Person> personField = from.get("person");
        Predicate personPredicate = criteriaBuilder.equal(personField, person);
        query.where(personPredicate);
        return entityManager.createQuery(query).getResultList();
    }

}
