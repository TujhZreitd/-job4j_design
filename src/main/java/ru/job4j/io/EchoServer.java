package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter output = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n");
                    String firstString = input.readLine();
                    String[] msg = firstString
                            .replace("GET /?", "")
                            .replace(" HTTP/1.1", "")
                            .split("=");
                    if ("Exit".equals(msg[1])) {
                        server.close();
                    } else {
                        output.write(msg[1]);
                    }
                    output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
