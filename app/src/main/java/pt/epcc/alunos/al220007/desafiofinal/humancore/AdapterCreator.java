package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;

public interface AdapterCreator<
		E extends Human,
		T extends Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>>
	>
{
	@NonNull
	T createAdapter(Context context);
}
