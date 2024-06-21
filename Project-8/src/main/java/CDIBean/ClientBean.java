/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import CBean.ClientSessionBean;
import ClassPackage.KeyGenrator;
import Entity.BillingTB;
import Entity.CartTB;
import Entity.CompanyTB;
import Entity.OrderDetailsTB;
import Entity.OrderTB;
import Entity.OrderTrackingTB;
import Entity.ProductCategoryTB;
import Entity.ProductTB;
import Entity.StagemasterTB;
import Entity.UserTB;
import RestClient.RestClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author rohan
 */
@Named(value = "ClientBean")
@RequestScoped
public class ClientBean {

//    ClientSessionBean cb = new ClientSessionBean();
    RestClient rc;

    UserTB utb = new UserTB();

    ProductTB prod = new ProductTB();

    CartTB carttb = new CartTB();

    OrderDetailsTB orderDetailsTB = new OrderDetailsTB();

    Collection<OrderDetailsTB> cod;
    GenericType<Collection<OrderDetailsTB>> gcod;

    Collection<ProductTB> cprod;
    GenericType<Collection<ProductTB>> gprod;

    Collection<CartTB> ccart;
    GenericType<Collection<CartTB>> gcart;

    ProductCategoryTB prodcat = new ProductCategoryTB();
    Collection<ProductCategoryTB> cprodcat;
    GenericType<Collection<ProductCategoryTB>> gprodcat;

    StagemasterTB st = new StagemasterTB();
    Collection<StagemasterTB> cst;
    GenericType<Collection<StagemasterTB>> gcst;

    Collection<OrderTrackingTB> cotbs;
    GenericType<Collection<OrderTrackingTB>> gcotbs;

    BillingTB billingTB = new BillingTB();

//    CompanyTB comp = new CompanyTB();
//    Collection<CompanyTB> ccomp;
//    GenericType<Collection<CompanyTB>> gccomp;
    String pcatID;
    String companyID;
    String textForOrder;
    Integer maxPriorityOfTracking;

    Integer catserach;
    static Integer temp = 0;

    Response rs;

    private UploadedFile file;
    private String getimage;

    private String uname;
    private int uid;
    private String role;

    /**
     * Creates a new instance of CDIBean
     */
    public ClientBean() {

        rc = new RestClient();

        cprod = new ArrayList<>();
        gprod = new GenericType<Collection<ProductTB>>() {
        };

        cprodcat = new ArrayList<>();
        gprodcat = new GenericType<Collection<ProductCategoryTB>>() {
        };

        ccart = new ArrayList<>();
        gcart = new GenericType<Collection<CartTB>>() {
        };

        cod = new ArrayList<>();
        gcod = new GenericType<Collection<OrderDetailsTB>>() {
        };

        cst = new ArrayList<>();
        gcst = new GenericType<Collection<StagemasterTB>>() {
        };

        cotbs = new ArrayList<>();
        gcotbs = new GenericType<Collection<OrderTrackingTB>>() {
        };
        maxPriorityOfTracking = 0;
//        ccomp = new ArrayList<>();
//        gccomp = new GenericType<Collection<CompanyTB>>() {};

//        catserach=0;
//        temp = 0;
    }

    public BillingTB getBillingTB() {
        return billingTB;
    }

    public void setBillingTB(BillingTB billingTB) {
        this.billingTB = billingTB;
    }

    public Integer getMaxPriorityOfTracking() {
        return maxPriorityOfTracking;
    }

    public void setMaxPriorityOfTracking(Integer maxPriorityOfTracking) {
        this.maxPriorityOfTracking = maxPriorityOfTracking;
    }

    public String getTextForOrder() {
        return textForOrder;
    }

    public void setTextForOrder(String textForOrder) {
        this.textForOrder = textForOrder;
    }

    public UserTB getUtb() {
        return utb;
    }

    public void setUtb(UserTB utb) {
        this.utb = utb;
    }

    public Integer getCatserach() {
        return catserach;
    }

    public void setCatserach(Integer catserach) {
        this.catserach = catserach;
    }

