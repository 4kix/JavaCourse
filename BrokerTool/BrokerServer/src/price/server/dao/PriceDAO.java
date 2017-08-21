package price.server.dao;

import trader.common.exception.BrokerException;
import price.common.model.PriceModel;

public interface PriceDAO {
    void createPrice(PriceModel pr) throws BrokerException;
    void removePrice(PriceModel pr) throws BrokerException;
    void changePrice (PriceModel pr) throws BrokerException;
    PriceModel getPrice(String symbol) throws BrokerException;
    PriceModel[] getAllPrices() throws BrokerException;
    public boolean symbolExists(String symbol);
}