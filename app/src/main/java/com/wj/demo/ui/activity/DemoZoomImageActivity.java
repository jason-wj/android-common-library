package com.wj.demo.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.wj.demo.R;
import com.wj.demo.ui.base.BaseActivity;
import com.wj.library.helper.ToolbarHelper;
import com.wj.library.widget.GestureImageView;

/**
 * 图片手势缩放demo
 * @version 1.0
 */
public class DemoZoomImageActivity extends BaseActivity {
    private static String TAG = DemoZoomImageActivity.class.getSimpleName();

    private Toolbar toolbar;
    private TextView tvTitle;
    private GestureImageView mivImage;
    Bitmap bitmap;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_demo_zoom_img);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tvTitle = (TextView)findViewById(R.id.tv_title);

        tvTitle.setText("图片手势缩放");
        ToolbarHelper.initToolbar(this,toolbar,R.mipmap.ic_back);

        mivImage = (GestureImageView) findViewById(R.id.miv_img);
        bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.mipmap.demo_img_zoom);
        mivImage.setImageBitmap(bitmap);
        mivImage.setType(GestureImageView.Type.FIT_CENTER);
    }

    @Override
    protected void myOnClick(View view) {
        super.myOnClick(view);
        switch (view.getId()){

        }
    }

    @Override
    protected void onDestroy() {
        bitmap.recycle();
        super.onDestroy();
        System.gc();

    }
}
