package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.HumanRecyclerViewFragment;
import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<E extends Human, T extends HumanAdapter<? extends HumanViewHolder>> extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_fragment);

		this.getSupportFragmentManager().beginTransaction()
			.setReorderingAllowed(true)
			.add(
				R.id.fragment_frame,
				new HumanRecyclerViewFragment<>(
					this.generateAdapterCreator()
						.createAdapter(
							this.generateList(), this
						),
					this.createBundle()
				)
			).commit();
	}

	protected Bundle createBundle() {
		Bundle bundle = new Bundle();
		bundle.putInt(HumanRecyclerViewFragment.LAYOUT_MANAGER_KEY, this.choseLayoutManager().id);

		return bundle;
	}

	abstract protected LayoutManagerType choseLayoutManager();

	abstract protected HumanAdapterCreator<T> generateAdapterCreator();

	abstract protected List<E> generateList();
}
