package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;

public abstract class DetailsActivity<E extends Human, T extends ExtraBuilder<E>>
	extends Activity<E, T, HumanActivity<E, T, ? extends Adapter<E, ? extends ViewHolder<E, T, ? extends DetailsActivity<E, T>>, ? extends ExtraBuilder<E>>>> {
	private static final int LAYOUT = R.layout.activity_human_details_fragment;

	@Override
	protected int setLayout() {
		return LAYOUT;
	}

	@Override
	protected final void onContentViewSet(@Nullable Bundle savedInstanceState) {
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
