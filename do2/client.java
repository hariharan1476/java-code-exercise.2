import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 12345;
        Socket clientSocket = new Socket(serverAddress, serverPort);

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        int expectedSequenceNumber = 0;

        while (true) {
            try {
                String message = in.readUTF();
                int sequenceNumber = in.readInt();

                if (sequenceNumber == expectedSequenceNumber) {
                    System.out.println("Received: " + message);
                    out.write(sequenceNumber);
                    expectedSequenceNumber++;
                } else {
                    // Out-of-order packet, discard and request retransmission
                    out.write(expectedSequenceNumber - 1);
                }
            } catch (EOFException e) {
                System.out.println("All messages received.");
                break;
            }
        }

        in.close();
        out.close();
        clientSocket.close();
    }
}
