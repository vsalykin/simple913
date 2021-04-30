package my.web;
// $ mvn clean compile && heroku local:start >txt
import org.eclipse.jetty.server.Server;

public class App {

    public static void main(String[] args)  {
        MyServer();
    }
    private static void MyServer(){
        int port = Integer.parseInt(System.getenv("PORT"));
        System.out.println( "[MY-INFO] ================================ Starting Jetty-server on port: " + port );
        Server server = null;
        try {
            //server = ServerByServletJakarta.GetServer(port);
            server = ServerByHandler.GetServer(port);
            //server = ServerByServletJavax.GetServer(port); //pom: jetty-server - rem, jetty-servlet - ver7.6.0...; mvn clean; idea: other Server - rem, (invalidate)

            server.start();
            server.join();
        }
        catch(Exception e){System.out.println( "[MY-INFO] MyException: " + e.toString());}
        catch(Error e){System.out.println( "[MY-INFO] MyError: " + e.toString());}
        System.out.println( "[MY-INFO] ================================ " + "END");
    }

}
