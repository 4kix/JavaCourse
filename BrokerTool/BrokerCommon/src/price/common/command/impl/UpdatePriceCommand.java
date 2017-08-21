package price.common.command.impl;
import price.common.command.Command;
import price.common.model.IPriceModel;
import price.common.model.PriceModel;

public class UpdatePriceCommand extends Command{
    
    PriceModel pr;
    /** Creates new AddCustomerCommand */
    public UpdatePriceCommand(PriceModel pr) {
        this.pr = pr;
    }
    
    public void execute(IPriceModel prI) {
        try {
            prI.updatePrice(pr);
        } catch (Exception ex) {
            this.excep = ex;
        }
    }
}
