package br.com.caelum.fj59.carangos.infra;

import android.util.Log;

public class MyLog {
    public static void i(Object o) {
        Log.i("Carangos", o.toString());
    }

    public static void e(Object o) {
        Log.e("Carangos", o.toString());
    }
}
