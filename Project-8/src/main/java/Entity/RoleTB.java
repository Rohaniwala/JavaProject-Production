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
@Table(name = "RoleTB")
@NamedQueries({
    @NamedQuery(name = "RoleTB.findAll", query = "SELECT r FROM RoleTB r"),
    @NamedQuery(name = "RoleTB.findByRoleID", query = "SELECT r FROM RoleTB r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "RoleTB.findByRolename", query = "SELECT r FROM RoleTB r WHERE r.rolename = :rolename")})
public class RoleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Rolename")
    private String rolename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<RelationTB> relationTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<UserTB> userTBCollection;

    public RoleTB() {
    }

    public RoleTB(Integer roleID) {
        this.roleID = roleID;
    }

    public RoleTB(Integer roleID, String rolename) {
        this.roleID = roleID;
        this.rolename = rolename;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
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
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    @JsonbTransient
    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTB)) {
            return false;
        }
        RoleTB other = (RoleTB) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RoleTB[ roleID=" + roleID + " ]";
    }
    
}
