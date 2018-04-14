package com.example.subramanyam.reciep;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kimkevin.cachepot.CachePot;

import java.util.List;

public class RecRece extends RecyclerView.Adapter<RecRece.ViewHolder> {
    public LayoutInflater layoutInflater;
    public Context mContext;
    private int food;
    List<Response> list;



    public RecRece(Context context,List<Response> responses)

    {
        mContext=context;

        this.list=responses;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.receipelist,parent,false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

  holder.textView.setText(list.get(position).getName());


        Log.i("wse", String.valueOf(list.get(position).getIngredients()));

        CachePot.getInstance().push("rec",list.get(position).getIngredients());
        CachePot.getInstance().push("fec",position);



        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,RecipList.class);
                mContext.startActivity(intent);







            }
        });



    }



    @Override
    public int getItemCount() {
        return list.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView);

        }
    }

}
