package com.example.travelutilityapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelutilityapp.R;
import com.example.travelutilityapp.entity.CardItem;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardItemViewHolder> {
    Context context;
    List<CardItem> cardItemList;

    public CardAdapter(Context context, List<CardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row_item, parent, false);
        return new CardItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemViewHolder holder, int position) {
        holder.cardName.setText(cardItemList.get(position).getName());
        holder.cardImage.setImageResource(cardItemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static final class CardItemViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImage;
        TextView cardName;

        public CardItemViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.cardImage);
            cardName = itemView.findViewById(R.id.cardName);
        }
    }



}
