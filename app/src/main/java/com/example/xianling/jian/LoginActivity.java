package com.example.xianling.jian;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    SQLiteOpenHelper helper;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button Login;
    private CheckBox rememberPass;
    String account;
    String password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.login);
        helper = new MyDatabaseHelper(this);
        helper.getWritableDatabase();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        Login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool=isNetworkConnected(LoginActivity.this);
                if(bool){
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);}
                else {
                    Toast.makeText(LoginActivity.this,"请检查网络连接",Toast.LENGTH_SHORT).show();
                }
            }
        });
       boolean remember=pref.getBoolean("记住密码", false);
       if(remember){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        Login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean bool=isNetworkConnected(LoginActivity.this);
                if(bool){
                account = accountEdit.getText().toString();
                password = passwordEdit.getText().toString();
                if (account.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入account及password", Toast.LENGTH_SHORT).show();
                } else {
                    sureuser(account, password);
                    editor=pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("记住密码", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else{
                        editor.clear();
                   }
                        editor.commit();
                }
            }else {
                    Toast.makeText(LoginActivity.this,"请检查网络连接",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void sureuser(String account, String password) {
        SQLiteDatabase db = helper.getReadableDatabase();
        try {
            String sql = "select * from jianshu where account=? and password=?";
            Cursor cursor = db.rawQuery(sql, new String[]{account, password});
            if (cursor.getCount()>0) {
                Intent intent = new Intent(LoginActivity.this, YindaoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("account", account);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "登录失败,你还未注册账号",
                        Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast.makeText(LoginActivity.this, "亲，请注册！",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public boolean isNetworkConnected(Context context){
        if(context!=null){
            ConnectivityManager con=(ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info=con.getActiveNetworkInfo();
            if(info!=null){
                return info.isAvailable();
            }

        }
        return false;

    }



}


