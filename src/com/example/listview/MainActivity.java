package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener, OnScrollListener{
	
	private ListView mListView;
	private ArrayAdapter<String> mArrayAdapter;
	private SimpleAdapter mSimpleAdapter;
	private List<Map<String, Object>> mDataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.listView);
		ImageView img;
		String[] courses = {"JAVA", "Android", "Ajax"};
		//mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
		//mListView.setAdapter(mArrayAdapter);
		mDataList = new ArrayList<Map<String,Object>>();
		mSimpleAdapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"image", "text"}, new int[]{R.id.imageView, R.id.textView});
		mListView.setAdapter(mSimpleAdapter);
		mListView.setOnItemClickListener(this);
		mListView.setOnScrollListener(this);
	}
	
	private List<Map<String, Object>> getData() {
		for(int i = 0; i < 20; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "imooc");
			mDataList.add(map);
		}
		return mDataList;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Log.i("lsx", "Fling");	
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "added item");
			mDataList.add(map);
			mSimpleAdapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			//Log.i("lsx", "IDle");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			//Log.i("lsx", "touch_scroll");
			break;
		
		}
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String text = (parent.getItemAtPosition(position)).toString();
		Toast.makeText(this, "po: " + position + " text: " + text, Toast.LENGTH_SHORT).show();
	}

}
