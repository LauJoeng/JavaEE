package yang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "seller", schema = "webshop", catalog = "")
public class SellerEntity implements Serializable {
    private int id;
    private String name;
    private String tel;
    private String address;
    private String website;
    private Integer star;
    private String business;

    public SellerEntity(String name,String tel,String address)
    {
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public SellerEntity() {
    }

    @Id
    @Column(name = "Id")
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
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "star")
    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    @Basic
    @Column(name = "business")
    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerEntity that = (SellerEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(address, that.address) &&
                Objects.equals(website, that.website) &&
                Objects.equals(star, that.star) &&
                Objects.equals(business, that.business);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, tel, address, website, star, business);
    }
}
