/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import ClassPackage.KeyGenrator;
import Entity.CompanyTB;
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
@Named(value = "CompanyBean")
@RequestScoped
public class CompanyBean {

    RestClient rc;

    UserTB utb = new UserTB();

    ProductTB prod = new ProductTB();
    Collection<ProductTB> cprod;
    GenericType<Collection<ProductTB>> gprod;

    ProductCategoryTB prodcat = new ProductCategoryTB();
    Collection<ProductCategoryTB> cprodcat;
    GenericType<Collection<ProductCategoryTB>> gprodcat;

    CompanyTB comp = new CompanyTB();
    Collection<CompanyTB> ccomp;
    GenericType<Collection<CompanyTB>> gccomp;

    StagemasterTB st =new StagemasterTB();
    Collection<StagemasterTB> cst;
    GenericType<Collection<StagemasterTB>> gcst;

    
    String pcatID;
    String companyID;

    Integer catserach;
//    static Integer temp = 0;

    Response rs;

    private UploadedFile file;
    private String getimage;

    private String uname;
    private int uid;
    private String role;

    /**
     * Creates a new instance of CDIBean
     */
    public CompanyBean() {

        rc = new RestClient();

        cprod = new ArrayList<>();
        gprod = new GenericType<Collection<ProductTB>>() {
        };

        cprodcat = new ArrayList<>();
        gprodcat = new GenericType<Collection<ProductCategoryTB>>() {
        };

        ccomp = new ArrayList<>();
        gccomp = new GenericType<Collection<CompanyTB>>() {
        };
        
        cst=new ArrayList<>();
        gcst=new GenericType<Collection<StagemasterTB>>(){};

//        catserach=0;
//        temp = 0;
    }

    public StagemasterTB getSt() {
        return st;
    }

    public void setSt(StagemasterTB st) {
        this.st = st;
    }

    public Collection<StagemasterTB> getCst() {
//                System.out.println("hello cdi" + pID);

//                TempData.prodtb=prod;
        rs=rc.getAllStagesByPid(Response.class, TempData.prodtb.getProductID().toString());
        cst=rs.readEntity(gcst);
        return cst;
    }

    public void setCst(Collection<StagemasterTB> cst) {
        this.cst = cst;
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
            rs = rc.getProductByCid(Response.class);
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

    public CompanyTB getComp() {
        return comp;
    }

    public void setComp(CompanyTB comp) {
        this.comp = comp;
    }

    public Collection<CompanyTB> getCcomp() {
        rs = rc.DisplayCompany(Response.class);
        ccomp = rs.readEntity(gccomp);
        return ccomp;
    }

    public void setCcomp(Collection<CompanyTB> ccomp) {
        this.ccomp = ccomp;
    }

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

    public void upload() throws FileNotFoundException, IOException {
        if (file != null) {
            String destinationdirctory = "/home/rohan/8TH_Sem_Project/Project-8/src/main/webapp/images/";
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

    public String addproductdata() throws IOException {

        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
            upload(); // Call the upload method to upload the file
            String imageName = file.getFileName();

//       String imgaename=upload();
            rc.addProductdata(prod.getProductname(), pcatID, prod.getProductdescription(), String.valueOf(prod.getProductprice()), imageName,
                    String.valueOf(prod.getIsimageinclude()), String.valueOf(prod.getIstextinclude()), companyID, String.valueOf(prod.getQuantity()));
        }

        return "ProductDisplayAdmin.jsf";
    }

    public String deleteProduct(Integer productID) {
        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
            rc.deleteProduct(productID.toString());
        }
        return "ProductDisplayAdmin.jsf";
    }

    public String addProd() {
        return "AddProduct.jsf";
    }

    public String getproddata(ProductTB prod) {
        System.out.println(prod);
        this.prod = prod;

        return "updateProdcut.jsf";
    }

    public String updateProddata() throws IOException {
        if (KeyGenrator.verifytoken(KeyGenrator.genratetoken(KeepRecord.getUsername()))) {
            upload(); // Call the upload method to upload the file
            String imageName = file.getFileName();

            rc.updateProductdata(prod.getProductID().toString(), prod.getProductname(), pcatID, prod.getProductdescription(), String.valueOf(prod.getProductprice()), imageName, String.valueOf(prod.getIsimageinclude()), String.valueOf(prod.getIstextinclude()), companyID, String.valueOf(prod.getQuantity()));
        }
        return "ProductDisplayAdmin.jsf";
    }

//    public String getProductByCat(Integer pCatId) {
//        catserach = pCatId;
//        System.out.println("temp" + temp);
//        if (temp == 0) {
//            temp = 1;
//            return "Display_1.jsf";
//        } else {
//            temp = 0;
//            return "Display.jsf";
//        }
//    }

//    public void userRegistration() {
//        System.out.println(utb);
//        rc.userRegistration(utb.getUsername(), utb.getUseremail(), utb.getPassword(), utb.getGender(), utb.getDob(), utb.getAddress(), utb.getMobileno());
//    }

//    public String getregisterpage() {
//        return "UserRegistration.jsf";
//    }

    public void addCompany() {
        rc.addCompany(comp.getCompanyname(), comp.getCompanydescription(), comp.getContactno(), comp.getCompanyemail());
        System.out.println("Company Added");

    }

    public long countofOrder() {
        return rc.countofOrder(long.class);
    }

    public double totalRevenu() {
        return rc.totalRevenu(double.class);
    }

    public double averegePprice() {
        return rc.AveregePprice(double.class);
    }
    
    public void adminRegistration(){
        rc.adminRegistration(utb.getUsername(), utb.getUseremail(), utb.getPassword(), utb.getMobileno(), utb.getAddress());
    }
    
    public String gotoProdDetil(ProductTB prod){
        TempData.prodtb=prod;
        this.prod=prod;
        return "ProductDetailPage.jsf";
    }
    
    public String addStageInProduct(){
//        System.out.println("" + pid);
         this.prod=TempData.prodtb;
        rc.addStageInProduct(TempData.prodtb.getProductID().toString(), st.getStagename(), st.getStagedescription(), String.valueOf(st.getPriority()));
        return "ProductDetailPage.jsf";
    }
    
    public String deleteStage(Integer Stageid){
        this.prod=TempData.prodtb;
       
        rc.deleteStage(Stageid.toString());
        return "ProductDetailPage.jsf";
    }
}
