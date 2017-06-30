package com.example.myapplication.ui.activity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

public class VideoPlayActivity extends BaseActivity {
private VideoView mVideoView;
    private ProgressBar mProgressBar;

    @Override
    public int getLayoutR(int id) {
        return R.layout.activity_video_play;
    }

    @Override
    protected void initViews() {
        mVideoView= (VideoView) findViewById(R.id.video_view);
        mProgressBar= (ProgressBar) findViewById(R.id.pb_02);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initDate() {
        String videoUrl=getIntent().getStringExtra("video_url");
        //设置播放路径
        mVideoView.setVideoPath(videoUrl);
        //设置监听  缓冲
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
                mProgressBar.setVisibility(View.GONE);
            }
        });

    }
}
