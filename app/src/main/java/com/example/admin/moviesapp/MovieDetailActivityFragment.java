package com.example.admin.moviesapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment {

    public MovieDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                                 
        // Getting the intent send by the main activity                         
        Intent intent = getActivity().getIntent();
        // Image path that will give the poster for movie detail of w185
        String imagePath = "http://image.tmdb.org/t/p/w185";
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ImageView posterView = (ImageView) rootView.findViewById(R.id.poster);
        
        // Setting the movie poster image on the poster view
        Picasso.with(getActivity()).load(imagePath + intent.getExtras().get("posterPath")).into(posterView);
        // Setting title of the movies
        ((TextView) rootView.findViewById(R.id.title))
                .setText(intent.getStringExtra("title"));
        // Setting overview of the movies
        ((TextView) rootView.findViewById(R.id.overview))
                .setText(intent.getStringExtra("overview"));
        // Setting rating of the movies        
        ((TextView) rootView.findViewById(R.id.rating))
                .setText("Rating: " + ((Double) intent.getDoubleExtra("voteAverage", 0.0)).toString());
        // Setting release date of the movies        
        ((TextView) rootView.findViewById(R.id.release_date))
                .setText("Released on " + intent.getStringExtra("releaseDate"));
        return rootView;
    }
}
