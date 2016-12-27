package com.example.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements RecyclerTouchListener.ClickListener {

    private ArrayList<Moovie> moovies=new ArrayList<>();
    private RecyclerView rvMain;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        adapter=new CustomAdapter(moovies);
        rvMain= (RecyclerView) findViewById(R.id.rvMain);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        rvMain.addItemDecoration(dividerItemDecoration);
        rvMain.setLayoutManager(manager);
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setAdapter(adapter);
        rvMain.addOnItemTouchListener(new RecyclerTouchListener(this, rvMain, this));
    }

    private void getData(){
        for (int i=1;i<=30;i++){
            moovies.add(new Moovie("Челюсти "+i,""+1990+i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAdd:
                adapter.add(new Moovie("Big Ben",new Date().toString()));
                break;
            case R.id.mRemove:
                adapter.remove();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v, int position) {

    }

    @Override
    public void onLongClick(View v, int position) {

    }
}
