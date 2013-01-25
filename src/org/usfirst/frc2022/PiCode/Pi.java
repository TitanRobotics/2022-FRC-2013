package org.usfirst.frc2022.PiCode;

import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.util.SquawkHashtable;
import com.sun.squawk.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.microedition.io.Connector;
import javax.microedition.io.ServerSocketConnection;
import javax.microedition.io.SocketConnection;

/**
 *Receives data from the CRio
 * ************************** This class still needs to send data back to the
 * ************************** main robot program
 */
public class Pi {
    
    private static SquawkHashtable data;
    private static InputStream cRioStream;
    private static InputStreamReader reader;
    private static BufferedReader bufferReader;
    private static Thread connection;
    
    private static ServerSocketConnection server;
    private static SocketConnection socket;
    private static final int PORT = 444;
    private static boolean updating;
    
    /**
     * Open and accept new connections
     */
    public Pi(){
        
        server = null;
        data = new SquawkHashtable();   //Dictionary of data
        reader = null;
        bufferReader = null;
        updating = false;
        
        connection = new Thread(){
            public void run(){
                acceptConnections();
            }
        };
        
        connection.start();           
    }
    
    /** 
     * Updates the dictionary with new variables
     * @param s key
     * @param o value
     */
    private static void newVariable(String name, Object variable){
        data.put(name, variable);
    }
    
    /**
     * @param s key
     * @return The object that corresponds to the key in the dictionary
     */
    public static Object getVariable(String name){
        return data.get(name);
    }
    
    /**
     * Accepts connections on the specified port
     */
    private synchronized void acceptConnections() {
        while (true) {
            try {
                server = (ServerSocketConnection) Connector.open("socket://:" + PORT);
                break;
            } 
            catch (IOException ex) {
                try {
                    Thread.sleep(2000);
                } 
                catch (InterruptedException ex1) {
                    ex1.printStackTrace();
                }
            }
        }

        try {
                socket = (SocketConnection) server.acceptAndOpen();

                //setSocketOption?
                
        } 
        catch (IOException ex) {
            System.out.println("LOST SERVER!");
            ex.printStackTrace();
        }
        try {
            
            cRioStream = socket.openInputStream();
        } 
        catch (IOException ex){
            System.out.println("Input failed");
        }
        
        reader = new InputStreamReader(cRioStream);
        bufferReader = new BufferedReader(reader);
        
        if (updating == false)
        {
            updating = true;
            new Thread() {
            public void run() {
                while(true) {
                    update();
                    }
                }
            }.start(); 
        }
        
    }
    
    /**
     * Updates values sent by the robot's main program
     */
    public void update()
    {
        if(bufferReader != null)
        {
            try 
            {
                while (bufferReader.ready())
                {                    
                    String message;
                    while ((message = bufferReader.readLine()) != null) 
                    {
                        StringTokenizer st = new StringTokenizer(message, " \n\r\t\f");
                        if (st.countTokens() > 0)
                        {
                    
                        /**values are passed through UDP in the format
                         * (Distance, x1, y1, x2, y2, x3, y3, x4, y4)
                         * This handles that using the switch statement for each
                         * different value to store them in a hashtable
                         */
                            for (int i = 0; i < st.countTokens(); i++)
                            {
                                String index = new Integer(i).toString();
                                String value = st.nextToken();
                                
                                newVariable(index, value);
                            }
                        }
                        
                        // TODO: If handling other data types than floats,
                        // those would be done here.
                    }
                }
                    
            } 
            catch (IOException z) {
                System.out.println("Update failed");
            }
        }
    }
}
