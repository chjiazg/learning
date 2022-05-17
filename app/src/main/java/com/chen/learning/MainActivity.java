package com.chen.learning;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    public TextView textView;
    private int[] textSizeArr = {10,20,25,30,40};
    int textSize = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textView = (TextView)findViewById(R.id.tv);
        findViewById(R.id.bt).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        AlertDialog dialog;
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("设置字体大小")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setSingleChoiceItems(new String[]{"小号", "默认", "中号", "大号", "超大"}, textSize, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textSize=which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textView.setTextSize(textSizeArr[textSize]);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        Log.i("11111", "onClick: ");
        dialog=builder.create();
        dialog.show();
    }
}
//    @Override
//    public void onClick(View view) {
//        AlertDialog dialog = new AlertDialog.Builder(this)
//                .setIcon(R.drawable.ic_launcher_foreground)                   //添加图标
//                .setTitle("请选择你的性别^_^")
//                .setPositiveButton("确定", null) //添加确定按钮
//                .setNegativeButton("取消", null)  //添加取消按钮
//                .setSingleChoiceItems(new String[]{"男", "女"}, -1, //负数表示没有默认选择；0默认选择"男"，1默认选择"女"
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })
//                .create();
//        dialog.show();
//    }
//}