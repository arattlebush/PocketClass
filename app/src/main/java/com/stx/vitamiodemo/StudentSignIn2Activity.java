package com.stx.vitamiodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentSignIn2Activity extends AppCompatActivity {

    private Class[]classes={new Class("汇编语言",R.drawable.huibian),new Class("高数",R.drawable.weijifen),new Class("C语言",R.drawable.c),new Class("JAVA",R.drawable.java),
            new Class("离散数学",R.drawable.lisan),new Class("数据结构",R.drawable.shujujiegou),new Class("概率论",R.drawable.gailvlun)};
    private List<Class> classList=new ArrayList<>();
    private ClassAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_student_sign2);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();//导航按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CircleImageView Circle=(CircleImageView)findViewById(R.id.Student_header1);
        Circle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

            }
        });
        TextView textView=(TextView)findViewById(R.id.studentname) ;

        Button button1=(Button)findViewById(R.id.Offline);
        Button button2=(Button)findViewById(R.id.news);
        TextView textView1=(TextView)findViewById(R.id.MYCLass);

        initClasses();//卡片式
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view1);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ClassAdapter(classList);
        recyclerView.setAdapter(adapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view6);
        navigation.setSelectedItemId(R.id.navigation_student);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void initClasses() {
        classList.clear();
        for(int i=0;i<8;i++){
            Random random=new Random();
            int index=random.nextInt(classes.length);
            classList.add(classes[index]);
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent=new Intent(StudentSignIn2Activity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_teacher:
                    Intent intent1=new Intent(StudentSignIn2Activity.this,AllClassActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_student:

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
                finish();

                break;
            default:
        }
        return true;
    }//响应事件




}
