package com.example.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener listener;
    private GestureDetector detector;

    public RecyclerTouchListener(Context context, final RecyclerView view, final ClickListener listener) {
        this.listener=listener;
        detector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View v=view.findChildViewUnder(e.getX(), e.getY());
                if (v!=null && listener!=null)
                    listener.onLongClick(v,view.getChildPosition(v));
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v=rv.findChildViewUnder(e.getX(), e.getY());
        if (rv!=null && listener!=null && detector.onTouchEvent(e))
            listener.onClick(v, rv.getChildPosition(v));
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface ClickListener{

        void onClick(View v, int position);
        void onLongClick(View v, int position);
    }
}
