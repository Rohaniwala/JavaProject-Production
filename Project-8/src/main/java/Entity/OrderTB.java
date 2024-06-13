/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Entity.*;
import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rohan
 */
@Entity
@Table(name = "OrderTB")
@NamedQueries({
    @NamedQuery(name = "OrderTB.findAll", query = "SELECT o FROM OrderTB o"),
    @NamedQuery(name = "OrderTB.findByOrderID", query = "SELECT o FROM OrderTB o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderTB.findByUserID", query = "SELECT o FROM OrderTB o WHERE o.userID = :userID"),
    @NamedQuery(name = "OrderTB.findByOrderStatus", query = "SELECT o FROM OrderTB o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "OrderTB.findByOrderdate", query = "SELECT o FROM OrderTB o WHERE o.orderdate = :orderdate")})
public class OrderTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Orderdate")
    private String orderdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<BillingTB> billingTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<OrderDetailsTB> orderDetailsTBCollection;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private UserTB userID;

    public OrderTB() {
    }

    public OrderTB(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderTB(Integer orderID, String orderStatus, String orderdate) {
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.orderdate = orderdate;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderdate() {
        return orderdate;
    }

    
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    @JsonbTransient
    public Collection<BillingTB> getBillingTBCollection() {
        return billingTBCollection;
    }

    @JsonbTransient
    public void setBillingTBCollection(Collection<BillingTB> billingTBCollection) {
        this.billingTBCollection = billingTBCollection;
    }

    @JsonbTransient
    public Collection<OrderDetailsTB> getOrderDetailsTBCollection() {
        return orderDetailsTBCollection;
    }

    @JsonbTransient
    public void setOrderDetailsTBCollection(Collection<OrderDetailsTB> orderDetailsTBCollection) {
        this.orderDetailsTBCollection = orderDetailsTBCollection;
    }

    public UserTB getUserID() {
        return userID;
    }

    public void setUserID(UserTB userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTB)) {
            return false;
        }
        OrderTB other = (OrderTB) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderTB[ orderID=" + orderID + " ]";
    }
    
}
