package com.doranco.ecommerceapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.doranco.ecommerceapp.models.Gateau;

import java.util.List;

public class GateauAdapter extends BaseAdapter {
    private List<Gateau> gateauList;
    private LayoutInflater inflater;
    private Context context;

    public GateauAdapter(Context context, List<Gateau> gateauList) {
        this.context = context;
        this.gateauList = gateauList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
