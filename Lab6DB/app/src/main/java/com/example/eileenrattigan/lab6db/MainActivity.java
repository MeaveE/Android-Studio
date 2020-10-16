package com.example.eileenrattigan.lab6db;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DatabaseExample thisDatabase = new DatabaseExample(this);
        thisDatabase.open();
        thisDatabase.insertTask("Shopping", "Get shopping list", 0);
        thisDatabase.insertTask("Dog", "Take it for a walk", 0);
        thisDatabase.insertTask("Work", "Make money", 0);

        Cursor mCursor = thisDatabase.getAllTasks();
        String[] columns = new String[] {"Task_Name", "Task_Description"};
        int[] rowIDs = new int [] {R.id.taskName,
                R.id.tasks};
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.row, mCursor, columns, rowIDs);
        setListAdapter(mAdapter);
        thisDatabase.close();

    }


  /*  protected void onListItemClick (ListView l, View v, int position, long id){
        DatabaseExample thisDatabase = new DatabaseExample(this);
        Cursor mCursor = thisDatabase.getAllTasks();
        if (mCursor.Status == 1)
        {
            Toast.makeText(getApplicationContext(), "Task Complete", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Task incomplete", Toast.LENGTH_LONG).show();
        }
    }
*/

}
