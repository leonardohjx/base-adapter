package br.edu.fasam.mobile.nomecomercialdoaplicativo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.adapter.PostAdapter;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Post;

public class PostActivity extends AppCompatActivity {

    EditText txtUserId;
    EditText txtTitle;
    EditText txtBody;
    ListView listViewPost;

    //SimpleAdapter trabalha com uma lista de HashMap List<HashMap>

    List<HashMap<String, String>> lista = new ArrayList<>(); //pega a lista de dados enviada pelo usuário

    //ArrayAdapter trabalha com uma lista do objeto preterido List<Post>
    List<Post> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void adicionarPost(View view) {

        //Entrada
        txtUserId = findViewById(R.id.txtUserId);
        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);

        // Processamento
        String userId,title,body;
        userId = txtUserId.getText().toString();
        title = txtTitle.getText().toString();
        body = txtBody.getText().toString();

        // SimpleAdapter simpleAdapter = SimpleAdapter(userId, title, body);
        //arrayAdapter(userId, title, body);
        baseAdapter(userId, title, body);

        //Procurar a referência da listView para que ela possa imprimir os dados utilizando o padrão ADAPTER
//        listViewPost = findViewById(R.id.listViewPost);
//        listViewPost.setAdapter((simpleAdapter));

    }

    /**
     * BaseAdapter metodo responsável para exibir registros de forma customizada e enxuta(prática)
     * @param userId
     * @param title
     * @param body
     */
    private void baseAdapter(String userId, String title, String body){
        preencherObjetoLista(userId, title, body);

        listViewPost = findViewById(R.id.listViewPost);

        PostAdapter postAdapter = new PostAdapter(this, postagens);

        listViewPost.setAdapter(postAdapter);

    }


    /**
     * ArrayAdapter trabalha com uma lista 'tipada"
     * @param userId
     * @param title
     * @param body
     */
    private void arrayAdapter(String userId, String title, String body){
        preencherObjetoLista(userId, title, body);

        //Procurar a referência da listaView na tela desta Atividade para imprimir os dados na lista.
        listViewPost = findViewById(R.id.listViewPost);

        // Imprimir o ArrayAdapter
        ArrayAdapter<Post> arrayAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postagens);
        listViewPost.setAdapter(arrayAdapter);

    }

    private void preencherObjetoLista(String userId, String title, String body) {
        //Criar o objeto
        Integer idConvertido = Integer.parseInt(userId);
        Post post = Post.builder().userId(idConvertido).title(title).body(body).build();

        //Adicionar o objeto na lista de post
        postagens.add(post);
    }

    private SimpleAdapter SimpleAdapter(String userId, String title, String body) {
        //Agora vamos iniciar os trabalhos para o SimpleAdapter
        //SimpleAdapter precisa de um List<? extends HasMap<String,?>>

        /*EXPLICAÇÃO DE COMO USAR LISTA E HASHMAP

        List<String> bla = new ArrayList<>();
        bla.add(""); //Posição 0
        bla.add(""); //Posição 1
        bla.add(""); //Posição 2
        bla.add(""); //Posição 3
        bla.add(""); //Posição 4
        bla.add(""); //Posição 5

        HashMap<String, String> mapExemplo = new HashMap<>(); //HashMap trabalha com o índice "associativo", geralmente
        mapExemplo.put("index1", "valor1");
        mapExemplo.put("index2", "valor2");
        mapExemplo.put("index3", "valor3");
        mapExemplo.put("index4", "valor4");

        mapExemplo.get("index3");  //retorna "valor3"

         */

        HashMap<String, String> map = new HashMap<>(); //Armazena as informações do usuário num map (mapa de valores)
        map.put("userId", userId);
        map.put("title", title);
        map.put("body", body);

        lista.add(map);

        //SimpleAdapter(Context context, List<? extends Map<String, ?>> data,
        // int resource, String[] from, int[] to)
        //Mapear o lauout do tipo "item" com os dados contidos dentro do List<HashMap<String, String>>


        //Saida
        String[] from = {"userId", "title", "body"}; //Chaves do meu Map
        int[] to = {R.id.txtItemUserId, R.id.txtItemTitle, R.id.txtItemBody}; //ids do layout do tipo "Item"

        return new SimpleAdapter(this, lista, R.layout.item_post,from, to);
    }
}