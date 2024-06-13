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
@Table(name = "StagemasterTB")
@NamedQueries({
    @NamedQuery(name = "StagemasterTB.findAll", query = "SELECT s FROM StagemasterTB s"),
    @NamedQuery(name = "StagemasterTB.findByStageID", query = "SELECT s FROM StagemasterTB s WHERE s.stageID = :stageID"),
    @NamedQuery(name = "StagemasterTB.findByProductID", query = "SELECT s FROM StagemasterTB s WHERE s.productID = :productID ORDER BY s.priority"),
    @NamedQuery(name = "StagemasterTB.findByStagename", query = "SELECT s FROM StagemasterTB s WHERE s.stagename = :stagename"),
    @NamedQuery(name = "StagemasterTB.findByStagedescription", query = "SELECT s FROM StagemasterTB s WHERE s.stagedescription = :stagedescription"),
    @NamedQuery(name = "StagemasterTB.findByPriority", query = "SELECT s FROM StagemasterTB s WHERE s.priority = :priority")})

public class StagemasterTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StageID")
    private Integer stageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Stagename")
    private String stagename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Stagedescription")
    private String stagedescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Priority")
    private int priority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageID")
    private Collection<OrderTrackingTB> orderTrackingTBCollection;
    @JoinColumn(name = "ProductID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private ProductTB productID;

    public StagemasterTB() {
    }

    public StagemasterTB(Integer stageID) {
        this.stageID = stageID;
    }

    public StagemasterTB(Integer stageID, String stagename, String stagedescription, int priority) {
        this.stageID = stageID;
        this.stagename = stagename;
        this.stagedescription = stagedescription;
        this.priority = priority;
    }

    public Integer getStageID() {
        return stageID;
    }

    public void setStageID(Integer stageID) {
        this.stageID = stageID;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

    public String getStagedescription() {
        return stagedescription;
    }

    public void setStagedescription(String stagedescription) {
        this.stagedescription = stagedescription;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @JsonbTransient
    public Collection<OrderTrackingTB> getOrderTrackingTBCollection() {
        return orderTrackingTBCollection;
    }

    @JsonbTransient
    public void setOrderTrackingTBCollection(Collection<OrderTrackingTB> orderTrackingTBCollection) {
        this.orderTrackingTBCollection = orderTrackingTBCollection;
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
        hash += (stageID != null ? stageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StagemasterTB)) {
            return false;
        }
        StagemasterTB other = (StagemasterTB) object;
        if ((this.stageID == null && other.stageID != null) || (this.stageID != null && !this.stageID.equals(other.stageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StagemasterTB[ stageID=" + stageID + " ]";
    }

}
