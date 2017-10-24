package imli.me.imlivideoplay.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import imli.me.ijkplayer.controller.SimpleVideoPlayerController;
import imli.me.ijkplayer.player.SimpleVideoPlayer;
import imli.me.imlivideoplay.R;
import imli.me.imlivideoplay.bean.Video;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public SimpleVideoPlayerController mController;
    public SimpleVideoPlayer mVideoPlayer;

    public VideoViewHolder(View itemView) {
        super(itemView);
        mVideoPlayer = (SimpleVideoPlayer) itemView.findViewById(R.id.simple_video_player);
        // 将列表中的每个视频设置为默认16:9的比例
        ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
        params.width = itemView.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
        params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
        mVideoPlayer.setLayoutParams(params);
    }

    public void setController(SimpleVideoPlayerController controller) {
        mController = controller;
        mVideoPlayer.setController(mController);
    }

    public void bindData(Video video) {
        mController.setTitle(video.getTitle());
        mController.setLenght(video.getLength());
//        Glide.with(itemView.getContext())
//                .load(video.getImageUrl())
//                .placeholder(R.drawable.img_default)
//                .crossFade()
//                .into(mController.imageView());
        mVideoPlayer.setUp(video.getVideoUrl(), null);
    }
}
