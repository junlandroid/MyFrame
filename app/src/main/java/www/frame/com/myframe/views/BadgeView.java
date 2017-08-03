package www.frame.com.myframe.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import www.frame.com.myframe.R;


/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：自定义带消息提醒控件
 * 参    考: http://blog.csdn.net/u011054066/article/details/46744807
 * 创建日期：2017/8/3
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class BadgeView extends View {

    private String mBadgeText;//标签里面的文字
    private Bitmap mBadgeBitmap;//要显示的位图
    private int mBadgeTextColor;//字体颜色
    private int mBadgeTextSize;//字体大小
    private int mBadgeColor;//标签颜色
    private int mBadgePosition;//标签的位置
    private float mBadgeRadio = 0.2f;//标签相对于整个view的比例
    private boolean isHasBadge = false;//是否需要标签---->显示消息条目数的标签


    private Paint textPaint;//字体画笔
    private Rect textRect;//测量字体宽高的类
    private Paint mBadgePaint;//标签画笔

    private float radius;//标签的半径

    public enum BadgeType {
        CENTER(0), LEFTTOP(1), LEFTVERTICAL(2), LEFTBOTTOM(3), RIGHTTOP(4), RIGHTVERTICAL(
                5), RIGHTBOTTOM(6), TOPHORIZATAL(7), BOTTOMHORIZATAL(8);

        private final int value;

        BadgeType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public BadgeView(Context context) {
        this(context, null);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BadgeView, defStyleAttr, 0);
        int count = typedArray.getIndexCount();//拿到数组索引
        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i);//拿到索引对应下标的属性
            switch (attr) {
                case R.styleable.BadgeView_badgeText:
                    mBadgeText = typedArray.getString(attr);
                    break;
                case R.styleable.BadgeView_badgeTextColor:
                    mBadgeTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.BadgeView_badgeTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mBadgeTextSize = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.BadgeView_badgeColor:
                    mBadgeColor = typedArray.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.BadgeView_badgePosition:
                    mBadgePosition = typedArray.getInt(attr, 0);
                    break;
                case R.styleable.BadgeView_badgeRadio:
                    mBadgeRadio = typedArray.getFloat(attr, 0.3f);
                    break;
                case R.styleable.BadgeView_badgeBitmap:
                    mBadgeBitmap = BitmapFactory.decodeResource(getResources(), typedArray.getResourceId(attr, R.mipmap.ic_launcher));
                    break;
                case R.styleable.BadgeView_badgeIsVisibility:
                    isHasBadge = typedArray.getBoolean(attr, false);
                    break;
            }
        }
        typedArray.recycle();
        if (mBadgeText != null) {
            initTextPaint();//初始化字体画笔:
        }
        mBadgePaint = new Paint();
        mBadgePaint.setColor(mBadgeColor);
        mBadgePaint.setAntiAlias(true);
    }

    private void initTextPaint() {
        textPaint = new Paint();
        textRect = new Rect();
        textPaint.setColor(mBadgeTextColor);
        textPaint.setTextSize(mBadgeTextSize);
        textPaint.getTextBounds(mBadgeText, 0, mBadgeText.length(), textRect);
        textPaint.setAntiAlias(true);
    }

    //初始化完成以后，开始测量该view的宽高的,重写onMeasure(int widthMeasureSpec, int heightMeasureSpec) 方法:
    //首先测量onMeasure()  在绘画onDraw()

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        int width, height;
        if (specMode == MeasureSpec.EXACTLY) {
            width = specSize;
        } else {
            width = mBadgeBitmap.getWidth();
        }
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            height = specSize;
        } else {
            height = mBadgeBitmap.getHeight();
        }
        setMeasuredDimension(width, height);
        calculateScaleBitmap();
    }

    private void calculateScaleBitmap() {
        // TODO Auto-generated method stub
        int min = Math.min(getMeasuredHeight(), getMeasuredHeight());
        if (mBadgeBitmap.getWidth() > getMeasuredWidth()
                || mBadgeBitmap.getHeight() > getMeasuredHeight()) {
            mBadgeBitmap = Bitmap.createScaledBitmap(mBadgeBitmap, min, min, true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBadgeBitmap(canvas);
        if (isHasBadge) {
            drawBadgeText(canvas);
        }
    }

    //绘制位图
    private void drawBadgeBitmap(Canvas canvas) {
        float left = getWidth() / 2 - mBadgeBitmap.getWidth() / 2 + getPaddingLeft() - getPaddingRight();
        float top = getHeight() / 2 - mBadgeBitmap.getHeight() / 2 + getPaddingTop() - getPaddingBottom();
        canvas.drawBitmap(mBadgeBitmap, left, top, mBadgePaint);
    }

    //绘制展示消息条目的标

    /**
     * 然后再来画我们的标记, 标记这个东西嘛。。我这里是一个红色圆 其他的形状思路也是一样的，先来讲讲思路吧
     * <p>
     * Q1 这个圆的面积是多大(重点 直接影响体验)
     * <p>
     * Q2 这个圆是啥颜色 (easy 上面不是有个标记画笔么)
     * <p>
     * Q3 这个圆在什么位置(重点 算一下就好了)
     *
     * @param canvas
     */
    private void drawBadgeText(Canvas canvas) {
        radius = (float) calculateRadius();
        float cx = 0;
        float cy = 0;
        switch (mBadgePosition) {
            case 0:
                cx = getWidth() / 2;
                cy = getHeight() / 2;
                break;
            case 1:
                cx = getPaddingLeft() + radius;
                cy = getPaddingTop() + radius;
                break;
            case 2:
                cx = getPaddingLeft() + radius;
                cy = getHeight() / 2;
                break;
            case 3:
                cx = getPaddingLeft() + radius;
                cy = getHeight() - getPaddingBottom() - radius;
                break;
            case 4:
                cx = getWidth() - getPaddingRight() - radius;
                cy = getPaddingTop() + radius;
                break;
            case 5:
                cx = getWidth() - getPaddingRight() - radius;
                cy = getHeight() / 2;
                break;
            case 6:
                cx = getWidth() - getPaddingRight() - radius;
                cy = getHeight() - getPaddingBottom() - radius;
                break;
            case 7:
                cx = getWidth() / 2;
                cy = getPaddingTop() + radius;
                break;
            case 8:
                cx = getWidth() / 2;
                cy = getHeight() - getPaddingBottom() - radius;
                break;
        }

        canvas.drawCircle(cx, cy, radius, mBadgePaint);//画圆
        canvas.drawText(mBadgeText, (float) (cx - textRect.width() / 2.0f), (float) (cy + textRect.height() / 2.0f), textPaint);//画文字
    }

    private int calculateRadius() {
        int totalArea = mBadgeBitmap.getWidth() * mBadgeBitmap.getHeight();
        return (int) Math.sqrt(totalArea * mBadgeRadio / Math.PI);//位图面积*30%/π  --->在开平方
    }

    /*对外公布的方法*/
    public void setBadgeGravity(BadgeType badgeType) {
        this.mBadgePosition = badgeType.getValue();
        postInvalidate();
    }

    public void setBadgeBitmapResource(int resId) {
        this.mBadgeBitmap = BitmapFactory.decodeResource(getResources(), resId);
        postInvalidate();
    }

    public void setBadgeText(String text) {
        this.mBadgeText = text;
        postInvalidate();
    }

    public void setBadgeTextColor(int color) {
        this.mBadgeColor = color;
        textPaint.setColor(color);
        postInvalidate();
    }

    public void setBadgeTextSize(int sp) {
        float scale = getResources().getDisplayMetrics().scaledDensity;
        this.mBadgeTextSize = (int) (sp * scale + 0.5f);
        textPaint.setTextSize(mBadgeTextSize);
        postInvalidate();
    }

    public void setBadgeRadio(float radio) {
        this.mBadgeRadio = radio;
        postInvalidate();
    }

    public void setBadgeIsVisibility(boolean visibility) {
        isHasBadge = visibility;
        postInvalidate();
    }

}
