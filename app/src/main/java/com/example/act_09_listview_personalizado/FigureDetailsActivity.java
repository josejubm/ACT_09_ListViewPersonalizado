package com.example.act_09_listview_personalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FigureDetailsActivity extends AppCompatActivity {

    private EditText editTextLado;
    private EditText editTextAltura;
    private EditText editTextThirdSide; // Nuevo EditText para el tercer lado
    private Button buttonCalcular;
    private TextView textResultado;
    private TextView textTituloFigura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure_details);

        editTextLado = findViewById(R.id.editTextLado);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextThirdSide = findViewById(R.id.editTextThirdSide);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textResultado = findViewById(R.id.textResultado);
        textTituloFigura = findViewById(R.id.textTituloFigura);

        String figuraSeleccionada = getIntent().getStringExtra("selectedFigureName");
        setTitle("Detalles de " + figuraSeleccionada);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado(figuraSeleccionada);
            }
        });

        // Establece el título de la figura
        textTituloFigura.setText("Detalles de " + figuraSeleccionada);
    }

    private void calcularResultado(String figuraSeleccionada) {
        double lado = Double.parseDouble(editTextLado.getText().toString());
        double altura = 0;
        double tercerLado = 0;

        if (figuraSeleccionada.equals("Triángulo Escaleno")) {
            String alturaStr = editTextAltura.getText().toString();
            String tercerLadoStr = editTextThirdSide.getText().toString();

            if (!alturaStr.isEmpty() && !tercerLadoStr.isEmpty()) {
                altura = Double.parseDouble(alturaStr);
                tercerLado = Double.parseDouble(tercerLadoStr);
            } else {
                textResultado.setText("Ingrese valores para la altura y el tercer lado del triángulo escaleno");
                return;
            }
        }

        // Realizar cálculos según la figura seleccionada
        double area = 0;
        double perimetro = 0;
        double volumen = 0; // Agregado para el caso del cubo

        switch (figuraSeleccionada) {
            case "Hexágono":
                area = calcularAreaHexagono(lado);
                perimetro = calcularPerimetroHexagono(lado);
                break;
            case "Triángulo Equilátero":
                area = calcularAreaTrianguloEquilatero(lado);
                perimetro = calcularPerimetroTrianguloEquilatero(lado);
                break;
            case "Cuadrado":
                area = calcularAreaCuadrado(lado);
                perimetro = calcularPerimetroCuadrado(lado);
                break;
            case "Cubo":
                area = calcularAreaCubo(lado);
                perimetro = calcularPerimetroCubo(lado);
                volumen = calcularVolumenCubo(lado);
                break;
        }

        // Mostrar el resultado
        textResultado.setText("Área: " + area +"\nPerímetro: " + perimetro);

        // Mostrar el volumen solo para el caso del cubo
        if (figuraSeleccionada.equals("Cubo")) {
            textResultado.append("\nVolumen: " + volumen);
        }
    }

    private double calcularAreaCuadrado(double lado) {
        return lado * lado;
    }

    private double calcularPerimetroCuadrado(double lado) {
        // Perímetro del cuadrado
        return 4 * lado;
    }

    // Funciones de cálculo específicas para cada figura
    private double calcularAreaHexagono(double lado) {
        return (3 * Math.sqrt(3) / 2) * Math.pow(lado, 2);
    }

    private double calcularPerimetroHexagono(double lado) {
        return 6 * lado;
    }

    private double calcularAreaTrianguloEquilatero(double lado) {
        return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
    }

    private double calcularPerimetroTrianguloEquilatero(double lado) {
        return 3 * lado;
    }

    // Funciones de cálculo específicas para el cubo
    private double calcularAreaCubo(double lado) {
        return 6 * Math.pow(lado, 2);
    }

    private double calcularPerimetroCubo(double lado) {
        return 12 * lado;
    }

    private double calcularVolumenCubo(double lado) {
        return Math.pow(lado, 3);
    }
}
