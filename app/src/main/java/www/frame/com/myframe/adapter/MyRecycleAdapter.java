package www.frame.com.myframe.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import www.frame.com.myframe.R;
import www.frame.com.myframe.utils.JudgeNullUtil;

/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：
 * <p>
 * 创建日期：2017/8/4
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<Bitmap> mList;
    private LayoutInflater mInflater;
    private String itemFlag;

    //添加回调接口来处理item的点击事件
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);//点击事件

        void onItemLongClickListener(View view, int position);//长按事件
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnClickListener(OnItemClickListener onClickListener) {
        this.mOnItemClickListener = onClickListener;
    }

    //建立枚举 2个item类型
    public enum ITEM_TYPE {
        ITEM1, ITEM2, ITEM3, ITEM4, ITEM5, ITEM6, ITEM7, ITEM8, ITEM9, ITEM10, ITEM11, ITEM12
    }

    public MyRecycleAdapter(Context context, List<Bitmap> list , String flag) {
        this.mContext = context;
        this.mList = list;
        this.itemFlag = flag;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = mInflater.inflate(R.layout.recycle_item, parent, false);
        holder = new Item1ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!JudgeNullUtil.iList(mList)) {
            return;
        }

        ((Item1ViewHolder) holder).imageView.setImageBitmap(mList.get(position));

    }

    @Override
    public int getItemViewType(int position) {
//        if (JudgeNullUtil.iStr(mList.get(position).getUseFlag())) {// 标签不为空
//            return ITEM_TYPE.ITEM1.ordinal();
//        } else {
//            return ITEM_TYPE.ITEM2.ordinal();
//        }
        return ITEM_TYPE.ITEM1.ordinal();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Item1ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_recycle_item);
        }
    }

    class Item2ViewHolder extends RecyclerView.ViewHolder {


        public Item2ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
