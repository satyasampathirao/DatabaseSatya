package com.satman.satya.databasesatya;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    EditText etname;
    Button btsave;
    String  sname;
    TextView tvres;

    JSONObject job;

    String s1 = "satya is a good boy";

    SQLiteDatabase db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        etname = (EditText)findViewById(R.id.etname);
        btsave = (Button) findViewById(R.id.btsave);
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sname = etname.getText().toString().trim();

                db = openOrCreateDatabase("ramsdb1", MODE_PRIVATE, null);


                db.execSQL("create table if not exists sampletable(firstname varchar,lastname varchar)");

                //db.execSQL("insert into sampletable values('ram','babu')");
               db.execSQL("insert into sampletable values('ram','babu')");

              //  db.execSQL("insert into sampletable values('ram',"+"'"+satjson+"'"+")");

             //   db.execSQL("insert into sampletable values('ram','"+job+"')");


                Cursor c = db.rawQuery("select * from sampletable", null);

                c.moveToFirst();

//Getting data using column name
                String fname = c.getString(c.getColumnIndex("firstname"));

//Getting data using column index number
                String lname = c.getString(1);

                Toast.makeText(getApplicationContext(), "firstname :"+fname+"\n"+"lastname :"+lname, Toast.LENGTH_LONG).show();

               //c.moveToNext();


                tvres = (TextView)findViewById(R.id.tvres);
                tvres.setText(fname+"\n\n"+lname);





            }
        });



    }




}
