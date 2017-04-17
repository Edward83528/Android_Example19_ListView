package com.example.u0151051.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    void findview() {
        lv = (ListView) findViewById(R.id.listview1);
        lv.setOnItemClickListener(onItemClickListener);
        //建立一個 ArrayAdapter把字串陣列包住塞入ListView
        //創一個自己的Layout當作ListView的樣式(R.layout.mystytle)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.mystytle, getResources().getStringArray(R.array.balls));
        lv.setAdapter(arrayAdapter);
    }

    //ListView監聽器(別跟spinner的監聽器OnItemSelectedListener搞混)
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //getItemAtPosition(position)取的元素內容
            String s = lv.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this, "你最喜歡的運動為:" + s, Toast.LENGTH_SHORT).show();
        }
    };

}
