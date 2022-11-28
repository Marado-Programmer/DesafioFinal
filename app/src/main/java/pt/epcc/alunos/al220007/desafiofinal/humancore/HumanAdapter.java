package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanAdapter<T extends HumanViewHolder>
		extends Adapter<T>
		implements HumanViewHolderCreator<T>
{
	protected List<? extends Human> list;
	protected Context context;

	public <E extends Human> HumanAdapter(List<E> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.human_id_layout, parent, false);

		T viewHolder = this.createViewHolder(view);
		viewHolder.init(this.context);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull T holder, int position) {
		Human human = this.list.get(position);

		holder.profilePic.setImageResource(human.getImage());
		holder.name.setText(human.getName());

		this.manage(holder, human);
	}

	@Override
	public int getItemCount() {
		return this.list.size();
	}

	abstract protected <E extends Human> void manage(T holder, E human);
}
