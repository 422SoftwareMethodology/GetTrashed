import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class BuildDB {
    @SuppressWarnings("deprecation")
	public static ArrayList<Drink> getJSONFromUrl(String url) {
        InputStream is = null;
        String json = "";
        ArrayList<Drink> drinksList;

        try {
            @SuppressWarnings("deprecation")
			DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {}

        drinksList = new ArrayList<>();
        JsonParseResult jsonParseResult = new Gson().fromJson(json, JsonParseResult.class);

        if (jsonParseResult != null && jsonParseResult.getResult() != null) {
            for (Drink drink : jsonParseResult.getResult()) {
                drinksList.add(drink);
            }
        }
        return drinksList;
    }

    public class JsonParseResult {
        @SerializedName("drinks")
        private List<Drink> drinks;
        public JsonParseResult(List<Drink> results) {
            super();
            this.drinks = results;
        }

        public List<Drink> getResult() {
            return drinks;
        }
    }
}