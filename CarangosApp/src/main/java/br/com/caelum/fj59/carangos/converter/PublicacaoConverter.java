package br.com.caelum.fj59.carangos.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.modelo.Publicacao;
import br.com.caelum.fj59.carangos.modelo.Humor;
import br.com.caelum.fj59.carangos.modelo.Usuario;

public class PublicacaoConverter {

    public List<Publicacao> converte(String json) {
        try {
            JSONArray js = new JSONObject(json).getJSONArray("list");

            List<Publicacao> publicacoes = new ArrayList<Publicacao>();

            for (int i = 0; i < js.length(); i++) {
                JSONObject jsonPublicacao = js.getJSONObject(i);
                String mensagem = jsonPublicacao.getString("mensagem");
                String nomeAutor = jsonPublicacao.getJSONObject("autor").getString("nome");
                Humor humor = Humor.valueOf(jsonPublicacao.getString("estadoDeHumor"));
                String foto = jsonPublicacao.getString("foto");

                publicacoes.add(new Publicacao(mensagem, new Usuario(nomeAutor), humor, foto));
            }
            return publicacoes;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
