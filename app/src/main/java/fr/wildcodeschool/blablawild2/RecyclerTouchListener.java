package fr.wildcodeschool.blablawild2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener clickListener;
    private View child;

    public RecyclerTouchListener(final ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.clickListener == null)
            return false;
        this.child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        return this.child != null;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        this.clickListener.onClick(child, recyclerView.getChildAdapterPosition(child));
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {
        this.clickListener = null;
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }
}
