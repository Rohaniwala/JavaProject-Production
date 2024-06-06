/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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

/**
 *
 * @author rohan
 */
@Entity
@Table(name = "CartTB")
@NamedQueries({
    @NamedQuery(name = "CartTB.findAll", query = "SELECT c FROM CartTB c"),
    @NamedQuery(name = "CartTB.findByCartID", query = "SELECT c FROM CartTB c WHERE c.cartID = :cartID"),
    @NamedQuery(name = "CartTB.findByUserID", query = "SELECT c FROM CartTB c WHERE c.userID = :userID"),
    @NamedQuery(name = "CartTB.findByQuantity", query = "SELECT c FROM CartTB c WHERE c.quantity = :quantity")})
public class CartTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CartID")
    private Integer cartID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "ProductID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private ProductTB productID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private UserTB userID;

    public CartTB() {
    }

    public CartTB(Integer cartID) {
        this.cartID = cartID;
    }

    public CartTB(Integer cartID, int quantity) {
        this.cartID = cartID;
        this.quantity = quantity;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductTB getProductID() {
        return productID;
    }

    public void setProductID(ProductTB productID) {
        this.productID = productID;
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
        hash += (cartID != null ? cartID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartTB)) {
            return false;
        }
        CartTB other = (CartTB) object;
        if ((this.cartID == null && other.cartID != null) || (this.cartID != null && !this.cartID.equals(other.cartID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CartTB[ cartID=" + cartID + " ]";
    }
    
}
