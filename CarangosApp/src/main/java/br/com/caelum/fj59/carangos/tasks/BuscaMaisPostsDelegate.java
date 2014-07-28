package br.com.caelum.fj59.carangos.tasks;

import java.util.List;

import br.com.caelum.fj59.carangos.modelo.BlogPost;

/**
 * Created by android4381 on 14/07/14.
 */
public interface BuscaMaisPostsDelegate{
    void lidaComRetorno(List<BlogPost> retorno);
    void lidaComErro(Exception e);
}
