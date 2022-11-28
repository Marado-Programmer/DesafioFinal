package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface HumanAdapterCreator<
		E extends Human,
		T extends HumanAdapter<E, ? extends HumanViewHolder>
	>
{
	T createAdapter(List<E> list, Context context);
}
