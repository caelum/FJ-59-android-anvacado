package br.com.caelum.fj59.carangos.evento;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.io.Serializable;
import java.util.List;

import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.tasks.BuscaMaisPostsDelegate;

/**
 * Created by felipe on 7/28/14.
 */
public class EventoBlogPostsRecebidos extends BroadcastReceiver {

    private static final String SUCESSO = "sucesso";
    private static final String RESULTADO_POSTS = "resultadoPosts";
    private static final String BLOGPOSTS_RECEBIDOS = "blogPosts recebidos";

    private BuscaMaisPostsDelegate delegate;

    @Override
    public void onReceive(Context context, Intent intent) {
        MyLog.i("RECEBI O EVENTO!! DEU CERTO? " + intent.getBooleanExtra(SUCESSO, true));

        delegate.lidaComRetorno((List<BlogPost>) intent.getSerializableExtra(RESULTADO_POSTS));
    }

    public static EventoBlogPostsRecebidos registraObservador(BuscaMaisPostsDelegate delegate) {
        EventoBlogPostsRecebidos receiver = new EventoBlogPostsRecebidos();
        receiver.delegate = delegate;

        LocalBroadcastManager.getInstance(delegate.getCarangosApplication())
                .registerReceiver(receiver, new IntentFilter(BLOGPOSTS_RECEBIDOS));

        return receiver;
    }

    public static void notificaPostsRecebidos(Context context, List<BlogPost> resultado, boolean sucesso) {

        Intent intent = new Intent(BLOGPOSTS_RECEBIDOS);

        intent.putExtra(RESULTADO_POSTS, (Serializable) resultado);
        intent.putExtra(SUCESSO, sucesso);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public void desregistra(CarangosApplication application) {
        LocalBroadcastManager.getInstance(application).unregisterReceiver(this);
    }
}
