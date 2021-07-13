package br.feevale.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listHistory;
    ArrayList<History> histories = new ArrayList<>();
    HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#221D1D")));
        setTitle("History");
        // Set the histories with the received list
        histories = (ArrayList<History>) getIntent().getSerializableExtra("history");

        listHistory = findViewById(R.id.listHistory);
        adapter = new HistoryAdapter(histories, getBaseContext());
        adapter.notifyDataSetChanged();
        listHistory.setAdapter(adapter);
    }

    public void back (View v) {
        finish();
    }

}