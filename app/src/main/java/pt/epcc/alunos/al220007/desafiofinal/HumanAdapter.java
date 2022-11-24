package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

abstract public class HumanAdapter<T extends HumanViewHolder> extends Adapter<T> {
	protected HumanViewHolderCreator<T> getInstance;

	protected List<? extends Human> list;
	protected Context context;

	public <E extends Human> HumanAdapter(List<E> list, Context context) {
		this.getInstance = createCreator();

		this.list = list;
		this.context = context;
	}

	abstract protected HumanViewHolderCreator<T> createCreator();

	@NonNull
	@Override
	public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		// TODO create layout
		View view = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.human_id_layout, parent, false);

		T viewHolder = (T) this.getInstance.createViewHolder(view);
		viewHolder.init(this.context);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull T holder, int position) {
		this.manage((T) holder, this.list.get(position));
	}

	@Override
	public int getItemCount() {
		return this.list.size();
	}

	abstract protected <E extends Human> void manage(T holder, E human);
}
