package imli.me.imlivideoplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import imli.me.imlivideoplay.ui.ChangeClarityActivity;
import imli.me.imlivideoplay.ui.ProcessHome1Activity;
import imli.me.imlivideoplay.ui.ProcessHome2Activity;
import imli.me.imlivideoplay.ui.RecyclerViewActivity;
import imli.me.imlivideoplay.ui.TinyWindowPlayActivity;
import imli.me.imlivideoplay.ui.UseInFragActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_window_play).setOnClickListener(this);
        findViewById(R.id.btn_change_clarity).setOnClickListener(this);
        findViewById(R.id.btn_list_play).setOnClickListener(this);
        findViewById(R.id.btn_fragment_play).setOnClickListener(this);
        findViewById(R.id.btn_activity_click_home).setOnClickListener(this);
        findViewById(R.id.btn_fragment_click_home).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_window_play:
                openActivity(TinyWindowPlayActivity.class);
                break;
            case R.id.btn_change_clarity:
                openActivity(ChangeClarityActivity.class);
                break;
            case R.id.btn_list_play:
                openActivity(RecyclerViewActivity.class);
                break;
            case R.id.btn_fragment_play:
                openActivity(UseInFragActivity.class);
                break;
            case R.id.btn_activity_click_home:
                openActivity(ProcessHome1Activity.class);
                break;
            case R.id.btn_fragment_click_home:
                openActivity(ProcessHome2Activity.class);
                break;
        }
    }

    private void openActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
