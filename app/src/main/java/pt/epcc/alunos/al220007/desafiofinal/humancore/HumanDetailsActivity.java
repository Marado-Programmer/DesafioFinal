package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public abstract class HumanDetailsActivity<E extends Human> extends AppCompatActivity implements DetailsManager {
	protected Bundle extras;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_details_fragment);

		extras = getIntent().getExtras();

		if (extras == null) {
			extras = savedInstanceState;
		}

		if (
			this.getResources().getConfiguration().orientation
				!= Configuration.ORIENTATION_LANDSCAPE
		) {
			this.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.replace(
					R.id.details,
					new DetailsFragment(this, extras)
				).commit();

			return;
		}

		Intent intent = new Intent(HumanDetailsActivity.this, aClass());

		String id = DetailsFragment.ID_KEY;
		String xtra = DetailsFragment.EXTRA_KEY;
		String human = DetailsFragment.HUMAN_KEY;

		intent.putExtra(id, extras.getInt(id, RecyclerView.NO_POSITION));
		intent.putExtra(xtra, extras.getInt(xtra, RecyclerView.NO_POSITION));
		intent.putExtra(human, extras.getBundle(human));

		startActivity(intent);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		String id = DetailsFragment.ID_KEY;
		String xtra = DetailsFragment.EXTRA_KEY;
		String human = DetailsFragment.HUMAN_KEY;

		outState.putInt(id, extras.getInt(id, RecyclerView.NO_POSITION));
		outState.putInt(xtra, extras.getInt(xtra, RecyclerView.NO_POSITION));
		outState.putBundle(human, extras.getBundle(human));
	}

	protected abstract Class<? extends HumanActivity<E, ? extends Adapter>> aClass();
}
