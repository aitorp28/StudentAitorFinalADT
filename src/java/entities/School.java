/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aitor
 */
@Entity
@Table(name="SCHOOL", schema="studentdb")
@XmlRootElement
public class School implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private SchoolType type;
    
    @OneToMany(cascade = ALL, mappedBy="school")
    private List<Student> students;
    
    @OneToMany(cascade = ALL, mappedBy="school")
    private List<SchoolSubject> subjects;
    
    
}
