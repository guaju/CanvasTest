package com.guaju.canvastest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by guaju on 2018/5/10.
 */

public class MyCanvas extends View {


    private Paint paint;

    public MyCanvas(Context context) {
        super(context);
        init();
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化画笔
        paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(100,100);

        canvas.drawCircle(0,0,50,paint);
        //关键步骤  复制了一个图层 并给图层设置透明度
        canvas.saveLayerAlpha(0,0,200,200,128);
        canvas.drawColor(Color.parseColor("#ffff00"));

        paint.setColor(Color.parseColor("#0000ff"));
        canvas.drawCircle(60,60,50,paint);
        //保存之前绘画记录，并且跳出 复制的图层
        canvas.restore();
        
        canvas.drawCircle(200,200,50,paint);
    }
}
