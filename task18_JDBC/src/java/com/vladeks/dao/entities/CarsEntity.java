package com.vladeks.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars", schema = "sample", catalog = "")
public class CarsEntity {
    private int id;
    private int year;
    private String model;
    private Set<EmployeeEntity> employees = new HashSet<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (id != that.id) return false;
        if (year != that.year) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + year;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "cars")
    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "CarsEntity{" +
                "id=" + id +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", employees=" + employees +
                '}';
    }
}
