import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        System.out.println("Server is open");
        try {
            ServerSocket serverSocket = new ServerSocket(123);
            Socket socket = serverSocket.accept();
            System.out.println("Client is connected");

            //asking input from user

            BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in));

            //taking input from socket

            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter= new PrintWriter(outputStream);

            String sendingmessage, receivingmessage;
            while(true) {
                sendingmessage =userInput.readLine();

                printWriter.println(sendingmessage);
                printWriter.flush();
                
                receivingmessage = socketInput.readLine();
                System.out.println("message from client: "+ receivingmessage);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}