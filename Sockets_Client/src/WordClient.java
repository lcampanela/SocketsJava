import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class WordClient {
    public static void main(String[] args) throws Exception {
        //int svcPort=4000;
        Socket client = new Socket("localhost", Integer.parseInt(args[0]));
        //Socket client = new Socket("localhost", svcPort);
        // Stream to write to
        PrintWriter outSock = new PrintWriter(client.getOutputStream(), true);
        // Stream to read from
        BufferedReader inSock = new BufferedReader(new InputStreamReader(client.getInputStream()));

        long start = System.currentTimeMillis();
        // write command
        outSock.println("Um exemplo de pangram em Inglês: The quick brown fox jumps over the lazy dog");
        // read response
        System.out.println(inSock.readLine());
        long end = System.currentTimeMillis();
        System.out.println("Operation completed in: " + (end-start) + " ms");
        client.close();
    }
}
