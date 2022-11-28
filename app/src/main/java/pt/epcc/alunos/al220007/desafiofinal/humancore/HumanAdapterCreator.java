package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface HumanAdapterCreator<
		E extends Human,
		T extends HumanAdapter<E, ? extends HumanViewHolder>
	>
{
	@NonNull
	T createAdapter(HumanActivity context);
}
