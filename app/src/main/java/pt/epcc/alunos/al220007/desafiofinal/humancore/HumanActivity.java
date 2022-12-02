package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<
		E extends Human,
		T extends Adapter<E, ? extends ViewHolder<E, ? extends HumanDetailsActivity<E>>, T>
	> extends Activity implements HumanAdapterCreator<E, T>, DetailsManager
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

	private void showDetails() {
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

	protected abstract Class<? extends HumanDetailsActivity<E>> aClass();
}
