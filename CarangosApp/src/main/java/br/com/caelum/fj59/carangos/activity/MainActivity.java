package br.com.caelum.fj59.carangos.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.adapter.BlogPostAdapter;
import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.fragments.ListaDePostsFragment;
import br.com.caelum.fj59.carangos.fragments.ProgressFragment;
import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.navegacao.EstadoMainActivity;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsDelegate;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsTask;

public class MainActivity extends Activity implements BuscaMaisPostsDelegate{
    private List<BlogPost> posts;
    private EstadoMainActivity estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.posts = new ArrayList<BlogPost>();

        this.estado = EstadoMainActivity.INICIO;
        this.estado.executa(this);
    }

    @Override
    public void lidaComRetorno(List<BlogPost> posts) {
        this.posts.clear();
        this.posts.addAll(posts);

        this.estado = EstadoMainActivity.PRIMEIROS_POSTS_RECEBIDOS;
        this.estado.executa(this);
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

    public void alteraEstadoEExecuta(EstadoMainActivity estado) {
        this.estado = estado;
        this.estado.executa(this);
    }

    public void buscaPrimeirosPosts() {
        new BuscaMaisPostsTask(this).execute();
    }
}
