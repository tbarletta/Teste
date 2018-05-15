package thiagonunes.com.teste;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import thiagonunes.com.teste.R;
import thiagonunes.com.teste.view.ContatoFragment;
import thiagonunes.com.teste.view.InvestimentoFragment;
import thiagonunes.com.teste.view.SuccessFragment;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements ContatoFragment.ContatoSubmitCallback, SuccessFragment.NovaMensagemCallback {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_investimento:
                    mTextMessage.setText(R.string.title_investimento);
                    return true;
                case R.id.navigation_contato:
                    mTextMessage.setText(R.string.title_contato);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        loadButtons();
        exibirFragment(ContatoFragment.newInstance(this));
    }

    private void loadButtons() {
        final Button btnInvestimento = (Button) findViewById(R.id.btn_investimento);
        final Button btnContato = (Button) findViewById(R.id.btn_contato);

        btnContato.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorPrimaryDark));

        btnInvestimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirFragment(InvestimentoFragment.newInstance());
                btnInvestimento.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorPrimaryDark));
                btnContato.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.buttonNormal));
            }
        });
        
        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirFragment(ContatoFragment.newInstance(MainActivity.this));
                btnInvestimento.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.buttonNormal));
                btnContato.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorPrimaryDark));
            }
        });
    }

    private void exibirFragment(Fragment fragment) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit();
    }

    @Override
    public void onContatoSubmit() {
                exibirFragment(SuccessFragment.newInstance(this));
    }

    @Override
    public void sendNewMessage() {
                exibirFragment(ContatoFragment.newInstance(this));
    }

}
