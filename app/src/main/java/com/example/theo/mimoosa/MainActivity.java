package com.example.theo.mimoosa;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity{
ListView lvList;
    TextView tv;

    protected void server (){


        RequestQueue queue = Volley.newRequestQueue(this);
        //172.18.49.1/

            String url ="http://51.255.131.191/v1/produit";
        tv=(TextView)findViewById(R.id.text);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    String commande="";
                        List<Produit> produits = new Gson().fromJson(response, new TypeToken<List<Produit>>(){}.getType());
                        for(int i=0;i<produits.size();i++) {
                            commande+=produits.get(i).getName() + " " + produits.get(i).getDescription() +"\n ------------------------ \n";
                        }
                        tv.setText(commande);



                     //   }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String commande="";
                List<String> test = new ArrayList<>();
                test.add("1 Xavier Delacourt: Lasagne");
                test.add("2 Paul Dupont: Hachis Parmentier");
                test.add("3 Adrien Lecomte: Riz Dinde");
                test.add("4 Emeline Dieu: Gratin d'auphinois");
                test.add("5 Quentin Peron: Blanquette de veau");
                test.add("6 Margot Plouvin: Boeuf bourguignon");
                test.add("7 Theo Capon: Cannelloni");
                test.add("9 Baptiste Plaisance: Couscous");

                //tv.setText(test.get(0) +"\n ------------------------");
                for(int i=0;i<test.size();i++){
                   commande+=test.get(i) +"\n \n";
                }

                tv.setText(commande );


            //    tv.setText("ERREUR SERVEUR");

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      server();
    }

    public void  onClick(View v){
        server();
    }

}
