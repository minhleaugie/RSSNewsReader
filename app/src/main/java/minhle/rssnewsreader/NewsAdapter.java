package minhle.rssnewsreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class NewsAdapter extends ArrayAdapter<RssItem> {
    private  Context context;
    private List<RssItem> items;
    private int imageViewIcon;

    public NewsAdapter(Context context, int imageViewIcon, List<RssItem> items) {
        super(context, imageViewIcon, items);

        this.context = context;
        this.imageViewIcon = imageViewIcon;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.news, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
        TextView textView = (TextView) rowView.findViewById(R.id.textViewNews);
        imageView.setImageResource(imageViewIcon);
        textView.setText(items.get(position).getTitle());
        return rowView;
    }
}
