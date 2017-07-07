package com.stx.vitamiodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllClassActivity extends AppCompatActivity {
    private List<ClassList> classListList = new ArrayList<ClassList>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_class);


        Toolbar toolbar = (Toolbar) findViewById(R.id.allclass_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();//导航按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initClassList(); // 初始化数据
        ClassListAdapter adapter = new ClassListAdapter(AllClassActivity.this, R.layout.classlist_item, classListList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ClassList classList = classListList.get(position);
                Toast.makeText(AllClassActivity.this, classList.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view_all_class);
        navigation.setSelectedItemId(R.id.navigation_teacher);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initClassList() {
        for(int i=0;i<2;i++) {
            ClassList c = new ClassList("数据结构", R.drawable.class1);
            classListList.add(c);
            ClassList c1 = new ClassList("计算机组成原理", R.drawable.class2);
            classListList.add(c1);
            ClassList c2 = new ClassList("高数", R.drawable.class3);
            classListList.add(c2);
            ClassList c3 = new ClassList("线性代数", R.drawable.class5);
            classListList.add(c3);
            ClassList c4 = new ClassList("概率论", R.drawable.class6);
            classListList.add(c4);
            ClassList c5 = new ClassList("JAVA", R.drawable.class7);
            classListList.add(c5);
            ClassList c6 = new ClassList("C++", R.drawable.class8);
            classListList.add(c6);
            ClassList c7 = new ClassList("IOS", R.drawable.class4);
            classListList.add(c7);
            ClassList c8 = new ClassList("ANDROID", R.drawable.class9);
            classListList.add(c8);
            ClassList c9 = new ClassList("MySQL", R.drawable.class10);
            classListList.add(c9);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent=new Intent(AllClassActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_teacher:

                case R.id.navigation_student:
                    Intent intent1=new Intent(AllClassActivity.this,StudentActivity.class);
                    startActivity(intent1);
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
