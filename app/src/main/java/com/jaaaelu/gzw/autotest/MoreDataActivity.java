package com.jaaaelu.gzw.autotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MoreDataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_data);

        initSpinner();

//        initRecycler();
    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.rl_show_more_string);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{"T1", "T2", "T3"}));
    }

    private void initRecycler() {
        RecyclerView showMore = findViewById(R.id.rl_show_more_data);

        showMore.setLayoutManager(new LinearLayoutManager(this));
        showMore.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new TextHolder(getLayoutInflater().inflate(R.layout.item_show_more, null));
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                TextHolder th = (TextHolder) holder;
                th.bind(position);
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });
    }

    class TextHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TextHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.t1);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MoreDataActivity.this, "click -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @SuppressLint("SetTextI18n")
        public void bind(int position) {
            textView.setText("Text -> " + position);
        }
    }

}
