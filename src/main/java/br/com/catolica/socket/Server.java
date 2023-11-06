package main.java.br.com.catolica.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("Servidor aberto na porta 54321\nAguardando conexao...\n");
        Socket socket = server.accept();
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        UUID id = (UUID) input.readObject();
        System.out.println("Recebido: " + id.toString());
        input.close();
        socket.close();
        server.close();
    }
}
