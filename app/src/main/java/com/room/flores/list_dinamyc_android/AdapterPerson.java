package com.room.flores.list_dinamyc_android;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.room.flores.list_dinamyc_android.helper.ItemTouchHelperAdapter;

import java.util.ArrayList;

public class AdapterPerson extends RecyclerView.Adapter<AdapterPerson.MyViewHolder> implements ItemTouchHelperAdapter {

    public interface OnDragStartListener {
        void onDragStarted(RecyclerView.ViewHolder viewHolder);
    }

    private ArrayList<Person> personArrayList;
    final private OnDragStartListener mDragStartListener ;

    public AdapterPerson(ArrayList<Person> personArrayList,OnDragStartListener dragStartListener) {
        this.personArrayList = personArrayList;
        mDragStartListener = dragStartListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(personArrayList.get(i));
        myViewHolder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) ==
                        MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onDragStarted(myViewHolder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Person person=personArrayList.get(fromPosition);
        personArrayList.remove(fromPosition);
        personArrayList.add(toPosition, person);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        personArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private final ImageView handleView;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvName);
            handleView= itemView.findViewById(R.id.handle);
        }

        private void bind(Person person) {
            textView.setText(person.getName());
        }
    }
}
