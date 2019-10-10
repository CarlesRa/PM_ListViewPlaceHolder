package com.carlesramos.listviewplaceholder.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.carlesramos.listviewplaceholder.R;

public class CountryAdapter extends ArrayAdapter<Country> {
    private Country[]datos;
    private Drawable d;
    public CountryAdapter(@NonNull Context context, Country[] objects) {
        super(context, R.layout.listitem_county, objects);
        datos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;
        if (item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_county, null);
            // nom pais
            holder = new ViewHolder();
            holder.tvPais = item.findViewById(R.id.tvPais);
            // nom Capital
            holder.tvCapital = item.findViewById(R.id.tvCapital);
            //poblacio del pais
            holder.tvPoblacio = item.findViewById(R.id.tvPoblacio);
            holder.ivBandera = item.findViewById(R.id.ivBandera);
            item.setTag(holder);
        }
        else{
            holder = (ViewHolder) item.getTag();
        }
        int id = this.getContext().getResources().getIdentifier("_"+datos[position].getCountryCode().toLowerCase()
                , "drawable", this.getContext().getPackageName());
        holder.tvCapital.setText(datos[position].getCapital());
        holder.tvPais.setText(datos[position].getCountryName());
        holder.tvPoblacio.setText(String.valueOf(datos[position].getPopulation()));
        holder.ivBandera.setImageResource(id);
        return item;
    }
    static class ViewHolder{
        TextView tvPais;
        TextView tvCapital;
        TextView tvPoblacio;
        ImageView ivBandera;
    }
}
