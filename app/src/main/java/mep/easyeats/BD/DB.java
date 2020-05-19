package mep.easyeats.BD;

import android.content.Context;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

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
    private Properties props = new Properties();

    public DB()  {
        super();
        props.setProperty("user","testeBD");
        props.setProperty("password","nextel111932");
        props.setProperty("ssl","true");
        this.url = "jdbc:postgresql://192.168.0.113:5432/easyeats" ;

        this.conecta();
        this.disconecta();
    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.props);
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
            e.printStackTrace();
        }
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
