/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import ClassPackage.KeyGenrator;
import Entity.CompanyTB;
import Entity.OrderDetailsTB;
import Entity.OrderTrackingTB;
import Entity.ProductCategoryTB;
import Entity.ProductTB;
import Entity.RelationTB;
import Entity.StagemasterTB;
import Entity.UserTB;
import RestClient.RestClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    RestClient rc;

    UserTB utb = new UserTB();

    OrderDetailsTB orderDetailsTB = new OrderDetailsTB();

    Collection<OrderDetailsTB> cod;
    GenericType<Collection<OrderDetailsTB>> gcod;

    ProductTB prod = new ProductTB();
    Collection<ProductTB> cprod;
    GenericType<Collection<ProductTB>> gprod;

    ProductCategoryTB prodcat = new ProductCategoryTB();
    Collection<ProductCategoryTB> cprodcat;
    GenericType<Collection<ProductCategoryTB>> gprodcat;

    CompanyTB comp = new CompanyTB();
    Collection<CompanyTB> ccomp;
    GenericType<Collection<CompanyTB>> gccomp;

    CompanyTB acomp = new CompanyTB();
    Collection<CompanyTB> accomp;
    GenericType<Collection<CompanyTB>> agccomp;

    StagemasterTB st = new StagemasterTB();
    Collection<StagemasterTB> cst;
    GenericType<Collection<StagemasterTB>> gcst;

    OrderTrackingTB orderTrackingTB = new OrderTrackingTB();

    Collection<OrderTrackingTB> cotbs;
    GenericType<Collection<OrderTrackingTB>> gcotbs;

    String pcatID;
    String companyID;

    Integer catserach;

    Integer maxPriorityOfTracking;
    Integer stageForAdd;

    boolean isThereEnddate;
    boolean isNotAddNewTrack;

//    static Integer temp = 0;
    Response rs;

    private UploadedFile file;
    private String getimage;

    private String uname;
    private int uid;
    private String role;

    ArrayList<String> pNameList = new ArrayList<>();
    ArrayList<Integer> pCountList = new ArrayList<>();

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

        cst = new ArrayList<>();
        gcst = new GenericType<Collection<StagemasterTB>>() {
        };

        cod = new ArrayList<>();
        gcod = new GenericType<Collection<OrderDetailsTB>>() {
        };

        cotbs = new ArrayList<>();
        gcotbs = new GenericType<Collection<OrderTrackingTB>>() {
        };

        accomp = new ArrayList<>();
        agccomp = new GenericType<Collection<CompanyTB>>() {
        };

        maxPriorityOfTracking = 0;
        isThereEnddate = false;
        stageForAdd = 0;

        Collection<OrderDetailsTB> detailsTBs = getCod();
        Map<String, Integer> productCountMap = new HashMap<>();

        for (OrderDetailsTB orderDetailsTB : detailsTBs) {
            String productName = orderDetailsTB.getProductID().getProductname(); // Assuming getProductName() method exists
            productCountMap.put(productName, productCountMap.getOrDefault(productName, 0) + 1);
        }

        // Lists to store product names and their counts
        pNameList = new ArrayList<>(productCountMap.keySet());
        pCountList = new ArrayList<>(productCountMap.values());

