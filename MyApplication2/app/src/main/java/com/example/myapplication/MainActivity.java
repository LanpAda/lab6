package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] transNameArray = new String[]{"腳踏車","機車","汽車","巴士","飛機","輪船"};
        int[] transPhotoIdArray = new int []{R.drawable.trans1,R.drawable.trans2,R.drawable.trans3,R.drawable.trans4,R.drawable.trans5,R.drawable.trans6};
        Data[] transData = new Data[transNameArray.length];
        for(int i = 0; i < transData.length; i++){
            transData[i] = new Data();
            transData[i].name = transNameArray[i];
            transData[i].photo = transPhotoIdArray[i];
        }
        MyAdapter transAdapter = new MyAdapter(transData, R.layout.trans_list);
        Spinner spinner =findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);
    }
    public class MyAdapter extends BaseAdapter{
        private MainActivity.Data[]data;
        private int view;
        public MyAdapter(MainActivity.Data[] data, int view){
            this.data = data;
            this.view = view;
        }
        @Override
        public int getCount(){return data.length;}
        @Override
        public Objects getItem(int position) {return data[position];}
        @Override
        public long getItemId(int position){return  0;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(view,parent,false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(data[position].name);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data[position].photo);

            return convertView;
        }
    }

}
