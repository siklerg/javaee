package hu.zerotohero.example.javaee.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NamedQueries({ @NamedQuery(name = Person.NQ_FIND_ALL_PERSONS, query = "select p from Person p"),
        @NamedQuery(name = Person.NQ_DELETE_PERSONS, query = "delete from Person"),
        @NamedQuery(name = Person.NQ_FIND_PERSON_BY_NAME, query = "select p from Person p where p.name=:name "),
        @NamedQuery(name = Person.NQ_FIND_PERSON_BY_ID, query = "select p from Person p where p.id=:id "),
        @NamedQuery(name = Person.NQ_DELETE_PHONES_WITH_PERSON, query = "delete from Phone where person=:person ")}
)
@Entity
public class Person extends BaseEntity {
    public static final String NQ_FIND_ALL_PERSONS = "person.findAll";
    public static final String NQ_DELETE_PERSONS = "person.deleteAll";
    public static final String NQ_FIND_PERSON_BY_NAME = "person.findByName";
    public static final String NQ_FIND_PERSON_BY_ID = "person.findById";
    public static final String NQ_DELETE_PHONES_WITH_PERSON = "person.deletePhonesForPerson";

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

    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private Collection<Phone> phones;
}
