package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;


public abstract class HumanDetailsActivity<E extends Human> extends AppCompatActivity implements DetailsManager {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_details_fragment);

		if (savedInstanceState == null) {
			HumanDetailsFragment fragment = new HumanDetailsFragment(this, getIntent().getExtras());

			this.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.add(
					R.id.details,
					fragment
				).commit();
		}
	}
}
