package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.AdapterCreator;
import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.RecyclerViewFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;

abstract public class HumanActivity<
	E extends Human,
	T extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>>
	> extends Activity<DetailsActivity<E>> implements AdapterCreator<E, T> {
	private static final int LAYOUT = R.layout.activity_human_fragment;
	private static final int FRAME_LAYOUT = R.id.fragment_frame;

	@Override
	protected final int setLayout() {
		return LAYOUT;
	}

	@Override
	protected final void onContentViewSet() {
		transact();
	}

	private void transact() {
		getSupportFragmentManager()
			.beginTransaction()
			.setReorderingAllowed(true)
			.add(
				FRAME_LAYOUT,
				RecyclerViewFragment.class,
				createBundle()
			).commit();
	}

	protected final Bundle createBundle() {
		Bundle bundle = new Bundle();

		bundle.putInt(
			RecyclerViewFragment.LAYOUT_MANAGER_KEY,
			choseLayoutManager().id
		);

		bundle.putInt(DetailsFragment.ID_KEY, getID());

		return bundle;
	}

	private int getID() {
		return getLastState() != null ? getLastState().getInt(
			DetailsFragment.ID_KEY,
			RecyclerView.NO_POSITION
		) : RecyclerView.NO_POSITION;
	}

	@Override
	protected final void onLandscape() {
		showDetails();
	}


	@Override
	protected final void onPortrait() {
		if (getID() == RecyclerView.NO_POSITION) {
			return;
		}

		intentDetailsManager();
	}

	abstract protected LayoutManagerType choseLayoutManager();

	abstract public List<E> generateList();
}
