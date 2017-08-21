package price.common.command;
import java.io.*;

import price.common.model.IPriceModel;

public abstract class Command implements Serializable {
    protected Object    result = null;
    protected Exception excep = null;
    
    public abstract void execute(IPriceModel prI);
    /**
     * @exception  DuplicateException
     *     if another record has same primary key
     * @exception  RecordNotFoundException
     *     if no record is found in the table
     */
    
    public Object getResult( )  throws  Exception{
        if (this.result != null){
            return this.result;
        }
        if (this.excep != null){
            throw this.excep;
        }
        return null;
    }
}
