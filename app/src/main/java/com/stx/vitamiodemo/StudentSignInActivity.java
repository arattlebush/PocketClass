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
import android.widget.EditText;
import android.widget.Toast;

public class StudentSignInActivity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_student_sign);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();//导航按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        accountEdit=(EditText)findViewById(R.id.account1);
        passwordEdit=(EditText)findViewById(R.id.password1);
        login=(Button)findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    Intent intent=new Intent(StudentSignInActivity.this,StudentSignIn2Activity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(StudentSignInActivity.this, "再次输入", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view5);
        navigation.setSelectedItemId(R.id.navigation_student);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent=new Intent(StudentSignInActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_teacher:
                    Intent intent1=new Intent(StudentSignInActivity.this,AllClassActivity.class);
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
