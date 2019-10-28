package com.example.iiuctime.ClassRoutine;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.iiuctime.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoutineActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPagerId);
        setupViewPager();
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Routine("Sun")); //index 0
        adapter.addFragment(new Fragment_Routine("Mon"));
        adapter.addFragment(new Fragment_Routine("Tue"));
        adapter.addFragment(new Fragment_Routine("Wed"));
        adapter.addFragment(new Fragment_Routine("Thu"));
        adapter.addFragment(new Fragment_Routine("Fri"));
        adapter.addFragment(new Fragment_Routine("Sat"));
        viewPager.setAdapter(adapter);
        //index 2


        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Sun");
        tabLayout.getTabAt(1).setText("Mon");
        tabLayout.getTabAt(2).setText("Tue");
        tabLayout.getTabAt(3).setText("Wed");
        tabLayout.getTabAt(4).setText("Thu");
        tabLayout.getTabAt(5).setText("Fri");
        tabLayout.getTabAt(6).setText("Sat");

    }

}
