package thiagonunes.com.teste.adapter;

import android.content.Context;
import thiagonunes.com.teste.entity.CellsEntity;
import android.widget.LinearLayout;
import java.util.List;

public class CreateCellsAdapter {

    private CreateFieldsAdapter.SubmitCallback submitCallback;
    private Context context;
    private List<CellsEntity> cells;
    private LinearLayout linearLayout;

    public void CellAdapter(CreateFieldsAdapter.SubmitCallback submitCallback, Context context, List<CellsEntity> cells, LinearLayout linearLayout) {
        this.submitCallback = submitCallback;
        this.context = context;
        this.cells = cells;
        this.linearLayout = linearLayout;
        montarLayout();
    }

    public void montarLayout() {

        CreateFieldsAdapter createFieldsAdapter = new CreateFieldsAdapter(submitCallback, context, linearLayout);

        for (CellsEntity cell : cells) {

                switch (cell.getType()) {
                case FIELD:
                    createFieldsAdapter.adicionarEditText(cell);
                    break;
                case TEXT:
                    createFieldsAdapter.adicionarLabel(cell);
                    break;
                case IMAGE:
                    createFieldsAdapter.adicionarImage(cell);
                    break;
                case CHECKBOX:
                    createFieldsAdapter.adicionarCheckbox(cell);
                    break;
                case SEND:
                    createFieldsAdapter.adicionarBotao(cell);
                    break;
            }
        }
    }
}
