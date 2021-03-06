package www.frame.com.myframe;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;

import www.frame.com.myframe.fragment.FragmentFactory;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    TextView tvToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarCompat.compat(this, Color.BLUE);

        setContentView(R.layout.activity_main);

        initView();
        setToolbar();
    }

    /**
     * 设置toolbar,Title居中<如果需要自定义Toolbar，可以参考助驾帮>
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbar = (TextView) findViewById(R.id.tv_toolbar);
        toolbar.setTitle("");
        tvToolbar.setText("首页");
    }

    private void initView() {
        mRadioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(this);
        //默认第一个为选中
        mRadioGroup.check(R.id.btn_home);
    }

    @Override
    /**
     * 响应选择改变的监听
     * @ checkedId 是当前选中的RadioButton的ID值
     */
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Fragment fragment= FragmentFactory.createFragment(checkedId , tvToolbar);

        //使用指定的fragment切换当前页面
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,fragment)
                .commit();

    }
}
