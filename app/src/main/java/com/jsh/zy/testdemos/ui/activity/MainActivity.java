package com.jsh.zy.testdemos.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Toast;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseActivity;
import com.jsh.zy.testdemos.ui.fragment.MainFragment;

import org.xutils.view.annotation.ContentView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(R.id.main_content,new MainFragment()).commit();
        actionBar = getSupportActionBar();
    }

    @Override
    public void initDatas() {
       checkUserPermission();
    }

    private void checkUserPermission() {
        List<String> permissionsList = new ArrayList<>();
        addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionsList.size() > 0) {
            ActivityCompat.requestPermissions(this, permissionsList.toArray(new String[permissionsList.size()]), 200);
        }
    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200:
                Map<String, Integer> perms = new HashMap<>();
                // Initial
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION
                if ( perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted
                    //PrefUtils.putBoolean("all_permission_allow", true);
                } else {
                    // Permission Denied
                    Toast.makeText(this, "授权未完成", Toast.LENGTH_SHORT)
                            .show();
//                    PrefUtils.putBoolean("all_permission_allow", false);
                }
                break;
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 200){
//            StringBuffer sb = new StringBuffer();
//            boolean isAllGranted = true;//权限是否全部得到
//            for(int i=0;i<permissions.length;i++){
//                if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
//                    isAllGranted = false;
//                    if(Manifest.permission.INTERNET.equals(permissions[i])){
//                        sb.append("联网");
//                    }else if(Manifest.permission.WRITE_EXTERNAL_STORAGE.equals(permissions[i])){
//                        sb.append("修改外部存储空间");
//                    }
//                    if (i!=permissions.length-1)
//                        sb.append("、");
//                }
//            }
//            if(!isAllGranted){
//                Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
