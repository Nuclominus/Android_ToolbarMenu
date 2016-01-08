package com.example.toolbar_menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.toolbar_menu.Utils.AnimatingUtils;

public class MainActivity extends AppCompatActivity {

    RelativeLayout menuLayout, hideLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_burger);

        menuLayout = ((RelativeLayout) findViewById(R.id.testLayoutMenu));
        hideLayer = ((RelativeLayout) findViewById(R.id.hideLayer));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!AnimatingUtils.animProgress)
                if (menuLayout.getMeasuredHeight() <= 10) {
                    AnimatingUtils.expand(menuLayout, hideLayer);
                } else {
                    AnimatingUtils.collapse(menuLayout, hideLayer);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
