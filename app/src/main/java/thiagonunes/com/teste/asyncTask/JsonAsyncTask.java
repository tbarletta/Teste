package thiagonunes.com.teste.asyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonAsyncTask extends AsyncTask<String, Void, String> {

    private ProgressDialog load;

    private JSONDownloaderCallback jsonDownloaderCallback;
    private Context context;

    public JsonAsyncTask(JSONDownloaderCallback jsonDownloaderCallback, Context context) {
        this.jsonDownloaderCallback = jsonDownloaderCallback;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        load = ProgressDialog.show(context, "Aguarde",
        "Carregando...");
    }

    @Override
    protected String doInBackground(String... params) {
        try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String json = "";
                String line = "";
                while (line != null) {
                    json += line;
                    line = bufferedReader.readLine();
                }

                return json;
            } catch (Exception e) {
                return null;
            }
    }

    @Override
    protected void onPostExecute(String json) {
        load.dismiss();
        jsonDownloaderCallback.onPostExecute(json);
    }

    public interface JSONDownloaderCallback {
        void onPostExecute(String json);
    }
}
