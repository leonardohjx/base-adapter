package br.edu.fasam.mobile.nomecomercialdoaplicativo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Post;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private List<Post> postagens;

    public PostAdapter (Context context, List<Post> postagens){
        this.context = context;
        this.postagens = postagens;
    }

    @Override
    public int getCount() {
        return this.postagens!=null ? this.postagens.size() : 0;
    }

    @Override
    public Object getItem(int i) {

        return this.postagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        //Primeira coisa que precisamos verificar é se o layout  está instanciado, senão leia a referência
        // do xml para o objeto java

        if(view == null){
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_post, viewGroup, false);
        }

        //Procura o item dentro da lista para ser "exibido" na ListView
        Post post = (Post) getItem(posicao);

        //Criar a referência de atributos/objeto java para se customizar uma ListView
        TextView txtItemUserId, txtItemTitle, txtItemBody;

        txtItemUserId = view.findViewById(R.id.txtItemUserId);
        txtItemTitle = view.findViewById(R.id.txtItemTitle);
        txtItemBody = view.findViewById(R.id.txtItemBody);

        txtItemUserId.setText(String.valueOf(post.getUserId()));
        txtItemTitle.setText(post.getTitle());
        txtItemBody.setText(post.getBody());

        return view;
    }
}
