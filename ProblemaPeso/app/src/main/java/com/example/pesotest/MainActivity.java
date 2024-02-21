package com.example.pesotest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etnombre, etpeso, etaltura;
    Button btncalcular;
    TextView tvResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombre = findViewById(R.id.etnombre);
        etpeso = findViewById(R.id.etpeso);
        etaltura = findViewById(R.id.etaltura);
        btncalcular = findViewById(R.id.btncalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etnombre.getText().toString();
                double peso = Double.parseDouble(etpeso.getText().toString());
                double altura = Double.parseDouble(etaltura.getText().toString());

                double imc = peso / (altura * altura);

                String resultado = null;

                if (imc < 18) {
                    resultado = "Bajo peso";
                }
                else if (imc >= 18.5 && imc < 24.9){
                    resultado = "Normal";
                }
                else if (imc >= 25 && imc < 29.9) {
                    resultado ="Sobrepeso";
                }
                else if (imc > 30) {
                    resultado = "Obesidad";
                }

                tvResultado.setText("Hola " + nombre + " , el indice de tu masa corporal es de: " + String.format("%.2f", imc) + "lo cual indica que estás: " + resultado + ".");

            }
        });
    }
}