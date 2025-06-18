package com.example.aplicaoexercicio01;
/*
    @autor: Gustavo Santos Bongiovani de Oliveira
 */
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText inputGasolina;
    EditText inputtEtanol;
    Button buttonCalcular;
    TextView textResultado;

    private boolean calcular(int gasolina, int etanol){
        boolean resultado = false;
        int calculo = 0;

        calculo = (etanol / gasolina) * 100;

        if(calculo  < 75){
            resultado = true;
        }else{
            return resultado;
        }
        return resultado ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);


        inputGasolina = findViewById(R.id.editTextGasolina);
        inputtEtanol = findViewById(R.id.editTextEtanol);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textResultado = findViewById(R.id.textViewResultado);


        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strGasolina  = inputGasolina.getText().toString();
                String strEtanol =  inputtEtanol.getText().toString();

                int precoGasolina = Integer.parseInt(strGasolina);
                int precoEtanol = Integer.parseInt(strEtanol);

                boolean resultado = calcular(precoGasolina,precoEtanol);

                if (resultado) {
                    String strResultado = "Abasteça com Etanol! Ele está custando 70% do valor da Gasolina. ";
                    textResultado.setText(strResultado);
                }else{
                    String strResultado = "Abastaça com Gasolina! Ela está valendo mais apena do que o Etanol.";
                    textResultado.setText(strResultado);
                }



            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }



}