package club.vasilis.vasmusic.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import club.vasilis.vasmusic.R;
import club.vasilis.vasmusic.domain.Music;
import club.vasilis.vasmusic.listener.OnItemClickListener;

/**
 * @author Vasilis
 * @date 2019/4/25 * 10:12
 */
public class PlayListAdapter extends RecyclerViewClickableAdapter<PlayListAdapter.ViewHolder> {

    private List<Music> musicList;

    public PlayListAdapter(OnItemClickListener listener, List<Music> musicList) {
        super(listener);
        this.musicList = musicList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_local_music_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Music music = musicList.get(i);


        viewHolder.tvTitle.setText(music.getTitle() == null ? "" : music.getTitle());

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    class ViewHolder extends RecyclerViewClickableAdapter.ViewHolder {
        @BindView(R.id.item_local_iv_cover)
        ImageView ivCover;
        @BindView(R.id.item_local_tv_title)
        TextView tvTitle;
        @BindView(R.id.item_local_tv_artist)
        TextView tvArtist;
        @BindView(R.id.iv_more)
        ImageView ivMore;
        @BindView(R.id.v_divider)
        View vDivider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            if (listener !=null){
                itemView.setOnClickListener(this);
                ivMore.setOnClickListener(this);
            }

        }
    }
}
