package com.tp3.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Prenom;
    EditText Nom;
    EditText Departement;
    RadioGroup sexe;
    Button saveButton;
    ListView listEmp;
    ArrayAdapter Adapter;
    ArrayList<String> arrayEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prenom = (EditText)findViewById(R.id.edtPreom);
        Nom = (EditText)findViewById(R.id.edtNom);
        Departement = (EditText)findViewById(R.id.edtdprt);
        sexe = (RadioGroup)findViewById(R.id.rgEmpl);
        saveButton = (Button)findViewById(R.id.saveBtn);
        listEmp = (ListView)findViewById(R.id.listView);

        arrayEmp = new ArrayList<String>();
        Adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayEmp);

        listEmp.setAdapter(Adapter);
    }

    public void btnClick(View view) {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _prenom = Prenom.getText().toString();
                String _nom = Nom.getText().toString();
                String _departement = Departement.getText().toString();
                String _sexe = "";
                switch (sexe.getCheckedRadioButtonId()){
                    case R.id.rdFm:
                        _sexe = "Femme";
                        break;
                    case R.id.rdHm:
                        _sexe = "Homme";
                        break;
                }

                arrayEmp.add(_prenom  + " | " + _nom + " | "
                        + _departement + " | " + _sexe);
                Adapter.notifyDataSetChanged();

                Prenom.setText("");
                Nom.setText("");
                Departement.setText("");
                sexe.clearCheck();
            }
        });



        listEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) listEmp.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }


}