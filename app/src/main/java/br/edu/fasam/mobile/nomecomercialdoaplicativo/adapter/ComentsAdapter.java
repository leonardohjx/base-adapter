package br.edu.fasam.mobile.nomecomercialdoaplicativo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.activity.ComentsActivity;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Coments;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Post;

public class ComentsAdapter extends BaseAdapter {

    private Context context;
    private List<Coments> comentarios;

    public  ComentsAdapter (Context context, List<Coments> comentarios){
        this.context = context;
        this.comentarios = comentarios;
    }



    @Override
    public int getCount() {
        return this.comentarios!=null ? this.comentarios.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return this.comentarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_coments, viewGroup, false);
        }

        Coments coments = (Coments) getItem(posicao);

        TextView txtComentsId, txtComentsName, txtComentsEmail, txtComentsBody;

        txtComentsId = view.findViewById((R.id.txtItemComentsId));
        txtComentsName = view.findViewById((R.id.txtComentsName));
        txtComentsEmail = view.findViewById((R.id.txtComentsEmail));
        txtComentsBody = view.findViewById((R.id.txtComentsBody));

        txtComentsId.setText(String.valueOf(coments.getComentsId()));
        txtComentsName.setText(coments.getName());
        txtComentsEmail.setText(coments.getEmail());
        txtComentsBody.setText(coments.getBody());

        return view;
    }
}
