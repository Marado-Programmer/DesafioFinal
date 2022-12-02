package pt.epcc.alunos.al220007.desafiofinal.humancore.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.DetailsFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapterCreator;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanRecyclerViewFragment;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;

abstract public class HumanActivity<
		E extends Human,
		T extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>, T>
	> extends Activity implements HumanAdapterCreator<E, T>
{
	private static final int LAYOUT = R.layout.activity_human_fragment;
	private static final int FRAME_LAYOUT = R.id.fragment_frame;

	@Override
	protected int setLayout() {
		return LAYOUT;
	}

	@Override
	protected void onContentViewSet() {
		transact();
	}

	private void transact() {
		getSupportFragmentManager()
			.beginTransaction()
			.setReorderingAllowed(true)
			.add(
				FRAME_LAYOUT,
				HumanRecyclerViewFragment.class,
				createBundle()
			).commit();
	}

	protected Bundle createBundle() {
		Bundle bundle = new Bundle();

		bundle.putInt(
			HumanRecyclerViewFragment.LAYOUT_MANAGER_KEY,
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

	abstract protected LayoutManagerType choseLayoutManager();

	@Override
	protected void onLandscape() {
		showDetails();
	}


	@Override
	protected void onPortrait() {
		if (getID() == RecyclerView.NO_POSITION) {
			return;
		}

		Intent intent = new Intent(HumanActivity.this, aClass());

		intent.putExtras(getLastState());

		startActivity(intent);
	}

	abstract public List<E> generateList();

	protected abstract Class<? extends DetailsActivity<E>> aClass();
}
