package minhle.rssnewsreader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewspaperActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
        // Variables.NEWSPAPER);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.newspaper, R.id.textViewNewspaper,
        // Variables.NEWSPAPER);




        NewspaperAdapter newspaperAdapter = new NewspaperAdapter(this, R.id.textViewNewspaper,
                Variables.NEWSPAPER);

        setListAdapter(newspaperAdapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent("minhle.rssnewsreader.CATEGORY");
        intent.putExtra(Variables.NEWS, position);
        startActivity(intent);
    }


}
