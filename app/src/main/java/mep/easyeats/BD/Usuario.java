package mep.easyeats.BD;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Usuario extends  _Default{
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(){
        super();
        this.id =-1;
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.senha = "";
    }

    public ArrayList<Usuario> getUsuarios(){
        DB db = new DB();
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            ResultSet resultSet = db.executa("SELECT * FROM usuario");
            if(resultSet!=null){
                while(resultSet.next()){
                    Usuario obj = new Usuario();
                    obj.setId(resultSet.getInt("id"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setTelefone(resultSet.getString("telefone"));
                    obj.setSenha(resultSet.getString("senha"));
                    lista.add(obj);
                    obj=null;
                }
            }
        }catch (Exception e){
            this._status=false;
            this._mensagem= e.getMessage();
        }
        return  lista;
    }
    public void cadastrar(){
        String comando="";
        comando = String.format("INSERT INTO usuario (nome, email, telefone, senha) VALUES ('%s','%s','%s', '%s')",this.getNome(),this.getEmail(),this.getTelefone(), this.getSenha());
        DB db = new DB();
        db.executa(comando);
        this._mensagem= db._mensagem;
        this._status = db._status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
