package com.vladeks.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee", schema = "sample", catalog = "")
public class EmployeeEntity {
    private int id;
    private String firstName;
    private String lastName;
    private int contactsId;
    private Set<AddressEntity> addresses = new HashSet<>();
    private ContactsEntity contacts;
    private Set<CarsEntity> cars = new HashSet<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "contacts_id", insertable = false, updatable = false)
    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (contactsId != that.contactsId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + contactsId;
        return result;
    }

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL )
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts_id", referencedColumnName = "id", nullable = false)
    public ContactsEntity getContacts() {
        return contacts;
    }

    public void setContacts(ContactsEntity contacts) {
        this.contacts = contacts;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_car", catalog = "", schema = "sample", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false))
    public Set<CarsEntity> getCars() {
        return cars;
    }

    public void setCars(Set<CarsEntity> cars) {
        this.cars = cars;
    }

    public void addCar(CarsEntity car) {
        this.cars.add(car);
    }

    public void addAddress(AddressEntity address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactsId=" + contactsId +
                ", addresses=" + addresses +
                ", contacts=" + contacts +
                ", cars=" + cars +
                '}';
    }
}
