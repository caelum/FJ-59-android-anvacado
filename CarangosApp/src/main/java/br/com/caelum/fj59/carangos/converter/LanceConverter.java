package br.com.caelum.fj59.carangos.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.fj59.carangos.modelo.Lance;
import br.com.caelum.fj59.carangos.modelo.Usuario;

/**
 * Created by erich on 8/8/13.
 */
public class LanceConverter {

    public List<Lance> converte(String json) {
        try {
            JSONArray js = new JSONObject(json).getJSONArray("list");

            List<Lance> lances = new ArrayList<Lance>();

            for (int i = 0; i < js.length(); i++) {
                JSONObject lanceJson = js.getJSONObject(i);
                JSONObject usuarioJson = lanceJson.getJSONObject("usuario");
                Usuario u = new Usuario(usuarioJson.getString("nome"));
                double valor = lanceJson.getDouble("valor");
                long millis = lanceJson.getJSONObject("horario").getLong("time");

                Calendar horario = Calendar.getInstance();
                horario.setTimeInMillis(millis);

                Lance lance = new Lance(u, horario, valor);
                lances.add(lance);
            }
            return lances;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
