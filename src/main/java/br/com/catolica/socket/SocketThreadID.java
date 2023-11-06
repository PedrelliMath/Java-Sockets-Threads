package main.java.br.com.catolica.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.UUID;

public class SocketThreadID extends Thread{
    private Socket socket;
    
    public SocketThreadID(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            UUID id = (UUID) input.readObject();
            System.out.println("Recebido: " + id.toString());
            input.close();
            socket.close();
        }catch(IOException e){
            System.out.println("Erro: " + e.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
