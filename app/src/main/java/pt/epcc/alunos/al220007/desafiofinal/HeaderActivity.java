package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HeaderActivity extends AppCompatActivity implements View.OnClickListener {
	private Button visit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_header);

		visit = findViewById(R.id.visit);
		visit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == visit) {
			startActivity(new Intent(HeaderActivity.this, VisitActivity.class));
		}
	}
}