//        catserach=0;
//        temp = 0;
    }

    public ArrayList<String> getpNameList() {
        return pNameList;
    }

    public void setpNameList(ArrayList<String> pNameList) {
        this.pNameList = pNameList;
    }

    public ArrayList<Integer> getpCountList(Integer i) {
        System.out.println(pCountList);
        return pCountList;
    }

    public Integer getIthCount(Integer i) {
        return pCountList.get(i);
    }

    public String getIthName(Integer i) {
        return pNameList.get(i);
    }

    public void setpCountList(ArrayList<Integer> pCountList) {
        this.pCountList = pCountList;
    }

    public CompanyTB getAcomp() {
        return acomp;
    }

    public void setAcomp(CompanyTB acomp) {
        this.acomp = acomp;
    }

    public Collection<CompanyTB> getAccomp() {
        System.out.println(TempData.Loginuid);
        rs = rc.getAdminProfile(Response.class, TempData.Loginuid.toString());
        accomp = rs.readEntity(agccomp);
        return accomp;
    }

    public void setAccomp(Collection<CompanyTB> accomp) {
        this.accomp = accomp;
    }

    public boolean isIsNotAddNewTrack() {
        return isNotAddNewTrack;
    }

    public void setIsNotAddNewTrack(boolean isNotAddNewTrack) {
        this.isNotAddNewTrack = isNotAddNewTrack;
    }

    public Integer getStageForAdd() {
        return stageForAdd;
    }

    public void setStageForAdd(Integer stageForAdd) {
        this.stageForAdd = stageForAdd;
    }

    public boolean isIsThereEnddate() {
        return isThereEnddate;
    }

    public void setIsThereEnddate(boolean isThereEnddate) {
        this.isThereEnddate = isThereEnddate;
    }

    public Integer getMaxPriorityOfTracking() {
        return maxPriorityOfTracking;
    }

    public void setMaxPriorityOfTracking(Integer maxPriorityOfTracking) {
        this.maxPriorityOfTracking = maxPriorityOfTracking;
    }

    public OrderTrackingTB getOrderTrackingTB() {
        return orderTrackingTB;
    }

    public void setOrderTrackingTB(OrderTrackingTB orderTrackingTB) {
        this.orderTrackingTB = orderTrackingTB;
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

    public StagemasterTB getSt() {
        return st;
    }

    public void setSt(StagemasterTB st) {
        this.st = st;
    }

    public Collection<StagemasterTB> getCst() {
//                System.out.println("hello cdi" + pID);

//                TempData.prodtb=prod;
        System.out.println("gdhdf");
        System.out.println(TempData.prodtb.getProductID());

        rs = rc.getAllStagesByPid(Response.class, TempData.prodtb.getProductID().toString());

        cst = rs.readEntity(gcst);
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

    public OrderDetailsTB getOrderDetailsTB() {
        return orderDetailsTB;
    }

    public void setOrderDetailsTB(OrderDetailsTB orderDetailsTB) {
        this.orderDetailsTB = orderDetailsTB;
    }

    public Collection<OrderDetailsTB> getCod() {
        if (TempData.Loginuid != null) {

            rs = rc.getAllOrderOfCompny(Response.class);
            cod = rs.readEntity(gcod);
        }
        return cod;
    }

    public void setCod(Collection<OrderDetailsTB> cod) {
        this.cod = cod;
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

        UserTB utb = em.find(UserTB.class, KeepRecord.uid);

        // Get the relation of the user to the company
        RelationTB relationTB = em.createNamedQuery("RelationTB.findByUid", RelationTB.class)
                .setParameter("userID", utb)
                .getSingleResult();
//
        Iterator<CompanyTB> iterator = ccomp.iterator();
        while (iterator.hasNext()) {
            CompanyTB company = iterator.next();
            if (company.getCompanyID() != relationTB.getCompanyID().getCompanyID()) {
                iterator.remove();
            }
        }
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
            String destinationdirctory = "/home/rohan/8th_Sem_Project/JavaProject-Production/Project-8/src/main/webapp/images/";
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
        TempData.prodtb = prod;
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

    public String adminRegistration() {
        rc.adminRegistration(utb.getUsername(), utb.getUseremail(), utb.getPassword(), utb.getMobileno(), utb.getAddress());

        return "login.jsf";
    }

    public String gotoProdDetil(ProductTB prod) {
        TempData.prodtb = prod;
        this.prod = prod;
        return "ProductDetailPage.jsf";
    }

    public String addStageInProduct() {
//        System.out.println("" + pid);
        this.prod = TempData.prodtb;
        rc.addStageInProduct(TempData.prodtb.getProductID().toString(), st.getStagename(), st.getStagedescription(), String.valueOf(st.getPriority()));
        return "ProductDetailPage.jsf";
    }

    public String deleteStage(Integer Stageid) {
        this.prod = TempData.prodtb;

        rc.deleteStage(Stageid.toString());
        return "ProductDetailPage.jsf";
    }

    public String getdetails(OrderDetailsTB orderDetailsTB) {
        this.orderDetailsTB = orderDetailsTB;
        TempData.orderDetailsTB = orderDetailsTB;
        TempData.prodtb = orderDetailsTB.getProductID();

        System.out.println("hello lodu");
        System.out.println(orderDetailsTB.getOrderID().getUserID().getUsername());
        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        Collection<OrderTrackingTB> ot = rs.readEntity(gcotbs);

        rs = rc.getAllStagesByPid(Response.class, TempData.orderDetailsTB.getProductID().getProductID().toString());
        Collection<StagemasterTB> sm = rs.readEntity(gcst);

        ArrayList<StagemasterTB> newsm = new ArrayList<>();

        isThereEnddate = true;

        for (OrderTrackingTB tracking : ot) {
            int priority = tracking.getStageID().getPriority();
            if (priority > maxPriorityOfTracking) {
                maxPriorityOfTracking = priority;
                if ("work in progress".equals(tracking.getEndingDate())) {
                    isThereEnddate = false;
                    isNotAddNewTrack = true;
                } else {
                    isThereEnddate = true;
                    isNotAddNewTrack = false;
                }
            }
        }

        return "OrderDetails.jsf";
    }

    public String addStartWork() {
        System.out.println("helloooooooo start   work   ");
        this.orderDetailsTB = TempData.orderDetailsTB;

        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        Collection<OrderTrackingTB> ot = rs.readEntity(gcotbs);

        rs = rc.getAllStagesByPid(Response.class, TempData.orderDetailsTB.getProductID().getProductID().toString());
        Collection<StagemasterTB> sm = rs.readEntity(gcst);

        ArrayList<StagemasterTB> newsm = new ArrayList<>();

        isThereEnddate = true;
        isNotAddNewTrack = false;

        for (OrderTrackingTB tracking : ot) {
            int priority = tracking.getStageID().getPriority();
            if (priority > maxPriorityOfTracking) {
                maxPriorityOfTracking = priority;
                if ("work in progress".equals(tracking.getEndingDate())) {
                    isThereEnddate = false;
                    isNotAddNewTrack = true;
                } else {
                    isThereEnddate = true;
                    isNotAddNewTrack = false;
                }
            }
        }

        if (isThereEnddate) {
            for (StagemasterTB stage : sm) {
                if (maxPriorityOfTracking < stage.getPriority()) {
                    newsm.add(stage);
                }
            }
        }

        stageForAdd = newsm.get(0).getStageID();
        for (StagemasterTB stage : newsm) {
            if (stageForAdd > stage.getStageID()) {
                stageForAdd = stage.getStageID();
            }
        }

        rc.addWorkInTrack(TempData.orderDetailsTB.getOdetailsID().toString(), "none", stageForAdd.toString());

        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        ot = rs.readEntity(gcotbs);

        rs = rc.getAllStagesByPid(Response.class, TempData.orderDetailsTB.getProductID().getProductID().toString());
        sm = rs.readEntity(gcst);

        newsm = new ArrayList<>();

        isThereEnddate = true;
        isNotAddNewTrack = false;

        for (OrderTrackingTB tracking : ot) {
            int priority = tracking.getStageID().getPriority();
            if (priority > maxPriorityOfTracking) {
                maxPriorityOfTracking = priority;
                if ("work in progress".equals(tracking.getEndingDate())) {
                    isThereEnddate = false;
                    isNotAddNewTrack = true;
                } else {
                    isThereEnddate = true;
                    isNotAddNewTrack = false;
                }
            }
        }

        if (isThereEnddate) {
            for (StagemasterTB stage : sm) {
                if (maxPriorityOfTracking < stage.getPriority()) {
                    newsm.add(stage);
                }
            }

            stageForAdd = newsm.get(0).getStageID();
            for (StagemasterTB stage : newsm) {
                if (stageForAdd > stage.getStageID()) {
                    stageForAdd = stage.getStageID();
                }
            }
        }
        System.out.println("helloooo loggg");
        System.out.println(TempData.orderDetailsTB.getOdetailsID().toString());
        System.out.println(stageForAdd.toString());
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()).toString());

        return "OrderDetails.jsf";

    }

    public String complitWork() {
        this.orderDetailsTB = TempData.orderDetailsTB;

        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());
        Collection<OrderTrackingTB> ot = rs.readEntity(gcotbs);

        Integer otid = 0;

        for (OrderTrackingTB tracking : ot) {
            if ("work in progress".equals(tracking.getEndingDate())) {
                otid = tracking.getOrdertrackID();
            }
        }

        rc.addEndDateInTrack(otid.toString());

        rs = rc.getTrackByOrderDetailID(Response.class, TempData.orderDetailsTB.getOdetailsID().toString());

        ot = rs.readEntity(gcotbs);

        rs = rc.getAllStagesByPid(Response.class, TempData.orderDetailsTB.getProductID().getProductID().toString());
        Collection<StagemasterTB> sm = rs.readEntity(gcst);

        ArrayList<StagemasterTB> newsm = new ArrayList<>();

        isThereEnddate = true;

        for (OrderTrackingTB tracking : ot) {
            int priority = tracking.getStageID().getPriority();
            if (priority > maxPriorityOfTracking) {
                maxPriorityOfTracking = priority;
                if ("work in progress".equals(tracking.getEndingDate())) {
                    isThereEnddate = false;
                    isNotAddNewTrack = true;
                } else {
                    isThereEnddate = true;
                    isNotAddNewTrack = false;
                }
            }
        }
        return "OrderDetails.jsf";

    }

    public String getAdminProfile() {
        this.uid = TempData.Loginuid;
        return "AdminProfile.jsf";
    }

}
