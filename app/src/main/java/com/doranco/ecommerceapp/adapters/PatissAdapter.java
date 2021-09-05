package com.doranco.ecommerceapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doranco.ecommerceapp.R;
import com.doranco.ecommerceapp.models.Gateau;

import java.util.List;

public class PatissAdapter extends BaseAdapter {
    private List<Gateau> gateauList;
    private LayoutInflater inflater;
    private Context context;

    public PatissAdapter(Context context, List<Gateau> gateauList) {
        this.context = context;
        this.gateauList = gateauList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return gateauList.size();
    }

    @Override
    public Object getItem(int i) {
        return gateauList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_patiss, null);

        // get data about item
        Gateau currentItem = (Gateau) getItem(i);
        String itemName = currentItem.getNom();
        String mnemonic = currentItem.getMnemonic();
        String itemDescription = currentItem.getDescription();
        double itemPrice = currentItem.getPrix();

        // get item icon view
        ImageView itemIconView = view.findViewById(R.id.item_icon);
        String ressourceName = "item_" + mnemonic + "_icon";
        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        // get item name view
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        // get item desciprion view
        TextView itemDescriptionView = view.findViewById(R.id.item_description);
        itemNameView.setText(itemDescription);

        // get item price view
        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + " €");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Vous essayer d'acheter un " + itemName + ", pour le prix de " + itemPrice + " €", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
