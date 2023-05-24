package com.william.notasdinheiro;

import static android.support.v4.content.ContextCompat.getSystemService;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
            buttonView
            ;
    private EditText editTextTextPersonNameCodigo,
            editTextNumberDecimalDinheiro,
            editTextNumberDecimalPix,
            editTextNumberDecimalMoeda,
            editTextNumberDecimalDespesa,
            editTextNumberDecimalPremio,
            editTextTextPersonNameOutros,
            editTextTextPersonNameTotal,
            editTextTextPersonNameOutrosName;

    private Button buttonTrashNome,
            buttonTrashDinheiro,
            buttonTrashPix,
            buttonTrashMoeda,
            buttonTrashDespesa,
            buttonTrashPremio;

    private ArrayList<String> nota = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFindViewById();
        atualizarTotal atvT = new atualizarTotal();
        this.editTextNumberDecimalDinheiro.setOnFocusChangeListener(atvT);
        this.editTextNumberDecimalPix.setOnFocusChangeListener(atvT);
        this.editTextNumberDecimalMoeda.setOnFocusChangeListener(atvT);
        this.editTextNumberDecimalDespesa.setOnFocusChangeListener(atvT);
        this.editTextNumberDecimalPremio.setOnFocusChangeListener(atvT);
        this.editTextTextPersonNameOutros.setOnFocusChangeListener(atvT);

        this.buttonTrashNome.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextTextPersonNameCodigo));
        this.buttonTrashPremio.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextNumberDecimalPremio));
        this.buttonTrashDinheiro.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextNumberDecimalDinheiro));
        this.buttonTrashPix.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextNumberDecimalPix));
        this.buttonTrashMoeda.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextNumberDecimalMoeda));
        this.buttonTrashDespesa.setOnClickListener(new ClearTextViewsOnClickListener(this.editTextNumberDecimalDespesa));
        //Teste
//        nota.add("william");
//        nota.add("R$ 234");
//        nota.add("20-03-2023");


        buttonCreate = findViewById(R.id.buttonCreate);
//        Butão desabilitato pois foi removido na nova versão
//        buttonView = findViewById(R.id.buttonView);

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

                    dialogPrompt(Funcoes.escreverNota(nota),"notas");


                    //O campo outros deve ocorrer uma verificação aplicar um titulo a ele
                }
                Log.i("desenvolvimento","Botão clicado create ");
                //sendObject(nota);
            }
        });
//        buttonView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("desenvolvimento","Botão clicado View");
//                sendObject(nota);
//            }
//        });
    }

    private void setFindViewById(){
        this.editTextTextPersonNameCodigo = findViewById(R.id.editTextTextPersonNameCodigo);
        this.editTextNumberDecimalDinheiro  = findViewById(R.id.editTextNumberDecimalDinheiro);
        this.editTextNumberDecimalPix  = findViewById(R.id.editTextNumberDecimalPix);
        this.editTextNumberDecimalMoeda  = findViewById(R.id.editTextNumberDecimalMoeda);
        this.editTextNumberDecimalDespesa  = findViewById(R.id.editTextNumberDecimalDespesa);
        this.editTextNumberDecimalPremio  = findViewById(R.id.editTextNumberDecimalPremio);
        this.editTextTextPersonNameOutros = findViewById(R.id.editTextTextPersonNameOutros);
        this.editTextTextPersonNameTotal = findViewById(R.id.editTextTextPersonNameTotal);
        this.editTextTextPersonNameOutrosName = findViewById(R.id.editTextTextPersonNameOutrosName);

        this.buttonTrashNome = findViewById(R.id.buttonTrashNome);
        this.buttonTrashPremio= findViewById(R.id.buttonTrashPremio);
        this.buttonTrashDinheiro = findViewById(R.id.buttonTrashDinheiro);
        this.buttonTrashPix= findViewById(R.id.buttonTrashPix);
        this.buttonTrashMoeda= findViewById(R.id.buttonTrashMoeda);
        this.buttonTrashDespesa= findViewById(R.id.buttonTrashDespesa);

    }
    public void sendObject(ArrayList<String> nota){
        Intent intent = new Intent(this,CopyScreen.class);
        intent.putStringArrayListExtra("nota",nota);
        startActivity(intent);
    }

    public  void copyToClipBoar(String nota){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("nota",nota);
        clipboard.setPrimaryClip(clip);

    }
    public void dialogPrompt(String msg, String title){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(msg);
        builder.setNeutralButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Funcoes.toastMsg(getApplicationContext(),"Copiada");
                copyToClipBoar(msg);

            }
        });

        builder.show();


    }

    public class atualizarTotal implements View.OnFocusChangeListener{
        @Override
        public void onFocusChange(View v,boolean hasFocus){

            Double total = 0.0;
            if(hasFocus){
                //Não faz nada quando um campo for focado e sim quando ele for desfocado
            }else{

                if(!editTextNumberDecimalDinheiro.getText().toString().equals("")){
                    total += Double.parseDouble(editTextNumberDecimalDinheiro.getText().toString());
                }
                if(!editTextNumberDecimalPix.getText().toString().equals("")){
                    total += Double.parseDouble(editTextNumberDecimalPix.getText().toString());
                }
                if(!editTextNumberDecimalMoeda.getText().toString().equals("")){
                    total += Double.parseDouble(editTextNumberDecimalMoeda.getText().toString());
                }
                if(!editTextNumberDecimalDespesa.getText().toString().equals("")){
                    total += Double.parseDouble(editTextNumberDecimalDespesa.getText().toString());
                }
                if(!editTextNumberDecimalPremio.getText().toString().equals("")){
                    total += Double.parseDouble(editTextNumberDecimalPremio.getText().toString());
                }
                if(!editTextTextPersonNameOutros.getText().toString().equals("")){
                    try{

                        total += Double.parseDouble(editTextTextPersonNameOutros.getText().toString());

                    }catch(Exception ex){
                        Log.e("desenvolvimento","somar no HasFocus"+ex);
                    };
                }
                editTextTextPersonNameTotal.setText(total.toString());

            }
        }
    }



}
;