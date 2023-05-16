import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleTelnet {

    public static void main(String[] args) throws IOException {
        final String HOST_NAME = "httpbin.org"; // example
        final String URI_LOCATION = "";
        final String MESSAGE = "";
        
        Socket socket = new Socket(HOST_NAME, 80);
        
        InputStream response = socket.getInputStream();
        OutputStream request = socket.getOutputStream();
        
        byte[] data = ("GET /" + URI_LOCATION + " HTTP/1.1\n"
                + "Host: " + HOST_NAME + "\n\n"
                + MESSAGE).getBytes();
        
        request.write(data);
        
        int c;
        
        while ((c = response.read()) != -1) {
            System.out.print((char) c);
        }
        
        socket.close();
    }   

}
