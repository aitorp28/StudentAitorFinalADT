/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aitor
 */
@NamedQueries({
    @NamedQuery(name="VisualizarAsignaturas",
            query="SELECT s.school FROM SchoolSubject s WHERE s.subject.name=:nombre"),
})
@Entity
@Table(name="SCHOOLSUBJECT", schema="studentdb")
@XmlRootElement
public class SchoolSubject implements Serializable{
    
    @EmbeddedId
    private SchoolSubjectId idSchoolSubject;
    
    @MapsId("schoolId")
    @ManyToOne
    private School school;
    
    @MapsId("subjectId")
    @ManyToOne
    private Subject subject;

    public SchoolSubjectId getIdSchoolSubject() {
        return idSchoolSubject;
    }

    public void setIdSchoolSubject(SchoolSubjectId idSchoolSubject) {
        this.idSchoolSubject = idSchoolSubject;
    }

    @XmlTransient
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idSchoolSubject);
        hash = 97 * hash + Objects.hashCode(this.school);
        hash = 97 * hash + Objects.hashCode(this.subject);
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
        final SchoolSubject other = (SchoolSubject) obj;
        if (!Objects.equals(this.idSchoolSubject, other.idSchoolSubject)) {
            return false;
        }
        if (!Objects.equals(this.school, other.school)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SchoolSubject{" + "idSchoolSubject=" + idSchoolSubject + ", school=" + school + ", subject=" + subject + '}';
    }
    
    
    
}
