import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ServerThread(clientSocket).start();
        }
    }
}

class ServerThread extends Thread {
    private Socket clientSocket;
    private DataOutputStream out;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String[] messages = {"Message 1", "Message 2", "Message 3", "Message 4", "Message 5"};
            int expectedSequenceNumber = 0;

            for (String message : messages) {
                out.writeUTF(message);
                out.writeInt(expectedSequenceNumber);
                expectedSequenceNumber++;

                // Simulate packet loss by not acknowledging some messages
                if (expectedSequenceNumber % 2 != 0) {
                    String ack = in.readLine();
                    if (ack != null) {
                        int ackNumber = Integer.parseInt(ack);
                        expectedSequenceNumber = ackNumber + 1;
                    }
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
