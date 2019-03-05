package com.vladeks.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "sample", catalog = "")
public class AddressEntity {
    private int adId;
    private String street;
    private String city;
    private EmployeeEntity employee;

    @Id
    @Column(name = "ad_id")
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (adId != that.adId) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adId;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "adId=" + adId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", employee=" + employee +
                '}';
    }
}
