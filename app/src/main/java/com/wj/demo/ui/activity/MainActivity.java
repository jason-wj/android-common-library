package com.wj.demo.ui.activity;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.wj.demo.R;
import com.wj.demo.domain.Item;
import com.wj.demo.ui.activity.hongbao.DemoWeChatGetHongbaoActivity;
import com.wj.demo.ui.activity.killprocess.DemoNotKillProcessActivity;
import com.wj.demo.ui.adapter.AdapterRecyclerItem;
import com.wj.demo.ui.base.BaseActivity;
import com.wj.library.helper.ToastHelper;
import com.wj.library.helper.ToolbarHelper;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private static String TAG = MainActivity.class.getName();

    private RecyclerView rvItem;  //使用了recyclerView
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private AdapterRecyclerItem adapterRecyclerItem;
    private ArrayList<Item> items;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        rvItem = (RecyclerView) findViewById(R.id.rv_item);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //地址动态添加
        adapterRecyclerItem = new AdapterRecyclerItem(this, items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvItem.setLayoutManager(linearLayoutManager);
        rvItem.setAdapter(adapterRecyclerItem);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "https://github.com/jason-wj/android-common-library", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

        ToolbarHelper.initToolbar(this, toolbar, R.string.app_name, R.string.toolBar, R.mipmap.ic_drawer_home, Color.WHITE);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    ToastHelper.toastShort(MainActivity.this, R.string.menu_search);

                } else if (menuItemId == R.id.action_notification) {
                    ToastHelper.toastShort(MainActivity.this, R.string.menu_notifications);

                } else if (menuItemId == R.id.action_settings) {
                    ToastHelper.toastShort(MainActivity.this, R.string.item_setting);

                } else if (menuItemId == R.id.action_about) {
                    ToastHelper.toastShort(MainActivity.this, R.string.item_about);

                }
                return true;
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        items = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("1.JSON生成与解析");
        item1.setState("已实现");
        item1.setActivity(DemoJsonActivity.class);
        items.add(item1);

        Item item2 = new Item();
        item2.setName("2.GIF动画");
        item2.setState("已实现");
        item2.setActivity(DemoGifViewActivity.class);
        items.add(item2);

        Item item3 = new Item();
        item3.setName("3.头像切换");
        item3.setState("已实现");
        item3.setActivity(DemoChangeProtraitActivity.class);
        items.add(item3);

        Item item4 = new Item();
        item4.setName("4.有弹性的ScrollView");
        item4.setState("已实现");
        item4.setActivity(DemoElasticScorllViewActivity.class);
        items.add(item4);

        Item item5 = new Item();
        item5.setState("未实现");
        item5.setName("5.页面手势滑动");
        items.add(item5);

        Item item6 = new Item();
        item6.setState("测试中");
        item6.setName("6.JNI测试");
        item6.setActivity(DemoJNIActivity.class);
        items.add(item6);

        Item item7 = new Item();
        item7.setName("7.图片手势缩放");
        item7.setState("已实现");
        item7.setActivity(DemoZoomImageActivity.class);
        items.add(item7);

        Item item8 = new Item();
        item8.setName("8.EmptyLayout");
        item8.setState("已实现");
        item8.setActivity(DemoEmptyLayoutActivity.class);
        items.add(item8);

        Item item9 = new Item();
        item9.setName("9.可清空的EditText");
        item9.setState("已实现");
        item9.setActivity(DemoClearEdittextActivity.class);
        items.add(item9);

        Item item10 = new Item();
        item10.setName("10.微信抢红包");
        item10.setState("已实现");
        item10.setActivity(DemoWeChatGetHongbaoActivity.class);
        items.add(item10);

        Item item11 = new Item();
        item11.setName("11.进程永驻");
        item11.setState("已实现");
        item11.setActivity(DemoNotKillProcessActivity.class);
        items.add(item11);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }

        return false;
    }

}
