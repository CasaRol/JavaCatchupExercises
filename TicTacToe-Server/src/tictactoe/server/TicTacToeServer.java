/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class TicTacToeServer {

    private ServerSocket server = null;
    private Socket client = null;
    private ObjectInputStream input = null;
    private PrintWriter output = null;
    private char[] game = null;

    public TicTacToeServer(int port) {
        try {
            game = new char[9];
            server = new ServerSocket(port);
            System.out.println("Server is now listening on port " + port);
            System.out.println("Awaiting client connection...");

            client = server.accept();
            System.out.println("Client has connected");

            input = new ObjectInputStream(client.getInputStream());

            while (input != null) {
                try {
                    char[] gameArray = (char[]) input.readObject();
                    System.out.println("Array has been filled");
                    for (int i = 0; i < gameArray.length; i++) {
                        System.out.println("index " + i + "= " + gameArray[i]);
                    }

                    //remove after testing!
                    System.exit(0);
                } catch (IOException IOE) {
                    System.out.println(IOE.toString());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TicTacToeServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                input.close();
                client.close();
            } catch (IOException IOE) {
                System.out.println(IOE.toString());
            }

        } catch (IOException IOE) {
            System.out.println(IOE.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        TicTacToeServer server = new TicTacToeServer(8080);
    }

}
