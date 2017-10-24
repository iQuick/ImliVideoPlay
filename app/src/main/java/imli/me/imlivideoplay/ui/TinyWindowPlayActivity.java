package imli.me.imlivideoplay.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import imli.me.ijkplayer.VideoPlayerManager;
import imli.me.ijkplayer.controller.SimpleVideoPlayerController;
import imli.me.ijkplayer.player.SimpleVideoPlayer;
import imli.me.imlivideoplay.R;

public class TinyWindowPlayActivity extends AppCompatActivity {

    private SimpleVideoPlayer mVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiny_window_play);
        init();
    }

    private void init() {
        mVideoPlayer = (SimpleVideoPlayer) findViewById(R.id.simple_video_player);
        mVideoPlayer.setPlayerType(SimpleVideoPlayer.TYPE_NATIVE); // IjkPlayer or MediaPlayer
        // 本地视频
        String videoUrl = Environment.getExternalStorageDirectory().getPath().concat("/办公室小野.mp4");
        mVideoPlayer.setUp(videoUrl, null);
        SimpleVideoPlayerController controller = new SimpleVideoPlayerController(this);
        controller.setTitle("办公室小野开番外了，居然在办公室开澡堂！老板还点赞？");
        controller.setLenght(98000);
//        Glide.with(this)
//                .load("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg")
//                .placeholder(R.drawable.img_default)
//                .crossFade()
//                .into(controller.imageView());
        mVideoPlayer.setController(controller);
    }

    public void enterTinyWindow(View view) {
        if (mVideoPlayer.isIdle()) {
            Toast.makeText(this, "要点击播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        } else {
            mVideoPlayer.enterTinyWindow();
        }
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
