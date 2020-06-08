package lesson_6.HW6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    final static String IP_ADDRESS = "localhost";
    final static int PORT = 8189;

    public static void main(String[] args){

            try (Socket socket = new Socket(IP_ADDRESS, PORT)) {
                System.out.println("Клиент подключился");

                try(Scanner inSocket = new Scanner(socket.getInputStream());
                    Scanner inConsole = new Scanner(System.in);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    Thread t1 = new Thread(() -> {
                        while (true){
                            try {
                                String str = inSocket.nextLine();
                                if (str.equals("/end")) {
                                    System.out.println("Сервер отключился");
                                    break;
                                }
                                System.out.println("Сервер: " + str);
                            }catch (NoSuchElementException ex){
                                return;
                            }
                        }
                    });
                    t1.setDaemon(true);
                    t1.start();

                    while (true) {
                        String str2 = inConsole.nextLine();
                        out.println(str2);
                        if (str2.equals("/end")) {
                            System.out.println("Вы отключились");
                            break;
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}
