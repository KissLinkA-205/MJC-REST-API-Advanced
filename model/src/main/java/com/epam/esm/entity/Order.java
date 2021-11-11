package com.epam.esm.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class {@code Order} represents order entity.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Entity
@Table(name = "orders")
@Audited
public class Order extends Identifiable {

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "gift_certificate_id")
    private GiftCertificate giftCertificate;

    public Order() {
    }

    public Order(long id, BigDecimal price, LocalDateTime purchaseTime, User user, GiftCertificate giftCertificate) {
        super(id);
        this.price = price;
        this.purchaseTime = purchaseTime;
        this.user = user;
        this.giftCertificate = giftCertificate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GiftCertificate getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(GiftCertificate giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order that = (Order) o;
        return user == that.user && giftCertificate == that.giftCertificate && Objects.equals(price, that.price)
                && Objects.equals(purchaseTime, that.purchaseTime) && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, purchaseTime, user, giftCertificate);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Order{");
        result.append("id=").append(super.getId());
        result.append(", price=").append(price);
        result.append(", purchaseTime=").append(purchaseTime);
        result.append(", user=").append(user);
        result.append(", giftCertificate=").append(giftCertificate);
        result.append('}');
        return result.toString();
    }
}
