package com.example.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends ListFragment {

    List<DienThoai> listPhone;
    ListDienThoaiAdapter adapter;
    PushData pushData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pushData = (PushData) getActivity();

        listPhone = new SetData().setDataDefault();
        adapter = new ListDienThoaiAdapter(getActivity(), listPhone);
        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        pushData.dataPhone((listPhone.get(position)));
    }
}
