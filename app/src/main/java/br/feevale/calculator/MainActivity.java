package br.feevale.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<History> histories = new ArrayList<>();
    History h;
    TextView textDisplay;
    Boolean clearDisplay = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#221D1D")));
        setContentView(R.layout.activity_main);

        textDisplay = findViewById(R.id.txtDisplay);
        // Initialize the display with zero
        textDisplay.setText("0");
    }

    // Access the history of operations
    public void accessHistory(View v) {
        Intent it = new Intent(getBaseContext(), HistoryActivity.class);
        // Send the history list for second page
        it.putExtra("history", histories);
        startActivity(it);
    }

    // Clear the display, numbers and operator
    public void clear(View v) {
        textDisplay.setText("0");
        h = null;
        clearDisplay = false;
    }

    // Action for numbers and point
    public void numbers(View v) {
        if (clearDisplay) {
            // If it's necessary to clear the display and the operator is empty, it's a new count
            if (h.getOperator() == ' ') {
                h = new History();
            }
            // Clear the display
            textDisplay.setText("0");
            clearDisplay = false;
        }
        // If in the display has a zero number and the button action is not a point
        // Because, if the button action is a point, concatenates the zero and the point
        if (textDisplay.getText() == "0" && ((Button) v).getText().charAt(0) != '.') {
            textDisplay.setText("");
        }
        textDisplay.setText(textDisplay.getText() + (((Button) v).getText().toString()));
    }

    // Action for button equal
    public void equal(View v) {
        // If don't have an object history or don't have an operator or need the clear the display
        if (h == null || h.getOperator() == ' ' || clearDisplay) {
            return;
        }
        // Set the Number2, show the result, add it to the history list, create a new history and define the Number1
        h.setNumber2(Float.parseFloat(textDisplay.getText().toString()));
        textDisplay.setText("" + h.getResult());
        histories.add(h);
        h = new History();
        h.setNumber1(Float.parseFloat(textDisplay.getText().toString()));
        clearDisplay = true;
    }

    // Action for operators, plus, less, multiply and divide
    public void operators(View v) {
        // If it has an object history and it has an operator
        if (h != null && h.getOperator() != ' ') {
            // If it's necessary to clear the display, it should set the operator and concatenate the display
            if (clearDisplay) {
                h.setOperator(((Button) v).getText().charAt(0));
                textDisplay.setText(h.getNumber1() + " " + h.getOperator());
                return;
            }
            // If it has an operator, it should the set Number2 and display the result
            h.setNumber2(Float.parseFloat(textDisplay.getText().toString()));
            textDisplay.setText("" + h.getResult());
            histories.add(h);
        }
        // Create a new history, set the Number1 and operator, then concatenate the display
        h = new History();
        h.setNumber1(Float.parseFloat(textDisplay.getText().toString()));
        h.setOperator(((Button) v).getText().charAt(0));
        textDisplay.setText(textDisplay.getText() + " " + (((Button) v).getText().toString()));
        clearDisplay = true;
    }
}