package br.com.caelum.fj59.carangos.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.modelo.Humor;
import br.com.caelum.fj59.carangos.modelo.Usuario;

public class BlogPostConverter {

    public List<BlogPost> toPosts(String json) {
        try {
            JSONArray js = new JSONObject(json).getJSONArray("list");

            List<BlogPost> posts = new ArrayList<BlogPost>();

            for (int i = 0; i < js.length(); i++) {
                JSONObject blogPost = js.getJSONObject(i);
                String mensagem = blogPost.getString("mensagem");
                String nomeAutor = blogPost.getJSONObject("autor").getString("nome");
                Humor humor = Humor.valueOf(blogPost.getString("estadoDeHumor"));
                String foto = blogPost.getString("foto");

                posts.add(new BlogPost(mensagem, new Usuario(nomeAutor), humor, foto));
            }
            return posts;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



}
