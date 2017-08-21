package price.client.controller;

import price.common.model.IPriceModel;
import price.common.view.IPriceView;
import price.common.controller.IPriceController;
import price.common.model.PriceModel;

public class IPriceControllerImpl implements IPriceController {
    private IPriceModel model;
    private IPriceView view;
  
    /** Creates new BrokerControllerImpl */
    public IPriceControllerImpl(IPriceModel model, IPriceView view) {
        try {
            //** 1 Assign method atrribute, model to this instance of BrokerModel
            this.model = model;
            //** 2 Assign method attribute, view to this instance of BrokerView
            this.view = view;
            //** 3 Register this object as a user gesture listener with
            //**   the view object
            //**   Hint - invoke addUserGestureListener
            view.addUserGestureListener(this);
        } catch(Exception e) {
            reportException(e);
        }
    }

    private void reportException(Object o) {
        // The responsibility of this method is to report exceptions
        // It calls the view's showDisplay method
        try {
            view.showDisplay(o);
        } catch(Exception e) {
            System.out.println("BrokerControllerImpl reportException " + e);
        }
    }
    
    //user gesture call back methods
    /* ---------------------------------------------------------------
     * get customer user gesture handle method called by
     * view in response to the get customer button click on the GUI or
     * equivalent user interface.
     * action - set customer display on the gui through the
     * showDisplay method of the view
     */
    public void handleGetPriceGesture(String id) {
        System.out.println("handleGetCustomerGesture " + id);
        PriceModel cust = null;
        try {
            //** 1 Set cust to the object returned as a result of
            //**   invoking the getCustomer method on model
            cust = model.getPrice(id);
            //** 2 Invoke showDisplay method of view with cust
            //**   as parameter
            view.showDisplay(cust);
        } catch(Exception e) {
            reportException(e);
        }
    }
  
    /* ---------------------------------------------------------------
     * add new customer user gesture handle method called by
     * view in response to the add customer button click on the
     * GUI or equivalent user interface.
     * action - add the (new) customer customer to the model
     */
    public void handleAddPriceGesture(PriceModel c) {
        System.out.println("handleAddCustomerGesture " + c);
        try {
            //** 1 Invoke addCustomer method of model with c
            //**   as parameter
            model.addPrice(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
    /* ---------------------------------------------------------------
     * delete customer user gesture handle method called by
     * view in response to the delete customer
     * button click on the GUI or equivalent user interface
     * action  - delete the customer from the model
     */
    public void handleDeletePriceGesture(PriceModel c){
        System.out.println("handleDeleteCustomerGesture " + c);
        try {
            //** 1 Invoke deleteCustomer method of model with c
            //**   as parameter
            model.deletePrice(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
    /* ---------------------------------------------------------------
     * update customer user gesture callback method called by
     * view in response to the update customer
     * button click on the GUI or equivalent user interface
     * action  - update the customer in the model
     */
    public void handleUpdatePriceGesture(PriceModel c){
        System.out.println("handleUpdateCustomerGesture " + c);
        try {
            //** 1 Invoke updateCustomer method of model with c
            //**   as parameter
            model.updatePrice(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
    /* ---------------------------------------------------------------
     * get all customers user gesture callback method called
     * by view in response to the get all customers
     * button click on the GUI or equivalent user interface
     * action - set all customers display on the gui through the
     * showDisplay method of the view
     */
    public void handleGetAllPricesGesture(){
        System.out.println("handleGetAllCustomerGesture ");
        PriceModel custs[];
        try {
            //** 1 Invoke getAllCustomers method of model
            //**   Assign the return value from this method to custs
            custs = model.getAllPrices();
            //** 2 Invoke showDisplay method of view with custs
            //** as parameter
            view.showDisplay(custs);
        } catch(Exception e) {
            reportException(e);
        }
    }
}