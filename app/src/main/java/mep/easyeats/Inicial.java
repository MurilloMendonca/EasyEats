package mep.easyeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context esse = this;
        setContentView(R.layout.activity_inicial);
        Button cadastrar = findViewById(R.id.btnSignUp);
        Button entrar = findViewById(R.id.btnLogIn);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(esse, SignUp.class);
                startActivity(sign);
            }
        });
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(esse, LogIn.class);
                startActivity(sign);
            }
        });




    }
}