    public String getUname() {
        return KeepRecord.getUsername();
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRole() {
        return KeepRecord.getRole();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<ProductTB> getCprod() {
        System.out.println(catserach);
        System.out.println(catserach == null || catserach == 0);
        cprod = new ArrayList<>();
        if (catserach == null || catserach == 0) {
            rs = rc.displayProduct(Response.class);
            cprod = rs.readEntity(gprod);
            System.out.println(cprod);
        } else {
            rs = rc.getProductByCat(Response.class, String.valueOf(catserach));
            cprod = rs.readEntity(gprod);
            System.out.println("hello" + cprod);

        }
        System.out.println(cprod);

        return cprod;
    }

    public CartTB getCarttb() {
        return carttb;
    }

    public void setCarttb(CartTB carttb) {
        this.carttb = carttb;
    }

    public Collection<CartTB> getCcart() {
        rs = rc.displayUserCart(Response.class, String.valueOf(TempData.Loginuid));
        ccart = rs.readEntity(gcart);
        return ccart;
    }

    public void setCcart(Collection<CartTB> ccart) {
        this.ccart = ccart;
    }

    public void setCprod(Collection<ProductTB> cprod) {
        this.cprod = cprod;
    }

    public ProductTB getProd() {
        return prod;
    }

    public void setProd(ProductTB prod) {
        this.prod = prod;
    }

    public ProductCategoryTB getProdcat() {
        return prodcat;
    }

    public void setProdcat(ProductCategoryTB prodcat) {
        this.prodcat = prodcat;
    }

    public Collection<ProductCategoryTB> getCprodcat() {
        rs = rc.displayProductCat(Response.class);
        cprodcat = rs.readEntity(gprodcat);
        return cprodcat;
    }

    public void setCprodcat(Collection<ProductCategoryTB> cprodcat) {
        this.cprodcat = cprodcat;
    }

    public String getPcatID() {
        return pcatID;
    }

    public void setPcatID(String pcatID) {
        this.pcatID = pcatID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public StagemasterTB getSt() {
        return st;
    }

    public void setSt(StagemasterTB st) {
        this.st = st;
    }

    public Collection<StagemasterTB> getCst() {
        System.out.println(TempData.orderDetailsTB.getOdetailsID());
        rs = rc.getStageByODId(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        cst = rs.readEntity(gcst);
        return cst;
    }

    public void setCst(Collection<StagemasterTB> cst) {
        this.cst = cst;
    }

    public Collection<OrderTrackingTB> getCotbs(Integer odid) {
        System.out.println(odid);
        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        cotbs = rs.readEntity(gcotbs);

        return cotbs;
    }

    public void setCotbs(Collection<OrderTrackingTB> cotbs) {
        this.cotbs = cotbs;
    }

//    public CompanyTB getComp() {
//        return comp;
//    }
//
//    public void setComp(CompanyTB comp) {
//        this.comp = comp;
//    }
//
//    public Collection<CompanyTB> getCcomp() {
//        rs = rc.DisplayCompany(Response.class);
//        ccomp = rs.readEntity(gccomp);
//        return ccomp;
//    }
//
//    public void setCcomp(Collection<CompanyTB> ccomp) {
//        this.ccomp = ccomp;
//    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getGetimage() {
        return getimage;
    }

    public void setGetimage(String getimage) {
        this.getimage = getimage;
    }

    public Collection<OrderDetailsTB> getCod() {
        rs = rc.getAllOrderOfUser(Response.class, TempData.Loginuid.toString());
        cod = rs.readEntity(gcod);
        return cod;
    }

    public void setCod(Collection<OrderDetailsTB> cod) {
        this.cod = cod;
    }

    public OrderDetailsTB getOrderDetailsTB() {
        return orderDetailsTB;
    }

    public void setOrderDetailsTB(OrderDetailsTB orderDetailsTB) {
        this.orderDetailsTB = orderDetailsTB;
    }

    public void upload() throws FileNotFoundException, IOException {
        if (file != null) {
            String destinationdirctory = "/home/rohan/8TH_Sem_Project/Project-8/src/main/webapp/images/Product/";
            File dirctory = new File(destinationdirctory);
            if (!dirctory.exists()) {
                dirctory.mkdirs();
            }
            String filename = file.getFileName();
            String filepath = destinationdirctory + filename;
            InputStream in = file.getInputStream();
            OutputStream out = new FileOutputStream(filepath);
            byte[] buffer = new byte[4000];
            int byteread;
            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }

//            getimage=filename;
        }
    }

//    public String addproductdata() throws IOException {
//
//        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
//            upload(); // Call the upload method to upload the file
//            String imageName = file.getFileName();
//
////       String imgaename=upload();
//            rc.addProductdata(prod.getProductname(), pcatID, prod.getProductdescription(), String.valueOf(prod.getProductprice()), imageName,
//                    String.valueOf(prod.getIsimageinclude()), String.valueOf(prod.getIstextinclude()), companyID, String.valueOf(prod.getQuantity()));
//        }
//
//        return "ProductDisplayAdmin.jsf";
//    }
//    public String deleteProduct(Integer productID) {
//        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
//            rc.deleteProduct(productID);
//        }
//        return "ProductDisplayAdmin.jsf";
//    }
//    public String addProd() {
//        return "AddProduct.jsf";
//    }
//    public String getproddata(ProductTB prod) {
//        System.out.println(prod);
//        this.prod = prod;
//
//        return "updateProdcut.jsf";
//    }
//
//    public String updateProddata() throws IOException {
//        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
//            upload(); // Call the upload method to upload the file
//            String imageName = file.getFileName();
//
//            rc.updateProductdata(prod.getProductID().toString(), prod.getProductname(), pcatID, prod.getProductdescription(), String.valueOf(prod.getProductprice()), imageName, String.valueOf(prod.getIsimageinclude()), String.valueOf(prod.getIstextinclude()), companyID, String.valueOf(prod.getQuantity()));
//        }
//        return "ProductDisplayAdmin.jsf";
//    }
    public String getProductByCat(Integer pCatId) {
        catserach = pCatId;
        System.out.println("temp" + temp);
        if (temp == 0) {
            temp = 1;
            return "Display_1.jsf";
        } else {
            temp = 0;
            return "Display.jsf";
        }
    }

    public String userRegistration() {
        System.out.println(utb);
        rc.userRegistration(utb.getUsername(), utb.getUseremail(), utb.getPassword(), utb.getGender(), utb.getDob(), utb.getAddress(), utb.getMobileno());
        return "login.jsf";
    }

    public String getregisterpage() {
        return "Client/UserRegistration.jsf";
    }

//    public void addCompany() {
//        rc.addCompany(comp.getCompanyname(), comp.getCompanydescription(), comp.getContactno(), comp.getCompanyemail());
//        System.out.println("Company Added");
//
//    }
//    public long countofOrder() {
//        return rc.countofOrder(long.class);
//    }
//
//    public double totalRevenu() {
//        return rc.totalRevenu(double.class);
//    }
//
//    public double averegePprice() {
//        return rc.AveregePprice(double.class);
//    }
//    
//    public void adminRegistration(){
//        rc.adminRegistration(utb.getUsername(), utb.getUseremail(), utb.getPassword(), utb.getMobileno(), utb.getAddress());
//    }
    public String addToCart(Integer pid) {
        rc.addToCart(String.valueOf(TempData.Loginuid), pid.toString(), "1");
        return "Cart.jsf";
    }

    public String gotoCart() {
        return "Cart.jsf";
    }

    public String updateQutOfCart(Integer cId, Integer qut) {
        rc.updateCart(cId.toString(), qut.toString());
        return "Cart.jsf";
    }

    public String orderForm(CartTB carttb) {

        this.carttb = carttb;
        TempData.cartTB = carttb;
        if (carttb.getProductID().getIsimageinclude()) {
            return "OrderForm_withImages.jsf";
        } else {
            return "OrderForm_withText.jsf";
        }
    }

    public String applyOrder() throws IOException {

        String imageName = "none";
        if (TempData.cartTB.getProductID().getIsimageinclude()) {
            upload();
            imageName = file.getFileName();
        }

        System.out.println(TempData.cartTB.getCartID());
        System.out.println(imageName);
        System.out.println(textForOrder);

        rc.applyOrder(TempData.cartTB.getCartID().toString(), imageName, textForOrder);
//cb.applyOrder(TempData.cartTB.getCartID(), imageName, textForOrder);

        return "DisplayOrder.jsf";
    }

    public String displayMyOrders() {
        return "DisplayOrder.jsf";
    }

    public String getdetails(OrderDetailsTB orderDetailsTB) {
        this.orderDetailsTB = orderDetailsTB;
        TempData.orderDetailsTB = orderDetailsTB;

        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        Collection<OrderTrackingTB> ot = rs.readEntity(gcotbs);

        for (OrderTrackingTB tracking : ot) {
            int priority = tracking.getStageID().getPriority();
            if (priority > maxPriorityOfTracking) {
                maxPriorityOfTracking = priority;
            }
        }

        return "OrderDetails.jsf";
    }

    public String getBill() {
        this.billingTB = rc.getBillByodId(BillingTB.class, TempData.orderDetailsTB.getOdetailsID().toString());
        System.out.println("bill"+this.billingTB.getOrderID().getOrderDetailsTBCollection());
        Collection<OrderDetailsTB> orderDetailsTBs = new ArrayList<>();
        orderDetailsTBs.add(TempData.orderDetailsTB);
        this.billingTB.getOrderID().setOrderDetailsTBCollection(orderDetailsTBs);
        return "Bill.jsf";
    }
}
