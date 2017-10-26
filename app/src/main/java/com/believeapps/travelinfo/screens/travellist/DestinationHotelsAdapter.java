package com.believeapps.travelinfo.screens.travellist;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.believeapps.travelinfo.R;
import com.believeapps.travelinfo.api.wrappers.HotelsByChildDestination;
import com.believeapps.travelinfo.model.DestinationHotels;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationHotelsAdapter extends RecyclerView.Adapter<DestinationHotelsAdapter.ViewHolder> {

    private Context mContext;

    private List<DestinationHotels> mDestinationHotelsList;

    public static final String imageUrlBase = "https://d2f0rb8pddf3ug.cloudfront.net/api2/destination/images/getfromobject";

    public DestinationHotelsAdapter() {
        this.mDestinationHotelsList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View viewItem = LayoutInflater.from(mContext).inflate(R.layout.destination_hotels_item, parent, false);
        return new ViewHolder(viewItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_destination_img)
        ImageView imageView;

        @BindView(R.id.item_title_text_view)
        TextView title;

        @BindView(R.id.item_number_text_view)
        TextView numberOfHotels;

        @BindView(R.id.item_price_text_view)
        TextView price;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DestinationHotels hotels = mDestinationHotelsList.get(position);
        holder.title.setText(hotels.getTitle());
        holder.numberOfHotels.setText(String.valueOf(hotels.getCount()));
        holder.price.setText(addCurrencySymbol(hotels.getMinPrice().toString()));
        Picasso.with(mContext).load(buildImagePath(hotels.getImageType(), hotels.getImageId()))
                .into(holder.imageView);

    }

    private String buildImagePath(String imageType, String imageId) {
       return Uri.parse(imageUrlBase)
                .buildUpon()
                .appendQueryParameter("id", imageId)
                .appendQueryParameter("type", imageType)
                .appendQueryParameter("useDialsImages", "true")
                .appendQueryParameter("width", "300")
                .appendQueryParameter("height", "300")
                .build().toString();

    }

    private String addCurrencySymbol(String price) {
        StringBuilder builder = new StringBuilder(price);
        builder.insert(0, "£");
        return builder.toString();
    }
    public void swap(List<DestinationHotels> list) {
        mDestinationHotelsList.clear();
        mDestinationHotelsList.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (mDestinationHotelsList != null) {
            return mDestinationHotelsList.size();
        } else return 0;
    }
}

