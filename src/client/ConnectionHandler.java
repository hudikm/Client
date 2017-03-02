/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hudik1
 */
public class ConnectionHandler implements Runnable {

    BufferedReader in;

    public ConnectionHandler(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        String newLine;
        try {
            while ((newLine = in.readLine()) != null) {
                System.out.println(newLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
