/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexa
 */
public class TicTacToeServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket serverSocket = new ServerSocket(8080);
        
        System.out.println("Server now listening on port 8080");
        
        System.out.println("Awaiting connection from client...");
        
        Socket socket = serverSocket.accept();
        
    }
    
}
