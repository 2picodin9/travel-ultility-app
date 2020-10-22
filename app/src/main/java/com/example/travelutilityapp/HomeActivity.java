package com.example.travelutilityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.travelutilityapp.adapter.CardAdapter;
import com.example.travelutilityapp.entity.CardItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView cardRecycle;
    CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.wethear, "Weather"));
        cardItemList.add(new CardItem(R.drawable.translate_image, "Translate"));
        cardItemList.add(new CardItem(R.drawable.convert_currency, "Currency Converter"));

        setCardRecycle(cardItemList);

    }

    private void setCardRecycle(List<CardItem> cardItemList) {

        cardRecycle = findViewById(R.id.card_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        cardRecycle.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this, cardItemList);
        cardRecycle.setAdapter(cardAdapter);

    }
}