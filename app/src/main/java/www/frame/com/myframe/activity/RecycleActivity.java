package www.frame.com.myframe.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import www.frame.com.myframe.R;
import www.frame.com.myframe.adapter.MyRecycleAdapter;

/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：
 * <p>
 * 创建日期：2017/8/4
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class RecycleActivity extends Activity {
    private RecyclerView recycleView;
    private List<Bitmap> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recycleView = (RecyclerView)findViewById(R.id.recycleview);
        initDatas();


        MyRecycleAdapter adapter = new MyRecycleAdapter(this, list , "item10");

        recycleView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));

        recycleView.setAdapter(adapter);

    }

    //初始化数据
    private void initDatas() {
        list = new ArrayList<>();
        for (int i = 0; i<12;i++) {
            list.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        }
    }
}
