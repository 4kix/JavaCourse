/*
 * DeleteCustomerCommand.java
 *
 * Created on February 2, 2007, 12:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package price.common.command.impl;
import price.common.command.Command;
import price.common.model.IPriceModel;
import price.common.model.PriceModel;

/**
 *
 * @author vp200359
 */
public class DeletePriceCommand extends Command {
    PriceModel pr;
    /** Creates a new instance of DeleteCustomerCommand */
    public DeletePriceCommand(PriceModel pr) {
        this.pr = pr;
    }
    
    public void execute (IPriceModel prI) {
        try {
            prI.deletePrice(pr);
        } catch (Exception ex) {
            this.excep = ex;
        }
    }
}
