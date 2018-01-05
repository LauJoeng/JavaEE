package yang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orderform", schema = "webshop", catalog = "")
public class OrderformEntity implements Serializable{
    private int id;
    private Date tradedate;
    private String status;
    private Double amount;

    private CustomerEntity customer;
    private Set<OrderitemEntity>orderItems = new HashSet<>();

    //多对一关系在由多方持有一方的引用，注解@joinColumn(name="") 其中name是一方对应表中的列名
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    public Set<OrderitemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderitemEntity> orderItems) {
        this.orderItems = orderItems;
    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(table = "customer",name = "Id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
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
    @Column(name = "tradedate")
    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderformEntity that = (OrderformEntity) o;
        return id == that.id &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(tradedate, that.tradedate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, tradedate, status, amount);
    }
}
