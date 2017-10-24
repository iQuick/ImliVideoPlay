package imli.me.imlivideoplay.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import imli.me.ijkplayer.VideoPlayerManager;
import imli.me.imlivideoplay.R;


public class UseInFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_in_frag);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new DemoFragenment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (VideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
