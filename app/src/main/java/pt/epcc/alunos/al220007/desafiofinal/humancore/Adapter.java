package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
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

abstract public class Adapter<E extends Human, T extends ViewHolder<E, ? extends DetailsActivity<E>>>
		extends RecyclerView.Adapter<T>
		implements ViewHolderCreator<E, T>
{
	protected static final int LINEAR_LAYOUT = R.layout.human_id_layout_linear;
	protected static final int GRID_LAYOUT = R.layout.human_id_layout_grid;

	protected final List<E> list;

	protected final Context context;
	protected LayoutManagerType layoutManagerType;

	public Adapter(Context context) {
		this.context = context;
		list = generateList();
	}

	@SuppressWarnings("unchecked")
	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(choseLayout(), parent, false);

		//noinspection unchecked
		return createViewHolder(view, (HumanActivity<E, ? extends Adapter<E, T>>) context);
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

		manageTinyExtra(holder.extra, human);
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

		if (ViewHolder.RECYCLABLE) {
			type = getDefaultLayout();
		}

		switch (type) {
			case GRID: return GRID_LAYOUT;
			case LINEAR: return LINEAR_LAYOUT;
		}

		return 0;
	}

	abstract public List<E> generateList();

	abstract protected void manageTinyExtra(View view, E human);

	abstract protected LayoutManagerType getDefaultLayout();

	public void setLayoutManagerType(LayoutManagerType layoutManagerType) {
		this.layoutManagerType = layoutManagerType;
	}
}
