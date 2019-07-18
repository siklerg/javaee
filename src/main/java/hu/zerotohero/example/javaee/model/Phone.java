package hu.zerotohero.example.javaee.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
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
}
