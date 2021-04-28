package my.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws Exception {
        int port = Integer.parseInt(System.getenv("PORT"));
        System.out.println( "[MY-INFO] ================================ Starting Jetty-server on port: " + port );
        Server server = new Server(port);
        server.setHandler(new MyHandler());
        server.start();
        server.join();
    }

    public static class MyHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            response.getWriter().println("<h1>Bu-bu-bu</h1>");
        }
    }


}
