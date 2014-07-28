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

    private static final String MESSAGE_ID = "messageId";
    private static final String COMPLEMENTOS = "complementos";
    private TextView mensagemTv;

    public ProgressFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.progress_bar, null);

        this.mensagemTv = (TextView) view.findViewById(R.id.progress_text);

        if (getArguments()!=null && getArguments().getInt(MESSAGE_ID, -1) != -1) {
            String[] stringsParaInterpolar = getArguments().getStringArray(COMPLEMENTOS);
            mudaMensagem(getArguments().getInt(MESSAGE_ID), stringsParaInterpolar);
        }

        return view;
    }

    public void mudaMensagem(int stringId, String... complementos) {
        String novaMensagem = getActivity().getResources().getString(stringId);
        guardaEstadoDaMensagem(stringId, getArguments(), complementos);

        novaMensagem = "";//String.format(novaMensagem, complementos);

        mensagemTv.setText(novaMensagem);
    }

    public static ProgressFragment comMensagem(int stringId, String... complementos) {
        ProgressFragment fragment = new ProgressFragment();
        Bundle bundle = new Bundle();
        guardaEstadoDaMensagem(stringId, bundle, complementos);
        fragment.setArguments(bundle);

        return fragment;
    }

    private static void guardaEstadoDaMensagem(int stringId, Bundle bundle, String... complementos) {
        bundle.putInt(MESSAGE_ID, stringId);
        bundle.putSerializable(COMPLEMENTOS, complementos);
    }

}
