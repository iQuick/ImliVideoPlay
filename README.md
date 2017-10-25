# ImliVideoPlay
基于 ijkplayer 的播放器

---

[![](https://jitpack.io/v/iQuick/ImliVideoPlay.svg)](https://jitpack.io/#iQuick/ImliVideoPlay)

## gradle 中引用

1. 在根目录 build.gradle 中添加

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. 在项目目录 build.gradle 中添加

```gradle
dependencies {
        compile 'com.github.iQuick:ImliVideoPlay:v0.9.1'
}
```

---

## 使用

```java
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
```

---

## License

ImliIjkplayer is Copyright (c) 2017 iquick, inc. It is free software, and may be redistributed under the terms specified in the LICENSE file.
