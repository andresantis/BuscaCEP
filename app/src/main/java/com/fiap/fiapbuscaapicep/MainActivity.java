package com.fiap.fiapbuscaapicep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fiap.fiapbuscaapicep.model.CEP;
import com.fiap.fiapbuscaapicep.service.HTTPService;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText textoCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCep = findViewById(R.id.idTextoCep);
    }

    public void clickEnviar(View view){

        HTTPService httpService = new HTTPService(textoCep.getText().toString());
        try {
           CEP resposta = httpService.execute().get();
            Toast.makeText(this, "CEP "+ resposta.toString(), Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
