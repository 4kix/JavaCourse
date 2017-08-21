package price.common.command.impl;
import price.common.command.Command;
import price.common.model.IPriceModel;
import price.common.model.PriceModel;

public class GetAllPricesCommand extends Command {
    public void execute(IPriceModel prI) {
        try {
            result = prI.getAllPrices();
        } catch (Exception ex) {
            this.excep = ex;
        }
    }
}