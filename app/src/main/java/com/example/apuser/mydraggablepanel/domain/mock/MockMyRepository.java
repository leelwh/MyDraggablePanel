package com.example.apuser.mydraggablepanel.domain.mock;

import com.example.apuser.mydraggablepanel.domain.GetMyItemsException;
import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.example.apuser.mydraggablepanel.domain.repository.MyRepository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by apuser on 3/30/15.
 */
public class MockMyRepository implements MyRepository{
    private final Set<MyItem> myItems;

    public MockMyRepository() {
        this.myItems = new LinkedHashSet<MyItem>();
        MyItem myItem = new MyItem("Breaking Bad",
                "http://thetvdb.com/banners/_cache/fanart/original/81189-21.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Marvel's Agents of S.H.I.E.L.D.",
                "http://thetvdb.com/banners/_cache/fanart/original/263365-4.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Lost",
                "http://thetvdb.com/banners/_cache/fanart/original/73739-20.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Arrow",
                "http://thetvdb.com/banners/_cache/fanart/original/257655-16.jpg");
        myItems.add(myItem);

        myItem = new MyItem("The Newsroom",
                "http://thetvdb.com/banners/_cache/fanart/original/76399-1.jpg");
        myItems.add(myItem);

        myItem = new MyItem("How I Met Your Mother",
                "http://thetvdb.com/banners/_cache/fanart/original/75760-51.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Game of Thrones",
                "http://thetvdb.com/banners/_cache/fanart/original/121361-15.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Dexter",
                "http://thetvdb.com/banners/_cache/fanart/original/79349-42.jpg");
        myItems.add(myItem);

        myItem = new MyItem("House of Cards",
                "http://thetvdb.com/banners/_cache/fanart/original/79861-3.jpg");
        myItems.add(myItem);

        myItem = new MyItem("The Big Bang Theory",
                "http://thetvdb.com/banners/_cache/fanart/original/80379-38.jpg");
        myItems.add(myItem);

        myItem = new MyItem("Sleepy Hollow",
                "http://thetvdb.com/banners/_cache/fanart/original/269578-4.jpg");
        myItems.add(myItem);

        myItem = new MyItem("The Vampire Diaries",
                "http://thetvdb.com/banners/_cache/fanart/original/95491-68.jpg ");
        myItems.add(myItem);

        myItem = new MyItem("Friends",
                "http://thetvdb.com/banners/_cache/fanart/original/79168-6.jpg");
        myItems.add(myItem);
    }

    @Override
    public Collection<MyItem> getMyItemsCollection() throws GetMyItemsException {
        return (Set<MyItem>) ((LinkedHashSet<MyItem>) myItems).clone();
    }
}
