package price.server.network;

import price.common.model.IPriceModel;
import price.server.dao.PriceDAO;
import price.server.dao.PriceDAOImpl;
import price.server.model.PriceModelImpl;
import price.common.command.Command;
import price.common.command.impl.AddPriceCommand;
import price.common.command.impl.DeletePriceCommand;
import price.common.model.PriceModel;

class CommandTester {
    
    public static void main(String args[]){
        String dbHost = "localhost";
        PriceModel cust = new PriceModel("SUNW2", 1);
        Command addCmd = new AddPriceCommand(cust);
        Command delCmd = new DeletePriceCommand(cust);
        //Command getCmd = new GetCustomerCommand("333_33_3333");
        System.out.println("CommandTester - AddCommand & " +
                "DeleteCommand Unit Test");
        try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            PriceDAO brokerDAO = new PriceDAOImpl(dbHost);
            IPriceModel brokerModel = new PriceModelImpl(brokerDAO);
            System.out.println("Adding Customer " + cust);
            addCmd.execute(brokerModel);
            Thread.sleep(5000);
            System.out.println("Deleting Customer " + cust);
            delCmd.execute(brokerModel);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
