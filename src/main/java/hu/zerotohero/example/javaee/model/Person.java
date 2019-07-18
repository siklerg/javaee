package hu.zerotohero.example.javaee.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NamedQueries({ @NamedQuery(name = Person.NQ_FIND_ALL_PERSONS, query = "select p from Person p"),
        @NamedQuery(name = Person.NQ_DELETE_PERSONS, query = "delete from Person"),
        @NamedQuery(name = Person.NQ_FIND_PERSON_BY_NAME, query = "select p from Person p where p.name=:name ")}
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
}
