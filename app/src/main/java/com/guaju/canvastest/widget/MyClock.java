package com.guaju.canvastest.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.guaju.canvastest.R;
import com.guaju.canvastest.utils.MeasureScreenUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guaju on 2018/5/8.
 */

public class MyClock extends View {

    private Paint clockSidePaint, blueCenterPaint, timePaint,centerLittleCirclePaint,centerBigCirclePaint;
    int hourEndX,hourEndY,minuteEndX,minuteEndY;

    public MyClock(Context context) {
        super(context);
        init();
    }

    public MyClock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //做一些初始化操作

    /**
     * 1、准备画笔
     * 2、画布就不需要准备了
     */
    void init() {
        //准备画笔
        clockSidePaint = new Paint();
        blueCenterPaint = new Paint();
        //画笔的颜色
        blueCenterPaint.setColor(getContext().getResources().getColor(R.color.blue));
        clockSidePaint.setColor(getContext().getResources().getColor(R.color.black));
        //画笔的粗度,通过dimens（尺寸文件）
        clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.clockWidth));
        //设置画笔的画的类型
        clockSidePaint.setStyle(Paint.Style.STROKE);
        blueCenterPaint.setStyle(Paint.Style.FILL);
        //设置画笔抗锯齿
        clockSidePaint.setAntiAlias(true);
        blueCenterPaint.setAntiAlias(true);

        //时  分 秒 画笔
        timePaint = new Paint();
        timePaint.setColor(getContext().getResources().getColor(R.color.black));
        timePaint.setStyle(Paint.Style.FILL);
        timePaint.setAntiAlias(true);


        centerLittleCirclePaint=new Paint();
        centerLittleCirclePaint.setColor(getContext().getResources().getColor(R.color.blue));
        centerLittleCirclePaint.setStyle(Paint.Style.FILL);

        centerBigCirclePaint=new Paint();
        centerBigCirclePaint.setColor(getContext().getResources().getColor(R.color.silver));
        centerBigCirclePaint.setStyle(Paint.Style.FILL);




    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        /*
            1 2是圆心坐标 x,y
            3  是圆的半径
            4  是画笔
         */

        canvas.drawCircle(
                MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                MeasureScreenUtil.getScreenWidth() / 2 - 40,
                clockSidePaint);
        canvas.drawCircle(
                MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                MeasureScreenUtil.getScreenWidth() / 2 - 40,
                blueCenterPaint);
//        canvas.save();
        //画表的刻度
//        clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree));
        //因为要画四次
        for (int i = 0; i < 4; i++) {
//            canvas.save();
            clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree) * 4);
            canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40,
                    MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40 + getContext().getResources().getDimensionPixelSize(R.dimen.degreeLength),
                    clockSidePaint);
            canvas.rotate(90, MeasureScreenUtil.getScreenWidth() / 2, MeasureScreenUtil.getScreenHeight() / 2);
        }
//        canvas.save();
        canvas.restore();
