package minhle.rssnewsreader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BrightLight on 1/4/2017.
 */

public class RssHandler extends DefaultHandler{

    public static final String ITEM = "item";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String LINK = "link";
    public static final String DATE = "pubdate";

    private RssItem item;
    private List<RssItem> itemList = new ArrayList<RssItem>();

    private boolean started = false;
    private StringBuilder sBuilder = new StringBuilder();


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);

        if (localName.equalsIgnoreCase(ITEM)) {
            item = new RssItem();
            started = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equalsIgnoreCase(ITEM)) {
            itemList.add(item);
        } else if (started) {
            if (localName.equalsIgnoreCase(TITLE)) {
                item.setTitle(sBuilder.toString().trim());
            } else  if (localName.equalsIgnoreCase(DESCRIPTION)) {
                item.setDescription(sBuilder.toString().trim());
            } else  if (localName.equalsIgnoreCase(LINK)) {
                item.setLink(sBuilder.toString().trim());
            } else  if (localName.equalsIgnoreCase(DATE)) {
                item.setDate(sBuilder.toString().trim());
            }
            sBuilder = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (started && (sBuilder != null)) {
            sBuilder.append(ch, start, length);
        }
    }

    public List<RssItem> getItemList() {
        return itemList;
    }
}
