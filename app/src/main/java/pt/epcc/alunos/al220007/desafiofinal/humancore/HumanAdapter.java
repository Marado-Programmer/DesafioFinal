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

abstract public class HumanAdapter<T extends HumanViewHolder> extends Adapter<T> {
	protected HumanViewHolderCreator<T> getInstance;

	protected List<? extends Human> list;
	protected Context context;
	protected LayoutManagerType layoutManagerType;

	public <E extends Human> HumanAdapter(List<E> list, Context context) {
		this.getInstance = createCreator();

		this.list = list;
		this.context = context;
	}

	abstract protected HumanViewHolderCreator<T> createCreator();

	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(this.choseLayout(), parent, false);

		T viewHolder = this.getInstance.createViewHolder(view);
		viewHolder.init(this.context);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull T holder, int position) {
		Human human = this.list.get(position);

		if (holder.profilePic != null) {
			holder.profilePic.setImageResource(human.getImage());
		}
		if (holder.name != null) {
			holder.name.setText(human.getName());
		}

		this.manage(holder, human);
	}

	@Override
	public int getItemCount() {
		return this.list.size();
	}

	protected int choseLayout() {
		switch (this.layoutManagerType) {
			case GRID: return R.layout.human_id_layout_grid;
			case LINEAR:
			default:
				return R.layout.human_id_layout_linear;
		}
	}

	public void setLayoutManagerType(LayoutManagerType layoutManagerType) {
		this.layoutManagerType = layoutManagerType;
	}

	abstract protected <E extends Human> void manage(T holder, E human);
}
