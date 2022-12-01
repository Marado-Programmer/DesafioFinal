package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

		Log.d("EXTRAS", String.valueOf(extras));
		Log.d("NOT LS", String.valueOf(this.getResources().getConfiguration().orientation
			!= Configuration.ORIENTATION_LANDSCAPE));

		if (
			this.getResources().getConfiguration().orientation
				!= Configuration.ORIENTATION_LANDSCAPE
		) {
			HumanDetailsFragment fragment = new HumanDetailsFragment(this, extras);

			this.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.replace(
					R.id.details,
					fragment
				).commit();

			return;
		}

		Intent intent = new Intent(HumanDetailsActivity.this, aClass());

		intent.putExtra("id", extras.getLong("id", 0));
		intent.putExtra("extra", extras.getInt("extra"));
		intent.putExtra("human", extras.getBundle("human"));

		startActivity(intent);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putLong("id", extras.getLong("id"));
		outState.putInt("extra", extras.getInt("extra", 0));
		outState.putBundle("human", extras.getBundle("human"));
	}

	protected abstract Class<? extends HumanActivity<E, ? extends HumanAdapter>> aClass();
}
