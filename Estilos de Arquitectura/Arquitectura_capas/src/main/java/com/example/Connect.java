package main.java.com.example;

public enum Connect {

    CONNECTION("localhost", 6666);

    private final String ip;
    private final int port;

    Connect (String ip, int port){
     this.ip = ip;
     this.port = port;
    }

    public String getIp (){
        return ip;
    }

    public int getPort (){
        return port;
    }




}
