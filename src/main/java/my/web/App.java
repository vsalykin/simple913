package my.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        int PORT;

        My.outPrintln("================================================= " + "My started!003");
        PORT = Integer.parseInt(System.getenv("PORT"));
        My.outPrintln("System.getenv(\"PORT\"):" + PORT);
        try{
            var server = new Server(PORT);
            server.Go();
        }
        catch(Exception e){My.errPrintln("MyException: " + e.toString());}
        catch(Error e){My.errPrintln("MyError: " + e.toString());}
        My.outPrintln("================================================= " + "[END]");
    }


}

class Server
{
    private final ServerSocket serversocket;
    private final Socket socket;
    private final InputStream inputstream;
    private final OutputStream outputstream;
    private final Scanner scanner;
    private final PrintWriter printwriter;

    public Server(int port) throws IOException {
        serversocket = new ServerSocket(port);
        My.outPrintln("Server wait for connection...");
        socket = serversocket.accept(); //wait for request
        My.outPrintln("... connection!");
        inputstream = socket.getInputStream();
        outputstream = socket.getOutputStream();
        scanner = new Scanner(inputstream, StandardCharsets.UTF_8);
        printwriter = new PrintWriter(new OutputStreamWriter(outputstream, StandardCharsets.UTF_8),true);
        My.outPrintln("Server created.");
    }

    public void Go(){
        printwriter.println("Hello!\n" +
                "Please connect to me on https://simple913.herokuapp.com/:" + socket.getPort() + "\n" +
                "Enter BYE to exit.");
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            My.outPrintln("Server got: " + s);
            if(s.trim().equals("BYE")) break;
            printwriter.println("Нравится! (" + s + ")");
        }
        My.outPrintln("Connection closed.");
    }
}

class My{
    public static String out(String string){
        return "[MY OUT] " + string;
    }
    public static void outPrintln(String string){
        System.out.println(out(string));
    }
    public static String err(String string){
        return "[MY ERR] " + string;
    }
    public static void errPrintln(String string){
        System.out.println(err(string));
    }


    private My(){};
}
