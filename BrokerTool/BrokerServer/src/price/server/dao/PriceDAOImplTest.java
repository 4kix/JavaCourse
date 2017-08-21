package price.server.dao;

import price.common.model.PriceModel;

public class PriceDAOImplTest {
    public static void main(String args[])  {
        System.out.println("BrokerDAOImplTest.main: testing BrokerDAOImpl");
        
        PriceDAOImpl db = null;
        PriceModel pr = null;
        
        try {
            db = new PriceDAOImpl();
        } catch (Exception e) {
            System.out.println(e);
        }
        
     try {
            // testing retrieving all customers
            System.out.println("BrokerDAOImplTest.main: retrieving all prices");
            PriceModel [] allCustomers = db.getAllPrices();
            System.out.println("BrokerDAOImplTest.main: printing all prices");
            for (int i = 0; i < allCustomers.length; i++) {
                System.out.println(allCustomers[i]);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
       
        System.out.println();
        System.out.println();
          try {
            // testing getting a valid Customer
            System.out.println("BrokerDAOImplTest.main: retrieving valid price SUNW");
            pr = db.getPrice("SUNW");
            System.out.println("BrokerDAOImplTest.main: " +  pr);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
     
        try {
            // testing getting an invalid customer
            System.out.println("BrokerDAOImplTest.main: retrieving invalid customer JUNK");
            pr = db.getPrice("JUNK");
            System.out.println(pr);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
           
        try {
            
            // testing updating a valid customer
            System.out.println("BrokerDAOImplTest.main: retrieving exisiting customer SUNW ");
            pr = db.getPrice("SUNW");
            pr.setPrice(1);
            
            db.changePrice(pr);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
       
        try {
            
            // inserting a new customer record
            System.out.println("BrokerDAOImplTest.main:  inserting a new price");
            pr = new PriceModel("TestSymbol", 1);
            
            db.createPrice(pr);
            
        } catch (Exception e) {
            System.out.println("BrokerDAOImplTest.main:  exception");
            System.out.println(e);
            System.out.println("BrokerDAOImplTest.main:  inserting will fail if 'New Customer' already in DB");
        }
        
        System.out.println();
        System.out.println();
        
        try {
            
            // deleting previously inserted new customer record
            System.out.println("BrokerDAOImplTest.main:  deleting new price");
            pr = new PriceModel("TestSymbol", 1);
            
            db.removePrice(pr);
            
        } catch (Exception e) {
            System.out.println("BrokerDAOImplTest.main:  exception");
            System.out.println(e);
        }
    }
}