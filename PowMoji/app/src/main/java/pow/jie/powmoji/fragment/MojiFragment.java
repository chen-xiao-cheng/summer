package pow.jie.powmoji.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pow.jie.powmoji.R;

import static java.lang.Thread.sleep;

public class MojiFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String type;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    public MojiFragment() {
        // Required empty public constructor
    }

    public static MojiFragment newInstance(String type) {
        MojiFragment fragment = new MojiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moji, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getView() != null) {
            refreshLayout = getView().findViewById(R.id.srl_fg);
            recyclerView = getView().findViewById(R.id.rv_fg);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    request(type);
                }
            });
        }
    }

    private void request(String type){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    refreshLayout.setRefreshing(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
