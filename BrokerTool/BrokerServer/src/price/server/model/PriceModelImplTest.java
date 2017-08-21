package price.server.model;

import price.common.model.IPriceModel;
import price.server.dao.PriceDAO;
import price.server.dao.PriceDAOImpl;
import price.common.model.PriceModel;

public class PriceModelImplTest {
    public static void main(String args[])  {
        System.out.println("BrokerModelImplTest.main: testing BrokerModelImplTest");
        
        IPriceModel model = null;
        PriceDAO db = null;
        PriceModel customer = null;
        
        try {
            db = new PriceDAOImpl();
            model = new PriceModelImpl(db);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            // testing retrieving all customers
            System.out.println("BrokerModelImplTest.main: retrieving all Customers");
            PriceModel [] allCustomers = model.getAllPrices();
            System.out.println("BrokerModelImplTest.main: printing all Customers");
            for (int i = 0; i < allCustomers.length; i++) {
                System.out.println(allCustomers[i]);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
        
        try {
            // testing getting a valid customer
            System.out.println("BrokerModelImplTest.main: retrieving valid customer Test Customer");
            customer = model.getPrice("SUNW");
            System.out.println("BrokerModelImplTest.main: " +  customer);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
        
        try {
            // testing getting an invalid customer
            System.out.println("BrokerModelImplTest.main: retrieving invalid customer JUNK");
            customer = model.getPrice("JUNK");
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
        
        try {
            // testing updating a valid customer
            System.out.println("BrokerModelImplTest.main: retrieving exisiting customer test customer ");
            customer = model.getPrice("SUNW");
            customer.setPrice(2);
            
            model.updatePrice(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println();
        
        try {
            // inserting a new customer record
            System.out.println("BrokerModelImplTest.main:  inserting a new customer");
            customer = new PriceModel("TestPrice", 13);
            
            model.addPrice(customer);
        } catch (Exception e) {
            System.out.println("BrokerModelImplTest.main:  exception");
            System.out.println(e);
            System.out.println("BrokerModelImplTest.main:  inserting will fail if 'New Customer' already in DB");
        }
        
        System.out.println();
        System.out.println();
        
        try {
            // deleting previously inserted new customer record
            System.out.println("BrokerModelImplTest.main:  deleting new customer");
            customer = new PriceModel("TestPrice", 13);
            
            model.deletePrice(customer);
        } catch (Exception e) {
            System.out.println("BrokerModelImplTest.main:  exception");
            System.out.println(e);
        }
    }
}