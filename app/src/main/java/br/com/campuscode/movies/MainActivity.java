package br.com.campuscode.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.campuscode.movies.adapters.MoviesAdapter;
import br.com.campuscode.movies.model.Movie;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.ItemClickListener {


    MoviesAdapter adapter;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            List<String> urls = new ArrayList<>();
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");


            List<Movie> movies = new ArrayList<>();

            // set up the RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movies);
            int numberOfColumns = 2;
            recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
            adapter = new MoviesAdapter(this, movies);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);

        }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Testing Recycler view. Position: " + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DetailsActivity.class));
    }
}
