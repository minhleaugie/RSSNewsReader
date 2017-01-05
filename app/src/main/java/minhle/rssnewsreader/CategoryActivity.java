package minhle.rssnewsreader;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
    private ProgressDialog dialog;

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
        int key = news * 1000 + position;
        if (Variables.newsMap.get(key) == null) {
            dialog = ProgressDialog.show(CategoryActivity.this, "", "Loading " + Variables.CATEGORIES[news][position]);
            new CategoryTask().execute(position);
        } else {
            Intent intent = new Intent(CategoryActivity.this, NewsListActivity.class);
            intent.putExtra(Variables.NEWS, news);
            intent.putExtra(Variables.CATEGORY, position);
            startActivity(intent);

        }


    }

    class CategoryTask extends AsyncTask<Integer, Void, Void> {

        private int position;

        protected Void doInBackground(Integer... params) {
            position = params[0];
            int key = news * 1000 + position;
            RssParser parser = new RssParser();
            List<RssItem> items = parser.getNewsList(Variables.LINKS[news][position]);
            Variables.newsMap.put(key,items);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if(dialog!=null) {
                dialog.dismiss();
            }
            Intent intent = new Intent(CategoryActivity.this, NewsListActivity.class);
            intent.putExtra(Variables.NEWS, news);
            intent.putExtra(Variables.CATEGORY, position);
            startActivity(intent);
            super.onPostExecute(result);
        }
    }
}
