package com.example.subramanyam.reciep;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ingrediantsRecycler extends RecyclerView.Adapter<ingrediantsRecycler.ViewHolder> {

    private Context mContext;
    private int ids;
    List<IngredientsItem> responses;

    public ingrediantsRecycler(Context context,List<IngredientsItem> responses1,int ids)
    {
        this.mContext=context;
        this.responses=responses1;
        this.ids=ids;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingrediantsdetails,parent,false);
        ButterKnife.bind(this,parent);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

holder.textView3.setText(responses.get(1).getIngredient());
holder.textView4.setText(responses.get(1).getMeasure());
//holder.textView5.setText(responses.get(position).getQuantity());


    }



    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.textView3) TextView textView3;
        @BindView(R.id.textView4) TextView textView4;
       @BindView(R.id.textView5) TextView textView5;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);




        }
    }
}
