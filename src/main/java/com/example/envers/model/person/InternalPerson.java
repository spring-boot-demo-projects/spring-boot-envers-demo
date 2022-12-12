package com.example.envers.model.person;

import com.example.envers.core.base.BaseVersionedAuditedModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "internal_person")
public class InternalPerson extends BaseVersionedAuditedModel {

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    /* Getters and setters */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
