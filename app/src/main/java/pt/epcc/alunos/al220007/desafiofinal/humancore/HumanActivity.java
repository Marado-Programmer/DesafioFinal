package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<
		E extends Human,
		T extends HumanAdapter<E, ? extends HumanViewHolder<E, ? extends HumanDetailsActivity<E>>, T>
	> extends AppCompatActivity implements HumanAdapterCreator<E, T>
{
	protected static final int LAYOUT = R.layout.activity_human_fragment;
	protected static final int FRAME_LAYOUT = R.id.fragment_frame;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(LAYOUT);

		if (savedInstanceState == null) {
			transact();
		}
	}

	protected final void transact() {
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

		return bundle;
	}

	abstract public List<E> generateList();

	abstract protected LayoutManagerType choseLayoutManager();
}
