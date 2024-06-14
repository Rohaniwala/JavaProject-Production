/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package CBean;

import Entity.BillingTB;
import Entity.CartTB;
import Entity.OrderDetailsTB;
import Entity.OrderTB;
import Entity.OrderTrackingTB;
import Entity.ProductCategoryTB;
import Entity.ProductTB;
import Entity.RoleTB;
import Entity.StagemasterTB;
import Entity.UserTB;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author rohan
 */
@Stateless
public class ClientSessionBean {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    StagemasterTB s;
    Float Totalprice;

    Pbkdf2PasswordHashImpl pb;

    //Product Display For Client Side
    public Collection<ProductTB> displayProduct() {
        return em.createNamedQuery("ProductTB.findAll").getResultList();
    }

    public Collection<ProductTB> getProductByCat(Integer pCatId) {
        ProductCategoryTB pctb = em.find(ProductCategoryTB.class, pCatId);
        return em.createNamedQuery("ProductTB.findByProductCatID").setParameter("pcatID", pctb).getResultList();
    }

    public Collection<ProductTB> getProductByName(String pName) {
        return em.createNamedQuery("ProductTB.findByProductname").setParameter("productname", pName).getResultList();
    }

    //Cart For Client
    public void addToCart(Integer UserID, Integer ProductID, Integer Qunatity) {
        UserTB ut = em.find(UserTB.class, UserID);
        ProductTB pt = em.find(ProductTB.class, ProductID);
        Collection<CartTB> caTBs = em.createNamedQuery("CartTB.findByUserIDAndProductID", CartTB.class).setParameter("userID", ut).setParameter("productID", pt).getResultList();

        if (caTBs.isEmpty()) {

//            UserTB ut=em.find(UserTB.class, UserID);
//            ProductTB pt=em.find(ProductTB.class, ProductID);
            Collection<CartTB> ct = ut.getCartTBCollection();
            Collection<CartTB> ctt = pt.getCartTBCollection();

            CartTB caTB = new CartTB();
            caTB.setUserID(ut);
            caTB.setProductID(pt);
            caTB.setQuantity(Qunatity);

            ct.add(caTB);
            ctt.add(caTB);

            ut.setCartTBCollection(ct);
            pt.setCartTBCollection(ctt);

            em.persist(caTB);
            em.merge(ut);
            em.merge(pt);
        } else {
            updateCart(caTBs.iterator().next().getCartID(), 1);
        }

    }

    // Update Cart For Client
    public void updateCart(Integer CartID, Integer newQunatity) {
        CartTB caTB = em.find(CartTB.class, CartID);
        caTB.setQuantity(newQunatity + caTB.getQuantity());
        em.merge(caTB);
        if (caTB.getQuantity() < 1) {
            deleteCart(CartID);
        }
    }

    // Delete cart data
    public void deleteCart(Integer CartID) {
        CartTB Carttb = em.find(CartTB.class, CartID);
        em.remove(Carttb);
    }

    // Display cart data of particular user
    public Collection<CartTB> displayUserCart(Integer UserID) {
        UserTB userTB = em.find(UserTB.class, UserID);
        return em.createNamedQuery("CartTB.findByUserID").setParameter("userID", userTB).getResultList();
    }

    //Order insert
//     public void placeOrder(Integer UserID){
//        UserTB userTB=em.find(UserTB.class, UserID);
//        Collection<CartTB> cartTBs=em.createNamedQuery("CartTB.findByUserID").setParameter("userID", userTB).getResultList();
//         OrderTB orderTB=new OrderTB();
//         orderTB.setUserID(userTB);
//         orderTB.setOrderStatus("Ordered");
//         
//         orderTB.setOrderdate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
//         
//         cartTBs.forEach(c -> {
//         OrderDetailsTB orderDetailsTB=new OrderDetailsTB();
//         orderDetailsTB.setProductID(c.getProductID());
//         orderDetailsTB.setOrderID(orderTB);
//         orderDetailsTB.setCustomizeImage("ABC.JPG");
//         orderDetailsTB.setCustomizetext("xyz");
//         orderDetailsTB.setOrderdate(orderTB.getOrderdate());
//         orderDetailsTB.setQuantity(c.getQuantity());
//
//         Collection<StagemasterTB> stagemasterTBs=em.createNamedQuery("StagemasterTB.findByProductID").setParameter("productID", c.getProductID()).getResultList();
//             s=new StagemasterTB();
//         stagemasterTBs.forEach(st -> {
//             if(st.getStagename().equals("Ordered")){
//                 s=st;
//             }
//         });
//         
//          OrderTrackingTB orderTrackingTB=new OrderTrackingTB();
//         orderTrackingTB.setOrderdetailsID(orderDetailsTB);
//         orderTrackingTB.setStageID(s);
//         orderTrackingTB.setPlace("mdc");
//         orderTrackingTB.setStartingDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
//
////         orderTrackingTB.setStartingDate(LocalDateTime.now().format("dd/mm/yyyy hh:mm:ss").toString());
//         orderTrackingTB.setEndingDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
//         orderTrackingTB.setDescription("cdh");
//         
//         em.persist(orderDetailsTB);
//         em.persist(orderTrackingTB);
//         
//         em.remove(c);
//     });
//          em.persist(orderTB);
//          
//          
//     }
    public void cancelorder(Integer OrderID) {
        OrderTB ordertb = em.find(OrderTB.class, OrderID);
        ordertb.setOrderStatus("Cancelled");
    }

//    public Collection<OrderTB> orderByUserId(Integer UserID) {
//        UserTB userTB = em.find(UserTB.class, UserID);
//        return em.createNamedQuery("OrderTB.findByUserID").setParameter("userID", userTB).getResultList();
//    }
//
//    public Collection<OrderDetailsTB> orderDetailsByOrderID(Integer OrderID) {
//        OrderTB orderTB = em.find(OrderTB.class, OrderID);
//        return em.createNamedQuery("OrderDetailsTB.findByOrderID").setParameter("orderID", orderTB).getResultList();
//    }

