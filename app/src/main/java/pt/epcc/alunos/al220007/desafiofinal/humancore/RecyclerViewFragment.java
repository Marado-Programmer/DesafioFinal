package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public final class RecyclerViewFragment<
	E extends Human,
	T extends ExtraBuilder<E>,
	S extends Adapter<E, ? extends ViewHolder<E, T, ? extends DetailsActivity<E, T>>, ? extends ExtraBuilder<E>>
	> extends Fragment implements View.OnClickListener {
	public static final String LAYOUT_MANAGER_KEY = "layoutManagerType";

	private static final int LAYOUT = R.layout.activity_human_list;

	private static final int BUTTON_ID = R.id.layout_type;
	private static final int LIST_ID = R.id.list;

	private static final int LINEAR_IMAGE = R.drawable.linear;
	private static final int GRID_IMAGE = R.drawable.grid;

	private static final int SPAN_COUNT = 3;

	private HumanActivity<E, T, S> context;

	private RecyclerView recyclerView;
	private S adapter;

	private LayoutManagerType curLayoutManager;

	private ImageButton button;

	private int pos;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		prepareForList();

		calcInitialLayoutManager(savedInstanceState);

		if (getArguments() != null) {
			pos = getArguments().getInt(DetailsFragment.ID_KEY, RecyclerView.NO_POSITION);
			curLayoutManager = (LayoutManagerType) getArguments().getSerializable(LAYOUT_MANAGER_KEY);
		}
	}

	@Nullable
	@Override
	public View onCreateView(
		@NonNull LayoutInflater inflater,
		@Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState
	) {
		return inflater.inflate(LAYOUT, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		button = view.findViewById(BUTTON_ID);

		button.setOnClickListener(this);

		recyclerView = view.findViewById(LIST_ID);

		setLayoutManager(curLayoutManager);

		scroll(pos);

		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putSerializable(LAYOUT_MANAGER_KEY, curLayoutManager);
	}

	@SuppressWarnings("unchecked")
	private void prepareForList() {
		//noinspection unchecked
		context = (HumanActivity<E, T, S>) getActivity();

		assert context != null;

		adapter = context.createAdapter(context);
	}

	private void calcInitialLayoutManager(Bundle bundle) {
		Bundle args = getArguments();

		if (bundle != null) {
			args = bundle;
		}

		assert args != null;

		curLayoutManager = (LayoutManagerType) args.getSerializable(LAYOUT_MANAGER_KEY);
	}

	private void setLayoutManager(LayoutManagerType layoutManagerType) {
		adapter.setLayoutManager(layoutManagerType);

		recyclerView.setLayoutManager(getLayoutManager(layoutManagerType));

		context.setLayoutManagerType(layoutManagerType);
	}

	private void scroll(int pos) {
		if (pos <= 0) {
			pos = 0;

			RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
			if (layoutManager != null) {
				pos = ((LinearLayoutManager) layoutManager)
					.findFirstVisibleItemPosition();
			}
		}

		pos = pos <= RecyclerView.NO_POSITION ? 0 : pos;

		recyclerView.scrollToPosition(pos);

		this.pos = pos;
	}

	private RecyclerView.LayoutManager getLayoutManager(LayoutManagerType layoutManagerType) {
		switch (layoutManagerType) {
			case GRID: {
				curLayoutManager = LayoutManagerType.GRID;
				button.setImageResource(GRID_IMAGE);
				return new GridLayoutManager(context, SPAN_COUNT);
			}
			case LINEAR:
			default: {
				curLayoutManager = LayoutManagerType.LINEAR;
				button.setImageResource(LINEAR_IMAGE);
				return new LinearLayoutManager(context);
			}
		}
	}

	@Override
	public void onClick(View v) {
		if (v != button) {
			return;
		}

		setLayoutManager(
			curLayoutManager == LayoutManagerType.LINEAR
				? LayoutManagerType.GRID
				: LayoutManagerType.LINEAR
		);
	}
}
