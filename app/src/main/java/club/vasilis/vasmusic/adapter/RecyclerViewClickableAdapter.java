package club.vasilis.vasmusic.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import club.vasilis.vasmusic.listener.OnItemClickListener;

/**
 * @author Vasilis
 * @date 2019/5/1 * 18:19
 */
public abstract class RecyclerViewClickableAdapter<VH extends RecyclerViewClickableAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected OnItemClickListener listener;

    public RecyclerViewClickableAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (listener != null) {
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getLayoutPosition());
        }
    }
}