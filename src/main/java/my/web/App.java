package my.web;

public class App
{
    public static void main(String[] args) {
        int PORT;

        My.outPrintln("================================================= " + "My started!004 Jetty");
        PORT = Integer.parseInt(System.getenv("PORT"));
        My.outPrintln("System.getenv(\"PORT\"):" + PORT);
        try{
//            var server = new Server(PORT);
//            server.Go();
        }
        catch(Exception e){My.errPrintln("MyException: " + e.toString());}
        catch(Error e){My.errPrintln("MyError: " + e.toString());}
        My.outPrintln("================================================= " + "[END]");
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
