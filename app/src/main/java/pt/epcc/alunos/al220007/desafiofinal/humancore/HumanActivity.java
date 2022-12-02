package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<
		E extends Human,
		T extends HumanAdapter<E, ? extends HumanViewHolder<E, ? extends HumanDetailsActivity<E>>, T>
	> extends AppCompatActivity implements HumanAdapterCreator<E, T>, DetailsManager
{
	protected static final int LAYOUT = R.layout.activity_human_fragment;
	protected static final int FRAME_LAYOUT = R.id.fragment_frame;

	protected Bundle last;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(LAYOUT);

		last = getIntent().getExtras();


		if (last == null) {
			last = savedInstanceState;
		}

		if (last != null) {
			if (
				this.getResources().getConfiguration().orientation
					== Configuration.ORIENTATION_LANDSCAPE && savedInstanceState == null
			) {
				Bundle bundleFragment = new Bundle();

				bundleFragment.putLong("id", last.getLong("id", 0));
				bundleFragment.putInt("extra", last.getInt("extra", 0));
				bundleFragment.putBundle("human", last.getBundle("human"));

				HumanDetailsFragment fragment = new HumanDetailsFragment(this, bundleFragment);

				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				transaction = transaction.setReorderingAllowed(true);
				transaction.replace(R.id.details, fragment);
				transaction.commit();

				return;
			}

			if (last.getInt("last", RecyclerView.NO_POSITION) == RecyclerView.NO_POSITION) {
				return;
			}

			Intent intent = new Intent(HumanActivity.this, aClass());

			intent.putExtra("id", last.getLong("id", 0));
			intent.putExtra("extra", last.getInt("extra", 0));
			intent.putExtra("human", last.getBundle("human"));

			startActivity(intent);
			return;
		}

		transact();
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		if (last == null) {
			return;
		}

		outState.putInt("last", last.getInt("last", RecyclerView.NO_POSITION));
		outState.putLong("id", last.getLong("id"));
		outState.putInt("extra", last.getInt("extra", RecyclerView.NO_POSITION));
		outState.putBundle("human", last.getBundle("human"));
	}

	public void setLast(Bundle last) {
		this.last = last;
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

		bundle.putInt("last", last != null ? last.getInt("last", RecyclerView.NO_POSITION) : RecyclerView.NO_POSITION);

		return bundle;
	}

	abstract public List<E> generateList();

	abstract protected LayoutManagerType choseLayoutManager();

	protected abstract Class<? extends HumanDetailsActivity<E>> aClass();
}
