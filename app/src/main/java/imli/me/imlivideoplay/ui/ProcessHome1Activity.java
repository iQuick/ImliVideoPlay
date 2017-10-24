package imli.me.imlivideoplay.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import imli.me.ijkplayer.VideoPlayerManager;
import imli.me.ijkplayer.player.SimpleVideoPlayer;
import imli.me.imlivideoplay.R;
import imli.me.imlivideoplay.adapter.VideoAdapter;
import imli.me.imlivideoplay.adapter.VideoViewHolder;
import imli.me.imlivideoplay.base.CompatHomeKeyActivity;
import imli.me.imlivideoplay.util.DataUtil;


/**
 * 只需要集成自CompatHomeKeyActivity，按下Home键，暂停视频播放，回到此Activity后继续播放视频；
 * 如果离开次Activity（跳转到其他Activity或按下Back键），则释放视频播放器
 */
public class ProcessHome1Activity extends CompatHomeKeyActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_home1);
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

}
