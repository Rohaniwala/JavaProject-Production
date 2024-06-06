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
@Table(name = "CompanyTB")
@NamedQueries({
    @NamedQuery(name = "CompanyTB.findAll", query = "SELECT c FROM CompanyTB c"),
    @NamedQuery(name = "CompanyTB.findByCompanyID", query = "SELECT c FROM CompanyTB c WHERE c.companyID = :companyID"),
    @NamedQuery(name = "CompanyTB.findByCompanyname", query = "SELECT c FROM CompanyTB c WHERE c.companyname = :companyname"),
    @NamedQuery(name = "CompanyTB.findByCompanydescription", query = "SELECT c FROM CompanyTB c WHERE c.companydescription = :companydescription"),
    @NamedQuery(name = "CompanyTB.findByContactno", query = "SELECT c FROM CompanyTB c WHERE c.contactno = :contactno"),
    @NamedQuery(name = "CompanyTB.findByCompanyemail", query = "SELECT c FROM CompanyTB c WHERE c.companyemail = :companyemail")})
public class CompanyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompanyID")
    private Integer companyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Companyname")
    private String companyname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Companydescription")
    private String companydescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Contactno")
    private String contactno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Companyemail")
    private String companyemail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<RelationTB> relationTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<ProductTB> productTBCollection;

    public CompanyTB() {
    }

    public CompanyTB(Integer companyID) {
        this.companyID = companyID;
    }

    public CompanyTB(Integer companyID, String companyname, String companydescription, String contactno, String companyemail) {
        this.companyID = companyID;
        this.companyname = companyname;
        this.companydescription = companydescription;
        this.contactno = contactno;
        this.companyemail = companyemail;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanydescription() {
        return companydescription;
    }

    public void setCompanydescription(String companydescription) {
        this.companydescription = companydescription;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail;
    }

    @JsonbTransient
    public Collection<RelationTB> getRelationTBCollection() {
        return relationTBCollection;
    }

    @JsonbTransient
    public void setRelationTBCollection(Collection<RelationTB> relationTBCollection) {
        this.relationTBCollection = relationTBCollection;
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
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyTB)) {
            return false;
        }
        CompanyTB other = (CompanyTB) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CompanyTB[ companyID=" + companyID + " ]";
    }
    
}
