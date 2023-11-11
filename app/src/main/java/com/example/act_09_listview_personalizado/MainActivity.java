package com.example.act_09_listview_personalizado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFigures;
    private GeometricFigureAdapter adapter;
    private ArrayList<GeometricFigure> figuresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        figuresList = new ArrayList<>();
        setupGeometricFigures();

        adapter = new GeometricFigureAdapter(this, R.layout.list_item_figure, figuresList);
        listViewFigures = findViewById(R.id.listViewFigures);
        listViewFigures.setAdapter(adapter);

        listViewFigures.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleFigureClick(position);
            }
        });
    }

    private void setupGeometricFigures() {
        figuresList.add(new GeometricFigure("Hexágono", R.drawable.hexagono, " 6 × L", " (3√3/2) × L^2", ""));
        figuresList.add(new GeometricFigure("Triángulo Equilátero", R.drawable.triangulo, " 3 × L", " (√3/4) × L^2", ""));
        figuresList.add(new GeometricFigure("Cuadrado", R.drawable.cuadrado, " L x 4 ", "L^2 ", ""));
        figuresList.add(new GeometricFigure("Cubo", R.drawable.cubo, " 12 × L", " 6 × L^2", " L^3"));
    }

    private void handleFigureClick(int position) {
        GeometricFigure clickedFigure = figuresList.get(position);

        Intent intent = new Intent(this, FigureDetailsActivity.class);
        intent.putExtra("selectedFigureName", clickedFigure.getName());

        if ("Triángulo Escaleno".equals(clickedFigure.getName())) {
            // Agregar lógica para pasar información adicional específica para el triángulo escaleno
        }

        startActivity(intent);
    }
}
