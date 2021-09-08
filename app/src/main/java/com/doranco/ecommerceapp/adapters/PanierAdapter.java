package com.doranco.ecommerceapp.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doranco.ecommerceapp.R;
import com.doranco.ecommerceapp.bean.Gateau;

import java.util.List;

public class PanierAdapter extends BaseAdapter {

    // Attributs
    private Context context;
    private List<Gateau> panierItemList;
    private LayoutInflater inflater;

    public PanierAdapter(Context context, List<Gateau> panierItemList) {
        this.context = context;
        this.panierItemList = panierItemList;
        this.inflater = LayoutInflater.from(context);
    }

    // Nombre d'élément sur l'écran
    @Override
    public int getCount() {
        return panierItemList.size();
    }

    @Override
    public Gateau getItem(int position) {
        return panierItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_panier_adapter, null);

        // get data about item
        Gateau currentItem = getItem(i);
        String itemNom = currentItem.getNom();
        String mnemonic = currentItem.getMnemonic();
        double itemPrix = currentItem.getPrix();

        // get item icon view
        ImageView itemIconView = view.findViewById(R.id.item_panier_icon);
        String ressourceName = "item_" + mnemonic + "_icon";
        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        // get item name view
        TextView itemNameView = view.findViewById(R.id.item_panier_name);
        itemNameView.setText(itemNom);

        // get item price view
        TextView itemPriceView = view.findViewById(R.id.item_panier_price);
        itemPriceView.setText(itemPrix + " €");



        return view;
    }

}