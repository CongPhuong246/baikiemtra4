package com.example.foldingcellwithcell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHoder>{
    private List<Model> modelList;

    public void setData(List<Model> list){
        this.modelList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);

        return new AdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHoder holder, int position) {
        Model model = modelList.get(position);
        if(model == null){
            return;
        }
        holder.txtTitle.setText(model.getTitle());
        holder.txtContent.setText(model.getContent());
        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.foldingCell.toggle(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(modelList != null){
            return  modelList.size();
        }
        return 0;
    }

    public class AdapterHoder extends RecyclerView.ViewHolder {
        private FoldingCell foldingCell;
        private TextView txtTitle;
        private TextView txtContent;

        public AdapterHoder(@NonNull View itemView) {
            super(itemView);

            foldingCell = itemView.findViewById(R.id.floding_cell);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtContent = itemView.findViewById(R.id.txt_content);

        }
    }
}
