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
@Table(name = "OrderDetailsTB")
@NamedQueries({
    @NamedQuery(name = "OrderDetailsTB.findAll", query = "SELECT o FROM OrderDetailsTB o"),
    @NamedQuery(name = "OrderDetailsTB.findByOdetailsID", query = "SELECT o FROM OrderDetailsTB o WHERE o.odetailsID = :odetailsID"),
    @NamedQuery(name = "OrderDetailsTB.findByOrderID", query = "SELECT o FROM OrderDetailsTB o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderDetailsTB.findByCustomizeImage", query = "SELECT o FROM OrderDetailsTB o WHERE o.customizeImage = :customizeImage"),
    @NamedQuery(name = "OrderDetailsTB.findByCustomizetext", query = "SELECT o FROM OrderDetailsTB o WHERE o.customizetext = :customizetext"),
    @NamedQuery(name = "OrderDetailsTB.findByOrderdate", query = "SELECT o FROM OrderDetailsTB o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "OrderDetailsTB.findByQuantity", query = "SELECT o FROM OrderDetailsTB o WHERE o.quantity = :quantity")})
public class OrderDetailsTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OdetailsID")
    private Integer odetailsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CustomizeImage")
    private String customizeImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Customizetext")
    private String customizetext;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Orderdate")
    private String orderdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderdetailsID")
    private Collection<OrderTrackingTB> orderTrackingTBCollection;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private OrderTB orderID;
    @JoinColumn(name = "ProductID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private ProductTB productID;

    public OrderDetailsTB() {
    }

    public OrderDetailsTB(Integer odetailsID) {
        this.odetailsID = odetailsID;
    }

    public OrderDetailsTB(Integer odetailsID, String customizeImage, String customizetext, String orderdate, int quantity) {
        this.odetailsID = odetailsID;
        this.customizeImage = customizeImage;
        this.customizetext = customizetext;
        this.orderdate = orderdate;
        this.quantity = quantity;
    }

    public Integer getOdetailsID() {
        return odetailsID;
    }

    public void setOdetailsID(Integer odetailsID) {
        this.odetailsID = odetailsID;
    }

    public String getCustomizeImage() {
        return customizeImage;
    }

    public void setCustomizeImage(String customizeImage) {
        this.customizeImage = customizeImage;
    }

    public String getCustomizetext() {
        return customizetext;
    }

    public void setCustomizetext(String customizetext) {
        this.customizetext = customizetext;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonbTransient
    public Collection<OrderTrackingTB> getOrderTrackingTBCollection() {
        return orderTrackingTBCollection;
    }
    
    @JsonbTransient
    public void setOrderTrackingTBCollection(Collection<OrderTrackingTB> orderTrackingTBCollection) {
        this.orderTrackingTBCollection = orderTrackingTBCollection;
    }

    public OrderTB getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTB orderID) {
        this.orderID = orderID;
    }

    public ProductTB getProductID() {
        return productID;
    }

    public void setProductID(ProductTB productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odetailsID != null ? odetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetailsTB)) {
            return false;
        }
        OrderDetailsTB other = (OrderDetailsTB) object;
        if ((this.odetailsID == null && other.odetailsID != null) || (this.odetailsID != null && !this.odetailsID.equals(other.odetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderDetailsTB[ odetailsID=" + odetailsID + " ]";
    }
    
}
