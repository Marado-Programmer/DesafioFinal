package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.content.Intent;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;

public abstract class DetailsActivity<E extends Human> extends Activity {
	private static final int LAYOUT = R.layout.activity_human_details_fragment;

	@Override
	protected int setLayout() {
		return LAYOUT;
	}

	@Override
	protected void onPortrait() {
		showDetails();
	}

	@Override
	protected void onLandscape() {
		Intent intent = new Intent(DetailsActivity.this, aClass());

		intent.putExtras(getLastState());

		startActivity(intent);
	}

	protected abstract Class<? extends HumanActivity<E, ? extends Adapter>> aClass();
}
