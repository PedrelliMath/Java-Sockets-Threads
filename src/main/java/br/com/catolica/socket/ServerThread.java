package main.java.br.com.catolica.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("Servidor aberto na porta 54321\nAguardando conexoes...\n");
        
        while (true) {
            Socket socket = serverSocket.accept();
            SocketThreadID thread = new SocketThreadID(socket);
            System.out.println("Criada uma nova Thread, ID: " + thread.getId());
            thread.start();
        }
    }
}