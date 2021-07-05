package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button btnAddItem;
    ArrayList<RecyclerData> myList = new ArrayList<>();
    EditText etemail, etnumber;
    String email = "", number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        etemail = findViewById(R.id.etemail);
        etnumber = findViewById(R.id.etnumber);
        btnAddItem = findViewById(R.id.btnAddItem);


        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etemail.getText().toString().trim();
                number = etnumber.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String MobilePattern = "[0-9]{10}";

                if (email.matches(emailPattern) && number.matches(MobilePattern)) {
                    Toast.makeText(getApplicationContext(), "valid email addres", Toast.LENGTH_SHORT).show();
                    RecyclerData mLog = new RecyclerData();
                    mLog.setTitle(email);
                    mLog.setDescription(number);
                    myList.add(mLog);




                    mRecyclerAdapter = new RecyclerAdapter(myList);
                    mRecyclerAdapter.notifyData(myList);
                    mRecyclerView.setAdapter(mRecyclerAdapter);
                    etemail.setText("");
                    etnumber.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}