package com2027.toolbox.group12.toolbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import java.util.Locale;


/**
 * Author: Dennis Ocaka
 *
 * Created at: 03/04/2019
 * Updated at: 05/04/2019
 *
 * The RecyclerViewAdapter is used to construct each tool instance in the ListView and
 * some formatting to the structure of the presentation of each item description etc..
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    /* The current context. */
    private Context mActivity;
    /* The list of tools. */
    private List<Tool> mToolList;

    /**
     * Parameterized Constructor used to initialise the class
     *
     * @param mActivity
     *          The Activity Context
     * @param mToolList
     *          A set of tools
     */
    public RecyclerViewAdapter(Context mActivity, List<Tool> mToolList){
        // The current context
        this.mActivity = mActivity;
        // An instance of tool
        this.mToolList = mToolList;
    }

    /**
     * Initialises the ViewHolder(s)
     *
     * @param viewGroup
     *          The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param i
     *          The index of the current view
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mView;
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        mView = mInflater.inflate(R.layout.cardview_item_tool, viewGroup, false);
        return new MyViewHolder(mView);
    }

    /*
     * Defines how each view is initialised. Each tool in the list is used for each
     * separate myViewHolder
     *
     * @param myViewHolder
     *          Represents the view that will be shown
     *
     * @param tool_index
     *          The index of the current tool
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int tool_index) {

        // Initialise tool with the current tool index in the list
        final Tool tool = mToolList.get(tool_index);

        String tName = tool.getToolName();
        String tPrice = "£" + String.format(Locale.ENGLISH, "%.2f", tool.getPrice());
        String tTimeSpan = "Pay by: " + tool.getPayRate().toString();

        int tRating = tool.getRating();
        String rating =  "Rating: " + String.valueOf(tRating) + "/5";





        // Set the tools name
        myViewHolder.tool_name.setText(tName);
        // Set the tools price
        myViewHolder.tool_price.setText(tPrice);
        // Set the payment timespan
        myViewHolder.tool_timespan.setText(tTimeSpan);
        // Set the tool rating
        myViewHolder.tool_rating.setText(rating);

        // Display an image of the tool
        Glide.with(mActivity)
                .load(tool.getImage_profile_picture())  // Load the tools profile picture
                .load(R.mipmap.ic_launcher)             // If it does not load, load a dummy image
                .apply(new RequestOptions())
                .into(myViewHolder.tool_image);         // load image into ImageView

        // Respond to clicks on the tool
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Go to the page of the item
                //Intent intent = new Intent(mContext, );
                Toast.makeText(mActivity, "You clicked on " + tool.getToolName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /*
     * Get the current number of tools in the list
     */
    @Override
    public int getItemCount() {
        return mToolList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // The Tool cardview instance
        CardView cardView;

        // The tools "profile picture"
        ImageView tool_image;
        // The name of the tool
        TextView tool_name;
        // The time span of payment
        TextView tool_timespan;
        // The price of the tool
        TextView tool_price;
        // The rating of the tool
        TextView tool_rating;
        // The Distance of the tool from the User
        TextView tool_distance;



        public MyViewHolder(View itemView){
            super(itemView);

            tool_image = (ImageView) itemView.findViewById(R.id.tool_img_id);
            tool_name = (TextView) itemView.findViewById(R.id.tool_name_id);
            tool_timespan = (TextView) itemView.findViewById(R.id.tool_payBy_id);
            tool_price = (TextView) itemView.findViewById(R.id.tool_price_id);
            tool_rating = (TextView) itemView.findViewById(R.id.tool_rating_id);
            tool_distance = (TextView) itemView.findViewById(R.id.tool_distance_id);

            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}


