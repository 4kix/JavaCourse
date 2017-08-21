/*
 * BrokerModelImpl.java
 *
 * Created on December 20, 2006, 7:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package price.server.model;

import java.util.*;

import price.common.model.IPriceModel;
import price.server.dao.PriceDAO;
import price.common.model.PriceModel;
import trader.common.exception.BrokerException;
import price.common.view.IPriceView;

/**
 *
 * @author vp200359
 */
public class PriceModelImpl implements IPriceModel {
    
   // ArrayList<BrokerView> changeListeners = new ArrayList<BrokerView>(10);
    PriceDAO brokerDAO;
    
    /** Creates a new instance of BrokerModelImpl */
    public PriceModelImpl(PriceDAO brokerDAO){
        this.brokerDAO = brokerDAO;
    }
    
    // Broker model state change listener registration methods
    /**-----------------------------------------------------------
     * Adds requester to the list of objects to be notified when an
     * object(Customer, Portfolio or Stock) in the broker model
     * alters state
     */
    public void addChangeListener(IPriceView bv)
    throws BrokerException {
        //** 1 add bv to changeListeners using the add method
       // changeListeners.add(bv);
    }
    
    // Iteration 1 Customer segment broker model methods
    // Customer segment state change methods
    /**----------------------------------------------------------
     * Adds the Customer to the broker model
     */
    public void addPrice(PriceModel cust)
    throws BrokerException {
        try {
            //** 1 Check if the record to be deleted is present
            //** Remove the customer if present in the database
            if(!brokerDAO.symbolExists(cust.getSymbol())){
                //** 2 Use the brokerDAO instance to add the Customer
                //** customer table.
                brokerDAO.createPrice(cust);
                //** 3 Invoke the fireModelChangeEvent with cust as param.
                //**   Q? why is this step necessary?
                //** To keep the registered views updated with the recent
                //** changes in the model.
            } else {
                throw new BrokerException("Duplicate Id : " + cust.getSymbol());
            }
        } catch (Exception e) {
            e.toString();
            throw new BrokerException("BrokerModelImpl.addCustomer\n" + e);
        }
    }
    
    /**-------------------------------------------------------------
     * deletes the customer from the broker model
     */
    public void deletePrice(PriceModel cust)
    throws BrokerException{
        try {
            //** 1 Check if the record to be deleted is present
            //** Remove the customer if present in the database
            if(brokerDAO.symbolExists(cust.getSymbol())){
                //** 2 Use the brokerDAO instance to delete the customer
                //** from the Shares and Customer tables.
                brokerDAO.removePrice(cust);
             
            } else {
                throw new BrokerException("Record for Id " + cust.getSymbol() + " not found ");
            }
        } catch (Exception e) {
            e.toString();
            throw new BrokerException("BrokerModelImpl.deleteCustomer\n" + e);
        }
    }
    
    /**-------------------------------------------------------------
     * Updates the customer in the broker model
     */
    public void updatePrice(PriceModel cust)
    throws BrokerException {
        try {
            //** 1 Check if the record to be updated is present
            //** Update the customer if present in the database
            if(brokerDAO.symbolExists(cust.getSymbol())){
                //** 2 Use the brokerDAO instance to update the Customer table.
                brokerDAO.changePrice(cust);
                //** 3 Invoke the fireModelChangeEvent with cust as param.
                //**   Q? why is this step necessary?
                //** To keep the registered views updated with the recent
                //** changes in the model.
            } else {
                throw new BrokerException("Record for " + cust.getSymbol() + " not found.");
            }
        } catch (Exception e) {
            e.toString();
            throw new BrokerException("BrokerModelImpl.updateCustomer\n" + e);
        }
    }
    
    // Customer segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Customer from the model
     */
    public PriceModel getPrice(String id)
    throws BrokerException {
        try {
        	PriceModel cr = null;
            //** 1 Use the brokerDAO instance to retrieve the record
            //** which returns null if no matching customer entity
            //** is found or the customer object once a match is found.
            cr=brokerDAO.getPrice(id);
            // The following statement checks if query successful
            if (cr!=null) {
                //** Match Found.
            } else {
                // if query failed
                throw new BrokerException("Record for " + id + " not found.");
            }
            // return cr
            return cr;
        } catch (Exception e) {
            e.toString();
            throw new BrokerException("BrokerModelImpl.getCustomer\n" + e);
        }
    }
    
    /**-------------------------------------------------------------
     * Returns all customers in the broker model
     */
    public PriceModel[] getAllPrices()
    throws BrokerException{
    	PriceModel[] all = null;
        try {
            //** 1 Use brokerDAO instance to call the getAllCustomers()
            //** method and populate the Array.
            all = brokerDAO.getAllPrices();
        } catch (Exception e) {
            e.toString();
            throw new BrokerException("BrokerModelImpl.getAllCustomers\n" + e);
        }
        return all;
    }
}