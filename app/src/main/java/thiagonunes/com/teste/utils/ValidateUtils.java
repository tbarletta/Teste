package thiagonunes.com.teste.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import thiagonunes.com.teste.R;
import thiagonunes.com.teste.entity.CellsEntity;
import thiagonunes.com.teste.entity.TypesEntity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.List;


public class ValidateUtils {

    public static Boolean validarCampos(Context context, LinearLayout linearLayout, List<CellsEntity> cells) {
        Boolean formularioValido = true;

        EditText editText;
        String text;
        
        for (CellsEntity cell : cells) {
        if (cell.getType() != TypesEntity.FIELD) {
                continue;
            }

                editText = (EditText) linearLayout.findViewWithTag(cell.getId());

                int visibility = linearLayout.findViewById(cell.getId()).getVisibility();
        if (visibility == View.INVISIBLE) {
                continue;
            }

                text = editText.getText().toString().trim();
        if (text.isEmpty() && !cell.getRequired()) {
                colorirEditText(context, editText, true);
                continue;
            }

                Boolean campoValido = true;

                switch (cell.getTypefield()) {
                case  EMAIL:
                        campoValido = validarCampoEmail(text);
                        break;
                case TEXT:
                        campoValido = validarCampoTexto(text);
                        break;
                case TEL_NUMBER:
                        campoValido = validarCampoTelefone(text);
                        break;
            }

                colorirEditText(context, editText, campoValido);

                if (!campoValido) {
                formularioValido = false;
            }
        }

        return formularioValido;
    }

    private static Boolean validarCampoTelefone(String telefone) {
        String number = telefone.trim();
        number = number.replace("-", "");
        number = number.replace("(", "");
        number = number.replace(")", "");
        number = number.replace(" ", "");

                try {
                Long.parseLong(number);
            }catch (Exception ex) {
                return false;
            }

                return  number.length() == 10 || number.length() == 11;
    }

    private static Boolean validarCampoTexto(String texto) {
        return !texto.trim().isEmpty();
    }

    private static Boolean validarCampoEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private static void colorirEditText(Context context, EditText editText, Boolean valid) {
        Integer color;

                if (valid) {
                color = R.color.fieldOk;
            } else {
                color = R.color.fieldError;
            }
        editText.getBackground().setColorFilter(
                        context.getResources().getColor(color),
                        PorterDuff.Mode.SRC_ATOP
                        );
    }
}

