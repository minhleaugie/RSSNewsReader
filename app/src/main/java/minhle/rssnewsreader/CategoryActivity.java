package minhle.rssnewsreader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;

import java.util.List;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class CategoryActivity extends ListActivity {

    private int news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Bundle bundle = getIntent().getExtras();
        news = bundle.getInt(Variables.NEWS);

        setTitle(Variables.NEWSPAPER[news]);
        CategoryAdapter adapter = new CategoryAdapter(this, Variables.ICONS[news],Variables.CATEGORIES[news]);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(CategoryActivity.this, NewsListActivity.class);
        intent.putExtra(Variables.NEWS, news);
        intent.putExtra(Variables.CATEGORY, position);
        startActivity(intent);
        int key = news * 1000 + position;
        RssParser parser = new RssParser();
        List<RssItem> items = parser.getNewsList(Variables.LINKS[news][position]);
        Variables.newsMap.put(key,items);
    }
}
