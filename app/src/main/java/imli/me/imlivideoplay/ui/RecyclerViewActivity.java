package imli.me.imlivideoplay.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import imli.me.ijkplayer.VideoPlayerManager;
import imli.me.ijkplayer.player.SimpleVideoPlayer;
import imli.me.imlivideoplay.R;
import imli.me.imlivideoplay.adapter.VideoAdapter;
import imli.me.imlivideoplay.adapter.VideoViewHolder;
import imli.me.imlivideoplay.util.DataUtil;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        VideoAdapter adapter = new VideoAdapter(this, DataUtil.getVideoListData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                SimpleVideoPlayer simpleVideoPlayer = ((VideoViewHolder) holder).mVideoPlayer;
                if (simpleVideoPlayer == VideoPlayerManager.instance().getCurrentVideoPlayer()) {
                    VideoPlayerManager.instance().releaseVideoPlayer();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        VideoPlayerManager.instance().releaseVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (VideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
