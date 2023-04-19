package com.william.notasdinheiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonCreate,
            buttonView;
    private EditText editTextTextPersonNameCodigo,
            editTextNumberDecimalDinheiro,
            editTextNumberDecimalPix,
            editTextNumberDecimalMoeda,
            editTextNumberDecimalDespesa,
            editTextNumberDecimalPremio,
            editTextTextPersonNameOutros,
            editTextTextPersonNameTotal,
            editTextTextPersonNameOutrosName;
    private ArrayList<String> nota = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editTextTextPersonNameCodigo = findViewById(R.id.editTextTextPersonNameCodigo);
        this.editTextNumberDecimalDinheiro  = findViewById(R.id.editTextNumberDecimalDinheiro);
        this.editTextNumberDecimalPix  = findViewById(R.id.editTextNumberDecimalPix);
        this.editTextNumberDecimalMoeda  = findViewById(R.id.editTextNumberDecimalMoeda);
        this.editTextNumberDecimalDespesa  = findViewById(R.id.editTextNumberDecimalDespesa);
        this.editTextNumberDecimalPremio  = findViewById(R.id.editTextNumberDecimalPremio);
        this.editTextTextPersonNameOutros = findViewById(R.id.editTextTextPersonNameOutros);
        this.editTextTextPersonNameTotal = findViewById(R.id.editTextTextPersonNameTotal);
        this.editTextTextPersonNameOutrosName = findViewById(R.id.editTextTextPersonNameOutrosName);

        //Teste
//        nota.add("william");
//        nota.add("R$ 234");
//        nota.add("20-03-2023");


        buttonCreate = findViewById(R.id.buttonCreate);
        buttonView = findViewById(R.id.buttonView);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextTextPersonNameCodigo.getText().toString().equals("")) {
                    Funcoes.dialogMsg(MainActivity.this,"Prencha o campo Codigo/nome","Invalido");
                } else if (editTextTextPersonNameTotal.getText().toString().equals("")) {
                    Funcoes.dialogMsg(MainActivity.this,"Prencha o campo Total","Invalido");
                } else{
                    //Limpa o array de notas para evitar repertições;
                    nota.clear();

                    nota.add(Funcoes.formatLinha("*Codigo/nome*",editTextTextPersonNameCodigo.getText().toString()));
                    if(!editTextNumberDecimalDinheiro.getText().toString().equals("")){
                        nota.add(Funcoes.formatLinha("*Dinheiro*",editTextNumberDecimalDinheiro.getText().toString()));
                    }
                    if(!editTextNumberDecimalPix.getText().toString().equals("")){
                        nota.add(Funcoes.formatLinha("*Pix*",editTextNumberDecimalPix.getText().toString()));
                    }
                    if(!editTextNumberDecimalMoeda.getText().toString().equals("")){
                        nota.add(Funcoes.formatLinha("*Moeda*",editTextNumberDecimalMoeda.getText().toString()));
                    }
                    if(!editTextNumberDecimalDespesa.getText().toString().equals("")){
                        nota.add(Funcoes.formatLinha("*Despesa*",editTextNumberDecimalDespesa.getText().toString()));
                    }
                    if(!editTextNumberDecimalPremio.getText().toString().equals("")){
                        nota.add(Funcoes.formatLinha("*Premio*",editTextNumberDecimalPremio.getText().toString()));
                    }
                    if(!editTextTextPersonNameOutros.getText().toString().equals("")){
                        String outrosName = editTextTextPersonNameOutrosName.getText().toString();
                        nota.add(Funcoes.formatLinha(String.format("*"+outrosName.trim()+"*") ,editTextTextPersonNameOutros.getText().toString()));
                    }
                    nota.add(Funcoes.formatLinha("*Total*",editTextTextPersonNameTotal.getText().toString()));

                    Funcoes.toastMsg(getApplicationContext(),"Lista criada");
                    //O campo outros deve ocorrer uma verificação aplicar um titulo a ele
                }
                Log.i("desenvolvimento","Botão clicado create ");
                //sendObject(nota);
            }
        });
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("desenvolvimento","Botão clicado View");
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