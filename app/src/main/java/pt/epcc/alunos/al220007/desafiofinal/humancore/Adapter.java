package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

abstract public class Adapter<E extends Human, T extends ViewHolder<E, S, ? extends DetailsActivity<E, S>>, S extends ExtraBuilder<E>>
	extends RecyclerView.Adapter<T>
	implements ViewHolderCreator<E, T, S> {
	protected static final int LINEAR_LAYOUT = R.layout.human_id_layout_linear;
	protected static final int GRID_LAYOUT = R.layout.human_id_layout_grid;
	protected final HumanActivity<E, S, ? extends Adapter<E, T, S>> ctx;
	private final List<E> list;
	private LayoutManagerType layoutManager;

	public Adapter(HumanActivity<E, S, ? extends Adapter<E, T, S>> ctx) {
		this.ctx = ctx;
		list = ctx.genList();
	}

	@NonNull
	@Override
	public final T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(ctx)
			.inflate(findLayout(), parent, false);

		return createViewHolder(view, ctx);
	}

	@Override
	public final void onBindViewHolder(@NonNull T holder, int position) {
		E human = list.get(position);

		holder.setHuman(human);

		populateViewHolder(holder, human);

		createExtraDetails(ctx.createBuilder(holder.extra, human.toBundle()));
	}

	@Override
	public final int getItemCount() {
		return list.size();
	}

	private void populateViewHolder(@NonNull T holder, E human) {
		if (holder.profilePic != null) {
			holder.profilePic.setImageResource(human.getImage());
		}

		if (holder.name != null) {
			holder.name.setText(human.getName());
		}
	}

	private int findLayout() {
		LayoutManagerType t = layoutManager;

		if (t == null || ViewHolder.RECYCLABLE) {
			t = defaultLayout();
		}

		switch (t) {
			case GRID:
				return GRID_LAYOUT;
			case LINEAR:
			default:
				return LINEAR_LAYOUT;
		}
	}

	abstract protected void createExtraDetails(S builder);

	abstract protected LayoutManagerType defaultLayout();

	public void setLayoutManager(LayoutManagerType layoutManager) {
		this.layoutManager = layoutManager;
	}
}
