import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {





        {
            try {
                Socket socket = new Socket("localhost", 123);

                // asking user input with buffer
                BufferedReader userInputBuffer = new BufferedReader(new InputStreamReader(System.in));
                String sendingmessage, receivingmessage;

                //taking data from buffer
                BufferedReader socketBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream);
                while(true) {
                    receivingmessage = socketBuffer.readLine();
                    System.out.println("message from client: "+ receivingmessage);
                    sendingmessage =userInputBuffer.readLine();

                    out.println(sendingmessage);
                    out.flush();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}