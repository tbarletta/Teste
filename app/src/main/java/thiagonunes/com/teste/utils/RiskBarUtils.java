package thiagonunes.com.teste.utils;

import thiagonunes.com.teste.R;
import android.view.View;
import android.widget.LinearLayout;

public class RiskBarUtils {

    public static void select(LinearLayout linearLayout, Integer risk) {

                cleanRisks(linearLayout);

                switch (risk) {
                case 1:
                        selectRiskOne(linearLayout);
                    break;
                case 2:
                        selectRiskTwo(linearLayout);
                    break;
                case 3:
                        selectRiskThree(linearLayout);
                    break;
                case 4:
                        selectRiskFour(linearLayout);
                    break;
                case 5:
                        selectRiskFive(linearLayout);
                    break;
            }
    }

    private static void selectRiskOne(LinearLayout linearLayout) {
        View riskBarSelector = linearLayout.findViewById(R.id.risk_selector_one);
        View riskSelected = linearLayout.findViewById(R.id.risk_selected_one);

                riskBarSelector.setVisibility(View.VISIBLE);
        riskSelected.setVisibility(View.VISIBLE);
    }

    private static void selectRiskTwo(LinearLayout linearLayout) {
        View riskBarSelector = linearLayout.findViewById(R.id.risk_selector_two);
        View riskSelected = linearLayout.findViewById(R.id.risk_selected_two);

                riskBarSelector.setVisibility(View.VISIBLE);
        riskSelected.setVisibility(View.VISIBLE);
    }

    private static void selectRiskThree(LinearLayout linearLayout) {
        View riskBarSelector = linearLayout.findViewById(R.id.risk_selector_three);
        View riskSelected = linearLayout.findViewById(R.id.risk_selected_three);

                riskBarSelector.setVisibility(View.VISIBLE);
        riskSelected.setVisibility(View.VISIBLE);
    }

    private static void selectRiskFour(LinearLayout linearLayout) {
        View riskBarSelector = linearLayout.findViewById(R.id.risk_selector_four);
        View riskSelected = linearLayout.findViewById(R.id.risk_selected_four);

                riskBarSelector.setVisibility(View.VISIBLE);
        riskSelected.setVisibility(View.VISIBLE);
    }

    private static void selectRiskFive(LinearLayout linearLayout) {
        View riskBarSelector = linearLayout.findViewById(R.id.risk_selector_five);
        View riskSelected = linearLayout.findViewById(R.id.risk_selected_five);

                riskBarSelector.setVisibility(View.VISIBLE);
        riskSelected.setVisibility(View.VISIBLE);
    }

    private static void cleanRisks(LinearLayout linearLayout) {
        View riskBarSelectorOne = linearLayout.findViewById(R.id.risk_selector_one);
        View riskSelectedOne = linearLayout.findViewById(R.id.risk_selected_one);
        View riskBarSelectorTwo = linearLayout.findViewById(R.id.risk_selector_two);
        View riskSelectedTwo = linearLayout.findViewById(R.id.risk_selected_two);
        View riskBarSelectorThree = linearLayout.findViewById(R.id.risk_selector_three);
        View riskSelectedThree = linearLayout.findViewById(R.id.risk_selected_three);
        View riskBarSelectorFour = linearLayout.findViewById(R.id.risk_selector_four);
        View riskSelectedFour = linearLayout.findViewById(R.id.risk_selected_four);
        View riskBarSelectorFive = linearLayout.findViewById(R.id.risk_selector_five);
        View riskSelectedFive = linearLayout.findViewById(R.id.risk_selected_five);

                riskBarSelectorOne.setVisibility(View.INVISIBLE);
        riskSelectedOne.setVisibility(View.INVISIBLE);
        riskBarSelectorTwo.setVisibility(View.INVISIBLE);
        riskSelectedTwo.setVisibility(View.INVISIBLE);
        riskBarSelectorThree.setVisibility(View.INVISIBLE);
        riskSelectedThree.setVisibility(View.INVISIBLE);
        riskBarSelectorFour.setVisibility(View.INVISIBLE);
        riskSelectedFour.setVisibility(View.INVISIBLE);
        riskBarSelectorFive.setVisibility(View.INVISIBLE);
        riskSelectedFive.setVisibility(View.INVISIBLE);
    }
}