//        clockSidePaint.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.textsize));
//        clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.textWidth));
//        for (int i = 0; i < 4; i++) {
////            canvas.save();
//            String text = i == 0 ? "12" : i * 3 + "";
//            clockSidePaint.setStyle(Paint.Style.FILL);
//            clockSidePaint.setColor(Color.parseColor("#ffffff"));
//            canvas.drawText(text,
//                    MeasureScreenUtil.getScreenWidth() / 2 - clockSidePaint.measureText(text) / 2,
//                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40 + getContext().getResources().getDimensionPixelSize(R.dimen.degreeLength) + 40,
//                    clockSidePaint);
//            canvas.rotate(90, MeasureScreenUtil.getScreenWidth() / 2, MeasureScreenUtil.getScreenHeight() / 2);
//        }
//        canvas.save();
//        canvas.restore();

        for (int i = 0; i < 12; i++) {
            clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree) * 2);
            canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40,
                    MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40 + getContext().getResources().getDimensionPixelSize(R.dimen.degreeLength) / 4 * 3,
                    clockSidePaint);
            canvas.rotate(30, MeasureScreenUtil.getScreenWidth() / 2, MeasureScreenUtil.getScreenHeight() / 2);
        }
        canvas.restore();

        for (int i = 0; i < 60; i++) {
            clockSidePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree));
            canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40,
                    MeasureScreenUtil.getScreenWidth() / 2,
                    MeasureScreenUtil.getScreenHeight() / 2 - MeasureScreenUtil.getScreenWidth() / 2 + 40 + getContext().getResources().getDimensionPixelSize(R.dimen.degreeLength) / 3,
                    clockSidePaint);
            canvas.rotate(6, MeasureScreenUtil.getScreenWidth() / 2, MeasureScreenUtil.getScreenHeight() / 2);
        }
        canvas.restore();
        //画一个圆心

        canvas.drawCircle(MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                getContext().getResources().getDimensionPixelSize(R.dimen.degreeRadius),
                centerBigCirclePaint);
        //画下时 分 秒 针
        timePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree) * 3);
        //时针
        canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                hourEndX,
                hourEndY,
                timePaint
        );
        //分针
        timePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree) * 2);
        canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                minuteEndX,
                minuteEndY,
                timePaint
        );
        //秒针
        timePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.degree));
        canvas.drawLine(MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2 + getContext().getResources().getDimensionPixelSize(R.dimen.secondLength),
                timePaint
        );



        canvas.drawCircle(MeasureScreenUtil.getScreenWidth() / 2,
                MeasureScreenUtil.getScreenHeight() / 2,
                getContext().getResources().getDimensionPixelSize(R.dimen.degreeRadius) / 2,
                centerLittleCirclePaint);
        Date date = new Date();
        SimpleDateFormat hourSdf = new SimpleDateFormat("hh");
        SimpleDateFormat miniteSdf = new SimpleDateFormat("mm");
        SimpleDateFormat secondSdf = new SimpleDateFormat("ss");
        int hour = Integer.parseInt(hourSdf.format(date));
        int minute = Integer.parseInt(miniteSdf.format(date));
        int second = Integer.parseInt(secondSdf.format(date));

        Log.e("guaju", hour + "--" + minute + "--" + second);
        //当小时小于等于6 时
        int hourRadius = getContext().getResources().getDimensionPixelSize(R.dimen.hourLength);
        int minuteRadius = getContext().getResources().getDimensionPixelSize(R.dimen.miniteLength);
        int clockCenterX = MeasureScreenUtil.getScreenWidth() / 2;
        int clockCenterY = MeasureScreenUtil.getScreenHeight() / 2;

       //hour  x 坐标
        int hourDegree = hour / 12 * 360;
        if (hour <= 6) {
            //拿到和横向水平线的角度关系
            int newDegree;
            if (hour <= 3) {
                newDegree = 90 - hourDegree;

            } else {
                newDegree = hourDegree - 90;
            }
            hourEndX = (int) (clockCenterX + hourRadius * Math.cos(newDegree));
        }
        if (hour > 6) {
            int newDegree;
            if (hour>=9){
                newDegree=hourDegree-270;
            }else{
                newDegree=270-hourDegree;
            }
            hourEndX = (int) (clockCenterX - hourRadius * Math.cos(newDegree));
        }

        //hour  y 坐标
        if (hour <= 6) {
            //拿到和横向水平线的角度关系
            int newDegree;
            if (hour <= 3) {
                newDegree = hourDegree;
                hourEndY = (int) (clockCenterY - hourRadius * Math.cos(newDegree));
            } else {
                newDegree = 180-hourDegree;
            }
            hourEndY = (int) (clockCenterY + hourRadius * Math.cos(newDegree));
        }
        if (hour > 6) {
            int newDegree;
            if (hour>=9){
                newDegree=360-hourDegree;
                hourEndY = (int) (clockCenterY - hourRadius * Math.cos(newDegree));
            }else{
                newDegree=hourDegree-180;
            }
            hourEndY = (int) (clockCenterY + hourRadius * Math.cos(newDegree));
        }


        int miniteDegree = minute / 60 * 360;
        if (minute <= 30) {
            //拿到和横向水平线的角度关系
            int newDegree;
            if (minute <= 15) {
                newDegree = 90 - hourDegree;

            } else {
                newDegree = hourDegree - 90;
            }
            minuteEndX = (int) (clockCenterX + minuteRadius * Math.cos(newDegree));
        }
        if (minute > 30) {
            int newDegree;
            if (minute>=45){
                newDegree=hourDegree-270;
            }else{
                newDegree=270-hourDegree;
            }
            minuteEndX = (int) (clockCenterX - minuteRadius * Math.cos(newDegree));
        }

        //minute  y 坐标
        if (minute <= 30) {
            //拿到和横向水平线的角度关系
            int newDegree;
            if (minute <= 15) {
                newDegree = hourDegree;
                hourEndY = (int) (clockCenterY - minuteRadius * Math.cos(newDegree));
            } else {
                newDegree = 180-hourDegree;
            }
            minuteEndY = (int) (clockCenterY + minuteRadius * Math.cos(newDegree));
        }
        if (minute > 30) {
            int newDegree;
            if (minute>=45){
                newDegree=360-hourDegree;
                minuteEndY = (int) (clockCenterY - minuteRadius * Math.cos(newDegree));
            }else{
                newDegree=hourDegree-180;
            }
            minuteEndY = (int) (clockCenterY + minuteRadius * Math.cos(newDegree));
        }
        //分
        invalidate();
    }




}
