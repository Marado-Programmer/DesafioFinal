package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.LayoutManagerType;
import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanAdapter<E extends Human, T extends HumanViewHolder>
		extends Adapter<T>
		implements HumanViewHolderCreator<T>
{
	protected List<E> list;
	protected Context context;
	protected LayoutManagerType layoutManagerType;

	public HumanAdapter(List<E> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(this.choseLayout(), parent, false);

		return this.createViewHolder(view, this.context);
	}

	@Override
	public void onBindViewHolder(@NonNull T holder, int position) {
		E human = this.list.get(position);

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
		return this.list.size();
	}

	protected int choseLayout() {
		LayoutManagerType type = this.layoutManagerType;

		if (type == null) {
			type = this.getDefaultLayout();
		}

		// WORKAROUND
		type = this.getDefaultLayout();

		switch (type) {
			case GRID: return R.layout.human_id_layout_grid;
			case LINEAR: return R.layout.human_id_layout_linear;
		}

		return 0;
	}

	public void setLayoutManagerType(LayoutManagerType layoutManagerType) {
		this.layoutManagerType = layoutManagerType;
	}

	abstract protected LayoutManagerType getDefaultLayout();
}
