package price.client.view;

import java.io.Serializable;

import price.common.model.IPriceModel;
import price.common.view.IPriceView;
import price.client.gui.PriceGui;
import price.common.controller.IPriceController;
import price.common.model.PriceModel;
import trader.common.exception.BrokerException;

public class PriceViewImpl implements IPriceView, Serializable {
    private final transient PriceGui gui;
    private IPriceModel model;
    private IPriceController controller;
    
    /** Creates a new instance of BrokerViewImpl */
    public PriceViewImpl(IPriceModel model, PriceGui gui) {
        System.out.println("Creating BrokerViewImpl");
        try {
            //** 1 Assign atrribute model to this instance of BrokerModel
            this.model = model;
            //** 2 Invoke the addChangeListener method of the model with
            //     this instance of BrokerViewImpl as the input parameter
            model.addChangeListener(this);
        } catch (Exception e) {
            System.out.println("BrokerViewImpl constructor " + e);
        }
        //** 3  Assign attribute gui to this instance of BrokerGui
        this.gui = gui;
    }
        
    //user gesture listener registration methods
    /* ---------------------------------------------------------------
     * adds requester to the list of objects to be notified of user
     * gestures entered through a user interface such as a GUI.
     * User getsures for the customer segment are add, delete, update
     * get and getAll customers. There are similar user gestures for
     * portfolio and stock segments
     */
    public void addUserGestureListener(IPriceController b)
    throws BrokerException {
        System.out.println("BrokerViewImpl.addUserGestureListener " + b);
        //** 1 Inform the gui of the controller b
        //     Hint: call the gui's addController method
        gui.addController(b);
    }
    
    //display selection request service methods
    /* ------------------------------------------------------------
     * shows the display page specified by the broker controller
     * Calls the displayObject(obj) in BrokerGUI to accomplish the task.
     */
    public void showDisplay(Object display) throws BrokerException {
        System.out.println("BrokerViewImpl.showDisplay " + display);
        //** 1 Forward the parameter display to the displayObject(obj)
        //     method of the gui
        gui.displayObject(display);
    }
    
    // iteration 1 Customer segment broker view methods
    /* ---------------------------------------------------------------
     * callback method to handle customer state change notification
     * from the broker model
     */
    public void handlePriceChange(PriceModel cust)
    throws BrokerException{
        System.out.println("BrokerViewImpl.processCustomer " + cust);
        //** 1 Forward the parameter cust to the displayObject(obj)
        //     method of the gui
        gui.displayObject(cust);
    }
}