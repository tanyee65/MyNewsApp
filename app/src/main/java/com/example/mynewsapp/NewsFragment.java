package com.example.mynewsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.new_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle==null) return;
        int newsid = bundle.getInt("news");
        int topicsid = bundle.getInt("topics");
        Log.d("A112280035", "get topics="+getString(topicsid));

        TextView tvNews = view.findViewById(R.id.tvNews);
        String newstitle = getString(topicsid)+getString(R.string.tech_news);
        tvNews.setText(newstitle);

        ListView lvNews = view.findViewById(R.id.lvNews);
        String[] news = getActivity().getResources().getStringArray(newsid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, news);
        lvNews.setAdapter(arrayAdapter);
    }

    public NewsFragment() {
        super();
    }
}
