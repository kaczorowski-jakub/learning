package com.os.udemy.jpa.programmer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmers_projects", 
    joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
    
    public void addProject(Project project) {
        if (projects == null) {
            projects = new HashSet<>();
        }
        project.addProgrammer(this);
        projects.add(project);
    }
}
