package www.frame.com.myframe.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import www.frame.com.myframe.R;


/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：自定义控件  { http://blog.csdn.net/lmj623565791/article/details/24252901}
 * <p>
 * 创建日期：2017/7/27
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class CustomTextView extends View {
    private static final String TAG = CustomTextView.class.getSimpleName();

    /*文本*/
    private String mTitleText;

    /*文本颜色*/
    private int mTitleColor;

    /*文本字体大小*/
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Paint mPaint;
    private Rect mBound;

    /**
     *
     * 注意：构造方法中 this关键字使用
     * 一、this关键字主要有三个应用：
     *(1)this调用本类中的属性，也就是类中的成员变量；
     *(2)this调用本类中的其他方法；
     *(3)this调用本类中的其他构造方法，调用时要放在构造方法的首行。
     *
     */
    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context) {
        this(context, null);
    }


    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyleAttr, 0);
        int count = typedArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTextView_titleText://注意这种写法
                    mTitleText = typedArray.getString(attr);
                    break;
                case R.styleable.CustomTextView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleColor = typedArray.getColor(attr, Color.YELLOW);
                    break;
                case R.styleable.CustomTextView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        //点击事件
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cassiel is my girl", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
        } else
        {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTitleColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }
}
