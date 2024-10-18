import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CallModel {
    public static void main(String[] args) throws Exception {
        URL url = new URL("/subscriptions/e3e20aa4-439a-45eb-8c3b-7434cae526ae/resourceGroups/AzureMachineLearning");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String input = "{ 'input_data': [ {'fields': ['feature1', 'feature2'], 'values': [[1.0, 2.0]]} ] }";
        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }
}
