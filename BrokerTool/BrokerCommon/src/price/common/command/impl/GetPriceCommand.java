package price.common.command.impl;
import price.common.command.Command;
import price.common.model.IPriceModel;
import price.common.model.PriceModel;

public class GetPriceCommand extends Command {
    String id;
    
    /** Creates new GetCustomerCommand */
    public GetPriceCommand(String symbol) {
        this.id = symbol;
    }
    
    public void execute(IPriceModel prI) {
        try {
            result = prI.getPrice(id);
            System.out.println("GetCustomerCommand.execute " + result);
        } catch (Exception ex) {
            this.excep = ex;
        }
    }
}