package com.example.act_09_listview_personalizado;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GeometricFigureAdapter extends ArrayAdapter<GeometricFigure> {

    public GeometricFigureAdapter(Context context, int resource, ArrayList<GeometricFigure> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_figure, parent, false);
        }

        GeometricFigure figure = getItem(position);

        ImageView imageFigure = convertView.findViewById(R.id.imageFigure);
        TextView textFigureName = convertView.findViewById(R.id.textFigureName);
        TextView textPerimeter = convertView.findViewById(R.id.textPerimeter);
        TextView textArea = convertView.findViewById(R.id.textArea);
        TextView textVolume = convertView.findViewById(R.id.textVolume);

        if (figure != null) {
            imageFigure.setImageResource(figure.getImageResource());
            textFigureName.setText(figure.getName());
            textPerimeter.setText("Perímetro: " + figure.getPerimeterFormula());
            textArea.setText("Área: " + figure.getAreaFormula());

            if ("Cubo".equals(figure.getName())) {
                textVolume.setText("Volumen: " + figure.getVolumeFormula());
                textVolume.setVisibility(View.VISIBLE);
            } else {
                textVolume.setVisibility(View.GONE);
            }
        }

        return convertView;
    }
}
