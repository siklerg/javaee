package hu.zerotohero.example.javaee.dao;

import hu.zerotohero.example.javaee.model.BaseEntity;
import hu.zerotohero.example.javaee.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class BaseDao {

	@PersistenceContext
	private EntityManager entityManager;

    private static final Logger logger
            = LoggerFactory.getLogger(BaseDao.class);

	public <E extends BaseEntity> List<E> query(Class<E> entityClass, String queryName) {
		return entityManager.createNamedQuery(queryName, entityClass).getResultList();
	}

	public Person queryWithNameParameter(Class<Person> entityClass, String queryName, String name) {
		return entityManager.createNamedQuery(queryName, entityClass).setParameter("name", name).getSingleResult();
	}

    public Person queryWithIdParameter(Class<Person> entityClass, String queryName, Long id) {
        return entityManager.createNamedQuery(queryName, entityClass).setParameter("id", id).getSingleResult();
    }


	public <E extends BaseEntity> E save(E entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
			return entity;
		} else {
			return entityManager.merge(entity);
		}
	}

    public <E extends BaseEntity> E find(Class<E> entityClass, Long id) {
        return entityManager.find(entityClass, id);
    }

    @Transactional
    public void deletePerson(Person person) {
        logger.info("---> " + person.getId() + " id-s person törlése by DAO");
        entityManager.remove(entityManager.find(Person.class, person.getId()));
    }

}
