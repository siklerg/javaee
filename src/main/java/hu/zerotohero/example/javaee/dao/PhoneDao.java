package hu.zerotohero.example.javaee.dao;

import hu.zerotohero.example.javaee.model.Person;
import hu.zerotohero.example.javaee.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class PhoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger
            = LoggerFactory.getLogger(BaseDao.class);

    public List<Phone> getPhonesByPerson(Person person) {
        System.out.println("---> getPhonesByPerson called...");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = criteriaBuilder.createQuery(Phone.class);
        Root<Phone> from = query.from(Phone.class);
        Path<Person> personField = from.get("person");
        Predicate personPredicate = criteriaBuilder.equal(personField, person);
        query.where(personPredicate);
        return entityManager.createQuery(query).getResultList();
    }

    public void deletePhone(Phone phone) {
        logger.info("---> " + phone.getId() + " id-s phone törlése by DAO");
        entityManager.remove(entityManager.contains(phone) ? phone : entityManager.merge(phone));
    }

}
