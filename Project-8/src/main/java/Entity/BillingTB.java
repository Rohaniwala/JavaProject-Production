/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Entity.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rohan
 */
@Entity
@Table(name = "BillingTB")
@NamedQueries({
    @NamedQuery(name = "BillingTB.findAll", query = "SELECT b FROM BillingTB b"),
    @NamedQuery(name = "BillingTB.findByBillID", query = "SELECT b FROM BillingTB b WHERE b.billID = :billID"),
    @NamedQuery(name = "BillingTB.findByOrderID", query = "SELECT b FROM BillingTB b WHERE b.orderID = :orderID"),
    @NamedQuery(name = "BillingTB.findByBillDate", query = "SELECT b FROM BillingTB b WHERE b.billDate = :billDate"),
    @NamedQuery(name = "BillingTB.findByDeliveryDate", query = "SELECT b FROM BillingTB b WHERE b.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "BillingTB.findByTotalPrice", query = "SELECT b FROM BillingTB b WHERE b.totalPrice = :totalPrice")})
public class BillingTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BillID")
    private Integer billID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BillDate")
    private String billDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DeliveryDate")
    private String deliveryDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice")
    private float totalPrice;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private OrderTB orderID;

    public BillingTB() {
    }

    public BillingTB(Integer billID) {
        this.billID = billID;
    }

    public BillingTB(Integer billID, String billDate, String deliveryDate, float totalPrice) {
        this.billID = billID;
        this.billDate = billDate;
        this.deliveryDate = deliveryDate;
        this.totalPrice = totalPrice;
    }

    public Integer getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderTB getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTB orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billID != null ? billID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillingTB)) {
            return false;
        }
        BillingTB other = (BillingTB) object;
        if ((this.billID == null && other.billID != null) || (this.billID != null && !this.billID.equals(other.billID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BillingTB[ billID=" + billID + " ]";
    }

}
