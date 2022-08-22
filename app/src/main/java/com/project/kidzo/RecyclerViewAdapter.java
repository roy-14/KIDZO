package com.project.kidzo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<RecyclerData> courseDataArrayList;
    private Context mcontext;
    int activityCode = 0;

    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, Context mcontext,int activityCode) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
        this.activityCode = activityCode;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerData recyclerData = courseDataArrayList.get(position);
        holder.courseTV.setText(recyclerData.getTitle());

        holder.parentLayout.setOnClickListener(v->{
            if (activityCode == 0){
                String text = speak(position);
                EnglishAlphabetActivity activity = (EnglishAlphabetActivity) holder.courseTV.getContext();
                activity.speak(text);
            }
            else if (activityCode == 1){
                MathsActivity activity = (MathsActivity) holder.courseTV.getContext();
                activity.speak(recyclerData.getTitle());
            } else if (activityCode == 2) {
                MathsBanglaActivity activity = (MathsBanglaActivity) holder.courseTV.getContext();
                activity.speak(recyclerData.getTitle());
            } else if (activityCode == 3){
                DaysActivity activity = (DaysActivity) holder.courseTV.getContext();
                activity.speak(recyclerData.getTitle());
            } else if (activityCode == 4){
                MonthsActivity activity = (MonthsActivity) holder.courseTV.getContext();
                activity.speak(recyclerData.getTitle());
            }


        });

    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView courseTV;
        public LinearLayout parentLayout;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.idTVCourse);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    private String speak(int position){
        String words = "A for Apple";
        switch (position) {
            case 0:
                words =  "A for Apple";
                break;
            case 1:
                words = "B for Ball";
                break;
            case 2:
                words = "C for cat";
                break;
            case 3:
                words = "D for dog";
                break;
            case 4:
                words = "E for elephant";
                break;
            case 5:
                words = "F for fish";
                break;
            case 6:
                words = "G for giraffe";
                break;
            case 7:
                words = "H for hat";
                break;
            case 8:
                words = "I for ice-cream";
                break;
            case 9:
                words = "J for jug";
                break;
            case 10:
                words = "K for kite";
                break;
            case 11:
                words = "L for lion";
                break;
            case 12:
                words = "M for monkey";
                break;
            case 13:
                words = "N for nest";
                break;
            case 14:
                words = "O for owl";
                break;
            case 15:
                words = "P for parrot";
                break;
            case 16:
                words = "Q for queen";
                break;
            case 17:
                words = "R for rat";
                break;
            case 18:
                words = "S for ship";
                break;
            case 19:
                words = "T for telephone";
                break;
            case 20:
                words = "u for umbrella";
                break;
            case 21:
                words = "V for van";
                break;
            case 22:
                words = "W for watch";
                break;
            case 23:
                words = "X for xylophone";
                break;
            case 24:
                words = "Y for yatch";
                break;
            case 25:
                words = "Z for zoo";
                break;

        }
        return words;
    }
}

