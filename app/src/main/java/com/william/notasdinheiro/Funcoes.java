package com.william.notasdinheiro;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;


import java.util.ArrayList;

public class Funcoes {
    public static void dialogMsg(Context atividade, String dialog_message, String dialog_title){
        AlertDialog.Builder builder = new AlertDialog.Builder(atividade);

        builder.setMessage(dialog_message);
        builder.setTitle(dialog_title);
        builder.setNeutralButton("OK",null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Fazer com que o usuario posso adicionar o texto q ele deseja. e ainda retornar uma string

//    public static String promptMsg(Context atividade, String dialog_message, String dialog_title){
//        AlertDialog.Builder builder = new AlertDialog.Builder(atividade);
//        final String valor;
//
//        builder.setTitle(dialog_title);
//        builder.setMessage(dialog_message);
//
//        EditText text = new EditText(atividade);
//
//        text.setInputType(InputType.TYPE_CLASS_TEXT);
//        builder.setView(text);
//
//        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//        return valor;
//    }
    public static void toastMsg(Context atividade,String msg){
        Context contexto = atividade;
        String texto = msg;
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }
    public static String formatLinha(String nome, String campo){

        return String.format("%-40s \n %s",nome,campo);

    }
    public static String escreverNota(ArrayList<String> nota){

        String notaContextualizada = "";
        for (String linha:nota) {
            notaContextualizada = notaContextualizada + linha +"\n\n";
        }
        return  notaContextualizada;

    }

}
