package com.example.travelutilityapp;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelutilityapp.adapter.CardAdapter;
import com.example.travelutilityapp.entity.CardItem;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class HomeActivity extends AppCompatActivity {

    RecyclerView cardRecycle;
    CardAdapter cardAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Trip supporter");

        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.weather, "Weather Forecast"));
        cardItemList.add(new CardItem(R.drawable.to_do_list, "Todo List"));
        cardItemList.add(new CardItem(R.drawable.convert_currency, "Currency Converter"));
        cardItemList.add(new CardItem(R.drawable.newspaper, "More Information"));
        cardItemList.add(new CardItem(R.drawable.more, "Upcoming feature ..."));
        setCardRecycle(cardItemList);

//        ImageView imageView = findViewById(R.id.cardImage);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(WeatherActivity.class));
//            }
//        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        requestPermissions();

    }

    private void setCardRecycle(List<CardItem> cardItemList) {

        cardRecycle = findViewById(R.id.card_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        cardRecycle.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this, cardItemList);
        cardRecycle.setAdapter(cardAdapter);

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[] {ACCESS_FINE_LOCATION}, 1);
    }
}