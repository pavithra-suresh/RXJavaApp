package com.example.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

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

//        Observable.just("Pavi","Thara","Yash","Dulquer","Vijay").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                mRVCustomAdapter.addStringToList(s);
//            }
//        });

        Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500),new Date());
        Entry entry2 = new Entry("XBox One", BigDecimal.valueOf(2000),new Date());
        Entry entry3 = new Entry("XBox One s", BigDecimal.valueOf(2500),new Date());
        Entry entry4 = new Entry("XBox One X", BigDecimal.valueOf(3000),new Date());

        Observable.just(entry1,entry2,entry3,entry4).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {
                mRVCustomAdapter.addEntry(entry);
            }
        });
    }



}