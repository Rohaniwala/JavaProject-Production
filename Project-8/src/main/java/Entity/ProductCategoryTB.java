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
@Table(name = "ProductCategoryTB")
@NamedQueries({
    @NamedQuery(name = "ProductCategoryTB.findAll", query = "SELECT p FROM ProductCategoryTB p"),
    @NamedQuery(name = "ProductCategoryTB.findByPcatID", query = "SELECT p FROM ProductCategoryTB p WHERE p.pcatID = :pcatID"),
    @NamedQuery(name = "ProductCategoryTB.findByPcatname", query = "SELECT p FROM ProductCategoryTB p WHERE p.pcatname = :pcatname"),
    @NamedQuery(name = "ProductCategoryTB.findByPcatdescription", query = "SELECT p FROM ProductCategoryTB p WHERE p.pcatdescription = :pcatdescription")})
public class ProductCategoryTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @JsonbTransient
    @Column(name = "PcatID")
    private Integer pcatID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Pcatname")
    private String pcatname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Pcatdescription")
    private String pcatdescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcatID")
    private Collection<ProductTB> productTBCollection;

    public ProductCategoryTB() {
    }

    public ProductCategoryTB(Integer pcatID) {
        this.pcatID = pcatID;
    }

    public ProductCategoryTB(Integer pcatID, String pcatname, String pcatdescription) {
        this.pcatID = pcatID;
        this.pcatname = pcatname;
        this.pcatdescription = pcatdescription;
    }

    public Integer getPcatID() {
        return pcatID;
    }

    public void setPcatID(Integer pcatID) {
        this.pcatID = pcatID;
    }

    public String getPcatname() {
        return pcatname;
    }

    public void setPcatname(String pcatname) {
        this.pcatname = pcatname;
    }

    public String getPcatdescription() {
        return pcatdescription;
    }

    public void setPcatdescription(String pcatdescription) {
        this.pcatdescription = pcatdescription;
    }

    @JsonbTransient
    public Collection<ProductTB> getProductTBCollection() {
        return productTBCollection;
    }

    @JsonbTransient
    public void setProductTBCollection(Collection<ProductTB> productTBCollection) {
        this.productTBCollection = productTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcatID != null ? pcatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategoryTB)) {
            return false;
        }
        ProductCategoryTB other = (ProductCategoryTB) object;
        if ((this.pcatID == null && other.pcatID != null) || (this.pcatID != null && !this.pcatID.equals(other.pcatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProductCategoryTB[ pcatID=" + pcatID + " ]";
    }
    
}
