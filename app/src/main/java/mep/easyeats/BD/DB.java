package mep.easyeats.BD;

import android.content.Context;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import mep.easyeats.SignUp;

public class DB extends _Default implements Runnable{
    private Connection conn;
    private String host="192.168.0.113";
    private String db = "easyEats";
    private int port = 55264;
    private String user = "testeDB";
    private String pass="";
    private String url = "jdbc:postgresql://%s:%d/%s";
    static private Properties props = new Properties();


    public DB()  {
        super();
        props.setProperty("user","tsgcavlyuuqpxz");
        props.setProperty("password","785e4ce0190c7ebe76a0535dca9c7b87aeda56e550df9f4859bbfef75ad850df");
        props.setProperty("sslmode","require");
        this.url = "jdbc:postgres://tsgcavlyuuqpxz:785e4ce0190c7ebe76a0535dca9c7b87aeda56e550df9f4859bbfef75ad850df@ec2-52-87-135-240.compute-1.amazonaws.com:5432/damkaa4ph631qs" ;

        this.conecta();
        this.disconecta();
    }

    @Override
    public void run() {
        try {
            this.conn = getConnection();
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {

        String dbUrl = "jdbc:postgresql://ec2-52-87-135-240.compute-1.amazonaws.com:5432/damkaa4ph631qs";
        String user = "tsgcavlyuuqpxz";
        String passw = "785e4ce0190c7ebe76a0535dca9c7b87aeda56e550df9f4859bbfef75ad850df";

        return DriverManager.getConnection(dbUrl, props);
    }


    public void conecta()  {
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
            e.printStackTrace();
        }
    }

    public  void disconecta()  {
        if(this.conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                this._mensagem = e.getMessage();
                this._status = false;
                e.printStackTrace();
            }
        }
    }

    public ResultSet executa(String query)
    {
        this.conecta();
        ResultSet resultSet = null;
        try{
            resultSet = new ExecutaDB(this.conn,query).execute().get();
        }catch (Exception e)
        {
            this._status=false;
            this._mensagem= e.getMessage();
            e.printStackTrace();
        }
        return  resultSet;
    }

}
