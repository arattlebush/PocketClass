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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Toolbar toolbar = (Toolbar) findViewById(R.id.student_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();//导航按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CircleImageView Circle=(CircleImageView)findViewById(R.id.Student_header);
        Circle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent=new Intent(StudentActivity.this,StudentSignInActivity.class);
                startActivity(intent);
            }
        });

        TextView textView=(TextView)findViewById(R.id.warning1) ;
        Button button1=(Button)findViewById(R.id.Sign_in1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent1=new Intent(StudentActivity.this,StudentSignInActivity.class);
                startActivity(intent1);
            }
        });
        Button button2=(Button)findViewById(R.id.register1);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent2=new Intent(StudentActivity.this,RegisterActivity.class);
            }
        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view2);
        navigation.setSelectedItemId(R.id.navigation_student);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent=new Intent(StudentActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_teacher:
                    Intent intent1=new Intent(StudentActivity.this,AllClassActivity.class);
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
