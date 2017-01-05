package minhle.rssnewsreader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class NewsListActivity extends ListActivity {

    private List<RssItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int category = bundle.getInt(Variables.CATEGORY);
        int news = bundle.getInt(Variables.NEWS);
        setTitle(Variables.CATEGORIES[news][category]);
        int key = news * 1000 + category;
        items = Variables.newsMap.get(key);
        NewsAdapter adapter = new NewsAdapter(this, Variables.ICONS[news], items);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, NewsActivity.class);
        intent.putExtra(Variables.LINK, items.get(position).getLink());

        startActivity(intent);
    }
}
