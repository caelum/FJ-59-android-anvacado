package br.com.caelum.fj59.carangos.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import br.com.caelum.fj59.carangos.R;
import br.com.caelum.fj59.carangos.activity.LeilaoActivity;
import br.com.caelum.fj59.carangos.activity.MainActivity;
import br.com.caelum.fj59.carangos.infra.MyLog;

/**
 * Created by felipe on 7/28/14.
 */
public class GCMBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MyLog.i("Chegou a mensagem do GCM!");

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        String messageType = gcm.getMessageType(intent);

        String mensagem = (String) intent.getExtras().getSerializable("message");

        MyLog.i("Tipo da mensagem: " + messageType+ " Com conteúdo: " + mensagem);

        Intent irParaLeilao = new Intent(context, LeilaoActivity.class);
        PendingIntent acaoPendente = PendingIntent.getActivity(context, 0, irParaLeilao, PendingIntent.FLAG_CANCEL_CURRENT);

        irParaLeilao.putExtra("idDaNotificacao", Constantes.ID_NOTIFICACAO);

        Notification notificacao = new Notification.Builder(context)
                .setContentTitle("Um novo leilão comecou!")
                .setContentText("Leilão: " + mensagem)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(acaoPendente)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(Constantes.ID_NOTIFICACAO, notificacao);
    }
}