    public Collection<OrderTrackingTB> orderTrackingByOrderdetailsID(Integer OrderdetailsID) {
        OrderDetailsTB orderDetailsTB = em.find(OrderDetailsTB.class, OrderdetailsID);
        return em.createNamedQuery("OrderTrackingTB.findByOrderdetailsID").setParameter("orderdetailsID", orderDetailsTB).getResultList();
    }

    public void genrateBill(Integer OrderID) {
        OrderTB orderTB = em.find(OrderTB.class, OrderID);
        BillingTB billtb = new BillingTB();
        billtb.setOrderID(orderTB);
        billtb.setBillDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        billtb.setDeliveryDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));

        Collection<OrderDetailsTB> orderDetailsTBs = em.createNamedQuery("OrderDetailsTB.findByOrderID").setParameter("orderID", orderTB).getResultList();
        Totalprice = 0.0f;
        orderDetailsTBs.forEach(o -> {

            float productPrice = o.getProductID().getProductprice();
            int quantity = o.getQuantity();
            Totalprice += (quantity * productPrice);
        });
        billtb.setTotalPrice(Totalprice);

        em.persist(billtb);
    }

    public void userRegistration(String Username, String Useremail, String Password, String Gender, String DOB, String Address, String Mobileno) {
        RoleTB roleTB = em.find(RoleTB.class, 2);
        Collection<UserTB> utbs = roleTB.getUserTBCollection();
        pb = new Pbkdf2PasswordHashImpl();
        UserTB userTB = new UserTB();
        userTB.setUsername(Username);
        userTB.setUseremail(Useremail);
        userTB.setPassword(pb.generate(Password.toCharArray()));
        userTB.setRoleID(roleTB);
        userTB.setGender(Gender);
        userTB.setDob(DOB);
        userTB.setAddress(Address);
        userTB.setMobileno(Mobileno);

        utbs.add(userTB);
        roleTB.setUserTBCollection(utbs);

        em.persist(userTB);
        em.merge(roleTB);
    }

    public void applyOrder(Integer CartID, String customizeImage, String customizeText) {

//       System.out.println("ejb");
        CartTB cartTB = em.find(CartTB.class, CartID);
        UserTB userTB = em.find(UserTB.class, cartTB.getUserID().getUserID());

        OrderTB orderTB = new OrderTB();
        OrderDetailsTB orderDetailsTB = new OrderDetailsTB();
        OrderTrackingTB orderTrackingTB = new OrderTrackingTB();

        orderTB.setUserID(userTB);
        orderTB.setOrderStatus("Ordered");
        orderTB.setOrderdate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));

//       OrderDetailsTB orderDetailsTB=new OrderDetailsTB();
        orderDetailsTB.setProductID(cartTB.getProductID());
        orderDetailsTB.setOrderID(orderTB);
        orderDetailsTB.setCustomizeImage(customizeImage);
        orderDetailsTB.setCustomizetext(customizeText);
        orderDetailsTB.setOrderdate(orderTB.getOrderdate());
        orderDetailsTB.setQuantity(cartTB.getQuantity());

        Collection<StagemasterTB> stagemasterTBs = em.createNamedQuery("StagemasterTB.findByProductID").setParameter("productID", cartTB.getProductID()).getResultList();
        s = new StagemasterTB();
        stagemasterTBs.forEach(st -> {
            if (st.getStagename().equals("Ordered")) {
                s = st;
            }
        });

        orderTrackingTB.setOrderdetailsID(orderDetailsTB);
        orderTrackingTB.setStageID(s);
        orderTrackingTB.setPlace("mdc");
        orderTrackingTB.setStartingDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        orderTrackingTB.setEndingDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        orderTrackingTB.setDescription("cdh");

        em.persist(orderTB);
        em.persist(orderDetailsTB);
        em.persist(orderTrackingTB);

        em.remove(cartTB);

    }

    public Collection<OrderDetailsTB> getAllOrderOfUser(Integer uid) {
        return em.createNamedQuery("OrderDetailsTB.findByUserID").setParameter("userID", uid).getResultList();
    }
}
