package thiagonunes.com.teste.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import thiagonunes.com.teste.R;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import thiagonunes.com.teste.adapter.ScreenAdapter;
import thiagonunes.com.teste.asyncTask.JsonAsyncTask;
import thiagonunes.com.teste.entity.ScreensEntity;
import thiagonunes.com.teste.utils.JsonParser;
import thiagonunes.com.teste.utils.JsonParserExceptionUtils;
import android.widget.LinearLayout;


public class InvestimentoFragment extends Fragment implements JsonAsyncTask.JSONDownloaderCallback {

    private ScreensEntity screensEntity;
    private ScreenAdapter screenAdapter;
    private LinearLayout fieldsContainer;

    public InvestimentoFragment() {
    }

    public static InvestimentoFragment newInstance() {
        InvestimentoFragment fragment = new InvestimentoFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investimento, container, false);
        fieldsContainer = (LinearLayout) view.findViewById(R.id.fields_container);

        carregarDados();

        return view;
    }

    public void carregarDados(){
        String url = "https://floating-mountain-50292.herokuapp.com/fund.json";
        new JsonAsyncTask(this, getActivity()).execute(url);
    }

    @Override
    public void onPostExecute(String json) {
        try {
                screensEntity = JsonParser.toScreen(json);
                exibirCampos();
            } catch (JsonParserExceptionUtils e) {
                exibirMensagemErroJson(e.getMessage());
            }
    }

    private void exibirMensagemErroJson(String message) {
        new AlertDialog.Builder(getActivity())
            .setTitle(message)
            .setMessage("Deseja tentar novamente?")
            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                carregarDados();
                dialog.dismiss();
                            }
        })
            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        })
        .create()
        .show();
    }

    private void exibirCampos() {
        new ScreenAdapter(getContext(), fieldsContainer, screensEntity).preencherLayout();
    }
}
