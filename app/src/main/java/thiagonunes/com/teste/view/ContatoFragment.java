package thiagonunes.com.teste.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thiagonunes.com.teste.adapter.CreateFieldsAdapter;
import thiagonunes.com.teste.asyncTask.JsonAsyncTask;

import thiagonunes.com.teste.R;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import thiagonunes.com.teste.adapter.CreateCellsAdapter;
import thiagonunes.com.teste.entity.CellsEntity;
import thiagonunes.com.teste.utils.JsonParser;
import thiagonunes.com.teste.utils.ValidateUtils;
import thiagonunes.com.teste.utils.JsonParserExceptionUtils;
import android.widget.LinearLayout;
import java.util.List;

public class ContatoFragment extends Fragment implements JsonAsyncTask.JSONDownloaderCallback, CreateFieldsAdapter.SubmitCallback {
    private List<CellsEntity> cellList;
    private LinearLayout fieldsContainer;
    private ContatoSubmitCallback contatoSubmitCallback;

    public ContatoFragment() {
    }

    public static ContatoFragment newInstance(ContatoSubmitCallback contatoSubmitCallback) {
        ContatoFragment fragment = new ContatoFragment();
        fragment.setContatoSubmitCallback(contatoSubmitCallback);
        return fragment;
    }

    private void setContatoSubmitCallback(ContatoSubmitCallback contatoSubmitCallback){
        this.contatoSubmitCallback = contatoSubmitCallback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_contato, container, false);
        fieldsContainer = (LinearLayout) view.findViewById(R.id.fields_container);

        baixarDados();

        return view;
    }

    public void baixarDados(){
        String url = "https://floating-mountain-50292.herokuapp.com/cells.json";
        new JsonAsyncTask(this, getActivity()).execute(url);
    }

    @Override
    public void onPostExecute(String json) {
        try {
                cellList = JsonParser.toListCell(json);
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
                                baixarDados();
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
        new CreateCellsAdapter().CellAdapter(this, getActivity(), cellList, fieldsContainer);
    }

    @Override
    public void onSubmitButtonPress() {
        Boolean camposValidos = ValidateUtils.validarCampos(getActivity(), fieldsContainer, cellList);

                if(camposValidos) {
                contatoSubmitCallback.onContatoSubmit();
            }
    }

    public interface ContatoSubmitCallback {
        public void onContatoSubmit();
    }
}