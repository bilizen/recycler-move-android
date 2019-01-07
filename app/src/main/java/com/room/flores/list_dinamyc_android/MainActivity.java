package com.room.flores.list_dinamyc_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.room.flores.list_dinamyc_android.helper.SimpleItemTouchHelperCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterPerson.OnDragStartListener {

    private RecyclerView rvPerson;
    private AdapterPerson adapterPerson;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPerson = findViewById(R.id.rvPerson);
        rvPerson.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(1, "Bill", "72041666"));
        personArrayList.add(new Person(2, "cris", "72041789"));
        personArrayList.add(new Person(3, "jamil", "72041616"));
        personArrayList.add(new Person(1, "Carlos", "72041666"));
        personArrayList.add(new Person(2, "Gerardo", "72041789"));
        personArrayList.add(new Person(3, "pilar", "72041616"));
        personArrayList.add(new Person(1, "Jhona", "72041666"));
        personArrayList.add(new Person(2, "alex", "72041789"));
        personArrayList.add(new Person(3, "sonaly", "72041616"));
        personArrayList.add(new Person(3, "Jan", "72041616"));
        personArrayList.add(new Person(3, "Pablo", "72041616"));


        adapterPerson = new AdapterPerson(personArrayList, this);
        rvPerson.setAdapter(adapterPerson);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapterPerson);

        mItemTouchHelper= new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rvPerson);
    }



    @Override
    public void onDragStarted(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
