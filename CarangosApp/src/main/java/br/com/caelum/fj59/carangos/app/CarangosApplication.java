package br.com.caelum.fj59.carangos.app;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj59.carangos.modelo.BlogPost;

/**
 * Created by felipe on 7/28/14.
 */
public class CarangosApplication extends Application {
    private List<AsyncTask<?,?,?>> tasks = new ArrayList<AsyncTask<?,?,?>>();
    private List<BlogPost> posts = new ArrayList<BlogPost>();

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
}
