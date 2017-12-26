package com.yang;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "hibernate", catalog = "")
public class StudentsEntity {
    private int id;
    private String name;
    private String gender;
    private String address;
    private Date birthday;
    private byte[] picture;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(address, that.address) &&
                Objects.equals(birthday, that.birthday) &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, gender, address, birthday);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
//                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
