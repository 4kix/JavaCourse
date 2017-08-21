package price.common.view;

import trader.common.exception.BrokerException;
import price.common.controller.IPriceController;
import price.common.model.PriceModel;

public interface IPriceView {
   
    void addUserGestureListener(IPriceController p)
    throws BrokerException;
    
  
    void showDisplay(Object display) throws BrokerException;
    
    
    void handlePriceChange(PriceModel p)
    throws BrokerException;
    
   
}