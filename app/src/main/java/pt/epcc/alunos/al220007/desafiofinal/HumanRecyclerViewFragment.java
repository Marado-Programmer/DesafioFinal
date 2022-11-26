package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class HumanRecyclerViewFragment<T extends HumanAdapter<? extends HumanViewHolder>> extends Fragment {
	protected RecyclerView recyclerView;
	protected T adapter;

	protected HumanActivity activity;

	protected final String LAYOUT_MANAGER_KEY = "layoutManagerType";

	protected LayoutManagerType curLayoutManager;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.activity = (HumanActivity) this.getActivity();

		assert this.activity != null;

		this.adapter = (T) this.activity
			.generateAdapterCreator()
			.createAdapter(this.activity.generateList(), this.activity);
	}

	@Nullable
	@Override
	public View onCreateView(
		@NonNull LayoutInflater inflater,
		@Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState
	) {
		View view = inflater.inflate(R.layout.activity_human_list, container, false);

		this.curLayoutManager = LayoutManagerType.fromID(
			this.requireArguments().getInt(this.LAYOUT_MANAGER_KEY, 0)
		);

		Log.i("SAVED???", String.valueOf(savedInstanceState != null));

		if (savedInstanceState != null) {
			this.curLayoutManager = LayoutManagerType.fromID(
				savedInstanceState
					.getInt(this.LAYOUT_MANAGER_KEY, 0)
			) == LayoutManagerType.GRID
				? LayoutManagerType.LINEAR
				: LayoutManagerType.GRID;
		}

		this.recyclerView = view.findViewById(R.id.list);

		int pos = 0;
		RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();

		if (layoutManager != null) {
			pos = ((LinearLayoutManager) layoutManager)
				.findFirstCompletelyVisibleItemPosition();
		}

		this.recyclerView.setLayoutManager(this.choseLayoutManager(this.curLayoutManager));
		this.recyclerView.scrollToPosition(pos);

		this.recyclerView.setAdapter(this.adapter);

		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(this.LAYOUT_MANAGER_KEY, this.curLayoutManager.id);
	}

	private RecyclerView.LayoutManager choseLayoutManager(LayoutManagerType layoutManagerType) {
		switch (layoutManagerType) {
			case LINEAR:
				this.curLayoutManager = LayoutManagerType.LINEAR;
				return new LinearLayoutManager(this.getActivity());
			case GRID:
			default:
				this.curLayoutManager = LayoutManagerType.GRID;
				return new GridLayoutManager(this.getActivity(), 3);
		}
	}
}
