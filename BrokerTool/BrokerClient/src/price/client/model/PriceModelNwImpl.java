package price.client.model;
import java.util.ArrayList;

import price.common.model.IPriceModel;
import price.common.view.IPriceView;
import price.client.network.NwClient;
import price.common.command.Command;
import price.common.command.impl.AddPriceCommand;
import price.common.command.impl.DeletePriceCommand;
import price.common.command.impl.GetAllPricesCommand;
import price.common.command.impl.GetPriceCommand;
import price.common.command.impl.UpdatePriceCommand;
import price.common.model.PriceModel;
import trader.common.exception.BrokerException;

public class PriceModelNwImpl implements IPriceModel {
    ArrayList<IPriceView> changeListeners = new ArrayList<IPriceView>(10);
    NwClient nwClient;
    
    /** Creates new BrokerNwImpl */
    public PriceModelNwImpl(NwClient nwClient) {
        //** 1 Assign the parameter variable nwClient to
        //**   the attribute nwClient
        //**   Hint use this.nwClient
        this.nwClient = nwClient;
    }
    
    // Broker model state change listener registration methods
    /**-----------------------------------------------------------
     * Adds requester to the list of objects to be notified when an
     * object(Customer, Portfolio or Stock) in the broker model
     * alters state
     */
    public void addChangeListener(IPriceView bv)
    throws BrokerException {
        //** 1 Leave this method empty for now.
        //     It will be discussed later during the Advance Multi-Tier
        //     module
    	this.changeListeners.add(bv);
    }
    
    /**-----------------------------------------------------------
     * This method notifies all registered BrokerView listeners
     * that a customer object has changed.
     */
    private void fireModelChangeEvent(PriceModel cust) {
        for (IPriceView v: changeListeners) {
            try {
                v.handlePriceChange(cust);
            } catch(Exception e) {
                e.toString();
            }
        }
    }
    
    // Iteration 1 Customer segment broker model methods
    // Customer segment state change methods
    /**----------------------------------------------------------
     * Adds the Customer to the broker model
     */
    public void addPrice(PriceModel cust)
    throws BrokerException {
        Command cmd;
        Object result;
        try {
            cmd = new AddPriceCommand(cust);
            nwClient.send(cmd);
            cmd = (Command) nwClient.receive();
            result = cmd.getResult();
            fireModelChangeEvent(cust);
        } catch(Exception e) {
            throw new BrokerException(e.toString());
        }
    }
    
    /**-------------------------------------------------------------
     * deletes the customer from the broker model
     */
    public void deletePrice (PriceModel cust)
    throws BrokerException{
        Command cmd;
        Object result;
        try {
            //** 1 Create a DeleteCustomerCommand using cust and
            //**   assign it to cmd
            cmd = new DeletePriceCommand(cust);
            //** 2, 3, 4 Remaining 3 lines of code are identical to
            //**         the addCustomer method
            nwClient.send(cmd);
            cmd = (Command) nwClient.receive();
            result = cmd.getResult();
            fireModelChangeEvent(cust);
        } catch(Exception e) {
            throw new BrokerException(e.toString());
        }
    }
    
    /**-------------------------------------------------------------
     * Updates the customer in the broker model
     */
    public void updatePrice (PriceModel cust)
    throws BrokerException {
        Command cmd;
        Object result;
        try {
            //** 1 Create a UpdateCustomerCommand using cust and
            //**   assign it to cmd
            cmd = new UpdatePriceCommand(cust);
            //** 2, 3, 4 Remaining 3 lines of code are identical to
            //**         the addCustomer method
            nwClient.send(cmd);
            cmd = (Command) nwClient.receive();
            result = cmd.getResult();  
            fireModelChangeEvent(cust);
        } catch(Exception e) {
            throw new BrokerException(e.toString());
        }
    }
    
    // Customer segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Customer from the model
     */
    public PriceModel getPrice(String id)
    throws BrokerException {
        Command cmd;
        Object result;
        PriceModel cust = null;
        try {
            //** 1 Create a GetCustomerCommand using id and
            //**   assign it to cmd
            cmd = new GetPriceCommand(id);
            //** 2, 3, 4 Remaining 3 lines of code are identical to
            //**         the addCustomer method
            nwClient.send(cmd);
            cmd = (Command) nwClient.receive();
            result = cmd.getResult();            
            //** 5 Cast result to Customer and assign to cust
            cust = (PriceModel) result;
            
        } catch(Exception e) {
            throw new BrokerException(e.toString());
        }
        return cust;
    }
    
    /**-------------------------------------------------------------
     * Returns all customers in the broker model
     */
    public PriceModel[] getAllPrices()
    throws BrokerException{
        Command cmd;
        Object result;
        PriceModel[] customers = null;
        try {
            //** 1 Create a GetAllCustomersCommand and
            //**   assign it to cmd
            cmd = new GetAllPricesCommand();
            //** 2, 3, 4 Remaining 3 lines of code are identical to
            //**         the addCustomer method
            nwClient.send(cmd);
            cmd = (Command) nwClient.receive();
            result = cmd.getResult();            
            //** 5 Cast result to Customer[] and assign to customers
            customers = (PriceModel []) result;
        } catch(Exception e) {
            throw new BrokerException(e.toString());
        }
        return customers;
    }
}