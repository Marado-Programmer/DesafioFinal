package pt.epcc.alunos.al220007.desafiofinal.humancore;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public interface HumanAdapterCreator<
		E extends Human,
		T extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>, T>
	>
{
	@NonNull
	T createAdapter(HumanActivity<E, T> context);
}
