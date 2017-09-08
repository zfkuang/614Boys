package activity;

import assembly.newsrecycle.NewsAdapter;
import news.* ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import assembly.slidingtab.SlidingTabLayout;
import assembly.slidingtab.NewsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        NewsDatabase.getInstance().setThisActivity(MainActivity.this);
        NewsDetail.setThisActivity(MainActivity.this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new NewsPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/
    }

    public void createNewNewsActivity(News news)
    {
        Intent intent = new Intent(MainActivity.this, NewsActivity.class) ;
        intent.putExtra("News", news.getId()) ;
        startActivity(intent);
    }

}
