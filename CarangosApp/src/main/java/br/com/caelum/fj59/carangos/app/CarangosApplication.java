package br.com.caelum.fj59.carangos.app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.modelo.BlogPost;
import br.com.caelum.fj59.carangos.tasks.RegistraDeviceTask;

/**
 * Created by felipe on 7/28/14.
 */
public class CarangosApplication extends Application {
    private List<AsyncTask<?,?,?>> tasks = new ArrayList<AsyncTask<?,?,?>>();
    private List<BlogPost> posts = new ArrayList<BlogPost>();

    private static final String REGISTERED = "registeredInGCM";
    private static final String REGISTRATION_ID = "registrationId";
    private SharedPreferences preferences;

    @Override
    public void onTerminate() {
        super.onTerminate();

        for(AsyncTask task : this.tasks) {
            task.cancel(true);
        }
    }

    public void registra(AsyncTask<?,?,?> task) {
        tasks.add(task);
    }

    public void desregistra(AsyncTask<?,?,?> task) {
        tasks.remove(task);
    }

    public List<BlogPost> getPosts() {
        return posts;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = getSharedPreferences("configs", Activity.MODE_PRIVATE);

        initializeGCM();
    }

    public void initializeGCM() {
        if(!usuarioRegistrado()) {
            new RegistraDeviceTask(this).execute();
        } else {
            MyLog.i("Device já cadastrado! RegistrationID: " + preferences.getString(REGISTRATION_ID, null));
        }
    }

    private boolean usuarioRegistrado() {
        return preferences.getBoolean(REGISTERED, false);
    }

    public void lidaComRespostaDoRegistroNoServidor(String registro) {
        if(registro != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(REGISTERED, true);
            editor.putString(REGISTRATION_ID, registro);
            editor.commit();
        }
    }
}
