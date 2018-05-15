package thiagonunes.com.teste.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.CompoundButtonCompat;
import thiagonunes.com.teste.entity.CellsEntity;
import thiagonunes.com.teste.utils.FormatPhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;

import thiagonunes.com.teste.R;

public class CreateFieldsAdapter {
    private SubmitCallback submitCallback;
    private Context context;
    private LinearLayout linearLayout;

    public CreateFieldsAdapter(SubmitCallback submitCallback, Context context, LinearLayout linearLayout) {
            this.submitCallback = submitCallback;
            this.context = context;
            this.linearLayout = linearLayout;
    }

    public void adicionarBotao(final CellsEntity cell) {
        Button button = new Button(context);
        Drawable drawable = context.getResources().getDrawable(R.drawable.round_button);
        button.setBackground(drawable);
        button.setTextColor(Color.WHITE);
        button.setText(cell.getMessage());

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                        );
        layoutParams.setMargins(0, cell.getTopSpacing(), 0, 0);
        button.setLayoutParams(layoutParams);

                if (cell.getHidden()) {
                button.setVisibility(View.INVISIBLE);
            }
            
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            submitCallback.onSubmitButtonPress();
                                        }
        });
    linearLayout.addView(button);
    }

    public void adicionarCheckbox(final CellsEntity cell) {
        CheckBox checkBox = new CheckBox(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, cell.getTopSpacing(), 0, 0);
        checkBox.setLayoutParams(layoutParams);
            
        checkBox.setText(cell.getMessage());
        checkBox.setTag(cell.getId());

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                                new int[]{-android.R.attr.state_checked},
                                new int[]{android.R.attr.state_checked} ,
                        },
                new int[]{
                                context.getResources().getColor(R.color.colorAccent),
                                context.getResources().getColor(R.color.buttonNormal)
                                }
                );

        CompoundButtonCompat.setButtonTintList(checkBox,colorStateList);

        if (cell.getShow() != null) {
        final Integer show = cell.getShow();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        View view = linearLayout.findViewById(show);
                        if (isChecked) {
                                view.setVisibility(View.VISIBLE);
                            } else {
                                view.setVisibility(View.INVISIBLE);
                            }
                            }
            });
        }
            
        linearLayout.addView(checkBox);
    }

    public void adicionarImage(CellsEntity cell) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                            );
            layoutParams.setMargins(0, cell.getTopSpacing(), 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setTag(cell.getId());

                    linearLayout.addView(imageView);
    }


    public void adicionarLabel(CellsEntity cell) {
        TextView textView = new TextView(context);
        textView.setText(cell.getMessage());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, cell.getTopSpacing(), 0, 0);

        textView.setLayoutParams(layoutParams);
        textView.setTag(cell.getId());

        if (cell.getHidden()) {
            textView.setVisibility(View.INVISIBLE);
        }
            linearLayout.addView(textView);
    }

    public void adicionarEditText(CellsEntity cell) {

        TextInputLayout textInputLayout = new TextInputLayout(context);
        textInputLayout.setId(cell.getId());

        EditText editText = new EditText(context);
        editText.setHint(cell.getMessage());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, cell.getTopSpacing(), 0, 0);
        editText.setLayoutParams(layoutParams);
        editText.setTag(cell.getId());

        if (cell.getHidden()) {
        textInputLayout.setVisibility(View.INVISIBLE);
        }

        switch (cell.getTypefield()) {
        case EMAIL:
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            break;
        case TEXT:
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            break;
        case TEL_NUMBER:
            editText.setInputType(InputType.TYPE_CLASS_PHONE);

            FormatPhoneNumberUtils addLineNumberFormatter = new FormatPhoneNumberUtils(new WeakReference<>(editText));
            editText.addTextChangedListener(addLineNumberFormatter);

            editText.setKeyListener(DigitsKeyListener.getInstance("0123456789 -()"));
            setEditTextMaxLength(editText, 15);
            break;
        }

        textInputLayout.addView(editText);
        linearLayout.addView(textInputLayout);
    }

    private void setEditTextMaxLength(EditText editText, int length) {
            InputFilter[] FilterArray = new InputFilter[1];
            FilterArray[0] = new InputFilter.LengthFilter(length);
            editText.setFilters(FilterArray);
        }

    public interface SubmitCallback {
        void onSubmitButtonPress();
    }
}
