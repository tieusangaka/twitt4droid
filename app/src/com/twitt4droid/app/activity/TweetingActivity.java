/*
 * Copyright 2014 Daniel Pedraza-Arcega
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.twitt4droid.app.activity;

import roboguice.inject.InjectView;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;
import com.twitt4droid.app.R;

public class TweetingActivity extends RoboSherlockActivity {
    
    private static final int TWEET_CHAR_LIMIT = 140;
    private static final int RED_COLOR = Color.parseColor("#FF0000");
    
    @InjectView(R.id.new_tweet_edit_text) private EditText newTweetEditText;
    
    private TextView characterCountTextView;
    private MenuItem sendMenuItem;
    private int defaultCharacterCountTextViewTextColor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweeting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // TODO: show soft keyboard
        newTweetEditText.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > TWEET_CHAR_LIMIT) {
                    characterCountTextView.setTextColor(RED_COLOR);
                    sendMenuItem.setEnabled(false);
                } else {
                    characterCountTextView.setTextColor(defaultCharacterCountTextViewTextColor);
                    sendMenuItem.setEnabled(true);
                }
                
                characterCountTextView.setText(String.valueOf(TWEET_CHAR_LIMIT - s.length()));
            }
            
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.tweeting, menu);
        sendMenuItem = menu.findItem(R.id.send_tweet_item);
        characterCountTextView = (TextView)menu.findItem(R.id.tweet_char_count_item).getActionView();
        characterCountTextView.setText(String.valueOf(TWEET_CHAR_LIMIT));
        defaultCharacterCountTextViewTextColor = characterCountTextView.getTextColors().getDefaultColor();
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.send_tweet_item:
                if (newTweetEditText.getText().length() > 0 && 
                    newTweetEditText.getText().length() <= TWEET_CHAR_LIMIT) {
                    // TODO: Send tweet and finish activity
                }
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}