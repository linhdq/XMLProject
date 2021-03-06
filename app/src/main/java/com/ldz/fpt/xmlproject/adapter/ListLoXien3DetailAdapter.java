package com.ldz.fpt.xmlproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldz.fpt.xmlproject.R;
import com.ldz.fpt.xmlproject.model.LoXien2Model;
import com.ldz.fpt.xmlproject.model.LoXien3Model;

import java.util.List;

/**
 * Created by linhdq on 7/4/17.
 */

public class ListLoXien3DetailAdapter extends RecyclerView.Adapter<ListLoXien3DetailAdapter.ViewHolder> {
    private List<LoXien3Model> list;
    private LayoutInflater inflater;
    private Context context;
    private LoXien3Model loModel;

    public ListLoXien3DetailAdapter(Context context, List<LoXien3Model> list) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_on_list_lo_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.size() > position && (loModel = list.get(position)) != null) {
            holder.txtIndex.setText(String.valueOf(position + 1));
            holder.txtUsername.setText(loModel.getUsername());
            holder.txtPoint.setText(String.valueOf(loModel.getPoint()));
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
        private TextView txtPoint;

        public ViewHolder(View itemView) {
            super(itemView);
            txtIndex = (TextView) itemView.findViewById(R.id.txt_stt);
            txtUsername = (TextView) itemView.findViewById(R.id.txt_username);
            txtPoint = (TextView) itemView.findViewById(R.id.txt_point);
        }
    }
}
