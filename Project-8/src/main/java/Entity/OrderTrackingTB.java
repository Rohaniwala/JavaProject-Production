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
@Table(name = "OrderTrackingTB")
@NamedQueries({
    @NamedQuery(name = "OrderTrackingTB.findAll", query = "SELECT o FROM OrderTrackingTB o"),
    @NamedQuery(name = "OrderTrackingTB.findByOrdertrackID", query = "SELECT o FROM OrderTrackingTB o WHERE o.ordertrackID = :ordertrackID"),
    @NamedQuery(name = "OrderTrackingTB.findByOrderdetailsID", query = "SELECT o FROM OrderTrackingTB o WHERE o.orderdetailsID = :orderdetailsID"),
    @NamedQuery(name = "OrderTrackingTB.findByPlace", query = "SELECT o FROM OrderTrackingTB o WHERE o.place = :place"),
    @NamedQuery(name = "OrderTrackingTB.findByStartingDate", query = "SELECT o FROM OrderTrackingTB o WHERE o.startingDate = :startingDate"),
    @NamedQuery(name = "OrderTrackingTB.findByEndingDate", query = "SELECT o FROM OrderTrackingTB o WHERE o.endingDate = :endingDate"),
    @NamedQuery(name = "OrderTrackingTB.findByDescription", query = "SELECT o FROM OrderTrackingTB o WHERE o.description = :description")})
public class OrderTrackingTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrdertrackID")
    private Integer ordertrackID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "StartingDate")
    private String startingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EndingDate")
    private String endingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "OrderdetailsID", referencedColumnName = "OdetailsID")
    @ManyToOne(optional = false)
    private OrderDetailsTB orderdetailsID;
    @JoinColumn(name = "StageID", referencedColumnName = "StageID")
    @ManyToOne(optional = false)
    private StagemasterTB stageID;

    public OrderTrackingTB() {
    }

    public OrderTrackingTB(Integer ordertrackID) {
        this.ordertrackID = ordertrackID;
    }

    public OrderTrackingTB(Integer ordertrackID, String place, String startingDate, String endingDate, String description) {
        this.ordertrackID = ordertrackID;
        this.place = place;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.description = description;
    }

    public Integer getOrdertrackID() {
        return ordertrackID;
    }

    public void setOrdertrackID(Integer ordertrackID) {
        this.ordertrackID = ordertrackID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderDetailsTB getOrderdetailsID() {
        return orderdetailsID;
    }

    public void setOrderdetailsID(OrderDetailsTB orderdetailsID) {
        this.orderdetailsID = orderdetailsID;
    }

    public StagemasterTB getStageID() {
        return stageID;
    }

    public void setStageID(StagemasterTB stageID) {
        this.stageID = stageID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordertrackID != null ? ordertrackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTrackingTB)) {
            return false;
        }
        OrderTrackingTB other = (OrderTrackingTB) object;
        if ((this.ordertrackID == null && other.ordertrackID != null) || (this.ordertrackID != null && !this.ordertrackID.equals(other.ordertrackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderTrackingTB[ ordertrackID=" + ordertrackID + " ]";
    }
    
}
