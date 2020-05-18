package mep.easyeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import mep.easyeats.BD.Usuario;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Context w = this;
        final EditText edtNome = (EditText) findViewById(R.id.edtNome);
        final EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        final EditText edtSenha = (EditText) findViewById(R.id.edtPassword);
        final EditText edtPhone = (EditText) findViewById(R.id.edtPhone);

        Button cadastra = (Button) findViewById(R.id.btnCadastro);
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usr = new Usuario();
                usr.setNome(edtNome.getText().toString());
                usr.setTelefone(edtPhone.getText().toString());
                usr.setEmail(edtEmail.getText().toString());
                usr.setSenha(edtSenha.getText().toString());
                usr.cadastrar();
                if(usr.is_status())
                Snackbar.make(v, "Deu bom", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                else
                {
                    Snackbar.make(v, "n deu bom "+usr.get_mensagem(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });
    }
}
