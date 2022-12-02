package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class VisitActivity  extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visit);

		WebView webView = findViewById(R.id.webview);
		webView.setWebViewClient(new WebClient());
		webView.loadUrl("https://epcc.pt/");
	}

	private static class WebClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
			return false;
		}
	}
}
