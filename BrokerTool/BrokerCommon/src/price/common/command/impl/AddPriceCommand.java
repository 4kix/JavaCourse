package price.common.command.impl;
import price.common.command.Command;
import price.common.model.IPriceModel;
import price.common.model.PriceModel;

public class AddPriceCommand extends Command {
    PriceModel pr; // receiver
    
    /** Creates new AddCustomerCommand */
    public AddPriceCommand(PriceModel pr) {
        this.pr = pr;
    }
    
    
    public void execute(IPriceModel prI) {
        try {
            prI.addPrice (pr);
        } catch (Exception ex) {
            this.excep = ex;
        }
    }
}