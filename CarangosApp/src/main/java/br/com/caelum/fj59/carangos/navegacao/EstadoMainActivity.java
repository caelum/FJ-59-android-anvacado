package br.com.caelum.fj59.carangos.navegacao;

import android.app.Fragment;
import android.app.FragmentTransaction;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.activity.MainActivity;
import br.com.caelum.fj59.carangos.fragments.ListaDePostsFragment;
import br.com.caelum.fj59.carangos.fragments.ProgressFragment;

/**
 * Created by felipe on 7/28/14.
 */
public enum EstadoMainActivity {
    INICIO {
        @Override
        public void executa(MainActivity activity) {
            activity.buscaPrimeirosPosts();
            activity.alteraEstadoEExecuta(EstadoMainActivity.AGUARDANDO_POSTS);
        }
    },
    AGUARDANDO_POSTS {
        @Override
        public void executa(MainActivity activity) {
            ProgressFragment progress = ProgressFragment.comMensagem(R.string.hello_world);
            this.colocaFragmentNaTela(activity, progress);
        }
    },
    PRIMEIROS_POSTS_RECEBIDOS {
        @Override
        public void executa(MainActivity activity) {
            this.colocaFragmentNaTela(activity, new ListaDePostsFragment());
        }
    }, PULL_TO_REFRESH_REQUISITADO {
        @Override
        public void executa(MainActivity activity) {
            activity.buscaPrimeirosPosts();
        }
    };

    void colocaFragmentNaTela(MainActivity activity, Fragment fragment) {

        FragmentTransaction tx =
                activity.getFragmentManager().beginTransaction();

        tx.replace(R.id.fragment_principal, fragment);
        tx.commit();
    }

    public abstract void executa(MainActivity activity);
}
