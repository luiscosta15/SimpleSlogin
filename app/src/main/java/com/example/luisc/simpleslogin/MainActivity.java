package com.example.luisc.simpleslogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private TextView att;
    private Button btn;

    private int att_count = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton();
    }

    public void loginButton(){
        user = (EditText)findViewById(R.id.user_Box);
        pass = (EditText) findViewById(R.id.pass_Box);
        att = (TextView) findViewById(R.id.attempts_count);
        btn = (Button) findViewById(R.id.button);

        att.setText(Integer.toString(att_count));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("Luis") && pass.getText().toString().equals("XPTO")){
                    Toast.makeText(MainActivity.this, "Login Aceite", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.luisc.simpleslogin.User");
                    intent.putExtra("User", user.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login rejeitado", Toast.LENGTH_SHORT).show();
                    att_count--;
                    att.setText(Integer.toString(att_count));
                }
            }
        });
    }

}
