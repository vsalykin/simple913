package my.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import org.eclipse.jetty.server.Server;

public class App extends HttpServlet
{
    public static void main(String[] args) {
        int PORT;

        My.outPrintln("================================================= " + "My started!003");
        PORT = Integer.parseInt(System.getenv("PORT"));
        My.outPrintln("System.getenv(\"PORT\"):" + PORT);
        try{


//            Server server = new Server(PORT);
//            Server server =
        }
        catch(Exception e){My.errPrintln("MyException: " + e.toString());}
        catch(Error e){My.errPrintln("MyError: " + e.toString());}
        My.outPrintln("================================================= " + "[END]");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        My.outPrintln("request=" + request);
        My.outPrintln("response=" + response);
        response.getWriter().print("Хаюшки!");
    }
}

class My
{
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
