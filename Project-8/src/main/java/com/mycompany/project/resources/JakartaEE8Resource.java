package com.mycompany.project.resources;

import CBean.AdminSessionBean;
import CBean.ClientSessionBean;
import Entity.CartTB;
import Entity.CompanyTB;
import Entity.OrderDetailsTB;
import Entity.OrderTB;
import Entity.OrderTrackingTB;
import Entity.ProductCategoryTB;
import Entity.ProductTB;
import Entity.UserTB;
import java.util.Collection;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB
    ClientSessionBean sb;
    @EJB
    AdminSessionBean ab;
    
    @GET
    @Path("displayProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductTB> displayProduct() {
        return sb.displayProduct();
    }
    
    @GET
    @Path("getProductByCat/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductTB> getProductByCat(@PathParam("catId") Integer catId) {
        return sb.getProductByCat(catId);
    }
    
    @GET
    @Path("getProductByname/{pName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductTB> getProductByname(@PathParam("pName") String pName) {
        return sb.getProductByName(pName);
    }
    
    @POST
    @Path("addToCart/{UserID}/{ProductID}/{Quantity}")
    public void addToCart(@PathParam("UserID") Integer UserID, @PathParam("ProductID") Integer ProductID, @PathParam("Quantity") Integer Quantity) {
        sb.addToCart(UserID, ProductID, Quantity);
    }
    
    @POST
    @Path("updateCart/{CartID}/{Quantity}")
    public void updateCart(@PathParam("CartID") Integer CartID,@PathParam("Quantity") Integer Quantity) {
        sb.updateCart(CartID, Quantity);
    }
    
    @DELETE
    @Path("deleteCart/{CartID}")
    public void deleteCart(@PathParam("CartID") Integer CartID) {
        sb.deleteCart(CartID);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("displayUserCart/{UserID}")
    public Collection<CartTB> displayUserCart(@PathParam("UserID") Integer UserID) {
        return sb.displayUserCart(UserID);
    }
    
    @POST
    @Path("Client/placeOrder/{CartID}/{customizeImage}/{customizeText}")
    public void placeOrder(@PathParam("CartID") Integer CartID,@PathParam("customizeImage") String customizeImage,@PathParam("customizeText") String customizeText){
        sb.placeOrder(CartID, customizeImage, customizeText);
    }
    
    @DELETE
    @Path("cancelorder/{OrderID}")
    public void cancelorder(@PathParam("OrderID") Integer OrderID) {
        sb.cancelorder(OrderID);
    }
    
    @GET
    @Path("orderByUserId/{UserID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderTB> orderByUserId(@PathParam("UserID") Integer UserID) {
        return sb.orderByUserId(UserID);
    }
    
    @GET
    @Path("orderDetailsByOrderID/{OrderID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderDetailsTB> orderDetailsByOrderID(@PathParam("OrderID") Integer OrderID) {
        return sb.orderDetailsByOrderID(OrderID);
    }
    
    @GET
    @Path("orderTrackingByOrderdetailsID/{OrderdetailsID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderTrackingTB> orderTrackingByOrderdetailsID(@PathParam("OrderdetailsID") Integer OrderdetailsID) {
        return sb.orderTrackingByOrderdetailsID(OrderdetailsID);
    }
    
    @POST
    @Path("genrateBill/{OrderID}")
    public void genrateBill(@PathParam("OrderID") Integer OrderID) {
        sb.genrateBill(OrderID);
    }

    //Admin Side Product Category
    @POST
    @Path("admin/addProdCat/{Pcatname}/{Pcatdescription}")
    public void addProdCat(@PathParam("Pcatname") String Pcatname, @PathParam("Pcatdescription") String Pcatdescription) {
        ab.addProdCat(Pcatname, Pcatdescription);
    }
    
    @DELETE
    @Path("admin/deleteproduct/{PcatID}")
    public void deleteproductcat(@PathParam("PcatID") Integer PcatID) {
        ab.deleteproductcat(PcatID);
    }
    
    @POST
    @Path("admin/updateCat/{PcatID}/{Pcatname}/{Pcatdescription}")
    public void updateCat(@PathParam("PcatID") Integer PcatID, @PathParam("Pcatname") String Pcatname, @PathParam("Pcatdescription") String Pcatdescription) {
        ab.updateCat(PcatID, Pcatname, Pcatdescription);
    }
    
    @GET
    @Path("admin/displayProductCat")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductCategoryTB> displayProductCat() {
        return ab.displayProductCat();
    }
    
    @GET
    @Path("admin/displayCompanyByComID/{CompanyID}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyTB displayCompanyByComID(@PathParam("CompanyID") Integer CompanyID) {
        return ab.displayCompanyByComID(CompanyID);
    }
    
    @POST
    @Path("admin/addCompany/{cname}/{cdescription}/{cno}/{cemail}")
    public void addCompany(@PathParam("cname") String cname, @PathParam("cdescription") String cdescription, @PathParam("cno") String cno, @PathParam("cemail") String cemail) {
        ab.addCompany(cname, cdescription, cno, cemail);
    }
    
    @POST
    @Path("admin/updateCompany/{CompanyID}/{cname}/{cdescription}/{cno}/{cemail}")
    public void updateCompany(@PathParam("CompanyID") Integer CompanyID, @PathParam("cname") String cname, @PathParam("cdescription") String cdescription, @PathParam("cno") String cno, @PathParam("cemail") String cemail) {
        ab.updateCompany(CompanyID, cname, cdescription, cno, cemail);
    }
    
    @DELETE
    @Path("admin/deleteCompnay/{CompanyID}")
    public void deleteCompnay(@PathParam("CompanyID") Integer CompanyID) {
        ab.deleteCompnay(CompanyID);
    }
    
    @POST
    @Path("admin/addProductdata/{pname}/{pcatID}/{Prodescription}/{productprice}/{productimage}/{isimageinclude}/{istextinclude}/{companyID}/{quantity}")
    public void addProductdata(@PathParam("pname") String pname, @PathParam("pcatID") Integer pcatID, @PathParam("Prodescription") String Prodescription, @PathParam("productprice") float productprice, @PathParam("productimage") String productimage, @PathParam("isimageinclude") boolean isimageinclude, @PathParam("istextinclude") boolean istextinclude, @PathParam("companyID") Integer companyID, @PathParam("quantity") Integer quantity) {
        ab.addProductdata(pname, pcatID, Prodescription, productprice, productimage, isimageinclude, istextinclude, companyID, quantity);
    }
    
    @GET
    @Path("admin/DisplayCompany")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CompanyTB> DisplayCompany() {
        return ab.DisplayCompany();
    }
    
    @DELETE
    @Path("admin/deleteProduct/{productID}")
    public void deleteProduct(@PathParam("productID") Integer productID) {
        ab.deleteProduct(productID);
    }
    
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin/updateProductdata/{productID}/{pname}/{pcatID}/{Prodescription}/{productprice}/{productimage}/{isimageinclude}/{istextinclude}/{companyID}/{quantity}")
    public void updateProductdata(@PathParam("productID") Integer productID, @PathParam("pname") String pname, @PathParam("pcatID") Integer pcatID, @PathParam("Prodescription") String Prodescription, @PathParam("productprice") float productprice, @PathParam("productimage") String productimage, @PathParam("isimageinclude") boolean isimageinclude, @PathParam("istextinclude") boolean istextinclude, @PathParam("companyID") Integer companyID, @PathParam("quantity") Integer quantity) {
        ab.updateProductdata(productID, pname, pcatID, Prodescription, productprice, productimage, isimageinclude, istextinclude, companyID, quantity);
    }
    
    @POST
    @Path("userRegistration/{Username}/{Useremail}/{Password}/{Gender}/{DOB}/{Address}/{Mobileno}")
    public void userRegistration(@PathParam("Username") String Username, @PathParam("Useremail") String Useremail, @PathParam("Password") String Password,  @PathParam("Gender") String Gender, @PathParam("DOB") String DOB, @PathParam("Address") String Address, @PathParam("Mobileno") String Mobileno) {
        sb.userRegistration(Username, Useremail, Password, Gender, DOB, Address, Mobileno);
    }
    
    @GET
    @Path("admin/countofOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public long countofOrder(){
        return ab.countofOrder();
    }
    @GET
    @Path("admin/totalRevenu")
    @Produces(MediaType.APPLICATION_JSON)
    public double totalRevenu(){
        return ab.totalRevenu();
    }
    
    @GET
    @Path("admin/AveregePprice")
    @Produces(MediaType.APPLICATION_JSON)
    public double AveregePprice(){
        return ab.AveregePprice();
    }
    
    @POST
    @Path("admin/adminRegistration/{Cname}/{Cemail}/{Password}/{CMobileno}/{Cdescription}")
    @Produces(MediaType.APPLICATION_JSON)
    public void adminRegistration(@PathParam("Cname") String Cname, @PathParam("Cemail") String Cemail, @PathParam("Password") String Password, @PathParam("CMobileno") String CMobileno,@PathParam("Cdescription") String Cdescription) {
        ab.adminRegistration(Cname, Cemail, Password, CMobileno, Cdescription);
    }
    
    @GET
    @Path("admin/getProductByCid")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductTB> getProductByCid(){
        return ab.getProductByCid();
    }
}
