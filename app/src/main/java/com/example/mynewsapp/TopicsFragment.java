package com.example.mynewsapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TopicsFragment extends Fragment {
    private NewsFragment aiFragment;
    private NewsFragment spaceFragment;
    private NewsFragment climateFragment;
    private NewsFragment biomedicalFragment;
    private NewsFragment computingFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.topics_fragment, container, false);
    }
    private void switchFragment(int topicsId, int newsId, NewsFragment newsFragment){
        Toast.makeText(getContext(), getString(topicsId), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putInt("topics", topicsId);
        bundle.putInt("news", newsId);
        newsFragment.setArguments(bundle);
        Log.d("A112280035", "put topics="+getString(topicsId));

        boolean isLandscape = getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(isLandscape? R.id.news_frame: R.id.topics_frame, newsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnAI = view.findViewById(R.id.btnAI);
        btnAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aiFragment == null) aiFragment = new NewsFragment();
                switchFragment(R.string.ai, R.array.ai_array, aiFragment);
            }
        });
        Button btnSpace = view.findViewById(R.id.btnSpace);
        btnSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spaceFragment == null) spaceFragment = new NewsFragment();
                switchFragment(R.string.aerospace, R.array.aerospace_array,spaceFragment);
            }
        });
        Button btnClimate = view.findViewById(R.id.btnClimate);
        btnClimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (climateFragment == null) climateFragment = new NewsFragment();
                switchFragment(R.string.climate_tech, R.array.climate_tech_array, climateFragment);
            }
        });
        Button btnBiomedical = view.findViewById(R.id.btnBiomedical);
            btnBiomedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (biomedicalFragment == null) biomedicalFragment = new NewsFragment();
                switchFragment(R.string.biomedical, R.array.biomedical_array, biomedicalFragment);
            }
        });
        Button btnComputing = view.findViewById(R.id.btnComputing);
        btnComputing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (computingFragment == null) computingFragment = new NewsFragment();
                switchFragment(R.string.computing, R.array.computing_array, computingFragment);
            }
        });


                //Bundle bundle = new Bundle();
                //bundle.putInt("topics", R.id.btnAI);
                //bundle.putInt("news", R.array.ai_array);
                //aiFragment.setArguments(bundle);
                //Log.d("A112280035",getString(R.string.ai));

                //FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                //fragmentTransaction.replace(R.id.news_frame, aiFragment);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.commit();


    }

    public TopicsFragment() {
        super();
    }
}
