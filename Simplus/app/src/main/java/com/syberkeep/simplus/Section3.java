package com.syberkeep.simplus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Section3 extends Fragment {

    private View view;
    private ListView listView;

    int[] images = {R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};
    String[] people = {"Shubham Kushwah", "Ramneek Kalra", "HMR Institute of Technology & Managament", "CSE"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_section3, container, false);
        listView = (ListView) view.findViewById(R.id.list_contacts);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        return view;
    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return people.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.list_image_person);
            TextView person_name = (TextView) convertView.findViewById(R.id.list_person);
            ImageButton call_btn = (ImageButton) convertView.findViewById(R.id.list_call_btn);
            ImageButton options_btn = (ImageButton) convertView.findViewById(R.id.list_options_btn);

            person_name.setText(people[position]);
            image.setImageResource(images[position]);

            return convertView;
        }
    }

}
