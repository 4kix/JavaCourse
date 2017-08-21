/*
 * GuiLogHandler.java
 *
 * Created on February 13, 2007, 5:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package price.client.gui;

import java.util.logging.*;
/**
 *
 * @author vp200359
 */

public class GuiLogHandler extends Handler {
    
    /** Creates a new instance of GuiLoghandler */
    String logMessages = new String("");
    GuiLogService logDisplay;
    java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance();

    /** Creates a new instance of GuiLogHandler */    
    public GuiLogHandler(GuiLogService service){
        logDisplay = service;
    }
    
    public void publish(LogRecord logRecord){
        // **1 Format the log record and publish it using the GuiLogService object
        // **  logDisplay
        java.util.Date date = new java.util.Date(logRecord.getMillis());
        String dateString = df.format(date);
        logMessages = logRecord.getSequenceNumber() + " " + 
                      dateString + " " + 
                      logRecord.getLevel() + "\n" + 
                      logRecord.getMessage() + "\n" +
                      logRecord.getSourceClassName() + " " + 
                      logRecord.getSourceMethodName() + "\n";
        if (logRecord.getSequenceNumber() == 0) {
            logDisplay.setLog(logMessages);
        } else {
            logDisplay.addToLog(logMessages);
        }        
    }
    
    public void flush(){
    }
    public void close(){
        logMessages = null;
    }    
}
