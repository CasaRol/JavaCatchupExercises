/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class ChatServer {

    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listning to port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has been connected with the following: " + clientSocket);
                
                //Starting a new Thread for the new connection while still accepting new clients
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
