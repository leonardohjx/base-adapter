package br.edu.fasam.mobile.nomecomercialdoaplicativo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.adapter.ComentsAdapter;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.adapter.PostAdapter;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Coments;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.model.Post;

public class ComentsActivity extends AppCompatActivity {

    EditText txtComentsId;
    EditText txtComentsName;
    EditText txtComentsEmail;
    EditText txtComentsBody;
    ListView listViewComents;

    List<HashMap<String, String>> lista = new ArrayList<>();

    List<Coments> comentarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coments);
    }


    @SuppressLint("WrongViewCast")
    public void adicionarComents(View view) {
        //Entrada
        txtComentsId = findViewById(R.id.txtComentsId);
        txtComentsName = findViewById(R.id.txtComentsName);
        txtComentsEmail = findViewById(R.id.txtComentsEmail);
        txtComentsBody = findViewById(R.id.txtComentsBody);

        //Processamento
        String comentsId, name, email, body;
        comentsId = txtComentsId.getText().toString();
        name = txtComentsName.getText().toString();
        email = txtComentsEmail.getText().toString();
        body = txtComentsBody.getText().toString();
        // SimpleAdapter simpleAdapter = SimpleAdapter(comentsId, name, email, body);
        //arrayAdapter(comentsId, name, email, body);
        baseAdapter(comentsId, name, email, body);


//        listViewComents = findViewById((R.id.listViewComents));
//        listViewComents.setAdapter((simpleAdapter));


    }

    private void baseAdapter(String comentsId, String name, String email, String body){
        preencherObjetoLista(comentsId, name, email, body);

        listViewComents = findViewById(R.id.listViewComents);

        ComentsAdapter comentsAdapter = new ComentsAdapter(this, comentarios);

        listViewComents.setAdapter(comentsAdapter);

    }


    private void arrayAdapter(String comentsId, String name, String email, String body){
        Integer idConvertido = Integer.parseInt(comentsId);
        Coments coments = Coments.builder().comentsId(idConvertido).name(name).email(email).body(body).build();

        comentarios.add(coments);

        listViewComents = findViewById(R.id.listViewComents);

        ArrayAdapter<Coments> arrayAdapter = new ArrayAdapter<Coments>(this, android.R.layout.simple_list_item_1, comentarios);
        listViewComents.setAdapter(arrayAdapter);

    }

    private void preencherObjetoLista(String comentsId, String name, String email, String body) {

        Integer idConvertido = Integer.parseInt(comentsId);
        Coments coments = Coments.builder().comentsId(idConvertido).name(name).email(email).body(body).build();

        comentarios.add(coments);
    }

    private SimpleAdapter SimpleAdapter(String comentsId, String name, String email, String body) {
        //explicação de como usar o SimpleAdapter no Post Activity
        HashMap<String, String> map = new HashMap<>();
        map.put("comentsId", comentsId);
        map.put("name", name);
        map.put("email", email);
        map.put("body", body);

        lista.add(map);

        //Saída
        String[] from = {"comentsId", "name", "email", "body"};
        int[] to = {R.id.txtItemComentsId, R.id.txtItemComentsName, R.id.txtItemComentsEmail, R.id.txtItemComentsBody};

        return new SimpleAdapter(this, lista, R.layout.item_coments, from, to);
    }
}