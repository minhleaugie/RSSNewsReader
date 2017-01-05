package minhle.rssnewsreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class CategoryAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] categories;
    private int imageViewIcon;


    public CategoryAdapter(Context context, int imageViewIcon, String[] categories) {
        super(context, imageViewIcon, categories);
        this.context = context;
        this.imageViewIcon = imageViewIcon;
        this.categories = categories;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.category, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
        TextView textView = (TextView) rowView.findViewById(R.id.textViewCategory);
        imageView.setImageResource(imageViewIcon);
        textView.setText(categories[position]);
        return rowView;
    }
}
