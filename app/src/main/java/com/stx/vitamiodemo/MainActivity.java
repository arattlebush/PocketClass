package com.stx.vitamiodemo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private RollPagerView mRollViewPager;
    private SwipeRefreshLayout swipeRefresh;
    private Class[]classes={new Class("汇编语言",R.drawable.huibian),new Class("高数",R.drawable.weijifen),new Class("C语言",R.drawable.c),new Class("JAVA",R.drawable.java),
            new Class("离散数学",R.drawable.lisan),new Class("数据结构",R.drawable.shujujiegou),new Class("概率论",R.drawable.gailvlun)};
    private List<Class>classList=new ArrayList<>();
    private ClassAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//标题栏Toolbar传入

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshClasses();
            }
        });//下拉刷新


       mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);
        mRollViewPager.setAnimationDurtion(500);    //设置切换时间
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager)); //设置适配器
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.WHITE, Color.GRAY));// 设置圆点指示器颜色
        // mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        //滑动图片轮播

        initClasses();//卡片式
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ClassAdapter(classList);
        recyclerView.setAdapter(adapter);
        /*de.hdodenhof.circleimageview.CircleImageView Circle=(de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.icon_image);
        Circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MainActivity.this,ZhongzhuanActivity.class);
               //startActivity(intent);
            }
        });
        *//**//**//**//*TextView textView=(TextView)findViewById(R.id.warning2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZhongzhuanActivity.class);
                startActivity(intent);
            }
        }); */

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);//底部菜单

        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);

        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);//侧滑菜单传入
        ActionBar actionBar=getSupportActionBar();//导航按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }



        //navView.setCheckedItem(R.id.nav_delete);//默认选中第一个
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            public boolean onNavigationItemSelected(MenuItem item){

                switch (item.getItemId()) {
                    case R.id.nav_delete:
                       return true;
                    case R.id.nav_settings:
                       Intent intent2=new Intent(MainActivity.this,SettingsActivity.class);
                       startActivity(intent2);

                } return true;
            }
        });
    }







    private void refreshClasses(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initClasses();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initClasses() {
        classList.clear();
        for(int i=0;i<8;i++){
            Random random=new Random();
            int index=random.nextInt(classes.length);
            classList.add(classes[index]);
        }
    }


    private class TestLoopAdapter extends LoopPagerAdapter
    {
        private int[] imgs = {R.drawable.j1, R.drawable.j2, R.drawable.j3, R.drawable.j4};  // 本地图片
        private int count = imgs.length; // banner上图片的数量

        public TestLoopAdapter(RollPagerView viewPager)
        {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position)
        {
            final int picNo = position + 1;
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setOnClickListener(new View.OnClickListener()      // 点击事件
            {
                @Override
                public void onClick(View v)
                {
                    //Toast.makeText(MainActivity.this, "点击了第" + picNo + "张图片", Toast.LENGTH_SHORT).show();
                    switch (picNo){
                        case 1:
                            Intent intent=new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://www.jianshu.com/p/92284e2e144a?utm_medium=index-banner&utm_source=desktop"));
                            startActivity(intent);
                            break;
                        case 2:
                            Intent intent1=new Intent(Intent.ACTION_VIEW);
                            intent1.setData(Uri.parse("http://coding.imooc.com/class/96.html?mc_marking=d7163aeee9a5eab550a14cc2b699c976&mc_channel=banner"));
                            startActivity(intent1);
                            break;
                        case 3:
                            Intent intent2=new Intent(Intent.ACTION_VIEW);
                            intent2.setData(Uri.parse("http://geek.csdn.net/news/detail/196554"));
                            startActivity(intent2);
                            break;
                        case 4:
                            Intent intent4=new Intent(Intent.ACTION_VIEW);
                            intent4.setData(Uri.parse("http://bss.csdn.net/m/topic/edu_front"));
                            startActivity(intent4);
                            break;
                            }

                }

            });

            return view;
        }

        @Override
        public int getRealCount()
        {
            return count;
        }

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_teacher:
                   Intent intent1=new Intent(MainActivity.this,AllClassActivity.class);
                   startActivity(intent1);
                    return true;
                case R.id.navigation_student:
                    Intent intent=new Intent(MainActivity.this,StudentActivity.class);
                   startActivity(intent);
                    return true;

            }
            return false;
        }

    };

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }//标题栏菜单

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "暂无", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }//响应事件


}
