package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsManager;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilderCreator;
import pt.epcc.alunos.al220007.desafiofinal.humancore.RecyclerViewFragment;

abstract public class Activity<E extends Human, T extends ExtraBuilder<E>, S extends DetailsManager<E, T>> extends AppCompatActivity implements DetailsManager<E, T>, ExtraBuilderCreator<E, T> {
	protected static final String ID_KEY = DetailsFragment.ID_KEY;
	protected static final String EXTRA_KEY = DetailsFragment.EXTRA_KEY;
	protected static final String HUMAN_KEY = DetailsFragment.HUMAN_KEY;

	private Bundle lastState;

	private LayoutManagerType type;

	@Override
	protected final void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(setLayout());

		findLastState(savedInstanceState);

		onContentViewSet(savedInstanceState);

		if (lastState != null) {
			firstTimeProcess();
		}
	}

	public void firstTimeProcess() {
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

	@Override
	protected final void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		if (lastState == null) {
			return;
		}

		putExtras(outState);
	}

	private void findLastState(@Nullable Bundle savedInstanceState) {
		lastState = savedInstanceState;

		if (lastState == null) {
			lastState = getIntent().getExtras();
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
		bundle.putSerializable(RecyclerViewFragment.LAYOUT_MANAGER_KEY, type);

		return bundle;
	}

	@Nullable
	protected Bundle getLastState() {
		return lastState;
	}

	public void setLastState(Bundle lastState) {
		this.lastState = lastState;
	}

	protected abstract int setLayout();

	protected abstract void onContentViewSet(@Nullable Bundle savedInstanceState);

	protected abstract void onLandscape();

	protected abstract void onPortrait();

	protected final void showDetails() {
		getSupportFragmentManager().beginTransaction()
			.setReorderingAllowed(true)
			.replace(
				DetailsFragment.DETAILS_ID,
				new DetailsFragment<>(
					this,
					putExtras(new Bundle())
				)
			)
			.commit();
	}

	public final void intentDetailsManager() {
		Intent intent = new Intent(getApplicationContext(), nextDetailsManager());

		intent.putExtras(getLastState());

		startActivity(intent);
	}

	protected void setState(Bundle lastState) {
		this.lastState = lastState;
	}

	@NonNull
	public abstract Class<? extends S> nextDetailsManager();

	public void setLayoutManagerType(LayoutManagerType type) {
		this.type = type;
	}
}
