package my.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.IOException;

public class App extends HttpServlet
{
    private static int ID = 0;

    public static void main(String[] args) {
        My.outPrintln("================================================= " + "My started!004 Jetty");
        int port = Integer.parseInt(System.getenv("PORT"));
        My.outPrintln("System.getenv(\"PORT\"):" + port);
        try{
            var server = new Server(port);
            var context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            //context.addLocaleEncoding();

            server.setHandler(context);
            context.addServlet(new ServletHolder(new App()), "/*");
            server.start();
            server.join();
        }
        catch(Exception e){My.errPrintln("MyException: " + e.toString());}
        catch(Error e){My.errPrintln("MyError: " + e.toString());}
        My.outPrintln("================================================= " + "END");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        String s = "<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/><title>HTTP method GET</title>\n" +
                "</head>\n<body>\n" +
                "<h2>Лерчик-колокольчик!</h2>\n" +
                "<p>P-r accessing /. Reason:\n<pre>    HTTP method GET == " + (++ID) + " ==</pre></p>\n" +
                "<hr /><i><small>Powered by Jetty&My</small></i>\n</body>\n</html>\n";
        resp.getWriter().print(s);
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
