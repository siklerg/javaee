package hu.zerotohero.example.javaee.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone extends BaseEntity {

    @Basic
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Basic
    @Column(name = "PHONE_NUMBER", length = 30)
    private String number;

    @ManyToOne
    private Person person;

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Phone phone = (Phone) o;
        return getType() == phone.getType() &&
                Objects.equals(getNumber(), phone.getNumber()) &&
                Objects.equals(getPerson(), phone.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType(), getNumber(), getPerson());
    }
}
