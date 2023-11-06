package main.java.br.com.catolica.socket;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

public class Main {
    public static void main(String args[]){
        int numSockets = Integer.parseInt(args[0]);
        Socket[] socketList = new Socket[numSockets];
        for(int i = 0; i < numSockets; i++){
            try{
                Thread.sleep(100);
                socketList[i] = new Socket("127.0.0.1", 54321);
                System.out.println("Client: " + i + " conectou...");
                ObjectOutputStream output = new ObjectOutputStream(socketList[i].getOutputStream());
                output.writeObject(UUID.randomUUID());
                output.close();
                socketList[i].close();
            }catch(Exception e){
                System.out.println(
                    "Nao foi possivel estabeler a conexao do Client: " + i + " com o servidor "
                    + e.getMessage());
            }
        }
    }
}
