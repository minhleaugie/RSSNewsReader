package minhle.rssnewsreader;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.List;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class NewsListActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int category = bundle.getInt(Variables.CATEGORY);
        int news = bundle.getInt(Variables.NEWS);

        int key = news * 1000 + category;
        List<RssItem> items = Variables.newsMap.get(key);
        NewsAdapter adapter = new NewsAdapter(this, Variables.ICONS[news], items);
        setListAdapter(adapter);

    }
}
