package com.vladeks.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "contacts", schema = "sample", catalog = "")
public class ContactsEntity {
    private int id;
    private String tel;
    private String email;
    private EmployeeEntity employeesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsEntity that = (ContactsEntity) o;

        if (id != that.id) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "contacts")
    public EmployeeEntity getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(EmployeeEntity employeesById) {
        this.employeesById = employeesById;
    }

    @Override
    public String toString() {
        return "ContactsEntity{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", employeesById=" + employeesById +
                '}';
    }
}
