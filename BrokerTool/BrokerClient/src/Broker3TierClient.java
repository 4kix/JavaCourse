import price.client.controller.IPriceControllerImpl;
import price.client.gui.PriceGui;
import price.client.model.PriceModelNwImpl;
import price.client.network.NwClient;
import price.client.view.PriceViewImpl;
import price.common.controller.IPriceController;
import price.common.model.IPriceModel;

public class Broker3TierClient {
    
    public static void main(String args[]) {
        String modelHost = "localhost";
        try {
            if (args.length > 0) {
                modelHost = args[0];
            }

            NwClient nwClient = new NwClient(modelHost, 5280);
            IPriceModel model = (IPriceModel) new PriceModelNwImpl(nwClient);

            final PriceGui gui1 = new PriceGui(model);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    gui1.setVisible(true);
                }
            });
            
            PriceViewImpl view1 = new PriceViewImpl(model, gui1);
            IPriceController con1 = new IPriceControllerImpl(model, view1);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
         /*   final PriceGui gui2 = new PriceGui(model);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    gui2.setVisible(true);
                }
            });
            
            PriceViewImpl view2 = new PriceViewImpl(model, gui2);
            IPriceController con2 = new IPriceControllerImpl(model, view2);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/