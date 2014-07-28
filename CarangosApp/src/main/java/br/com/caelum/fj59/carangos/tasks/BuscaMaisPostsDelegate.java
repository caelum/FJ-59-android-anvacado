package br.com.caelum.fj59.carangos.tasks;

import java.util.List;

import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.modelo.BlogPost;

/**
 * Created by felipe on 7/28/14.
 */
public interface BuscaMaisPostsDelegate {

    void lidaComRetorno(List<BlogPost> retorno);
    void lidaComErro(Exception e);

    CarangosApplication getCarangosApplication();
}
