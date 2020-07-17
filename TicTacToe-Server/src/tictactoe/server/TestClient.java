/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CasaRol
 */
public class TestClient {

    private Socket client = null;
    private BufferedReader input = null;
    private ObjectOutputStream output = null;
    private char[] game = null;

    public TestClient(String address, int port) {
        System.out.println("Starting client...");
        try {
            game = new char[9];
            client = new Socket("127.0.0.1", 8080);
            
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Client is connected and ready. Please enter your message.");

        } catch (IOException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }

            try {
                for(int i = 0; i < game.length; i++) {
                    if(i == 5 || i == 2) {
                        continue;
                    }
                    game[i] = 'c';
                }
                output.writeObject(game);
                System.out.println("output written");
                output.flush();
                System.out.println("Flushing");
                client.close();
            } catch (IOException IoE) {
                System.out.println(IoE.toString());
            }
        

        /*try {
            input.close();
            output.close();
            client.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } */
    }

    public static void main(String[] args) {
        TestClient testClient = new TestClient("127.0.0.1", 8080);
    }
}
