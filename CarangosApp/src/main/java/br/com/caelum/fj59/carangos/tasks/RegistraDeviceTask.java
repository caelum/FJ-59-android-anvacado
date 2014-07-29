package br.com.caelum.fj59.carangos.tasks;

import android.os.AsyncTask;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import br.com.caelum.fj59.carangos.app.CarangosApplication;
import br.com.caelum.fj59.carangos.gcm.Constantes;
import br.com.caelum.fj59.carangos.gcm.InformacoesDoUsuario;
import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.webservice.WebClient;

/**
 * Created by felipe on 7/28/14.
 */
public class RegistraDeviceTask extends AsyncTask<Void, Void, String>{

    private CarangosApplication app;

    public RegistraDeviceTask(CarangosApplication app) {
        this.app = app;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String registrationId = null;

        try {
            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this.app);
            registrationId = gcm.register(Constantes.GCM_SERVER_ID);

            MyLog.i("Device registrado com o ID: " + registrationId);

            String email = InformacoesDoUsuario.getEmail(this.app);

            String url = "device/register/" + email + "/" + registrationId;
            WebClient client = new WebClient(url);
            client.post();

        } catch (Exception e) {
            MyLog.e("Problema no registro do device no server! " + e.getMessage());
        }
        return registrationId;
    }

    @Override
    protected void onPostExecute(String result) {
        app.lidaComRespostaDoRegistroNoServidor(result);
    }
}
