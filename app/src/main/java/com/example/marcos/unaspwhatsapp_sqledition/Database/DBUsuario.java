package com.example.marcos.unaspwhatsapp_sqledition.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import com.example.marcos.unaspwhatsapp_sqledition.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;


public class DBUsuario {

    private int id;
    private String email;
    private String senha;
    private String nome;

    public String _mensagem;
    public boolean _status;

    public DBUsuario() {
        super();
        this.id = -1;
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    public DBUsuario(AppCompatActivity activity) {

    }

    public ArrayList<DBUsuario> getLista() {
        DB db = new DB();
        ArrayList<DBUsuario> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT * FROM newuser");
            if (resultSet != null) {
                while (resultSet.next()) {

                    DBUsuario obj = new DBUsuario();

                    obj.setId(resultSet.getInt("user_id"));
                    obj.setNome(resultSet.getString("user_name"));
                    obj.setEmail(resultSet.getString("user_email"));
                    obj.setSenha(resultSet.getString("user_password"));
                    lista.add(obj);

                }
            }
        } catch (Exception ex) {
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }

    public void salvar(String s) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, LoginException {
        String comando = "";
        if (this.getId() == -1) {
<<<<<<< HEAD
            comando = String.format("INSERT INTO newuser (user_name,user_email,user_password) VALUES ('%s','%s','%s');",
                    this.getNome(), this.getEmail(), this.getSenha());
=======
            comando = String.format("INSERT INTO usuario (nome,login,senha) VALUES ('%s','%s','%s');",
                    this.getNome(), this.getLogin(), this.getSenha());
>>>>>>> 7d0c28f229abc2fab43d8064c912c33c99fae0ec
        } else {
            comando = String.format("UPDATE newuser SET nome ='%s', login ='%s', senha = '%s', WHERE id = %d;",
                    this.getNome(), this.getEmail(), this.getSenha(), this.getId());
        }
        DB db = new DB();
        db.update(comando);
    }

    public void apagar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String comando = String.format("DELETE FROM newuser WHERE user_id = %d;", this.getId());
        DB db = new DB();
        db.execute(comando);
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


