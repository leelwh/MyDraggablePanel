package com.example.apuser.mydraggablepanel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.github.pedrovgs.DraggableView;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.LogRecord;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainFragment.Listener{
    private DraggableFragment draggableFragment;
    private MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFragments();
    }

    private void initializeFragments() {
        this.draggableFragment = (DraggableFragment) getFragmentManager()
                .findFragmentById(R.id.draggable_fragment);
        this.mainFragment = (MainFragment) getFragmentManager()
                .findFragmentById(R.id.main_fragment);

    }

    @Override
    protected List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<Object>();
        return modules;
    }

    @Override
    public void onClick(MyItem myItem) {
        draggableFragment.showMyItem(myItem);
    }
}
