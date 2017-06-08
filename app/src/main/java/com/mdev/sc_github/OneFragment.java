package com.mdev.sc_github;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OneFragment extends Fragment {
    private AllCommand allCommand;
    private static final String ARG_PARAM1 = "param1";
    private String mData;
    private TextView tvTitle,tvData;

    public OneFragment() {}

    public static OneFragment newInstance(String param1) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mData = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle.setText(mData);
        if (savedInstanceState == null) {
            onLoadFromServer();
        }
    }

    private void initView(View rootView) {
        allCommand = new AllCommand();
        tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        tvData = (TextView) rootView.findViewById(R.id.tvData);
    }

    private void onLoadFromServer(){
        try {
            new AsyncTask<String, Void, String>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    tvData.setText("กำลังโหลด...");
                }

                @Override
                protected String doInBackground(String... params) {

                    return allCommand.GET_OK_HTTP_SendData("http://www.thailive.net/ios/get_tableplay.php?date="+ mData +"&uuid=358918050979765");
                }

                @Override
                protected void onPostExecute(String s) {
                    tvData.setText(s.toString().trim());
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
        }catch (Exception e){
            allCommand.ShowLogcat("Error","OneFragment : onLoadFromServer");
        }

    }
}
