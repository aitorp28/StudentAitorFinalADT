/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aitor
 */
@Entity
@Table(name="STUDENT", schema="studentdb")
@XmlRootElement
public class Student implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBirth;
    private String email;
    private String fullAddress;
    private Integer telephoneNumber;
    
    @ManyToOne
    private School school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date DateBirth) {
        this.dateBirth = DateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.fullName);
        hash = 23 * hash + Objects.hashCode(this.dateBirth);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.fullAddress);
        hash = 23 * hash + Objects.hashCode(this.telephoneNumber);
        hash = 23 * hash + Objects.hashCode(this.school);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.fullAddress, other.fullAddress)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateBirth, other.dateBirth)) {
            return false;
        }
        if (!Objects.equals(this.telephoneNumber, other.telephoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.school, other.school)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullName=" + fullName + ", dateBirth=" + dateBirth + ", email=" + email + ", fullAddress=" + fullAddress + ", telephoneNumber=" + telephoneNumber + ", school=" + school + '}';
    }
    
    
    
    
}
