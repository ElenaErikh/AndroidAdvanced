package lesson_6.HW6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {
    final static int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен!");

            try (Socket socket = server.accept()) {
                System.out.println("Клиент подключился");

                try(Scanner inSocket = new Scanner(socket.getInputStream());
                    Scanner inConsole = new Scanner(System.in);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

                    Thread t1 = new Thread(()->{
                        while (true){
                                String str2 = inConsole.nextLine();
                                out.println(str2);
                                if (str2.equals("/end")) {
                                    System.out.println("Вы отключились");
                                    break;
                                }
                        }
                    });
                    t1.setDaemon(true);
                    t1.start();

                    while (true) {
                        try {
                            String str = inSocket.nextLine();
                            if (str.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }
                            System.out.println("Клиент: " + str);
                        }catch (NoSuchElementException ex) {
                            return;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
