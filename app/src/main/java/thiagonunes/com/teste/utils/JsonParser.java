package thiagonunes.com.teste.utils;
import thiagonunes.com.teste.entity.CellsEntity;
import thiagonunes.com.teste.entity.ScreensEntity;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;

public class JsonParser {

    public static List<CellsEntity> toListCell(String json) throws JsonParserExceptionUtils {
        try {
            Gson gson = new GsonBuilder().create();
            Cells cells = gson.fromJson(json, Cells.class);

            if (cells == null || cells.getCells() == null) {
                return null;
            }

            return Arrays.asList(cells.getCells());
        } catch (Exception ex) {
            Log.e("JsonParser", ex.getMessage());
            throw new JsonParserExceptionUtils("Erro ao fazer parse do JSON");
        }
    }

    public static ScreensEntity toScreen(String json) throws JsonParserExceptionUtils {
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, ScreenWrapper.class).getScreen();
        } catch (Exception ex) {
            Log.e("JsonParser", ex.getMessage());
            throw new JsonParserExceptionUtils("Erro ao fazer parse do JSON");
        }
    }

    private class Cells{
        private CellsEntity[] cells;

        public CellsEntity[] getCells() {
            return cells;
        }
    }

    private class ScreenWrapper {
        private ScreensEntity screen;

        public ScreensEntity getScreen() {
            return screen;
        }
    }
}