package price.common.controller;

import price.common.model.PriceModel;

public interface IPriceController {
    
    void handleGetPriceGesture(String id);
    
    
    void handleAddPriceGesture(PriceModel c);
    
    void handleDeletePriceGesture(PriceModel c);
    
    void handleUpdatePriceGesture(PriceModel c);
    

    void handleGetAllPricesGesture();
    
    // Portfolio segment - TBD in future iteration
    // Add method to handle portfolio related user gesture
    // notifications from the broker view
    
    // Stock segment - TBD in future iteration
    // Add method to handle stock related user gesture
    // notifications from the broker view
}