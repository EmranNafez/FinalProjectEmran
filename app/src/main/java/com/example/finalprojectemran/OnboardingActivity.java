package com.example.finalprojectemran;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.viewPager);
        Button nextButton = findViewById(R.id.btnNext);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OnboardingFragment1());
        fragments.add(new OnboardingFragment2());
        fragments.add(new OnboardingFragment3());

        OnboardingAdapter adapter = new OnboardingAdapter(this, fragments);
        viewPager.setAdapter(adapter);

        nextButton.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() < fragments.size() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            } else {
                startActivity(new Intent(OnboardingActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
