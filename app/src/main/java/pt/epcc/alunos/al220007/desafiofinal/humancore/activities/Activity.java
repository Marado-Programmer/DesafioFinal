package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsManager;

abstract public class Activity<T extends DetailsManager> extends AppCompatActivity implements DetailsManager {
	protected static final String ID_KEY = DetailsFragment.ID_KEY;
	protected static final String EXTRA_KEY = DetailsFragment.EXTRA_KEY;
	protected static final String HUMAN_KEY = DetailsFragment.HUMAN_KEY;

	private Bundle lastState;

	@Override
	protected final void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(setLayout());

		findLastState(savedInstanceState);

		onContentViewSet();

		if (lastState != null) {
			if (isLandscape()) {
				onLandscape();

				return;
			}

			if (isPortrait()) {
				onPortrait();

				return;
			}

			Log.i("???", "???");
		}
	}

	@Override
	protected final void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		if (lastState == null) {
			return;
		}

		putExtras(outState);
	}

	private void findLastState(@Nullable Bundle savedInstanceState) {
		lastState = getIntent().getExtras();

		if (lastState == null) {
			lastState = savedInstanceState;
		}
	}

	private boolean isLandscape() {
		return getResources()
			.getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
	}

	private boolean isPortrait() {
		return getResources()
			.getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
	}

	protected final Bundle putExtras(Bundle bundle) {
		bundle.putInt(ID_KEY, lastState.getInt(ID_KEY, RecyclerView.NO_POSITION));
		bundle.putInt(EXTRA_KEY, lastState.getInt(EXTRA_KEY, 0));
		bundle.putBundle(HUMAN_KEY, lastState.getBundle(HUMAN_KEY));

		return bundle;
	}

	@Nullable
	protected Bundle getLastState() {
		return lastState;
	}

	protected abstract int setLayout();

	protected abstract void onContentViewSet();

	protected abstract void onLandscape();

	protected abstract void onPortrait();

	public final void setLastState(Bundle lastState) {
		this.lastState = lastState;
	}

	protected final void showDetails() {
		getSupportFragmentManager().beginTransaction()
			.setReorderingAllowed(true)
			.replace(
				DetailsFragment.DETAILS_ID,
				new DetailsFragment(
					this,
					putExtras(new Bundle())
				)
			)
			.commit();
	}

	protected final void intentDetailsManager() {
		Intent intent = new Intent(getApplicationContext(), nextDetailsManager());

		intent.putExtras(getLastState());

		startActivity(intent);
	}

	@NonNull
	protected abstract Class<? extends T> nextDetailsManager();
}
