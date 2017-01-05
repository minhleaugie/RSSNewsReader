package minhle.rssnewsreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BrightLight on 1/3/2017.
 */

public class NewspaperAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] newspapers;


    public NewspaperAdapter(Context context, int textViewResourceId, String[] newspapers) {
        super(context, textViewResourceId, newspapers);
        this.context = context;
        this.newspapers = newspapers;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.newspaper, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
        TextView textView = (TextView) rowView.findViewById(R.id.textViewNewspaper);
        imageView.setImageResource(Variables.ICONS[position]);
        textView.setText(newspapers[position]);
        return rowView;
    }
}
