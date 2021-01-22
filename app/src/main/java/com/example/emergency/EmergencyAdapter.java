package com.example.emergency;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder> {
    private MediaPlayer media;
    private ArrayList<EmergencyModel> emergencyList;
    private Activity activity;

    public EmergencyAdapter(ArrayList<EmergencyModel> emergencyList, Activity activity) {
        this.emergencyList = emergencyList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EmergencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        EmergencyViewHolder holder = new EmergencyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmergencyViewHolder holder, final int position) {
        holder.imageView.setImageResource(emergencyList.get(position).getImage());
        holder.textView.setText(emergencyList.get(position).getName());
        holder.text2View.setText("" + emergencyList.get(position).getNumber());
        try {

            holder.text2View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = emergencyList.get(position).getNumber();
                    String res = String.valueOf(num);
                    Uri call = Uri.parse("tel:" + res);
                    Intent intent = new Intent(Intent.ACTION_DIAL, call);
                    activity.startActivity(intent);

                }
            });
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity,ImageR.class);
                    intent.putExtra("picture",emergencyList.get(position).getImage());
                    intent.putExtra("sound",emergencyList.get(position).getRaw());
                    intent.putExtra("title",emergencyList.get(position).getName());
                    activity.startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getItemCount() {
        return emergencyList.size();
    }

    public class EmergencyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView text2View;


        public EmergencyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageCard);
            textView = itemView.findViewById(R.id.textCard);
            text2View = itemView.findViewById(R.id.text2Card);

        }
    }
}

