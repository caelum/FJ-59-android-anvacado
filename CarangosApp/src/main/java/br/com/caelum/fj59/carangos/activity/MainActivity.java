package br.com.caelum.fj59.carangos.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.adapter.PublicacaoAdapter;
import br.com.caelum.fj59.carangos.modelo.Publicacao;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPublicacoesTask;

public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private List<Publicacao> publicacoes;
    private PublicacaoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publicacao_list);

        this.listView = (ListView) findViewById(R.id.publicacoes_list);
        this.publicacoes = new ArrayList<Publicacao>();
        this.adapter = new PublicacaoAdapter(this, this.publicacoes);

        this.listView.setAdapter(adapter);

        new BuscaMaisPublicacoesTask(this).execute();
    }

    public void atualizaListaCom(List<Publicacao> publicacoes) {
        this.publicacoes.clear();
        this.publicacoes.addAll(publicacoes);
        this.adapter.notifyDataSetChanged();
    }

    public List<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }
}
