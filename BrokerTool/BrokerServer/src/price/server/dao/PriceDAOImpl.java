

        
        /*
         * BrokerDAOImpl.java
         *
         * Created on December 20, 2006, 7:00 PM
         *
         * To change this template, choose Tools | Template Manager
         * and open the template in the editor.
         */

        package price.server.dao;

        import java.sql.*;
        import java.util.*;
        import trader.common.exception.BrokerException;
        import price.common.model.PriceModel;

        public class PriceDAOImpl implements PriceDAO {      
            private static Connection theConnection;
            /** Creates a new instance of PriceDAOImpl */
            public PriceDAOImpl() throws Exception{
                this("localhost");
            }
            public PriceDAOImpl(String hostName) throws Exception {
                String  database = "sample";     // --action StockMarket
                String url;
                try {
                    Class.forName("org.sqlite.JDBC");
                    url = "jdbc:sqlite:sample.db";
                    theConnection = DriverManager.getConnection(url, "public", "public");
                } catch (Exception e) {
                    e.toString();
                    throw e;
                }
            }
            protected Connection obtainConnection() throws SQLException{
                return theConnection;
            }

            /** ---------------------------------------------------------
             * This is a helper method used by many methods
             * It returns true if the symbol (ie price id) is found in
             * the Stock table
             */
            public boolean symbolExists(String symbol) {
                try {
                    Connection con = obtainConnection();
                    Statement stmt = con.createStatement();
                    ResultSet result = stmt.executeQuery
                            ("SELECT symbol FROM Stock WHERE symbol="+ "'" +symbol+ "'");
                    return result.next();
                } catch (SQLException e) {
                    System.err.println("in symbolExists, query for " + symbol + " failed");
                    e.toString();
                    return false;
                }
            }

            /**----------------------------------------------------------
             * Adds the Price to the price model interface
             */
            public void createPrice(PriceModel pr)
            throws BrokerException {
                try {
                    String symbol = null;
                    float price = 0;
                    Connection con;
                    Statement stmt;
                    int rowCount;
                    String request;
                    
                    symbol = pr.getSymbol();
                    price = pr.getPrice();
                    con = obtainConnection();
                    stmt = con.createStatement();
                    request = "INSERT INTO Stock (symbol, price) VALUES ("
                            + "'" + symbol + "'" + ","
                           
                            + "'" + price + "'" + ")";
                    rowCount = stmt.executeUpdate(request);
                } catch (Exception e) {
                    e.toString();
                    throw new BrokerException("BrokerDAOImpl.createCustomer\n" +e);
                }
            }
            
            /**-------------------------------------------------------------
             * deletes the customer from the broker model
             */
            public void removePrice (PriceModel pr)
            throws BrokerException{
                try {
                    String symbol = null;
                    Connection con;
                    Statement stmt;
                    int rowCount;
                    String request;      
                    symbol = pr.getSymbol();                
                    con = obtainConnection();
                    stmt = con.createStatement();
                    request = "DELETE FROM Stock WHERE symbol=" + "'" + symbol + "'";
                    rowCount = stmt.executeUpdate(request);
                 
                } catch (Exception e) {
                    e.toString();
                    throw new BrokerException("ModelImpl.removePrice\n" + e);
                }
            }
            
            /**-------------------------------------------------------------
             * Updates the customer in the broker model
             */
            public void changePrice(PriceModel pr)
            throws BrokerException {
                try {
                    String symbol = null;
                    
                    float price = 0;
                    Connection con;
                    Statement stmt;
                    String request;
                    int rowCount;
                    symbol = pr.getSymbol();
                    price = pr.getPrice();
                    con = obtainConnection();
                    stmt = con.createStatement();
                    request = "UPDATE Stock SET "
                            + " price=" + price  + " WHERE symbol=" +"'" + symbol + "'";
                   
                    rowCount = stmt.executeUpdate(request);
                } catch (Exception e) {
                    e.toString();
                    throw new BrokerException("BrokerModelImpl.changeCustomerInfo\n" + e);
                }
            }
      
            
            // Customer segment state query methods
            /**-------------------------------------------------------------
             * Given an ssn, returns the Customer from the model
             */
       public PriceModel getPrice(String symbol)
            throws BrokerException {
                try {
                	float price = 0;
                    Connection con;
                    Statement stmt;
                    ResultSet result = null;
                    String request;
                    con = obtainConnection();
                    stmt = con.createStatement();
                    PriceModel pr = null;
                    
                    request = "SELECT price FROM Stock "
                            + " WHERE symbol=" + "'" + symbol + "'";
                   
                    result = stmt.executeQuery(request);
                    
                    if (result.next()) {
                        price = result.getFloat(1);
                        pr = new PriceModel(symbol, price);
                    } else {
                        // if query failed
                        throw new BrokerException("Record for " + symbol + " not found.");
                    }
             
                    return pr;
                } catch (SQLException e) {
                    e.toString();
                    throw new BrokerException("BrokerModelImpl.findCustomer\n" + e);
                }
            }
            
            /**-------------------------------------------------------------
             * Returns all customers in the broker model
             */
public PriceModel[] getAllPrices()
            throws BrokerException{
	String symbol;
	float price = 0;
                Connection con;
                Statement stmt;
                ResultSet result = null;
                String request;
                PriceModel pr = null;
                PriceModel[] all;
                PriceModel[] temp = new PriceModel[1];
                ArrayList<PriceModel> aList = new ArrayList<PriceModel>(1);
                try {
                    
                    con = obtainConnection();
                 
                    stmt = con.createStatement();
                    
                    request = "SELECT * FROM Stock";
                
                    result = stmt.executeQuery(request);
                    while (result.next()) {
                      
                        symbol = result.getString(1);
                     
                        price = result.getFloat(2);
                       
                        pr = new PriceModel(symbol, price);
                      
                        aList.add(pr);
                    }
                    if (aList.size() > 0) {
                        
                        all =  aList.toArray(temp);
                    } else {
                        all = null;
                    }
                    return all;
                } catch (SQLException e) {
                    all = null;
                    e.toString();
                    throw new BrokerException("DAOImpl.findAllCustomers\n" + e);
                }
            }
        }
           