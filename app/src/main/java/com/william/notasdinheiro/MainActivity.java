package com.william.notasdinheiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonCreate;
    private ArrayList<String> nota = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Teste
        nota.add("william");
        nota.add("R$ 234");
        nota.add("20-03-2023");


        buttonCreate = findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("desenvolvimento","Botão clicado ");
                sendObject(nota);
            }
        });
    }

    public void sendObject(ArrayList<String> nota){
        Intent intent = new Intent(this,CopyScreen.class);
        intent.putStringArrayListExtra("nota",nota);
        startActivity(intent);
    }
}