package thiagonunes.com.teste.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thiagonunes.com.teste.R;

import android.widget.Button;


public class SuccessFragment extends Fragment {

    private NovaMensagemCallback novaMensagemCallback;

    public SuccessFragment() {
    }

    public static SuccessFragment newInstance(NovaMensagemCallback novaMensagemCallback) {
        SuccessFragment successFragment = new SuccessFragment();
        successFragment.setNovaMensagemCallback(novaMensagemCallback);
        return successFragment;
    }

    private void setNovaMensagemCallback(NovaMensagemCallback novaMensagemCallback) {
        this.novaMensagemCallback = novaMensagemCallback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_success, container, false);

        Button btnNovaMensagem = (Button) view.findViewById(R.id.btn_nova_mensagem);
        btnNovaMensagem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                        novaMensagemCallback.sendNewMessage();
                    }
        });

            return view;
    }

    public interface NovaMensagemCallback {
        void sendNewMessage();
    }
}