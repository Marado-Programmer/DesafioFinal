package pt.epcc.alunos.al220007.desafiofinal;

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

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class HumanRecyclerViewFragment<T extends HumanAdapter<? extends HumanViewHolder>>
	extends Fragment
	implements View.OnClickListener
{
	protected RecyclerView recyclerView;
	protected T adapter;

	protected ImageButton button;

	protected static final String LAYOUT_MANAGER_KEY = "layoutManagerType";

	protected final int LINEAR_IMAGE = R.drawable.linear;
	protected final int GRID_IMAGE = R.drawable.grid;

	protected LayoutManagerType curLayoutManager;

	public HumanRecyclerViewFragment(T adapter, Bundle bundle) {
		super();
		this.adapter = adapter;
		this.setArguments(bundle);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = this.getArguments();

		if (args != null) {
			this.curLayoutManager = LayoutManagerType.fromID(
				args.getInt(HumanRecyclerViewFragment.LAYOUT_MANAGER_KEY, 0)
			);
		}

		if (savedInstanceState != null) {
			this.curLayoutManager = LayoutManagerType.fromID(
				savedInstanceState
					.getInt(HumanRecyclerViewFragment.LAYOUT_MANAGER_KEY, 0)
			) == LayoutManagerType.GRID
				? LayoutManagerType.LINEAR
				: LayoutManagerType.GRID;
		}

		if (this.curLayoutManager == null) {
			this.curLayoutManager = LayoutManagerType.LINEAR;
		}
	}

	@Nullable
	@Override
	public View onCreateView(
		@NonNull LayoutInflater inflater,
		@Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState
	) {
		inflater.inflate(R.layout.activity_human_list, container, false);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		this.button = view.findViewById(R.id.layout_type);

		this.button.setOnClickListener(this);

		this.recyclerView = view.findViewById(R.id.list);

		this.setLayoutManager(this.curLayoutManager);

		this.recyclerView.setAdapter(this.adapter);
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(HumanRecyclerViewFragment.LAYOUT_MANAGER_KEY, this.curLayoutManager.id);
	}

	private void setLayoutManager(LayoutManagerType layoutManagerType) {
		int pos = 0;
		RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();

		if (layoutManager != null) {
			pos = ((LinearLayoutManager) layoutManager)
				.findFirstCompletelyVisibleItemPosition();
		}

		this.recyclerView.setLayoutManager(this.getLayoutManager(layoutManagerType));
		this.recyclerView.scrollToPosition(pos);

	}

	private RecyclerView.LayoutManager getLayoutManager(LayoutManagerType layoutManagerType) {
		switch (layoutManagerType) {
			case GRID: {
				this.curLayoutManager = LayoutManagerType.GRID;
				this.button.setImageResource(this.GRID_IMAGE);
				return new GridLayoutManager(this.getActivity(), 3);
			}
			case LINEAR:
			default: {
				this.curLayoutManager = LayoutManagerType.LINEAR;
				this.button.setImageResource(this.LINEAR_IMAGE);
				return new LinearLayoutManager(this.getActivity());
			}
		}
	}

	@Override
	public void onClick(View v) {
		if (v == this.button) {
			this.setLayoutManager(
				this.curLayoutManager == LayoutManagerType.LINEAR
					? LayoutManagerType.GRID
					: LayoutManagerType.LINEAR
			);
		}
	}
}
