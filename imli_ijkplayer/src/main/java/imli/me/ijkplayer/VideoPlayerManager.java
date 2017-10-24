package imli.me.ijkplayer;

import imli.me.ijkplayer.player.SimpleVideoPlayer;

/**
 *
 * 视频播放器管理器.
 *
 */
public class VideoPlayerManager {

    private SimpleVideoPlayer mSimpleVideoPlayer;

    private VideoPlayerManager() {
    }

    private static VideoPlayerManager sInstance;

    public static synchronized VideoPlayerManager instance() {
        if (sInstance == null) {
            sInstance = new VideoPlayerManager();
        }
        return sInstance;
    }

    public SimpleVideoPlayer getCurrentVideoPlayer() {
        return mSimpleVideoPlayer;
    }

    public void setCurrentVideoPlayer(SimpleVideoPlayer videoPlayer) {
        if (mSimpleVideoPlayer != videoPlayer) {
            releaseVideoPlayer();
            mSimpleVideoPlayer = videoPlayer;
        }
    }

    public void suspendVideoPlayer() {
        if (mSimpleVideoPlayer != null && (mSimpleVideoPlayer.isPlaying() || mSimpleVideoPlayer.isBufferingPlaying())) {
            mSimpleVideoPlayer.pause();
        }
    }

    public void resumeVideoPlayer() {
        if (mSimpleVideoPlayer != null && (mSimpleVideoPlayer.isPaused() || mSimpleVideoPlayer.isBufferingPaused())) {
            mSimpleVideoPlayer.restart();
        }
    }

    public void releaseVideoPlayer() {
        if (mSimpleVideoPlayer != null) {
            mSimpleVideoPlayer.release();
            mSimpleVideoPlayer = null;
        }
    }

    public boolean onBackPressd() {
        if (mSimpleVideoPlayer != null) {
            if (mSimpleVideoPlayer.isFullScreen()) {
                return mSimpleVideoPlayer.exitFullScreen();
            } else if (mSimpleVideoPlayer.isTinyWindow()) {
                return mSimpleVideoPlayer.exitTinyWindow();
            }
        }
        return false;
    }
}
