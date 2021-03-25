package my.web;


import java.util.Map;

public class App
{
    public static void main(String[] args) {
        int PORT;
        System.out.println("[MY OUT] ================================================= My started!2");
        PORT = Integer.parseInt(System.getenv("PORT"));
        System.out.println("System.getenv(\"PORT\"):" + PORT);
        System.out.println("=======================================================================");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
        System.out.println("=======================================================================");
    }


}
