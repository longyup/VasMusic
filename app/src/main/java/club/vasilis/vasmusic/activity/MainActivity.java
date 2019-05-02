package club.vasilis.vasmusic.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import club.vasilis.vasmusic.R;
import club.vasilis.vasmusic.adapter.FragmentAdapter;
import club.vasilis.vasmusic.fragment.LocalMusicFragment;
import club.vasilis.vasmusic.fragment.OnlineFragment;
import club.vasilis.vasmusic.fragment.PlayFragment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabbar_iv_menu)
    ImageView mTabbarIvMenu;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private LocalMusicFragment localMusicFragment;
    private OnlineFragment onlineFragment;
    private PlayFragment playFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);

        initViewPager();
    }

    private void initViewPager() {
        localMusicFragment = new LocalMusicFragment();
        onlineFragment = new OnlineFragment();
        playFragment = new PlayFragment();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(localMusicFragment);
        adapter.addFragment(onlineFragment);
        adapter.addFragment(playFragment);
        viewPager.setAdapter(adapter);

    }

    @OnClick(R.id.tabbar_iv_menu)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tabbar_iv_menu:
                break;
        }
    }
}
