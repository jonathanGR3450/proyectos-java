/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class comando {
    Process process;
    InputStream inputstream = process.getInputStream();
    BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
    
    public comando(){
        try {
            process = Runtime.getRuntime().exec("lsb_release -a");
        } catch (IOException ex) {
            Logger.getLogger(comando.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.enviar();
    }
    public void enviar(){
        try {
            String [] cmd = {"DATE"}; 
            Runtime.getRuntime().exec(cmd);
    } catch (IOException ioe) {
	System.out.println (ioe);
    }
    }

}
