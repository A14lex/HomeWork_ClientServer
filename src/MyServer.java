import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {
        // использую порт 8080, как в задании рекомендовано
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения

                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    //Выведите её на экран вместе с номером порта, с которого это соединение пришло
                    System.out.println("приняли от клиента: " + name);


                    //Отправляем клиенту, то что приняли от него и № порта с которого пришло соединение, т.е. № порта клиента, так думаю
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));


                }

            }

        } catch (IOException e) {
            System.out.println("Ошибка на сервере");
            e.printStackTrace();
        }


    }
}
