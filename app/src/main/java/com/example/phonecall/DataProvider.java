package com.example.phonecall;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.text1;
import static android.R.layout.simple_list_item_1;
import static com.example.phonecall.CollectionWidget.updateAppWidget;

public class DataProvider implements RemoteViewsService.RemoteViewsFactory {
    List<String> myListView = new ArrayList<>();
    Context mContext = null;

    public DataProvider(Context context, Intent intent){
        mContext = context;
    }
    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return myListView.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews view = new RemoteViews(mContext.getPackageName(), simple_list_item_1);
        view.setTextViewText(text1, myListView.get(i));
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    private void initData() {
        myListView.clear();
        for (int i = 1; i <= 15; i++) {
            myListView.add("ListView item " + i);
        }
    }
}
