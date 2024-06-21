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
@Table(name = "UserTB")
@NamedQueries({
    @NamedQuery(name = "UserTB.findAll", query = "SELECT u FROM UserTB u"),
    @NamedQuery(name = "UserTB.findByUserID", query = "SELECT u FROM UserTB u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserTB.findByUsername", query = "SELECT u FROM UserTB u WHERE u.username = :username"),
    @NamedQuery(name = "UserTB.findIDByUsername", query = "SELECT u.userID FROM UserTB u WHERE u.username = :username"),
    @NamedQuery(name = "UserTB.findByUseremail", query = "SELECT u FROM UserTB u WHERE u.useremail = :useremail"),
    @NamedQuery(name = "UserTB.findByPassword", query = "SELECT u FROM UserTB u WHERE u.password = :password"),
    @NamedQuery(name = "UserTB.findByGender", query = "SELECT u FROM UserTB u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserTB.findByDob", query = "SELECT u FROM UserTB u WHERE u.dob = :dob"),
    @NamedQuery(name = "UserTB.findByAddress", query = "SELECT u FROM UserTB u WHERE u.address = :address"),
    @NamedQuery(name = "UserTB.findByMobileno", query = "SELECT u FROM UserTB u WHERE u.mobileno = :mobileno")})
public class UserTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Useremail")
    private String useremail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DOB")
    private String dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Mobileno")
    private String mobileno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<RelationTB> relationTBCollection;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private RoleTB roleID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<CartTB> cartTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<OrderTB> orderTBCollection;

    public UserTB() {
    }

    public UserTB(Integer userID) {
        this.userID = userID;
    }

    public UserTB(Integer userID, String username, String useremail, String password, String gender, String dob, String address, String mobileno) {
        this.userID = userID;
        this.username = username;
        this.useremail = useremail;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.mobileno = mobileno;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @JsonbTransient
    public Collection<RelationTB> getRelationTBCollection() {
        return relationTBCollection;
    }

    @JsonbTransient
    public void setRelationTBCollection(Collection<RelationTB> relationTBCollection) {
        this.relationTBCollection = relationTBCollection;
    }

    public RoleTB getRoleID() {
        return roleID;
    }

    public void setRoleID(RoleTB roleID) {
        this.roleID = roleID;
    }

    @JsonbTransient
    public Collection<CartTB> getCartTBCollection() {
        return cartTBCollection;
    }

    @JsonbTransient
    public void setCartTBCollection(Collection<CartTB> cartTBCollection) {
        this.cartTBCollection = cartTBCollection;
    }

    @JsonbTransient
    public Collection<OrderTB> getOrderTBCollection() {
        return orderTBCollection;
    }

    @JsonbTransient
    public void setOrderTBCollection(Collection<OrderTB> orderTBCollection) {
        this.orderTBCollection = orderTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTB)) {
            return false;
        }
        UserTB other = (UserTB) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserTB[ userID=" + userID + " ]";
    }

}
