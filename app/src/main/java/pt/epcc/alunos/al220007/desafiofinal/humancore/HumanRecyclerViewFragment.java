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

public final class HumanRecyclerViewFragment<
		E extends Human,
		T extends HumanAdapter<E, ? extends HumanViewHolder<E>, T>
	> extends Fragment implements View.OnClickListener
{
	public static final String LAYOUT_MANAGER_KEY = "layoutManagerType";
	private static final String POS_KEY = "pos";

	private static final int LAYOUT = R.layout.activity_human_list;

	private static final int BUTTON_ID = R.id.layout_type;
	private static final int LIST_ID = R.id.list;

	private static final int LINEAR_IMAGE = R.drawable.linear;
	private static final int GRID_IMAGE = R.drawable.grid;

	private static final int SPAN_COUNT = 3;

	private HumanActivity<E, T> context;

	private RecyclerView recyclerView;
	private T adapter;

	private LayoutManagerType curLayoutManager;

	private ImageButton button;

	private int pos;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		prepareForList();

		calcInitialLayoutManager(savedInstanceState);

		if (savedInstanceState == null) {
			return;
		}
		pos = savedInstanceState.getInt(POS_KEY, -1);

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

		recyclerView.setAdapter(adapter);

		scroll(pos);
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(LAYOUT_MANAGER_KEY, curLayoutManager.id);
		outState.putInt(POS_KEY, pos);
	}

	private void prepareForList() {
		context = (HumanActivity<E, T>) getActivity();

		assert context != null;

		adapter = context.createAdapter(context);
	}

	private void calcInitialLayoutManager(Bundle bundle) {
		Bundle args = getArguments();

		if (bundle != null) {
			args = bundle;
		}

		assert args != null;

		curLayoutManager = LayoutManagerType.fromID(args.getInt(LAYOUT_MANAGER_KEY));
	}

	private void setLayoutManager(LayoutManagerType layoutManagerType) {
		adapter.setLayoutManagerType(layoutManagerType);

		recyclerView.setLayoutManager(getLayoutManager(layoutManagerType));
	}

	private void scroll(int pos) {
		if (pos > 0) {
			recyclerView.scrollToPosition(pos);
			return;
		}

		pos = 0;

		RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

		if (layoutManager != null) {
			pos = ((LinearLayoutManager) layoutManager)
				.findFirstCompletelyVisibleItemPosition();
		}

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
