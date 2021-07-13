package br.feevale.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<History> histories;

    public HistoryAdapter(List<History> histories, Context ctx) {
        this.histories = histories;
        inflater = LayoutInflater.from(ctx);
    }

    public int getCount() {
        return histories.size();
    }

    public Object getItem(int position) {
        return histories.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // Inflater view with histories list
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.history_item, null);
        TextView number1 = v.findViewById(R.id.IdNumber1View);
        TextView number2 = v.findViewById(R.id.IdNumber2View);
        TextView operator = v.findViewById(R.id.IdOperatorView);
        TextView result = v.findViewById(R.id.IdResultView);

        History h = histories.get(position);
        number1.setText(String.valueOf(h.getNumber1()));
        number2.setText(String.valueOf(h.getNumber2()));
        operator.setText(String.valueOf(h.getOperator()));
        result.setText(String.valueOf(h.getResult()));

        return v;
    }
}
