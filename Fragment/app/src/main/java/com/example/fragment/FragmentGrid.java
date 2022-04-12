package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;

import java.util.List;

public class FragmentGrid extends Fragment {

    List<DienThoai> listPhone;
    PushData pushData;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        listPhone = new DataDefault().getDataDefault();
        view = inflater.inflate(R.layout.fragment_grid, container, false);

        DienThoaiAdapter adapter = new DienThoaiAdapter(getActivity(), listPhone);
        GridView gridView =(GridView) view.findViewById(R.id.gridView_DienThoai);

        gridView.setAdapter(adapter);

        pushData = (PushData) getActivity();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pushData.dataPhone(listPhone.get(i));
            }
        });

        return view;
    }
}
