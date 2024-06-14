/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package RestClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JakartaEE8Resource [rest]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ravindrasinh
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Project-8/resources";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void addStageInProduct(String pid, String stagename, String stagedescription, String Priority) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/addStageInProduct/{0}/{1}/{2}/{3}", new Object[]{pid, stagename, stagedescription, Priority})).request().post(null);
    }

    public <T> T DisplayCompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/DisplayCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countofOrder(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/countofOrder");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void userRegistration(String Username, String Useremail, String Password, String Gender, String DOB, String Address, String Mobileno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("userRegistration/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{Username, Useremail, Password, Gender, DOB, Address, Mobileno})).request().post(null);
    }

    public void updateCompany(String CompanyID, String cname, String cdescription, String cno, String cemail) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/updateCompany/{0}/{1}/{2}/{3}/{4}", new Object[]{CompanyID, cname, cdescription, cno, cemail})).request().post(null);
    }

    public <T> T displayProductCat(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/displayProductCat");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCart(String CartID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCart/{0}", new Object[]{CartID})).request().delete();
    }

    public <T> T orderByUserId(Class<T> responseType, String UserID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderByUserId/{0}", new Object[]{UserID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductByCat(Class<T> responseType, String catId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductByCat/{0}", new Object[]{catId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addProdCat(String Pcatname, String Pcatdescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/addProdCat/{0}/{1}", new Object[]{Pcatname, Pcatdescription})).request().post(null);
    }

    public <T> T orderDetailsByOrderID(Class<T> responseType, String OrderID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderDetailsByOrderID/{0}", new Object[]{OrderID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T displayProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("displayProduct");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addToCart(String UserID, String ProductID, String Quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}", new Object[]{UserID, ProductID, Quantity})).request().post(null);
    }

    public void updateCat(String PcatID, String Pcatname, String Pcatdescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/updateCat/{0}/{1}/{2}", new Object[]{PcatID, Pcatname, Pcatdescription})).request().post(null);
    }

    public void addProductdata(String pname, String pcatID, String Prodescription, String productprice, String productimage, String isimageinclude, String istextinclude, String companyID, String quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/addProductdata/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{pname, pcatID, Prodescription, productprice, productimage, isimageinclude, istextinclude, companyID, quantity})).request().post(null);
    }

    public void updateCart(String CartID, String Quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCart/{0}/{1}", new Object[]{CartID, Quantity})).request().post(null);
    }

    public void deleteProduct(String productID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/deleteProduct/{0}", new Object[]{productID})).request().delete();
    }

    public <T> T AveregePprice(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/AveregePprice");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void genrateBill(String OrderID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("genrateBill/{0}", new Object[]{OrderID})).request().post(null);
    }

    public void cancelorder(String OrderID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("cancelorder/{0}", new Object[]{OrderID})).request().delete();
    }

    public <T> T getProductByname(Class<T> responseType, String pName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductByname/{0}", new Object[]{pName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T totalRevenu(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/totalRevenu");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllStagesByPid(Class<T> responseType, String pid) throws ClientErrorException {
        System.out.println("hello client");

        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("admin/getAllStagesByPid/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void applyOrder(String CartID, String customizeImage, String customizeText) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("applyOrder/{0}/{1}/{2}", new Object[]{CartID, customizeImage, customizeText})).request().post(null);
    }

    public <T> T displayUserCart(Class<T> responseType, String UserID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("displayUserCart/{0}", new Object[]{UserID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteproductcat(String PcatID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/deleteproduct/{0}", new Object[]{PcatID})).request().delete();
    }

    public <T> T displayCompanyByComID(Class<T> responseType, String CompanyID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("admin/displayCompanyByComID/{0}", new Object[]{CompanyID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCompany(String cname, String cdescription, String cno, String cemail) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/addCompany/{0}/{1}/{2}/{3}", new Object[]{cname, cdescription, cno, cemail})).request().post(null);
    }

    public <T> T orderTrackingByOrderdetailsID(Class<T> responseType, String OrderdetailsID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderTrackingByOrderdetailsID/{0}", new Object[]{OrderdetailsID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductByCid(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/getProductByCid");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCompnay(String CompanyID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/deleteCompnay/{0}", new Object[]{CompanyID})).request().delete();
    }

    public void updateProductdata(String productID, String pname, String pcatID, String Prodescription, String productprice, String productimage, String isimageinclude, String istextinclude, String companyID, String quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/updateProductdata/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{productID, pname, pcatID, Prodescription, productprice, productimage, isimageinclude, istextinclude, companyID, quantity})).request().post(null);
    }

    public void adminRegistration(String Cname, String Cemail, String Password, String CMobileno, String Cdescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/adminRegistration/{0}/{1}/{2}/{3}/{4}", new Object[]{Cname, Cemail, Password, CMobileno, Cdescription})).request().post(null);
    }

    public void deleteStage(String Stageid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("admin/deleteStage/{0}", new Object[]{Stageid})).request().delete();
    }

    public void close() {
        client.close();
    }

}
