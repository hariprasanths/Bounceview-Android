package hari.bounceviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hari.bounceview.BounceView;

/**
 * Created by hari on 8/6/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    List<String> menus;
    boolean isOutside = false;

    public RecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.menus = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.textView.setText(menus.get(position));

        //Add animation to a view inside recycler view
        BounceView.addAnimTo(holder.listItem)
            .setPopOutAnimDuration(150)
            .setScaleForPushInAnim(.95f,.9f)
            .setScaleForPopOutAnim(1.05f,1.1f);

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout listItem;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            listItem = view.findViewById(R.id.relativeLayoutListItem);
            textView = view.findViewById(R.id.textViewListItem);
        }
    }

    void onClickListItem(View view, int position) {
        Toast.makeText(context, menus.get(position) + " clicked",Toast.LENGTH_SHORT).show();
    }
}