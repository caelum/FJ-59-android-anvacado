package br.com.caelum.fj59.carangos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.modelo.BlogPost;

/**
 * Created by erich on 7/16/13.
 */
public class BlogPostAdapter extends BaseAdapter {
    private Context context;
    private final List<BlogPost> posts;

    public BlogPostAdapter(Context mContext, List<BlogPost> posts) {
        this.context = mContext;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BlogPost blogPost = (BlogPost) getItem(position);

        View linha = LayoutInflater.from(context).inflate(R.layout.
                post_linha_par, null);

        ImageView foto = (ImageView) linha.findViewById(R.id.foto);
        TextView mensagem = (TextView) linha.findViewById(R.id.mensagem);
        TextView nomeAutor = (TextView) linha.findViewById(R.id.nome_autor);
        ImageView emoticon = (ImageView) linha.findViewById(R.id.emoticon);

        mensagem.setText(blogPost.getMensagem());
        nomeAutor.setText(blogPost.getAutor().getNome());

        Picasso.with(this.context)
                .load(blogPost.getFoto())
                .placeholder(R.drawable.loading)
                .fit()
                .into(foto);

        int idImagem = 0;
        switch (blogPost.getEstadoDeHumor()) {
            case ANIMADO: idImagem = R.drawable.ic_muito_feliz; break;
            case INDIFERENTE: idImagem = R.drawable.ic_feliz; break;
            case TRISTE: idImagem = R.drawable.ic_indiferente; break;
        }

        emoticon.setImageDrawable(this.context.getResources().getDrawable(idImagem));

        return linha;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    class ViewHolder {
        ImageView foto;
        ImageView emoticon;
        TextView mensagem;
        TextView nomeAutor;

        ViewHolder(View view) {
            this.foto = (ImageView) view.findViewById(R.id.foto);
            this.emoticon = (ImageView) view.findViewById(R.id.emoticon);
            this.mensagem = (TextView) view.findViewById(R.id.mensagem);
            this.nomeAutor = (TextView) view.findViewById(R.id.nome_autor);
        }
    }
}
