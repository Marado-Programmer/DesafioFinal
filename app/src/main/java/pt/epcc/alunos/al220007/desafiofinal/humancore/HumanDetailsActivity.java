package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pt.epcc.alunos.al220007.desafiofinal.R;


public class HumanDetailsActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_details_fragment);

		this.getSupportFragmentManager().beginTransaction()
			.setReorderingAllowed(true)
			.add(
				R.id.details,
				new HumanDetailsFragment(this.getIntent().getBundleExtra("human"))
			).commit();
	}
}
