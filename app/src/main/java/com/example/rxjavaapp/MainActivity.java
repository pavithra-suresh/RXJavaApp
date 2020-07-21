package com.example.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;

    @BindView(R.id.myRecyclerView)
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RVCustomAdapter mRVCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRVCustomAdapter = new RVCustomAdapter();

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRVCustomAdapter);

        Observable.just("How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                txtHi.setText(s);

            }
        });

        Observable.just("Pavi","Thara","Yash","Dulquer","Vijay").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                mRVCustomAdapter.addStringToList(s);
            }
        });

    }



}