package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;

public abstract class DetailsActivity<E extends Human> extends Activity<HumanActivity<E, ? extends Adapter>> {
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
		intentDetailsManager();
	}
}
