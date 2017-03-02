/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hudik1
 */
public class Client {

    static Logger logger = Logger.getLogger("client");
    private static final int port = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        logger.log(Level.INFO, "Start client");
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader intStd = new BufferedReader(new InputStreamReader(System.in));
            
            new Thread(new ConnectionHandler(in)).start();

            String newLine;
            while ((newLine = intStd.readLine()) != null) {
                out.println(newLine);
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
