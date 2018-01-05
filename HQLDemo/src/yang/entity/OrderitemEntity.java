package yang.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderitem", schema = "webshop", catalog = "")
public class OrderitemEntity {
    private int id;
    private Double discount;
    private Double actprice;
    private Double amount;

    private OrderformEntity order;
    private CommodityEntity commodity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(table = "oderform",name = "Id")
    @Column(name = "ORDERID")
    public OrderformEntity getOrder() {
        return order;
    }

    public void setOrder(OrderformEntity order) {
        this.order = order;
    }


    public CommodityEntity getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityEntity commodity) {
        this.commodity = commodity;
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
    @Column(name = "DISCOUNT")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "ACTPRICE")
    public Double getActprice() {
        return actprice;
    }

    public void setActprice(Double actprice) {
        this.actprice = actprice;
    }

    @Basic
    @Column(name = "AMOUNT")
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
        OrderitemEntity that = (OrderitemEntity) o;
        return id == that.id &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(actprice, that.actprice) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(order, that.order) &&
                Objects.equals(commodity, that.commodity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, discount, actprice, amount, order, commodity);
    }
}
