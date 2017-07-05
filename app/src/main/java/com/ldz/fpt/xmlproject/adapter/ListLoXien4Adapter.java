package com.ldz.fpt.xmlproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldz.fpt.xmlproject.OnItemClickListener;
import com.ldz.fpt.xmlproject.R;
import com.ldz.fpt.xmlproject.fragment.AdminHomeFragment;
import com.ldz.fpt.xmlproject.model.LoXien3Model;
import com.ldz.fpt.xmlproject.model.LoXien4Model;
import com.ldz.fpt.xmlproject.util.PreferenceUtil;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by linhdq on 7/2/17.
 */

public class ListLoXien4Adapter extends RecyclerView.Adapter<ListLoXien4Adapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<LoXien4Model> list;
    private LoXien4Model model;
    private Locale locale;
    private NumberFormat currencyFormatter;
    private PreferenceUtil preferenceUtil;
    private OnItemClickListener listener;

    public ListLoXien4Adapter(Context context, List<LoXien4Model> list, OnItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.locale = new Locale("vi", "VN");
        this.currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        this.preferenceUtil = PreferenceUtil.getInst(context);
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_on_list_lo_xien_4, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.size() > position && (model = list.get(position)) != null) {
            holder.txtSTT.setText(String.valueOf(position + 1));
            holder.txtNumber.setText(String.format("%d, %d, %d, %d", model.getNumber1(), model.getNumber2(),
                    model.getNumber3(), model.getNumber4()));
            holder.txtPoint.setText(String.valueOf(model.getPoint()));
            holder.txtPrice.setText(currencyFormatter.format(model.getPoint() * preferenceUtil.getLoPrice()));
            holder.position = position;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        //view
        private TextView txtSTT;
        private TextView txtNumber;
        private TextView txtPoint;
        private TextView txtPrice;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            //
            txtSTT = (TextView) itemView.findViewById(R.id.txt_stt);
            txtNumber = (TextView) itemView.findViewById(R.id.txt_number);
            txtPoint = (TextView) itemView.findViewById(R.id.txt_point);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_price);
            //
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(position, AdminHomeFragment.TYPE_LO_XIEN_4);
                }
            });
        }
    }
}
