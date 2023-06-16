package com.william.notasdinheiro;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CopyScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_screen);
        TextView textViewNota = findViewById(R.id.textViewNota);
        Button buttonClip = findViewById(R.id.buttonClip);


        ArrayList<String> nota;
        nota = receberNota();



        String notaContextualizada = escreverNota(nota);

        textViewNota.setText(notaContextualizada);



        buttonClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                copyToClipBoar(notaContextualizada);
                Funcoes.toastMsg(getApplicationContext(),"Adicionado ao campo de tranferencia");

            }
        });

    }
    public ArrayList<String> receberNota(){
        ArrayList<String> nota = getIntent().getStringArrayListExtra("nota");
        return nota;

    }
    public String escreverNota(ArrayList<String> nota){

        String notaContextualizada = "";
        for (String linha:nota) {
            notaContextualizada = notaContextualizada + linha +"\n\n";
        }
        return  notaContextualizada;

    }
    public  void copyToClipBoar(String nota){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("nota",nota);
        clipboard.setPrimaryClip(clip);

    }
}