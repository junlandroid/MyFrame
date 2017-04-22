package www.frame.com.myframe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import www.frame.com.myframe.R;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class MeFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.llayout);
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        return view;
    }
}
