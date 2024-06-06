/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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
@Table(name = "productTB")
@NamedQueries({
    @NamedQuery(name = "ProductTB.findAll", query = "SELECT p FROM ProductTB p"),
    @NamedQuery(name = "ProductTB.findByProductID", query = "SELECT p FROM ProductTB p WHERE p.productID = :productID"),
    @NamedQuery(name = "ProductTB.findByProductCatID", query = "SELECT p FROM ProductTB p WHERE p.pcatID = :pcatID"),
    @NamedQuery(name = "ProductTB.findByProductname", query = "SELECT p FROM ProductTB p WHERE p.productname = :productname"),
    @NamedQuery(name = "ProductTB.findByProductdescription", query = "SELECT p FROM ProductTB p WHERE p.productdescription = :productdescription"),
    @NamedQuery(name = "ProductTB.findByProductprice", query = "SELECT p FROM ProductTB p WHERE p.productprice = :productprice"),
    @NamedQuery(name = "ProductTB.findByProductimage", query = "SELECT p FROM ProductTB p WHERE p.productimage = :productimage"),
    @NamedQuery(name = "ProductTB.findByIsimageinclude", query = "SELECT p FROM ProductTB p WHERE p.isimageinclude = :isimageinclude"),
    @NamedQuery(name = "ProductTB.findByIstextinclude", query = "SELECT p FROM ProductTB p WHERE p.istextinclude = :istextinclude"),
    @NamedQuery(name = "ProductTB.findByQuantity", query = "SELECT p FROM ProductTB p WHERE p.quantity = :quantity")})
public class ProductTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productID")
    private Integer productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "productname")
    private String productname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "productdescription")
    private String productdescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productprice")
    private float productprice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "productimage")
    private String productimage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isimageinclude")
    private boolean isimageinclude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istextinclude")
    private boolean istextinclude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<CartTB> cartTBCollection;
    @JoinColumn(name = "pcatID", referencedColumnName = "PcatID")
    @ManyToOne(optional = false)
    private ProductCategoryTB pcatID;
    @JoinColumn(name = "companyID", referencedColumnName = "CompanyID")
    @ManyToOne(optional = false)
    private CompanyTB companyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<StagemasterTB> stagemasterTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<OrderDetailsTB> orderDetailsTBCollection;

    public ProductTB() {
    }

    public ProductTB(Integer productID) {
        this.productID = productID;
    }

    public ProductTB(Integer productID, String productname, String productdescription, float productprice, String productimage, boolean isimageinclude, boolean istextinclude, int quantity) {
        this.productID = productID;
        this.productname = productname;
        this.productdescription = productdescription;
        this.productprice = productprice;
        this.productimage = productimage;
        this.isimageinclude = isimageinclude;
        this.istextinclude = istextinclude;
        this.quantity = quantity;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public float getProductprice() {
        return productprice;
    }

    public void setProductprice(float productprice) {
        this.productprice = productprice;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public boolean getIsimageinclude() {
        return isimageinclude;
    }

    public void setIsimageinclude(boolean isimageinclude) {
        this.isimageinclude = isimageinclude;
    }

    public boolean getIstextinclude() {
        return istextinclude;
    }

    public void setIstextinclude(boolean istextinclude) {
        this.istextinclude = istextinclude;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonbTransient
    public Collection<CartTB> getCartTBCollection() {
        return cartTBCollection;
    }

    @JsonbTransient
    public void setCartTBCollection(Collection<CartTB> cartTBCollection) {
        this.cartTBCollection = cartTBCollection;
    }

    public ProductCategoryTB getPcatID() {
        return pcatID;
    }

    public void setPcatID(ProductCategoryTB pcatID) {
        this.pcatID = pcatID;
    }

    public CompanyTB getCompanyID() {
        return companyID;
    }

    public void setCompanyID(CompanyTB companyID) {
        this.companyID = companyID;
    }

    @JsonbTransient
    public Collection<StagemasterTB> getStagemasterTBCollection() {
        return stagemasterTBCollection;
    }

    @JsonbTransient
    public void setStagemasterTBCollection(Collection<StagemasterTB> stagemasterTBCollection) {
        this.stagemasterTBCollection = stagemasterTBCollection;
    }

    @JsonbTransient
    public Collection<OrderDetailsTB> getOrderDetailsTBCollection() {
        return orderDetailsTBCollection;
    }
    
    @JsonbTransient
    public void setOrderDetailsTBCollection(Collection<OrderDetailsTB> orderDetailsTBCollection) {
        this.orderDetailsTBCollection = orderDetailsTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductTB)) {
            return false;
        }
        ProductTB other = (ProductTB) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProductTB[ productID=" + productID + " ]";
    }
    
}
