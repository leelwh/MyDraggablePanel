package com.example.apuser.mydraggablepanel.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by apuser on 3/30/15.
 */
public class MyItemList {
    public List<MyItem> myItems;

    public MyItemList() {
        this.myItems = new ArrayList<MyItem>();
    }

    public List<MyItem> getMarvelCharacters() {
        return (List<MyItem>) ((ArrayList<MyItem>) myItems).clone();
    }

    public void add(MyItem marvelCharacter) {
        this.myItems.add(marvelCharacter);
    }

    public void addAll(Collection<MyItem> myItems) {
        this.myItems.addAll(myItems);
    }

    public void clear() {
        this.myItems.clear();
    }

    public MyItem get(int position) {
        return myItems.get(position);
    }
}
