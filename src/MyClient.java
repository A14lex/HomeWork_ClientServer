import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        String host = "localhost" ;
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

        ) {
//          отправка на сервер название хоста, ip, №порта куда хотим подключиться
            InetAddress inetAddress = InetAddress.getByName(host);
            out.println(host + ", ip address: " +  inetAddress.getHostAddress()+ "; " + clientSocket.getPort());
            System.out.println("Получаем с сервера");
            String resp = in.readLine();
            System.out.println("Приянято с сервера: " +resp);
        }catch (RuntimeException | IOException e){
            System.out.println("Ошибка клиента");
            System.out.println(e.getMessage());
        }
    }
}
