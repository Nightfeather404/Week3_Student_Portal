package com.example.student.portal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {
    private List<Portal> portals;
    final private PortalClickListener portalClickListener;

    public interface PortalClickListener {
        void portalOnClick(int index);
    }

    public PortalAdapter(List<Portal> portals, PortalClickListener portalClickListener) {
        this.portals = portals;
        this.portalClickListener = portalClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            portalClickListener.portalOnClick(clickedPosition);
        }
    }

    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        PortalAdapter.ViewHolder viewHolder = new PortalAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder holder, int position) {
        Portal portal = portals.get(position);
        holder.textView.setText(portal.getPortalTitle());
    }

    @Override
    public int getItemCount() {
        return portals.size();
    }


}
