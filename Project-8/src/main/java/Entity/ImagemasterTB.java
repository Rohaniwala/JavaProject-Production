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
@Table(name = "ImagemasterTB")
@NamedQueries({
    @NamedQuery(name = "ImagemasterTB.findAll", query = "SELECT i FROM ImagemasterTB i"),
    @NamedQuery(name = "ImagemasterTB.findByImageID", query = "SELECT i FROM ImagemasterTB i WHERE i.imageID = :imageID"),
    @NamedQuery(name = "ImagemasterTB.findByImageurl", query = "SELECT i FROM ImagemasterTB i WHERE i.imageurl = :imageurl"),
    @NamedQuery(name = "ImagemasterTB.findByReferenceID", query = "SELECT i FROM ImagemasterTB i WHERE i.referenceID = :referenceID"),
    @NamedQuery(name = "ImagemasterTB.findByReferencename", query = "SELECT i FROM ImagemasterTB i WHERE i.referencename = :referencename")})
public class ImagemasterTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ImageID")
    private Integer imageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Imageurl")
    private String imageurl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReferenceID")
    private int referenceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Referencename")
    private String referencename;

    public ImagemasterTB() {
    }

    public ImagemasterTB(Integer imageID) {
        this.imageID = imageID;
    }

    public ImagemasterTB(Integer imageID, String imageurl, int referenceID, String referencename) {
        this.imageID = imageID;
        this.imageurl = imageurl;
        this.referenceID = referenceID;
        this.referencename = referencename;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    public String getReferencename() {
        return referencename;
    }

    public void setReferencename(String referencename) {
        this.referencename = referencename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagemasterTB)) {
            return false;
        }
        ImagemasterTB other = (ImagemasterTB) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ImagemasterTB[ imageID=" + imageID + " ]";
    }
    
}
