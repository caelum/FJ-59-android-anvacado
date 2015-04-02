package br.com.caelum.fj59.carangos.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.caelum.fj59.carangos.R;

/**
 * Created by erich on 7/17/13.
 */
public class ProgressFragment extends Fragment {

    private static final String STRING_ID = "stringId";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.progress_bar, container, false);

        TextView mensagemTv = (TextView) view.findViewById(R.id.progress_text);

        if(getArguments() != null) {
            int stringId = getArguments().getInt(STRING_ID, -1);
            String mensagem = getString(stringId);

            mensagemTv.setText(mensagem);
        }
        return view;
    }

    public static ProgressFragment comMensagem(int stringId) {
        ProgressFragment fragment = new ProgressFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(STRING_ID, stringId);
        fragment.setArguments(bundle);

        return fragment;
    }
}