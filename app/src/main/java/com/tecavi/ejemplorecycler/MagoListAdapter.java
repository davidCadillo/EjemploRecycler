package com.tecavi.ejemplorecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tecavi.clases.Mago;

import java.util.List;

public class MagoListAdapter extends RecyclerView.Adapter<MagoListAdapter.MagoViewHolder> {

    private List<? extends Mago> magos;
    private Context context;

     MagoListAdapter(Context context, List<? extends Mago> magos){
        this.context = context;
        this.magos =   magos;
    }

    @NonNull
    @Override
    public MagoListAdapter.MagoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MagoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MagoListAdapter.MagoViewHolder holder, int position) {
        String nombre = magos.get(position).getName();
        String foto = magos.get(position).getImage();
        holder.tvNombre.setText(nombre);
        holder.tvNombreCasa.setText(magos.get(position).getHouse());
        holder.tvSexo.setText(magos.get(position).getGender());
        holder.tvEspecie.setText(magos.get(position).getSpecies());
        holder.tvNombreActor.setText(magos.get(position).getActor());
        holder.tvNacimiento.setText(magos.get(position).getDateOfBirth());
        Glide.with(context).load(foto).into(holder.ivMago);
        //holder.ivMago.setImageResource(context.getResources().getIdentifier(foto, "drawable", context.getPackageName()));

    }

    @Override
    public int getItemCount()
    {
        return magos.size();
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class MagoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombre;
        private TextView tvNombreCasa;
        private TextView tvSexo;
        private TextView tvNombreActor;
        private TextView tvNacimiento;
        private TextView tvEspecie;
        private ImageView ivMago;

        MagoViewHolder(View view) {
            super(view);
            tvNombre = view.findViewById(R.id.tvNombre);
            tvNombreCasa = view.findViewById(R.id.tvNombreCasa);
            ivMago = view.findViewById(R.id.ivMago);
            tvSexo = view.findViewById(R.id.tvSexo);
            tvEspecie = view.findViewById(R.id.tvEspecie);
            tvNombreActor = view.findViewById(R.id.tvNombreActor);
            tvNacimiento = view.findViewById(R.id.tvNacimiento);
        }

    }

}
