package com.ldz.fpt.xmlproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldz.fpt.xmlproject.R;
import com.ldz.fpt.xmlproject.model.BaCangModel;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by linhdq on 7/4/17.
 */

public class ListBaCangDetailAdapter extends RecyclerView.Adapter<ListBaCangDetailAdapter.ViewHolder> {
    private List<BaCangModel> list;
    private LayoutInflater inflater;
    private Context context;
    private BaCangModel deModel;
    private Locale locale;
    private NumberFormat currencyFormatter;

    public ListBaCangDetailAdapter(Context context, List<BaCangModel> list) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.locale = new Locale("vi", "VN");
        this.currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_on_list_de_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.size() > position && (deModel = list.get(position)) != null) {
            holder.txtIndex.setText(String.valueOf(position + 1));
            holder.txtUsername.setText(deModel.getUsername());
            holder.txtPrice.setText(currencyFormatter.format(deModel.getPrice()));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        //view
        private TextView txtIndex;
        private TextView txtUsername;
        private TextView txtPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            txtIndex = (TextView) itemView.findViewById(R.id.txt_stt);
            txtUsername = (TextView) itemView.findViewById(R.id.txt_username);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_price);
        }
    }
}
