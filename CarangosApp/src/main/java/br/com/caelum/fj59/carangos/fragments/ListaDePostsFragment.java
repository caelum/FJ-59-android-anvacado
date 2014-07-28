package br.com.caelum.fj59.carangos.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.activity.MainActivity;
import br.com.caelum.fj59.carangos.adapter.BlogPostAdapter;
import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.modelo.BlogPost;

/**
 * Created by erich on 9/11/13.
 */
public class ListaDePostsFragment extends Fragment {
    private ListView postsList;
    private BlogPostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.postsList = (ListView) inflater.inflate(R.layout.posts_list, container, false);

        final MainActivity activity = ((MainActivity)this.getActivity());

        this.adapter = new BlogPostAdapter(getActivity(), activity.getPosts());
        this.postsList.setAdapter(this.adapter);

        return this.postsList;
    }

}
