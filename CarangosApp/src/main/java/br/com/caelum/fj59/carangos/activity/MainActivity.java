package br.com.caelum.fj59.carangos.activity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.adapter.BlogPostAdapter;
import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsDelegate;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsTask;

public class MainActivity extends Activity implements BuscaMaisPostsDelegate{
    private ListView postsList;
    private List<BlogPost> posts;
    private BlogPostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_list);

        this.postsList = (ListView) findViewById(R.id.posts_list);
        this.posts = new ArrayList<BlogPost>();
        this.adapter = new BlogPostAdapter(this, this.posts);

        this.postsList.setAdapter(adapter);

        new BuscaMaisPostsTask(this).execute();
    }

    @Override
    public void lidaComRetorno(List<BlogPost> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        this.adapter.notifyDataSetChanged();
    }

    public List<BlogPost> getPosts() {
        return this.posts;
    }

    @Override
    public void lidaComErro(Exception e) {
        Toast.makeText(this, "Erro ao buscar dados", Toast.LENGTH_LONG).show();
    }

    @Override
    public CarangosApplication getCarangosApplication() {
        return (CarangosApplication) getApplication();
    }
}
