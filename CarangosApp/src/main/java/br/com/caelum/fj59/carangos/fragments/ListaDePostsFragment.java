package br.com.caelum.fj59.carangos.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.activity.MainActivity;
import br.com.caelum.fj59.carangos.adapter.BlogPostAdapter;
import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.navegacao.EstadoMainActivity;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsDelegate;

/**
 * Created by erich on 9/11/13.
 */
public class ListaDePostsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private MainActivity activity;
    private SwipeRefreshLayout swipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.swipe = (SwipeRefreshLayout) inflater.inflate(R.layout.posts_list, container, false);
        ListView postsList = (ListView) swipe.findViewById(R.id.posts_list);

        this.activity = ((MainActivity)this.getActivity());
        CarangosApplication app = activity.getCarangosApplication();
        BlogPostAdapter adapter = new BlogPostAdapter(getActivity(), app.getPosts());
        postsList.setAdapter(adapter);

        this.swipe.setOnRefreshListener(this);

        this.swipe.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return this.swipe;
    }

    @Override
    public void onRefresh() {
        MyLog.i("PULL TO REFRESH INICIADO!");

        activity.alteraEstadoEExecuta(EstadoMainActivity.PULL_TO_REFRESH_REQUISITADO);
        swipe.setRefreshing(true);
    }
}
