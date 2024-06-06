/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package CBean;

import Entity.CartTB;
import Entity.CompanyTB;
import Entity.ProductCategoryTB;
import Entity.ProductTB;
import Entity.UserTB;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.StyledEditorKit;
import javax.ws.rs.Path;

/**
 *
 * @author rohan
 */
@Stateless
public class AdminSessionBean {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    public void addProdCat(String Pcatname, String Pcatdescription) {
        ProductCategoryTB categoryTB = new ProductCategoryTB();
        categoryTB.setPcatname(Pcatname);
        categoryTB.setPcatdescription(Pcatdescription);

        em.persist(categoryTB);
    }

    public void deleteproductcat(Integer PcatID) {
        ProductCategoryTB pctb = em.find(ProductCategoryTB.class, PcatID);
        em.remove(pctb);
    }

    public void updateCat(Integer PcatID, String Pcatname, String Pcatdescription) {
        ProductCategoryTB pctb = em.find(ProductCategoryTB.class, PcatID);
        pctb.setPcatname(Pcatname);
        pctb.setPcatdescription(Pcatdescription);
        em.merge(pctb);
    }

    public Collection<ProductCategoryTB> displayProductCat() {
        return em.createNamedQuery("ProductCategoryTB.findAll").getResultList();
    }

    public CompanyTB displayCompanyByComID(Integer CompanyID) {
        CompanyTB companyTB = em.find(CompanyTB.class, CompanyID);
        return companyTB;
    }

    public void addCompany(String cname, String cdescription, String cno, String cemail) {
        CompanyTB companyTB = new CompanyTB();

        companyTB.setCompanyname(cname);
        companyTB.setCompanydescription(cdescription);
        companyTB.setContactno(cno);
        companyTB.setCompanyemail(cemail);
        em.persist(companyTB);
    }

    public void updateCompany(Integer CompanyID, String cname, String cdescription, String cno, String cemail) {
        CompanyTB companyTB = em.find(CompanyTB.class, CompanyID);
        companyTB.setCompanyname(cname);
        companyTB.setCompanydescription(cdescription);
        companyTB.setContactno(cno);
        companyTB.setCompanyemail(cemail);
        em.merge(companyTB);
    }

    public void deleteCompnay(Integer CompanyID) {
        CompanyTB companyTB = em.find(CompanyTB.class, CompanyID);
        em.remove(companyTB);
    }

    public void addProductdata(String pname, Integer pcatID, String Prodescription, float productprice, String productimage, boolean isimageinclude, boolean istextinclude, Integer companyID, Integer quantity) {
        CompanyTB ct = em.find(CompanyTB.class, companyID);
        ProductCategoryTB pct = em.find(ProductCategoryTB.class, pcatID);

        Collection<ProductTB> cpt = ct.getProductTBCollection();
        Collection<ProductTB> cptt = pct.getProductTBCollection();

        ProductTB pTB = new ProductTB();
        pTB.setCompanyID(ct);
        pTB.setPcatID(pct);
        pTB.setProductname(pname);
        pTB.setProductdescription(Prodescription);
        pTB.setProductprice(productprice);
        pTB.setProductimage(productimage);
        pTB.setIsimageinclude(isimageinclude);
        pTB.setIstextinclude(istextinclude);
        pTB.setQuantity(quantity);

        cpt.add(pTB);
        cptt.add(pTB);

        ct.setProductTBCollection(cpt);
        pct.setProductTBCollection(cptt);

        em.persist(pTB);
        em.merge(ct);
        em.merge(pct);
    }

    public Collection<CompanyTB> DisplayCompany() {
        return em.createNamedQuery("CompanyTB.findAll").getResultList();
    }

    public void deleteProduct(Integer productID) {
        ProductTB ptb = em.find(ProductTB.class, productID);
        em.remove(ptb);
    }

    public void updateProductdata(Integer productID, String pname, Integer pcatID, String Prodescription, float productprice, String productimage,boolean isimageinclude, boolean istextinclude, Integer companyID, Integer quantity) {
        ProductTB pTB = em.find(ProductTB.class, productID);
        CompanyTB ct = em.find(CompanyTB.class, companyID);
        ProductCategoryTB pct = em.find(ProductCategoryTB.class, pcatID);
//        ProductTB pTB = new ProductTB();
        pTB.setCompanyID(ct);
        pTB.setPcatID(pct);
        pTB.setProductname(pname);
        pTB.setProductdescription(Prodescription);
        pTB.setProductprice(productprice);
        pTB.setProductimage(productimage);
        pTB.setIsimageinclude(isimageinclude);
        pTB.setIstextinclude(istextinclude);
        pTB.setQuantity(quantity);

        em.merge(pTB);

    }

    public long countofOrder(){
        TypedQuery<Long> query=em.createQuery("SELECT count(o) FROM OrderTB o",Long.class);
        return query.getSingleResult();
        
    }
    
    public double totalRevenu(){
        TypedQuery<Double> trevenu=em.createQuery("SELECT SUM(b.totalPrice) FROM BillingTB b",Double.class);
        return trevenu.getSingleResult();
    }
    
        public double AveregePprice(){
        TypedQuery<Double> avgprice=em.createQuery("SELECT AVG(p.productprice) FROM ProductTB p",Double.class);
        return avgprice.getSingleResult();
    }
//    public void updateProddata;
}
