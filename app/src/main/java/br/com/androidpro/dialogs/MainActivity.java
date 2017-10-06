package br.com.androidpro.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnAlert;
    private AppCompatButton btnDialogItems;
    private AlertDialog alertDialog;
    private AlertDialog dialogItems;

    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builderAlert = new AlertDialog.Builder(this, R.style.AlertDialog);
        builderAlert.setTitle("Deseja excluir?");
        builderAlert.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "SIM", Toast.LENGTH_SHORT).show();
            }
        });
        builderAlert.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "NÃO", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog.Builder builderDialogItems = new AlertDialog.Builder(this);
        builderDialogItems.setTitle("Selecione a opção desejada:");
//        builderDialogItems.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
//            }
//        });
        builderDialogItems.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, items[i] + ":" + b, Toast.LENGTH_SHORT).show();
            }
        });
        builderDialogItems.setPositiveButton("OK", null);
        builderDialogItems.setNegativeButton("CANCELAR", null);

        dialogItems = builderDialogItems.create();

        alertDialog = builderAlert.create();

        btnAlert = (AppCompatButton) findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

        btnDialogItems = (AppCompatButton) findViewById(R.id.btnDialogItems);
        btnDialogItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogItems.show();
            }
        });

    }
}
