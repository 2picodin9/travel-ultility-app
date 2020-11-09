package com.example.travelutilityapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelutilityapp.HomeActivity;
import com.example.travelutilityapp.R;
import com.example.travelutilityapp.TranslateActivity;
import com.example.travelutilityapp.WeatherActivity;
import com.example.travelutilityapp.entity.CardItem;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardItemViewHolder> {
    Context context;
    List<CardItem> cardItemList;
//    Object function;

    public CardAdapter(Context context, List<CardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
//        this.function = function;
    }

    @NonNull
    @Override
    public CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row_item, parent, false);
        return new CardItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemViewHolder holder, final int position) {
        holder.cardName.setText(cardItemList.get(position).getName());
        holder.cardImage.setImageResource(cardItemList.get(position).getImage());
        holder.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, WeatherActivity.class);
                        break;
                    case 1:
                        intent = new Intent(context, TranslateActivity.class);
                        break;
                    default:
                        intent = new Intent(context, HomeActivity.class);
                        break;

                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public interface OnItemClickEventListener {
        void onItemClick(int position);
    }

    public class CardItemViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImage;
        TextView cardName;

        public CardItemViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.cardImage);
            cardName = itemView.findViewById(R.id.cardName);
        }

    }



}
