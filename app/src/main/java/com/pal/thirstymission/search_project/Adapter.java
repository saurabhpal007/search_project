package com.pal.thirstymission.search_project;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Projects> projects;
    private Context context;

    public Adapter(List<Projects> projects, Context context) {
        this.projects = projects;
        this.context = context;
        Log.i("opopo","sfdsfdsf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText("TITLE:"+projects.get(position).getTitle());
        holder.id.setText("ID:"+String.valueOf(projects.get(position).getId()));
        holder.uid.setText("USER ID:"+String.valueOf(projects.get(position).getUid()));
        holder.descp.setText("DESCP:"+String.valueOf(projects.get(position).getDescp()));
        holder.time.setText("CREATED ON:"+String.valueOf(projects.get(position).getTime()));
        Log.i("qqqqqqqq",""+projects.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,id,descp,uid,time;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            id=itemView.findViewById(R.id.ide);
            uid=itemView.findViewById(R.id.uid);
            descp=itemView.findViewById(R.id.descp);
            time=itemView.findViewById(R.id.time);

        }
    }
}