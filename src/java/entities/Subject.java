/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aitor
 */
@Entity
@Table(name="SUBJECT", schema="studentdb")
@XmlRootElement
public class Subject implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer credits;
    
    @OneToMany(cascade=ALL, mappedBy="subject")
    private List<SchoolSubject> schools;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @XmlTransient
    public List<SchoolSubject> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolSubject> schools) {
        this.schools = schools;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.credits);
        hash = 47 * hash + Objects.hashCode(this.schools);
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
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.credits, other.credits)) {
            return false;
        }
        if (!Objects.equals(this.schools, other.schools)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + ", credits=" + credits + ", schools=" + schools + '}';
    }
    
    
    
}
