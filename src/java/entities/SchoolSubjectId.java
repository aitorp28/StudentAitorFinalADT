/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author aitor
 */
@Embeddable
public class SchoolSubjectId implements Serializable{
    
    private Integer schoolId;
    private Integer subjectId;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.schoolId);
        hash = 13 * hash + Objects.hashCode(this.subjectId);
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
        final SchoolSubjectId other = (SchoolSubjectId) obj;
        if (!Objects.equals(this.schoolId, other.schoolId)) {
            return false;
        }
        if (!Objects.equals(this.subjectId, other.subjectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SchoolSubjectId{" + "schoolId=" + schoolId + ", subjectId=" + subjectId + '}';
    }
    
    
}
