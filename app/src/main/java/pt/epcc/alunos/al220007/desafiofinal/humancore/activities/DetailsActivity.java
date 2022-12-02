package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;

public abstract class DetailsActivity<E extends Human>
	extends Activity<HumanActivity<E, ? extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>>>>
{
	private static final int LAYOUT = R.layout.activity_human_details_fragment;

	@Override
	protected int setLayout() {
		return LAYOUT;
	}

	@Override
	protected final void onContentViewSet() {
	}

	@Override
	protected void onPortrait() {
		showDetails();
	}

	@Override
	protected void onLandscape() {
		intentDetailsManager();
	}

	@NonNull
	@Override
	protected abstract Class<? extends HumanActivity<E, ? extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>>>> nextDetailsManager();
}
