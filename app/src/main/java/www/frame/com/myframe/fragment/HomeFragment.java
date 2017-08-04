package www.frame.com.myframe.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import www.frame.com.myframe.R;
import www.frame.com.myframe.activity.FlowLayoutActivity;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class HomeFragment extends Fragment{

    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn = ((Button) view.findViewById(R.id.btn));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),FlowLayoutActivity.class));
            }
        });
        return view;


    }

}
