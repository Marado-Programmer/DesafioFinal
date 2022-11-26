package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.HumanRecyclerViewFragment;
import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<E extends Human, T extends HumanAdapter<? extends HumanViewHolder>> extends AppCompatActivity {
	protected RecyclerView recyclerView;
	protected T adapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_fragment);

		if (savedInstanceState == null) {
			Bundle bundle = new Bundle();
			bundle.putInt("layoutManagerType", this.choseLayoutManager().id);

			this.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.add(
					R.id.fragment_frame,
					HumanRecyclerViewFragment.class,
					bundle
				).commit();
		}
	}

	abstract protected LayoutManagerType choseLayoutManager();

	abstract public HumanAdapterCreator<T> generateAdapterCreator();

	abstract public List<E> generateList();
}
