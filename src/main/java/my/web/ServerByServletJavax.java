//package my.web;
//
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
//
//import java.io.IOException;
//
//public class ServerByServletJavax extends HttpServlet {
//    public static Server GetServer(int port) {
//        Server server = new Server(port);
//        var context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//
//        server.setHandler(context);
//        context.addServlet(new ServletHolder(new ServerByServletJavax()), "/*");
//
//        return server;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().println("<h1>ServerByServletJavax</h1>");
//    }
//}

//Чтоб заработало надо:
//  - в помке в депеннсак поменять версию jetty-servlet с <version>11.0.2</version> на <version>7.6.0.v20120127</version>
//  - в помке в депеннсак отключить вообще jetty-server (не нужен, а его 11.0.2 версия как-то конфликтует)
//  - в помке в депеннсак подключить (javax)  servlet-api:
//    <dependency>
//      <groupId>javax.servlet</groupId>
//      <artifactId>servlet-api</artifactId>
//      <version>2.5</version>
//    </dependency>
//  - убрать вообще класс ServerByServletJakarta
//  - убрать вообще класс ServerByHandler
//И, ессно, потом все вернуть назад, а заремить текущий класс.