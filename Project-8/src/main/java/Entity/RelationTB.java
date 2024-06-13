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

/**
 *
 * @author rohan
 */
@Entity
@Table(name = "RelationTB")
@NamedQueries({
    @NamedQuery(name = "RelationTB.findAll", query = "SELECT r FROM RelationTB r"),  
    @NamedQuery(name = "RelationTB.findByUid", query = "SELECT r FROM RelationTB r WHERE r.userID = :userID"),
    @NamedQuery(name = "RelationTB.findByRelationID", query = "SELECT r FROM RelationTB r WHERE r.relationID = :relationID")})
public class RelationTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RelationID")
    private Integer relationID;
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    @ManyToOne(optional = false)
    private CompanyTB companyID;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private RoleTB roleID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private UserTB userID;

    public RelationTB() {
    }

    public RelationTB(Integer relationID) {
        this.relationID = relationID;
    }

    public Integer getRelationID() {
        return relationID;
    }

    public void setRelationID(Integer relationID) {
        this.relationID = relationID;
    }

    public CompanyTB getCompanyID() {
        return companyID;
    }

    public void setCompanyID(CompanyTB companyID) {
        this.companyID = companyID;
    }

    public RoleTB getRoleID() {
        return roleID;
    }

    public void setRoleID(RoleTB roleID) {
        this.roleID = roleID;
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
        hash += (relationID != null ? relationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationTB)) {
            return false;
        }
        RelationTB other = (RelationTB) object;
        if ((this.relationID == null && other.relationID != null) || (this.relationID != null && !this.relationID.equals(other.relationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RelationTB[ relationID=" + relationID + " ]";
    }
    
}
