import price.common.model.IPriceModel;
import price.server.dao.PriceDAO;
import price.server.dao.PriceDAOImpl;
import price.server.model.PriceModelImpl;
import price.server.network.CommandServer;

public class Broker3TierServer {
    
    public static void main(String args[]){
        String dbHost = "localhost";
        try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            PriceDAO brokerDAO = new PriceDAOImpl(dbHost);
            IPriceModel brokerModel = new PriceModelImpl(brokerDAO);
            CommandServer commandServer = new CommandServer(5280, brokerModel);
        } catch (Exception e) {
            System.out.println("Broker3TierServer err: " + e.getMessage());
        }
    }
}
