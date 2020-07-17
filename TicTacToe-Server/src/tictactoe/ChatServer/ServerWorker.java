/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class ServerWorker extends Thread {

    private final Socket clientSocket;

    public ServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Method for the client work once created and started
    private void handleClientSocket() throws InterruptedException, IOException {
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line; 
        while((line = reader.readLine()) != null) {
            if("quit".equalsIgnoreCase(line)) {
                break;
            }
            String msg = "You typed: " + line + "\n";
            output.write(msg.getBytes());
        }
        
        clientSocket.close();
    }
}
