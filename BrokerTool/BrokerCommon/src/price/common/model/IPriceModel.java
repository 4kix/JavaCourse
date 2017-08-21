package price.common.model;

import price.common.view.IPriceView;

import trader.common.exception.BrokerException;

public interface IPriceModel {
	public void addChangeListener(IPriceView bv)
		    throws BrokerException;
		    
		    /**-------------------------------------------------------------
		     * Adds the Customer to the broker model
		     */
		    public void addPrice(PriceModel pr)
		    throws BrokerException;
		    
		    /**-------------------------------------------------------------
		     * Deletes the customer from the broker model
		     */
		    public void deletePrice(PriceModel pr)
		    	    throws BrokerException;
		    
		    /**-------------------------------------------------------------
		     * Updates the customer in the broker model
		     */
		    public void updatePrice(PriceModel pr)
		    	    throws BrokerException;
		    
		    // Customer segment state query methods
		    /**-------------------------------------------------------------
		     * Given an id, returns the Customer from the model
		     */
		    public PriceModel getPrice(String id)
		    throws BrokerException;
		    
		    /**-------------------------------------------------------------
		     * Returns all customers in the broker model
		     */
		    public PriceModel[] getAllPrices()
		    throws BrokerException;
}
