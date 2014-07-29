package br.com.caelum.fj59.carangos.tasks;

import android.os.Message;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.webservice.WebClient;

/**
 * Created by felipe on 7/29/14.
 */
public class BuscaLeiloesTask extends TimerTask {

    private CustomHandler handler;
    private Calendar horarioUltimaBusca;

    public BuscaLeiloesTask(CustomHandler handler, Calendar horarioUltimaBusca) {
        this.handler = handler;
        this.horarioUltimaBusca = horarioUltimaBusca;
    }

    @Override
    public void run() {
        MyLog.i("Efetuando nova busca!");

        WebClient webClient = new WebClient("leilao/leilao54635/" + new SimpleDateFormat("ddMMyy-HHmmss").format(horarioUltimaBusca.getTime()));

        String json = webClient.get();

        MyLog.i("Lances recebidos: " + json);

        Message message = handler.obtainMessage();
        message.obj = json;
        handler.sendMessage(message);

        horarioUltimaBusca = Calendar.getInstance();
    }

    public void executa() {
        Timer timer = new Timer();
        timer.schedule(this, 0, 30*1000);
    }
}
