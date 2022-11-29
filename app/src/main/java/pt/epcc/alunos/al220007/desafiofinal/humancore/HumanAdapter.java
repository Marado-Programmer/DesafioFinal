package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanAdapter<E extends Human, T extends HumanViewHolder<E, ? extends HumanDetailsActivity<E>>, U extends HumanAdapter<E, T, U>>
		extends Adapter<T>
		implements HumanViewHolderCreator<E, T>
{
	protected static final int LINEAR_LAYOUT = R.layout.human_id_layout_linear;
	protected static final int GRID_LAYOUT = R.layout.human_id_layout_grid;

	protected List<E> list;
	protected HumanActivity<E, ? extends HumanAdapter<E, T, U>> context;
	protected LayoutManagerType layoutManagerType;

	public HumanAdapter(HumanActivity<E, U> context) {
		this.context = context;
		list = context.generateList();
	}


	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(choseLayout(), parent, false);

		return createViewHolder(view, context);
	}

	@Override
	public void onBindViewHolder(@NonNull T holder, int position) {
		E human = list.get(position);

		holder.setHuman(human);

		if (holder.profilePic != null) {
			holder.profilePic.setImageResource(human.getImage());
		}

		if (holder.name != null) {
			holder.name.setText(human.getName());
		}
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	protected int choseLayout() {
		LayoutManagerType type = layoutManagerType;

		if (type == null) {
			type = getDefaultLayout();
		}

		// WORKAROUND
		type = getDefaultLayout();

		switch (type) {
			case GRID: return GRID_LAYOUT;
			case LINEAR: return LINEAR_LAYOUT;
		}

		return 0;
	}

	abstract protected LayoutManagerType getDefaultLayout();

	public void setLayoutManagerType(LayoutManagerType layoutManagerType) {
		this.layoutManagerType = layoutManagerType;
	}
}
