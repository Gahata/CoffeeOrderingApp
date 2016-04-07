package org.example.paweljezierski.udacitylearning;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String coffeeAmountText = "1";
    String coffeePriceText = "3";
    String coffeeTypeSelected = "none";
    int coffeePriceNumber = 3;
    int coffeeAmountNumber = 1;
    Button minusButton;
    Button plusButton;
    Button orderButton;
    String orderToastText;
    TextView amountTextView;
    TextView priceTextView;
    Button coffeeTypeButton1;
    Button coffeeTypeButton2;
    Button coffeeTypeButton3;
    EditText nameEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        minusButton = (Button) findViewById(R.id.MinusButton);
        plusButton = (Button) findViewById(R.id.PlusButton);
        orderButton = (Button) findViewById(R.id.OrderButton);

        coffeeTypeButton1 = (Button) findViewById(R.id.coffeeTypeButton1);
        coffeeTypeButton2 = (Button) findViewById(R.id.coffeeTypeButton2);
        coffeeTypeButton3 = (Button) findViewById(R.id.coffeeTypeButton3);

        amountTextView = (TextView) findViewById(R.id.amountTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);

        nameEditText = (EditText) findViewById(R.id.nameEditText);

        minusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coffeeAmountNumber >= 2) {
                    coffeeAmountNumber--;
                    coffeeAmountText = Integer.toString(coffeeAmountNumber);
                    amountTextView.setText(coffeeAmountText);
                    coffeePriceNumber = 3 * coffeeAmountNumber;
                    coffeePriceText = Integer.toString(coffeePriceNumber);
                    priceTextView.setText(coffeePriceText);
                }
                else {
                    Toast.makeText(MainActivity.this, "Cannot order less than one coffee", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                coffeeAmountNumber ++;
                coffeeAmountText = Integer.toString(coffeeAmountNumber);
                amountTextView.setText(coffeeAmountText);
                coffeePriceNumber = 3 * coffeeAmountNumber;
                coffeePriceText = Integer.toString(coffeePriceNumber);
                priceTextView.setText(coffeePriceText);
            }
        });

        coffeeTypeButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                coffeeTypeButton1.setTypeface(null, Typeface.BOLD);
                coffeeTypeSelected = "latte";
                coffeeTypeButton2.setTypeface(null, Typeface.NORMAL);
                coffeeTypeButton3.setTypeface(null, Typeface.NORMAL);
            }
        });

        coffeeTypeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                coffeeTypeButton2.setTypeface(null, Typeface.BOLD);
                coffeeTypeSelected = "americano";
                coffeeTypeButton1.setTypeface(null, Typeface.NORMAL);
                coffeeTypeButton3.setTypeface(null, Typeface.NORMAL);
            }
        });

        coffeeTypeButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                coffeeTypeButton3.setTypeface(null, Typeface.BOLD);
                coffeeTypeSelected = "cappucino";
                coffeeTypeButton1.setTypeface(null, Typeface.NORMAL);
                coffeeTypeButton2.setTypeface(null, Typeface.NORMAL);
            }
        });



        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nameEditText.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please type in your name", Toast.LENGTH_LONG).show();
                }
                else {
                    if (coffeeTypeSelected == "none") {
                        Toast.makeText(MainActivity.this, "Please select the type of coffee", Toast.LENGTH_LONG).show();
                    }
                    if (coffeeTypeSelected == "latte") {
                        if (coffeeAmountNumber == 1) {
                            orderToastText = "You have ordered 1 cup of latte for 3 dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        } else {
                            orderToastText = "You have ordered " + coffeeAmountText + " cups of latte for a total of " + coffeePriceText + " dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        }
                    }

                    if (coffeeTypeSelected == "cappucino") {
                        if (coffeeAmountNumber == 1) {
                            orderToastText = "You have ordered 1 cup of cappucino for 3 dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        } else {
                            orderToastText = "You have ordered " + coffeeAmountText + " cups of cappucino for a total of " + coffeePriceText + " dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        }
                    }

                    if (coffeeTypeSelected == "americano") {
                        if (coffeeAmountNumber == 1) {
                            orderToastText = "You have ordered 1 cup of americano for 3 dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        } else {
                            orderToastText = "You have ordered " + coffeeAmountText + " cups of americano for a total of " + coffeePriceText + " dollars for " + nameEditText.getText();
                            Toast.makeText(MainActivity.this, orderToastText, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });



    }
}
