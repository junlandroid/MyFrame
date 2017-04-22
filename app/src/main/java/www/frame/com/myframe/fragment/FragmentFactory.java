package www.frame.com.myframe.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.HashMap;

import www.frame.com.myframe.R;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class FragmentFactory {

    private static Fragment fragment;

    public static Fragment createFragment(int checkedId, TextView tvToolbar) {

        switch (checkedId) {

            case R.id.btn_home://主页
                fragment = new HomeFragment();
                if (tvToolbar != null) {
                    tvToolbar.setText("首页");
                }
                break;

            case R.id.btn_classify://发现
                fragment = new ClassifyFragment();
                if (tvToolbar != null) {
                    tvToolbar.setText("发现");
                }
                break;

            case R.id.btn_discover://分类
                fragment = new DiscoverFragment();
                if (tvToolbar != null) {
                    tvToolbar.setText("分类");
                }
                break;

            case R.id.btn_me://我的
                fragment = new MeFragment();
                if (tvToolbar != null) {
                    tvToolbar.setText("我的");
                }
                break;
        }

        return fragment;
    }
}
