package club.vasilis.vasmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import club.vasilis.vasmusic.R;
import club.vasilis.vasmusic.adapter.PlayListAdapter;
import club.vasilis.vasmusic.domain.Music;
import club.vasilis.vasmusic.listener.OnItemClickListener;

/**
 * @author Vasilis
 * @date 2019/4/24 * 9:18
 */
public class LocalMusicFragment extends Fragment implements OnItemClickListener{

    @BindView(R.id.rv_local_music)
    RecyclerView rvLocalMusic;
    @BindView(R.id.local_music_tv_searching)
    TextView tvSearching;

    private static final String TAG = "LocalMusicFragment";


    private List<Music> localMusicList;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        testInit();
        Log.e(TAG, "onCreateView: "+localMusicList.toString());

        rvLocalMusic.setAdapter(new PlayListAdapter(this,localMusicList));
        rvLocalMusic.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void testInit() {
        localMusicList = new ArrayList<>();
        Music music = new Music();
        music.setTitle("1");
        localMusicList.add(music);
        music.setTitle("2");
        localMusicList.add(music);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v, int position) {
        switch (v.getId()){
            case R.id.iv_more :{
                Toast.makeText(getContext(), "点击了更多"+position ,Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                Toast.makeText(getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: " + v + position);
            }
        }


    }
}
