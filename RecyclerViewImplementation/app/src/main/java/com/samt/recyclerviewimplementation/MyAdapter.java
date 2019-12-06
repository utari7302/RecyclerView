package com.samt.recyclerviewimplementation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> values;
    //Parametrize Constructor Which Accept The List Data
    public MyAdapter(List<String> myDataSet)
    {
        //In myDataSet the data is comming from MainActivity class from variable Input and store in values varoable
        values=myDataSet;
    }

    @NonNull
    @Override
    //Create the View Holder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Set Data in Every Element is responsibility of "Adapter" This work is done in onCreateViewHolder class
        //It returns an object of type "ViewHolder" against every entry
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.singleitem,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }
    //Used to Set the Values
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Return the position in which you click on specific data position
        final String name=values.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When ever we click on item the item is removed
                remove(position);

            }
        });
        holder.txtfooter.setText("footer"+name);
    }
    public void remove(int position)
    {
        values.remove(position);
        //After removing the list should be updated automatically
        notifyItemRemoved(position);
    }
    //This Function Return the Size of List/ArrayList
    @Override
    public int getItemCount() {
        return values.size();
    }
    //To declare and initialization the singleitem.xml class onjects(ImageView,Text etc)
    //To caught the view and holds the widget
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Declare the Widgets
        public TextView txtHeader;
        public TextView txtfooter;
        //For Adopt
        public View layout;
        //In onCreateViewHolder code is return "View" which is accept by Constructor of "View Holder"
        //in which "singleitem" is passed through object
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHeader=(TextView) itemView.findViewById(R.id.maintext);
            txtfooter=(TextView) itemView.findViewById(R.id.subtext);
        }
    }
}
