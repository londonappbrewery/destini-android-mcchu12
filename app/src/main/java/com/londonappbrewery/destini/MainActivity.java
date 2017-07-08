package com.londonappbrewery.destini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStory;
    Button mTop;
    Button mBottom;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, End.class);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStory = (TextView) findViewById(R.id.storyTextView);
        mTop = (Button) findViewById(R.id.buttonTop);
        mBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    setupStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else {
                    setupStory(R.string.T6_End);
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    setupStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    setupStory(R.string.T4_End);
                } else if (mStoryIndex == 3) {
                    setupStory(R.string.T5_End);
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    private void setupStory(int story, int top, int bot) {
        mStory.setText(story);
        mTop.setText(top);
        mBottom.setText(bot);
    }

    private void setupStory(int story) {
        mStory.setText(story);
        mTop.setVisibility(View.GONE);
        mBottom.setText(R.string.continue_button);
        mStoryIndex = 4; // TO END STORY
    }
}
