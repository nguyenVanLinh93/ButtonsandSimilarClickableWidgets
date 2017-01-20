package com.example.nguyenlinh.buttonsandsimilarclickablewidgets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 *  Exercises 5.1:
 *  Buttons and Similar Clickable Widgets
 *
 *  @author nguyenlinh
 *  @version 1.0
 *  @since 2017-1-19
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.txtV);
    }

    /**
     * Ex 1:
     * Make a row containing two ImageButtons.
     * Put a blank TextView at the bottom. Have the first image be red, and have it turn the TextView red when you click it.
     * Have the second image be blue, and have it turn the TextView blue when you click it. Use a single image file for each ImageButton.
     *
     * @param v imageButton
     */
    public void setColorByImageButton(View v){
        ImageButton imageButton = (ImageButton)v;
        String text = String.valueOf(imageButton.getContentDescription());    // lấy phần mô tả của imageButton (ContentDescription) để phân biệt giữa 2 nút bằng cách so sánh red or blue

        if(text.equalsIgnoreCase("red")){
            mTextView.setBackgroundColor(Color.RED);
        } else {
            mTextView.setBackgroundColor(Color.BLUE);
        }
    }

    /**
     * Ex 2:
     * Add a row with three RadioButtons with labels Red, Yellow, and Blue.
     * Have them turn the TextView at the bottom the appropriate color.
     *
     * @param v radioButton
     */
    public void setColorByRadioButton(View v){
        RadioButton radioButton = (RadioButton)v;
        String text = (String)radioButton.getText();   // lấy phần text để so sánh giữa 3 nút

        if(text.equalsIgnoreCase("red")){
            mTextView.setBackgroundColor(Color.RED);
        }
        if(text.equalsIgnoreCase("yellow")){
            mTextView.setBackgroundColor(Color.YELLOW);
        }
        if(text.equalsIgnoreCase("blue")){
            mTextView.setBackgroundColor(Color.BLUE);
        }
    }

    /**
     * Ex 3:
     * Add a row with three ToggleButtons.
     * Have the labels be Red/Not Red, Yellow/Not Yellow, and Blue/Not Blue.
     * Turn the TextView the appropriate color when the ToggleButton is clicked. For “Not Whatever”, use black.
     *
     * @param v toggleButton
     */
    public void setColorbyToggleButton(View v){
        ToggleButton toggleButton = (ToggleButton)v;

        if(toggleButton.isChecked()){
            String text = (String)toggleButton.getTextOn();
            if(text.equalsIgnoreCase("red")){
                mTextView.setBackgroundColor(Color.RED);

                // tiếp theo, uncheck 2 nút còn lại. nếu là nút đỏ dc check, uncheck 2 nút xanh và vàng
                ToggleButton toggleButton1 = (ToggleButton)findViewById(R.id.tgbtnBlue);    // nút xanh
                toggleButton1.setChecked(false);
                ToggleButton toggleButton2 = (ToggleButton)findViewById(R.id.tgbtnYellow);  // nút vàng
                toggleButton2.setChecked(false);
            }
            if(text.equalsIgnoreCase("yellow")){
                mTextView.setBackgroundColor(Color.YELLOW);
                ToggleButton toggleButton1 = (ToggleButton)findViewById(R.id.tgbtnBlue);
                toggleButton1.setChecked(false);
                ToggleButton toggleButton2 = (ToggleButton)findViewById(R.id.tgbtnRed);
                toggleButton2.setChecked(false);
            }
            if(text.equalsIgnoreCase("blue")){
                mTextView.setBackgroundColor(Color.BLUE);
                ToggleButton toggleButton1 = (ToggleButton)findViewById(R.id.tgbtnRed);
                toggleButton1.setChecked(false);
                ToggleButton toggleButton2 = (ToggleButton)findViewById(R.id.tgbtnYellow);
                toggleButton2.setChecked(false);
            }
        } else {
            mTextView.setBackgroundColor(Color.BLACK);  // néu cả 3 nút đều uncheck ,set black color
        }
    }

    /**
     * Ex 4:
     * Add another row of RadioButtons with the same labels as in problem 2.
     * But this time, take no action when the RadioButtons are clicked.
     * Instead, put a Button underneath that says “Set Color Chosen Above”.
     * Change the color when that Button is clicked.
     *
     * @param view button
     */
    public void setColorChosenAbove(View view){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        int checked = radioGroup.getCheckedRadioButtonId();                    // lấy id của radiobutton dc check
        RadioButton radioButtonCheckd = (RadioButton)findViewById(checked);
        String text = "" + radioButtonCheckd.getText();                        // lấy phần text để phân biệt giữa 3 nút

        if(text.equalsIgnoreCase("red")){
            mTextView.setBackgroundColor(Color.RED);
        }
        if(text.equalsIgnoreCase("yellow")){
            mTextView.setBackgroundColor(Color.YELLOW);
        }
        if(text.equalsIgnoreCase("blue")){
            mTextView.setBackgroundColor(Color.BLUE);
        }
    }
}
