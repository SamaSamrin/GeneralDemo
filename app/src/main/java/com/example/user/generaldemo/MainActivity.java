package com.example.user.generaldemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    GridView grid;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.main_menu_grid);
        GridAdapter main_grid_adapter = new GridAdapter(this);
        grid.setAdapter(main_grid_adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.e(TAG, "clicked on item number = "+i);
                Intent intent = null;
                if (i==0) //go to widgets
                    intent = new Intent(MainActivity.this, WidgetsClass.class);
                else if (i==1)
                    intent = new Intent(MainActivity.this, UICode.class);
                else if (i==2)
                    intent = new Intent(MainActivity.this, ActivityTypes.class);
                if (intent!=null)
                    startActivity(intent);
                else
                    Log.e(TAG, "NO VALID GRID SELECTED AT i="+i);
            }
        });
    }
}

class GridAdapter extends BaseAdapter{

    private final String TAG = this.getClass().getSimpleName();

    Context context;
    String[] categories = {"Widgets", "UI Code", "Activity Types", "Type 4", "Type 5", "Type 6",
            "Type 7", "Type 8", "Type 9", "Type 10", "Type 11", "Type 12"};
    String[] fadeColors = {"#ce93d8", "#b388ff", "#f48fb1", "#26c6da"};
    int length = categories.length;

    LayoutInflater inflater;

    GridAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return length;
    }

    @Override
    public Object getItem(int i) {
        Log.e(TAG, " getItem : item number = "+i );
        if (i<length)
            return categories[i];
        else
            return null;
    }

    @Override
    public long getItemId(int i) {
        //Log.e(TAG, " getItemId : item id = "+i );
        if (i<length)
            return i;
        else
            return -1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v==null){
            //LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.main_grid_menu , null, false);
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            v.setLayoutParams(new LinearLayout.LayoutParams(point.x/3, point.y/4));
        }

        TextView tv = v.findViewById(R.id.main_grid_item_text);
        //Log.e(TAG, " getView : view = "+tv.getId() );
        tv.setText(categories[i]);
        tv.setTextSize(20);
        tv.setTextColor(Color.WHITE);
        if (i%4==0) //red
            tv.setBackgroundColor(Color.parseColor(fadeColors[0]));
        else if (i%4==1) //blue
            tv.setBackgroundColor(Color.parseColor(fadeColors[1]));
        else if (i%4==2) //green
            tv.setBackgroundColor(Color.parseColor(fadeColors[2]));
        else if (i%4==3)
            tv.setBackgroundColor(Color.parseColor(fadeColors[3]));
        //notifyDataSetChanged();

        return v;
    }
}
